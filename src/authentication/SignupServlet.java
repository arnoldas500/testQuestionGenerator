package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String dbName = null;
			//creating sql queery from above data
			//user is the actual sql table name and name and password is what it takes
			String sql = "insert into User(username,password,role) values(?,?,?)";
			String sql2 = "insert into User_Profile(firstName,lastname) values(?,?)";
			//String sqlGet = "select * from User where username=?";
			
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
			/*
			try(PreparedStatement psGet = connection.prepareStatement(sqlGet)){
				//psGet.setString(1, username);
				//ps.setString(2, password);
				//ps.setString(3, roles);
				//fetch the data and store it somewhere 
				ResultSet resultSet = psGet.executeQuery();
				//PrintWriter out = response.getWriter();
				while(resultSet.next()) {
					dbName = resultSet.getString(1);
					//dbPassword = resultSet.getString("password");
					//dbRole = resultSet.getString("role");
				}
			}
		*/
			//if (username.equals(dbName) && password.equals(dbPassword)) {
				// if the username or password incorrect will go here
				// if not succesfull redirect to error.jsp
				// response.sendRedirect("error.jsp");
				// request.getSession().removeAttribute("errorMessage");
				
			//if (usernameUpper.equals(dbName) && password.equals(dbPassword)) {
			
			/*
				if (username.isEmpty() && password.isEmpty()) {
					request.setAttribute("errorMessage", "Please enter username and password.");
				}
				//else if (usernameUpper.isEmpty()) {
				 else if (username.isEmpty()) {
					request.setAttribute("errorMessage", "Please enter username.");
				} else if (password.isEmpty()) {
					request.setAttribute("errorMessage", "Please enter password.");
				} 
				else if (firstName.isEmpty()) {
					request.setAttribute("errorMessage", "Please enter first name.");
				}
				else if (lastname.isEmpty()) {
					request.setAttribute("errorMessage", "Please enter last name.");
				}
				else {
					request.setAttribute("errorMessage", "Your information does not exist!");
				}
				
				
				request.getRequestDispatcher("Login.jsp").forward(request, response); //could also use include 
			*/
			
			
			//print out what was executed
			PrintWriter out = response.getWriter();
			out.println("You have successfully signed up!");
			//***DONT FORGET TO UPDATE WEB.XML under WEB-INF
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//sendErrorRedirect(request, response, "/signup.jsp", e);
			//request.setAttribute("errorMessage", "Username existed");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMessage", "Username existed");
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

	private void sendErrorRedirect(HttpServletRequest request, HttpServletResponse response, String string,
			ClassNotFoundException e) {
		// TODO Auto-generated method stub
		try {
            request.setAttribute ("javax.servlet.jsp.jspException", e);
            getServletConfig().getServletContext().getRequestDispatcher(string).forward(request, response);
      } catch (Exception ex) {
           //putError("serXXXXX.sendErrorRedirect ", ex);
      }
	}

}
