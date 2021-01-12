package by.gsu.epamlab.model.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.BufferedWriter;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.ActivityDao;

public class ActivityImplCsv implements ActivityDao {
	private String csv;

	public ActivityImplCsv(String csvName) {
		csv = csvName.trim() + ".csv";
	}

	public void addParticipant(String account, int idConf, int[] idEvents) throws DaoException {
		String lines = IntStream.of(idEvents)
                .mapToObj(idEvent -> account + ";" + idConf + ";" + idEvent)
                .collect(Collectors.joining("\n"));
		synchronized (this) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(csv, true))) {
				writer.append(lines + "\n");
			} catch (IOException e) {
				throw new DaoException("problem with " + csv);
			}
		}
	}
}
