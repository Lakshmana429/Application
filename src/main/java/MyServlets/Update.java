package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Update() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String Email = request.getParameter("Email");  // Corrected parameter name
        String password = request.getParameter("pwd");  // Corrected parameter name

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver is loaded");
            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
                 PreparedStatement ps = con.prepareStatement("update Google set Password = ? where E_Mail = ?")) {

                ps.setString(1, password);
                ps.setString(2, Email);

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                	//pw.println("Password is Updated Sucessfully...");
                    pw.println("<a href=\"Signin.html\">Login Again</a>");
                } else {
                    pw.println("No user found with the provided email");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("Error updating password. Please try again.");
        }
    }

}