package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     **/
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String E_mail = request.getParameter("UserName");
        String password = request.getParameter("Pass");
        
		
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("Driver is loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
            System.out.println("Connection established");

            PreparedStatement ps = con.prepareStatement("select E_Mail, Password, FirstName, LastName,PhoneNo from Google");
            ResultSet rs = ps.executeQuery();
            boolean EValid = false;
            boolean PValid = false;
            response.setContentType("text/html");
            while (rs.next())
            {
                String mail = rs.getString("E_Mail");
                String pass = rs.getString("Password");
                System.out.println(mail);
                
                if (Objects.equals(mail, E_mail))
                {
                    EValid = true;

                    if (Objects.equals(pass, password))
                    {
                        PValid = true;
                        break;
                    }
                }
            }

            if (!EValid) {
                pw.println("<div style='color: red; margin-bottom: 10px;'>Invalid UserName. Please Login Again</div>");
                pw.println("<a href='Signin.html' style='color: blue; text-decoration: underline; display: block;'>Login</a>");
            } else if (!PValid) {
                pw.println("<div style='color: red; margin-bottom: 10px;'>Invalid Password. Please Login Again</div>");
                pw.println("<a href='Signin.html' style='color: blue; text-decoration: underline; display: block;'>Login</a>");
            }
			else 
			{
				System.out.println("Login Success");
				
					String firstName = rs.getString("FirstName");
	                String lastName = rs.getString("LastName");
	                String phoneNo = rs.getString("PhoneNo");

	                HttpSession session = request.getSession();
	                session.setAttribute("email", E_mail);
	                session.setAttribute("firstname", firstName);
	                session.setAttribute("lastname", lastName);
	                session.setAttribute("phone", phoneNo);
	                
	                response.sendRedirect("Thankyou");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
