import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/plus/clever")
public class OurCleverAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Integer sum = (Integer) session.getAttribute("sum");

        if (sum == null) sum = 0;

        String number = request.getParameter("number");
        sum += Integer.parseInt(number);
        session.setAttribute("sum", sum);

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Our Plus Servlet</title></head>");
        writer.println("<body>");
        writer.println("<h1>Result: " + sum + "</h1>");
        writer.println("</body>");
        writer.println("</html>");

        writer.close();
    }
}
