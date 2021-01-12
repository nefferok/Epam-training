package by.gsu.epamlab.command.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectPage extends AbstractPage {
    public RedirectPage() {
    }

    public RedirectPage(String path) {
        super(path);
    }

    @Override
    public void finishRequest(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + getPath());
    }
}