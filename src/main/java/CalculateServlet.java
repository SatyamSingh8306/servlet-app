//  - Servlet to perform the selected operation
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculateServlet")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int n = Integer.parseInt(request.getParameter("n"));
        String operation = request.getParameter("operation");
        
        // Collect numbers from input fields
        double[] numbers = new double[n];
        for (int i = 1; i <= n; i++) {
            numbers[i-1] = Double.parseDouble(request.getParameter("num" + i));
        }
        
        // Perform selected operation
        double result = performOperation(numbers, operation);
        
        // Display result
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculator Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
        out.println(".container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }");
        out.println(".result { margin: 20px 0; padding: 15px; background-color: #f9f9f9; border-radius: 4px; }");
        out.println("h2 { color: #333; }");
        out.println("button { padding: 10px 15px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }");
        out.println("button:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h1>Calculator Result</h1>");
        
        out.println("<div class=\"result\">");
        out.println("<h2>Operation: " + getOperationName(operation) + "</h2>");
        out.println("<p>Numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            out.print(numbers[i]);
            if (i < numbers.length - 1) {
                out.print(", ");
            }
        }
        out.println("</p>");
        out.println("<p>Result: " + result + "</p>");
        out.println("</div>");
        
        out.println("<a href=\"index.html\"><button type=\"button\">Start Again</button></a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    private double performOperation(double[] numbers, String operation) {
        double result = numbers[0]; // Start with the first number
        
        for (int i = 1; i < numbers.length; i++) {
            switch (operation) {
                case "add":
                    result += numbers[i];
                    break;
                case "subtract":
                    result -= numbers[i];
                    break;
                case "multiply":
                    result *= numbers[i];
                    break;
                case "divide":
                    if (numbers[i] != 0) {
                        result /= numbers[i];
                    } else {
                        // Handle division by zero
                        return Double.POSITIVE_INFINITY;
                    }
                    break;
            }
        }
        
        return result;
    }
    
    private String getOperationName(String operation) {
        switch (operation) {
            case "add":
                return "Addition";
            case "subtract":
                return "Subtraction";
            case "multiply":
                return "Multiplication";
            case "divide":
                return "Division";
            default:
                return "Unknown";
        }
    }
}