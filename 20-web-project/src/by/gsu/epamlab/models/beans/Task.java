package by.gsu.epamlab.models.beans;

import java.util.Date;

public class Task {

    private int id;
    private String bodyTask;
    private Date date;

    public Task() {
    }

    public Task(int id, String bodyTask, Date date) {
        this.id = id;
        this.bodyTask = bodyTask;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBodyTask() {
        return bodyTask;
    }

    public void setBodyTask(String bodyTask) {
        this.bodyTask = bodyTask;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
