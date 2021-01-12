package by.gsu.epamlab.model.beans;

public class User {
    private int id;
    private String login;
    private String mail;

    public User(int id, String login, String mail) {
        this.id = id;
        this.login = login;
        this.mail = mail;
    }

    public User(String login, String mail) {
        this.login = login;
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public int getId() {
        return id;
    }
}