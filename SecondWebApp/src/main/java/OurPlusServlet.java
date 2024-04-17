import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/plus")
public class OurPlusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        if (param1 != null && param2 != null) {
            try {

                int number1 = Integer.parseInt(param1);
                int number2 = Integer.parseInt(param2);

                int result = number1 + number2;

                response.setContentType("text/html");

                PrintWriter writer = response.getWriter();

                writer.println("<html>");
                writer.println("<head><title>Our Plus Servlet</title></head>");
                writer.println("<body>");
                writer.println("<h1>Result: " + result + "</h1>");
                writer.println("</body>");
                writer.println("</html>");

                writer.close();
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Invalid parameters: " + e.getMessage());
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Parameters are missing");
        }
    }

}
