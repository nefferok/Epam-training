package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.models.beans.User;

import java.util.Optional;

public interface UserDAO {

    Optional<User> getUser(String login, String password) throws DaoException;

    Optional<User> addAndGetUser(String login, String password) throws DaoException;

}
