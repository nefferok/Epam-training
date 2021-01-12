package by.gsu.epamlab.models.factories;

import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.ifaces.UserDAO;
import by.gsu.epamlab.models.impl.ServiceDB;
import by.gsu.epamlab.models.impl.UserImplDB;

import java.util.ResourceBundle;

import static by.gsu.epamlab.constants.ConstantsController.*;

public class UserFactory {

    private enum Source {
        DB{
            @Override
            UserDAO getImpl(ResourceBundle rb){
                ServiceDB.init(
                        rb.getString(DB_NAME_SOURCE_KEY),
                        rb.getString(DB_USER_SOURCE_KEY),
                        rb.getString(DB_PASSWORD_SOURCE_KEY)
                );
                return new UserImplDB();
            }
        };

        abstract UserDAO getImpl(ResourceBundle rb);
    }

    private static UserDAO userImpl;

    public static void init(ResourceBundle rb) throws InitException {
        String userImplName = rb.getString(USERS_SOURCE_KEY);
        Source source = Source.valueOf(userImplName.toUpperCase());
        userImpl = source.getImpl(rb);
    }

    public static UserDAO getClassFromFactory() {
        return userImpl;
    }
}
