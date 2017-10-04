package authentication;

//****REMOVED FROM WEB.XML
/*
 * 
<display-name>login</display-name>
  <servlet>
  <servlet-name>reg</servlet-name>
  <servlet-class>jdbc.SignupServlet</servlet-class>
  
  </servlet>
  <servlet-mapping>
  <servlet-name>reg</servlet-name>
  <url-pattern>/regServlet</url-pattern>
  
  </servlet-mapping>
  
  
  <servlet>
  <servlet-name>login</servlet-name>
  <servlet-class>jdbc.Login</servlet-class>
  
  </servlet>
  <servlet-mapping>
  <servlet-name>login</servlet-name>
  <url-pattern>/LoginServlet</url-pattern>
  
  </servlet-mapping>
 * 
 * 
 */



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//getConnection();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	//used to connect to mysql databse
	public static Connection getConnection() throws Exception{
		//to catch any errors we might get
		try {
			String driver = "com.mysql.jdbc.Driver";
			//where the databse is located
			String url = "jdbc:mysql://localhost:3306/database";
			String username = "arnold";
			String password = "mypass";
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established");
			return connection;

		} catch(Exception e) {
			System.out.println(e);
			}
		
		//will only hit this if connection not sucessful
		return null;
	}
*/
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	/*
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
		String url = "jdbc:mysql://localhost:3306/csi518";
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
		
		try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO PUBLISHER (CODE, PUBLISHER_NAME) VALUES (?, ?)")) {
	        stmt.setString(1, book.getPublisher().getCode());   
	        stmt.setString(2, book.getPublisher().getName());           
	        stmt.executeUpdate();
	    }
	   
		
		
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
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			/*
			 * 
			 * 
			 */
			
			User jb2 = new User();
			
			// this is where control will go from the jsp login post method
			// this is where i check if the username and password are valid or not
			// doGet(request, response);
			// will get our information from the request and by specifying the name of what
			// we want to get ex username
			String username = request.getParameter("username");
			String usernameUpper = username.toUpperCase();
			String password = request.getParameter("password");
			String roles = request.getParameter("roles");
			//String signUp = request.getParameter("signUp");
			String dbName = null;
			String dbPassword = null;
			//String dbRole = null;
			
			//creating sql queery from above data to fetch the data from the mySQL database
			//String sql = "select * from User where username=? and password=? and role=?";
			String sql = "select * from User where username=? and password=?";
			//String sql2 = "insert into User_Profile(firstName,lastname) values(?,?)";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/csi518";
			String usernameSQL = "root";
			String passwordSQL = "";
			Connection connection = DriverManager.getConnection(url,usernameSQL,passwordSQL);
			
			//execute sql command for users table
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setString(1, username);
				ps.setString(2, password);
				//ps.setString("jb2", jb2);
				//ps.setString(3, roles);
				//fetch the data and store it somewhere 
				ResultSet resultSet = ps.executeQuery();
				PrintWriter out = response.getWriter();
				while(resultSet.next()) {
					dbName = resultSet.getString("username");
					dbPassword = resultSet.getString("password");
					//dbRole = resultSet.getString("role");
				}
				
				jb2.setDbName(dbName);
				
				String test = jb2.getDbName();
				PrintWriter out2 = response.getWriter();
				out2.println("jbUSEr is **************  "+test);
				
				/*
				//checking if information actually exist in the database
				if(username.equals(dbName) && password.equals(dbPassword) && roles.equals(dbRole)) {
					out.println("You have successfully signed in!");
				}else {
					//response.sendRedirect("login.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response); //could also use forward instead of include
				}
				*/
				
				
				//if (usernameUpper.equals(dbName) && password.equals(dbPassword)) {
				if (username.equals(dbName) && password.equals(dbPassword)) {
					// if login is successfull then redirect to members jsp page
					// request.getSession().removeAttribute("errorMessage");
					// response.sendRedirect("members.jsp");
					if (roles.equals("Supplier")) {
						request.getSession().setAttribute("currentUser", username);
						request.getRequestDispatcher("Supplier.jsp").forward(request, response);
						// request.setAttribute("currentDate", "Please enter username.");
					}

					if (roles.equals("Wholesaler")) {
						request.getSession().setAttribute("currentUser", username);
						request.getRequestDispatcher("Wholesaler.jsp").forward(request, response);
					}
					
					if (roles.equals("Retailer")) {
						request.getSession().setAttribute("currentUser", username);
						request.getRequestDispatcher("Retailer.jsp").forward(request, response);
					}
					
					if (roles.equals("Customer")) {
						request.getSession().setAttribute("currentUser", username);
						request.getRequestDispatcher("Customer.jsp").forward(request, response);
					}

					// request.getRequestDispatcher("members.jsp").forward(request, response);
				} else { // if the username or password incorrect will go here
					// if not succesfull redirect to error.jsp
					// response.sendRedirect("error.jsp");
					// request.getSession().removeAttribute("errorMessage");
					
					//if (usernameUpper.isEmpty() && password.isEmpty()) {
					if (username.isEmpty() && password.isEmpty()) {
						request.setAttribute("errorMessage", "Please enter username and password.");
					}
					//else if (usernameUpper.isEmpty()) {
					 else if (username.isEmpty()) {
						request.setAttribute("errorMessage", "Please enter username.");
					} else if (password.isEmpty()) {
						request.setAttribute("errorMessage", "Please enter password.");
					} else {
						request.setAttribute("errorMessage", "Your information does not exist!");
					}
					
					/*
					***TESTING to see if random input and some field left blank***
					{ // if the username or password incorrect will go here
					// if not succesfull redirect to error.jsp
					// response.sendRedirect("error.jsp");
					// request.getSession().removeAttribute("errorMessage");
					if (usernameUpper.equals("ICSI518") && password.isEmpty()) {
						request.setAttribute("errorMessage", "Please enter password.");
					} else if (usernameUpper.isEmpty() && password.equals("Fall2017")) {
						request.setAttribute("errorMessage", "Please enter username.");
					} else if (usernameUpper.isEmpty() && password.isEmpty()) {
						request.setAttribute("errorMessage", "Please enter username and password.");
					} else {
						request.setAttribute("errorMessage", "Invalid username and password.");
					}
					
					
					
					*/
					
					/*
					 * if(!(username.equals("ICSI518")) && !(password.equals("Fall2017"))) {
					 * request.getSession().setAttribute("errorMessage",
					 * "Invalid username and password."); }
					 */
					// request.getSession().setAttribute("errorMessage", "Please enter username and
					// password");
					request.getRequestDispatcher("Login.jsp").forward(request, response); //could also use include 
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
