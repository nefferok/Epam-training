package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.exceptions.DaoException;

public interface ActivityDao {
	void addParticipant(String account, int idConf, int[] idEvents) throws DaoException;
}
