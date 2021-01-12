package by.gsu.epamlab.model.beans;

import by.gsu.epamlab.constants.ConstantMain;

public class Conference {

    private String name;
    private String faculty;
    private String date;

    public Conference(String name, String faculty, String date) {
            this.name = name;
            this.faculty = faculty;
            this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + ConstantMain.DELIMITER + faculty + ConstantMain.DELIMITER + date;
    }
}
