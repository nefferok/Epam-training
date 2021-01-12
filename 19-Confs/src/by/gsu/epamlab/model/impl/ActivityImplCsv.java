package by.gsu.epamlab.model.impl;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.ActivityDAO;

import javax.servlet.ServletConfig;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static by.gsu.epamlab.constants.ConstantMain.*;
import static by.gsu.epamlab.constants.ConstantsException.*;

public class ActivityImplCsv implements ActivityDAO {
    private static final String PROPERTY_CSV_PATH = "activity.csv.name";
    private static final String ROOT_PATH = "/WEB-INF/classes";
    private static final String CSV = ".csv";

    private String csvPath;

    public ActivityImplCsv(ResourceBundle rb, ServletConfig sc) {
        String path = rb.getString(PROPERTY_CSV_PATH);
        csvPath =sc.getServletContext().getRealPath(ROOT_PATH) + path + CSV;
    }


    @Override
    public void addParticipant(String acc, int conf, int[] events) throws DaoException {
        String lines = Arrays.stream(events)
                .mapToObj(ev -> acc + DELIMITER + conf + DELIMITER + ev)
                .collect(Collectors.joining("\n"));
        synchronized (this){
            try (BufferedWriter writer
                         = new BufferedWriter(new FileWriter(csvPath, true))) {
                writer.append(lines).append("\n");
            } catch (IOException e) {
                throw new DaoException(EXCEPTION_WRITE_CSV + csvPath);
            }
        }
    }
}
