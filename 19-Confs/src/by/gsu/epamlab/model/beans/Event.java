package by.gsu.epamlab.model.beans;

import by.gsu.epamlab.constants.ConstantMain;

public class Event {

    private int id;
    private String name;
    private String time;

    public Event(int id, String name, String time) {
            this.id = id;
            this.name = name;
            this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return id + ConstantMain.DELIMITER + name + ConstantMain.DELIMITER + time;
    }
}
