package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//fetching the data and storing in local variable 
			String firstName = request.getParameter("firstName");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			//creating sql queery from above data
			//user is the actual sql table name and name and password is what it takes
			String sql = "insert into User(username,password,role) values(?,?,?)";
			String sql2 = "insert into User_Profile(firstName,lastname) values(?,?)";
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/portal";
			String usernameSQL = "root";
			String passwordSQL = "";
			Connection connection = DriverManager.getConnection(url,usernameSQL,passwordSQL);
			
			//execute sql command for users table
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, role);
				//now need to execute this statement
				ps.executeUpdate();
			}
			
			//execute sql command for users profile table
			try(PreparedStatement ps2 = connection.prepareStatement(sql2)){
				ps2.setString(1, firstName);
				ps2.setString(2, lastname);
				//now need to execute this statement
				ps2.executeUpdate();
			}
			/*
			try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO PUBLISHER (CODE, PUBLISHER_NAME) VALUES (?, ?)")) {
		        stmt.setString(1, book.getPublisher().getCode());   
		        stmt.setString(2, book.getPublisher().getName());           
		        stmt.executeUpdate();
		    }
		   */
			
			
			//print out what was executed
			PrintWriter out = response.getWriter();
			out.println("You have successfully signed up!");
			//***DONT FORGET TO UPDATE WEB.XML under WEB-INF
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

}
