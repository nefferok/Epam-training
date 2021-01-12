package by.gsu.epamlab.models.impl;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.UserDAO;
import by.gsu.epamlab.models.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;


import static by.gsu.epamlab.constants.ConstantsError.ERR_DATA_SOURCE;
import static by.gsu.epamlab.constants.ConstantsSQL.*;

public class UserImplDB implements UserDAO {

    @Override
    public Optional<User> getUser(String login, String password) throws DaoException {
        try (Connection cn = ServiceDB.getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_USER)) {

            Optional<User> opUser = Optional.empty();

            final int LOGIN_INDEX = 1;
            final int PASSWORD_INDEX = 2;
            ps.setString(LOGIN_INDEX, login);
            ps.setString(PASSWORD_INDEX, password);

            final int USER_ID_INDEX = 1;
            final int USERNAME_INDEX = 2;
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int userId = rs.getInt(USER_ID_INDEX);
                    String userName = rs.getString(USERNAME_INDEX);
                    opUser = Optional.of(new User(userId, userName));
                }
            }
            return opUser;
        } catch (SQLException e) {
            throw new DaoException(ERR_DATA_SOURCE);
        }
    }

    @Override
    public Optional<User> addAndGetUser(String login, String password) throws DaoException {

        try (Connection cn = ServiceDB.getConnection();
             PreparedStatement psGet = cn.prepareStatement(SELECT_CHECK_USERNAME);
             PreparedStatement psAdd = cn.prepareStatement(INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS)) {

            Optional<User> opUser = Optional.empty();

            final int LOGIN_INDEX = 1;
            final int PASSWORD_INDEX = 2;
            psGet.setString(LOGIN_INDEX, login);
            psAdd.setString(LOGIN_INDEX, login);
            psAdd.setString(PASSWORD_INDEX, password);


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
                    opUser = Optional.of(new User(userId, login));
                }
                return opUser;
            }
        } catch (SQLException e) {
            throw new DaoException(ERR_DATA_SOURCE);
        }

    }


}
