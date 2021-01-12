package by.gsu.epamlab.model.impl;

import by.gsu.epamlab.constants.ConstantsException;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.exceptions.InitRuntimeException;
import by.gsu.epamlab.ifaces.ActivityDAO;

import javax.servlet.ServletConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static by.gsu.epamlab.constants.ConstantsException.*;
import static by.gsu.epamlab.constants.ConstantMain.*;


public class ActivityImplDb implements ActivityDAO {

    private static final Logger LOGGER = Logger.getLogger(ActivityImplDb.class.getName());

    public ActivityImplDb(ResourceBundle rb, ServletConfig sc) {
        try {
            String dbUrl = rb.getString(PROPERTIES_DB_NAME);
            String user = rb.getString(PROPERTIES_DB_USER);
            String password = rb.getString(PROPERTIES_DB_PASS);
            ServiceDb.init(dbUrl, user, password);
        } catch (InitException e) {
            throw new InitRuntimeException(EXCEPTION_INIT_DB + e);
        }
    }


    @Override
    public void addParticipant(String acc, int conf, int... events) throws DaoException {
        final int ID_EVENT = 1;
        final String INSERT_QUERY = "insert into activites (participant, confId, eventId) values ('" + acc + "', " + conf + ", ?)";
        try (Connection cn = ServiceDb.getConnection()) {
            cn.setAutoCommit(false);
            try (PreparedStatement ps = cn.prepareStatement(INSERT_QUERY)) {
                for (int event : events) {
                    ps.setInt(ID_EVENT, event);
                    ps.addBatch();
                }
                ps.executeBatch();
                cn.commit();
            } catch (SQLException e) {
                try {
                    if (cn != null) {
                        cn.rollback();
                    }
                } catch (SQLException e1) {
                    LOGGER.log(Level.WARNING, EXCEPTION_ROLLBACK, e1);
                }
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            throw new DaoException(EXCEPTION_WRITE_DB + e);
        }
    }
}
