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

@WebServlet("/Regis")
public class Regis extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        System.out.println("Entered");

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String First_Name = request.getParameter("FName");
            String Last_Name = request.getParameter("LName");
            String E_mail = request.getParameter("Mail");
            String Password = request.getParameter("Pass");
            String Password1 = request.getParameter("Pass1");
            String phone = request.getParameter("Mobile");
            
            // Establish the database connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
            System.out.println("Connection established in registration");
            System.out.println(First_Name + " " + Last_Name);

            // Prepare and execute the SQL statement
            
            PreparedStatement ps = con.prepareStatement("insert into Google values(?,?,?,?,?,?)");
            ps.setString(1, First_Name);
            ps.setString(2, Last_Name);
            ps.setString(3, E_mail);
            ps.setString(4, Password);
            ps.setString(5, Password1);
            ps.setString(6, phone);
            ps.executeUpdate();

            // Redirect to the specified page on successful registration
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            response.sendRedirect("Signin.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
