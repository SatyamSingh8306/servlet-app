import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inputServlet")
public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int n = Integer.parseInt(request.getParameter("n"));
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculator App</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
        out.println(".container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }");
        out.println(".form-group { margin-bottom: 15px; }");
        out.println("label { display: block; margin-bottom: 5px; }");
        out.println("input[type=\"number\"] { padding: 8px; width: 100%; border: 1px solid #ddd; border-radius: 4px; }");
        out.println(".operations { margin-top: 20px; }");
        out.println(".operations button { margin-right: 10px; padding: 10px 15px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }");
        out.println(".operations button:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h1>Enter " + n + " Numbers</h1>");
        out.println("<form action=\"calculateServlet\" method=\"post\">");
        
        // Create n input boxes
        for (int i = 1; i <= n; i++) {
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"num" + i + "\">Number " + i + ":</label>");
            out.println("<input type=\"number\" id=\"num" + i + "\" name=\"num" + i + "\" step=\"any\" required>");
            out.println("</div>");
        }
        
        // Hidden input to pass n to the next servlet
        out.println("<input type=\"hidden\" name=\"n\" value=\"" + n + "\">");
        
        // Operation buttons
        out.println("<div class=\"operations\">");
        out.println("<button type=\"submit\" name=\"operation\" value=\"add\">Addition</button>");
        out.println("<button type=\"submit\" name=\"operation\" value=\"subtract\">Subtraction</button>");
        out.println("<button type=\"submit\" name=\"operation\" value=\"multiply\">Multiplication</button>");
        out.println("<button type=\"submit\" name=\"operation\" value=\"divide\">Division</button>");
        out.println("</div>");
        
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}