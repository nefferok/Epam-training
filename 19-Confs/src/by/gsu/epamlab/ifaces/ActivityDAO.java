package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.exceptions.DaoException;

public interface ActivityDAO {

    void addParticipant(String acc, int conf, int[] events) throws DaoException;

}
