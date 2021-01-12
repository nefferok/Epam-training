package by.gsu.epamlab.controllers;

import by.gsu.epamlab.models.beans.Task;
import org.json.CDL;
import org.json.JSONArray;

import java.util.List;
import java.util.stream.Collectors;

public class Utilities {
    public static final String ARRAY_BRACKET = "[]";
    public static final int ZERO_LENGTH = 0;

    public static String getJsonTasks(List<Task> tasks) {

        if (tasks.size() == ZERO_LENGTH) {
            return ARRAY_BRACKET;
        }
        final String ID_TASK = "id";
        final String BODY_TASK = "bodyTask";
        final String DATE_TASK = "date";

        JSONArray ja = new JSONArray();
        ja.put(ID_TASK);
        ja.put(BODY_TASK);
        ja.put(DATE_TASK);

        final String LINE_BREAK = " \n";
        String strTasks = tasks.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LINE_BREAK));

        JSONArray jsonTasks = CDL.toJSONArray(ja, strTasks);
        return jsonTasks.toString();
    }

    public static String getJsonByList(List<String> views) {
        if (views.size() == ZERO_LENGTH) {
            return ARRAY_BRACKET;
        }
        return new JSONArray(views).toString();
    }
}