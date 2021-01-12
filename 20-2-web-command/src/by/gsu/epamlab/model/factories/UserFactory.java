package by.gsu.epamlab.model.factories;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.ifaces.UserDao;
import by.gsu.epamlab.model.impl.UserImpl;

import java.util.ResourceBundle;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;
import static by.gsu.epamlab.controllers.ConstantsJsp.DB_PASSWORD;

public class UserFactory {
    private enum Source {
        MYSQL {
            @Override
            UserDao getImpl(ResourceBundle rb) {
                PoolConnection.init(rb.getString(DB_NAME),
                        rb.getString(DB_USER), rb.getString(DB_PASSWORD));
                return new UserImpl();
            }
        };

        abstract UserDao getImpl(ResourceBundle rb) throws InitException;

    }

    private static UserDao userImpl;

    public static void init(ResourceBundle rb) throws InitException {
        String sourceType = rb.getString(WEB_DATA);
        Source source = Source.valueOf(sourceType.toUpperCase());
        userImpl = source.getImpl(rb);
    }

    public static UserDao getInstanceFromFactory() throws DaoException {
        if(userImpl == null){
            throw new DaoException(ERR_DB_CON_PROP);
        }
        return userImpl;
    }
}