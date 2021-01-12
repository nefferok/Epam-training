package by.gsu.epamlab.command.page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractPage {
    private String path;

    public AbstractPage() {
    }

    public AbstractPage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public abstract void finishRequest(HttpServletRequest request,
                                       HttpServletResponse response) throws ServletException, IOException;
}