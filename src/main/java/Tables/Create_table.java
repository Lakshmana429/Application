package Tables;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Create_table 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
				Scanner sc = new Scanner(System.in);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.print("Driver is loaded");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
				System.out.println("Connection established");
				System.out.println("Create the table");
				Statement st = con.createStatement();
				//st.executeUpdate("create table Google(FirstName varchar(20),LastName varchar(20), E_Mail varchar(30),Password varchar(20), Confirm_Password varchar(20),PhoneNo varchar(20))");
				System.out.println("Table Created");
				
				PreparedStatement ps;
						ps = con.prepareStatement("insert into Google values(?,?,?,?,?,?)");
						System.out.print("Please Enter FirstName");
						ps.setString(1, sc.next());
						System.out.print("Please Enter LastName");
						ps.setString(2,sc.next());
						System.out.print("Please Enter E-Mail");
						ps.setString(3,sc.next());
						System.out.print("Please Enter Password");
						ps.setString(4,sc.next());
						System.out.print("Please Confirm Password");
						ps.setString(5,sc.next());
						System.out.println("Please Enter PhoneNumber");
						ps.setString(6, sc.next());
						System.out.print("record is inserted");
						ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}

}
