package by.gsu.epamlab.model.beans;

import java.sql.Date;

public class Task {
    private int id;
    private String task;
    private Date date;

    public Task(int id, String task, Date date) {
        this.id = id;
        this.task = task;
        this.date = date;
    }

    public Task(String task, String date) {
        this.task = task;
        this.date = Date.valueOf(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}