package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.model.beans.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> getUser(String login, String password) throws DaoException;

    Optional<User> addAndGetUser(String login, String password, String mail) throws DaoException;
}