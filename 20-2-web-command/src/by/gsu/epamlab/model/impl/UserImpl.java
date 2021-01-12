package by.gsu.epamlab.model.impl;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.UserDao;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.factories.PoolConnection;

import java.sql.*;
import java.util.Optional;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;
import static by.gsu.epamlab.model.impl.ConstantsSql.*;

public class UserImpl implements UserDao {

    public UserImpl() {
    }

    @Override
    public Optional<User> getUser(String login, String password) throws DaoException {
        Optional<User> foundUser = Optional.empty();
        try (Connection connection = PoolConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER)) {
            ps.setString(COLUMN_INDEX_FIRST, login);
            ps.setString(COLUMN_INDEX_SECOND, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    foundUser = Optional.of(new User(rs.getInt(COLUMN_INDEX_FIRST),
                            rs.getString(COLUMN_INDEX_SECOND), rs.getString(COLUMN_INDEX_THIRD)));
                }
            }
            return foundUser;
        } catch (SQLException e) {
            throw new DaoException(ERR_DB, e);
        }
    }

    @Override
    public Optional<User> addAndGetUser(String login, String password, String mail) throws DaoException {

        try (Connection connection = PoolConnection.getConnection();
             PreparedStatement psGet = connection.prepareStatement(SELECT_CHECK_USERNAME);
             PreparedStatement psAdd = connection.prepareStatement(INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS)) {

            Optional<User> opUser = Optional.empty();

            final int LOGIN_INDEX = 1;
            final int PASSWORD_INDEX = 2;
            final int MAIL_INDEX = 3;
            psGet.setString(LOGIN_INDEX, login);
            psAdd.setString(LOGIN_INDEX, login);
            psAdd.setString(PASSWORD_INDEX, password);
            psAdd.setString(MAIL_INDEX, mail);

            synchronized (this) {
                try (ResultSet rs = psGet.executeQuery()) {
                    if (!rs.next()) {
                        psAdd.executeUpdate();
                    }
                }
            }

            final int USER_ID_INDEX = 1;
            try (ResultSet rsAdded = psAdd.getGeneratedKeys()) {
                if (rsAdded.next()) {
                    int userId = rsAdded.getInt(USER_ID_INDEX);
                    opUser = Optional.of(new User(userId, login, mail));
                }
                return opUser;
            }
        } catch (SQLException e) {
            throw new DaoException(ERR_DB, e);
        }
    }
}