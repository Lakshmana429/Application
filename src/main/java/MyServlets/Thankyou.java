package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Thankyou
 */
@WebServlet("/Thankyou")
public class Thankyou extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Thankyou() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String firstname = (String) session.getAttribute("firstname");
        String lastname = (String) session.getAttribute("lastname");
        String phone = (String) session.getAttribute("phone");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: 'Arial', sans-serif;");
        out.println("    background-color: #f4f4f4;");
        out.println("    text-align: center;");
        out.println("    padding: 20px;");
        out.println("}");

        out.println("header {");
        out.println("    background-color: lightblue;");
        out.println("    color: blue;");
        out.println("    padding: 10px;");
        out.println("}");

        out.println("h1 {");
        out.println("    color: #333;");
        out.println("}");

        out.println(".user-details {");
        out.println("    max-width: 600px;");
        out.println("    margin: 20px auto;");
        out.println("    margin-top: 80px;");
        out.println("    padding: 60px;");
        out.println("    background-color: #fff;");
        out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        out.println("}");

        out.println(".user-details p {");
        out.println("    color: #555;");
        out.println("    margin: 10px 0;");
        out.println("}");

        out.println(".button-container {");
        out.println("    margin-top: 20px;");
        out.println("}");

        out.println(".button-container button {");
        out.println("    background-color: lightblue;");
        out.println("    color: white;");
        out.println("    padding: 10px 20px;");
        out.println("    text-align: center;");
        out.println("    text-decoration: none;");
        out.println("    display: inline-block;");
        out.println("    font-size: 16px;");
        out.println("    margin: 0 10px;");
        out.println("    cursor: pointer;");
        out.println("    border: none;");
        out.println("    border-radius: 5px;");
        out.println("}");

        out.println("</style>");
        out.println("</head><body>");

        out.println("<header>");
        out.println("<h1>User Details</h1>");
        out.println("</header>");

        out.println("<div class='user-details'>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>First Name: " + firstname + "</p>");
        out.println("<p>Last Name: " + lastname + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("</div>");

        out.println("<div class='button-container'>");
        out.println("<button ><a href='Signin.html' style='text-decoration:none'>Cancel</a></button>");
        out.println("<button ><a href='Submitted.html' style='text-decoration:none'>Submit</a></button>");
        out.println("</div>");

        out.println("</body></html>");
    }


}
