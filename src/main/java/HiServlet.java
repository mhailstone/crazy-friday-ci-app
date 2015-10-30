import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joseph Moore (joseph_moore@byu.edu)
 */
public class HiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getParameter("lang");
        String name = req.getParameter("name");

        String body = Service.makeGreeting(lang, name);

        resp.setHeader("Content-Type", "application/json");
        resp.getWriter().append(body);
        resp.getWriter().flush();
    }
}
