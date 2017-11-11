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

import model.AuthDAO;
import model.User;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// retriving all paramenters from JSP page
		String firstName = request.getParameter("firstName");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String roles = request.getParameter("role");
		int userId = 0;
		String dbName2 = null;

		// setting all the values in the model class object
		User m = new User();
		m.setFirstname(firstName);
		m.setLastname(lastname);
		m.setUsername(username);
		m.setPassword(password);
		m.setRole(roles);

		String sql3 = "select * from User where username=?";
		int k = AuthDAO.checkUserNameAvailable(m, sql3);
		if (k != 0) {
			System.out.println("Youre Good Username doesnt exist!");

			if (password.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter password.");
			} else if (username.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter username.");
			} else if (firstName.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter first name.");
			} else if (lastname.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter last name.");
			} else {

				// calling a method in DAO class to inset data into table
				String sql = "insert into User(username,password,role) values(?,?,?)";
				int i = AuthDAO.signupUser(m, sql);

				if (i != 0) {
					System.out.println("Values inserted successfully into User table!");

				} else {
					System.out.println("Error! Values not inserted into User table!");
				}

				userId = AuthDAO.getUserId();
				userId -= 1;
				m.setUserId(userId);
				System.out.println("Current user ID is : " + userId);

				// System.out.print("testing get user by id : ");

				String sql2 = "insert into User_Profile(userId, firstName,lastname) values(?,?,?)";
				int j = AuthDAO.signupUser_Profile(m, sql2);

				if (j != 0) {
					System.out.println("Values inserted successfully into User_Profile table!");

				} else {
					System.out.println("Error! Values not inserted into User_Profile table!");
				}

//				userId = AuthDAO.getUserId();
//				userId -= 1;
//				//jb2.setUserId(userId);
//				System.out.println("Current user ID is : " + userId);
//				User b = new User();
//				b = AuthDAO.getUserById(userId);
//				System.out.print("testing get user by id for Firstname : " + b.getFirstname());
//				System.out.print("testing get user by id for Firstname : " + b.getLastname());

				if (roles.equals("Student")) {
					request.getSession().setAttribute("currentUser", username);
					request.getSession().setAttribute("roles", roles);
					request.getSession().setAttribute("firstName", firstName);
					request.getSession().setAttribute("lastName", lastname);
					request.getRequestDispatcher("Student.jsp").forward(request, response);
					// request.setAttribute("currentDate", "Please enter username.");
				}

				if (roles.equals("Instructor")) {
					request.getSession().setAttribute("currentUser", username);
					request.getSession().setAttribute("roles", roles);
					request.getSession().setAttribute("firstName", firstName);
					request.getSession().setAttribute("lastName", lastname);
					request.getRequestDispatcher("Instructor.jsp").forward(request, response);
				}

				if (roles.equals("Retailer")) {
					request.getSession().setAttribute("currentUser", username);
					request.getSession().setAttribute("roles", roles);
					request.getSession().setAttribute("firstName", firstName);
					request.getSession().setAttribute("lastName", lastname);
					request.getRequestDispatcher("Retailer.jsp").forward(request, response);
				}

				if (roles.equals("TA")) {
					request.getSession().setAttribute("currentUser", username);
					request.getSession().setAttribute("roles", roles);
					request.getSession().setAttribute("firstName", firstName);
					request.getSession().setAttribute("lastName", lastname);
					request.getRequestDispatcher("TA.jsp").forward(request, response);
				}
			}

		} else {
			System.out.println("Error! Username already exists!");
			request.setAttribute("errorMessage", "Username existed.");
		}

		request.getRequestDispatcher("signup.jsp").forward(request, response); // could also use include

		// try {
		// //for javabean
		// User jb = new User();
		//
		// //fetching the data and storing in local variable
		// String firstName = request.getParameter("firstName");
		// String lastname = request.getParameter("lastname");
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		// String role = request.getParameter("role");
		// String dbName2 = null;
		//
		// jb.setFirstname(firstName);
		// jb.setLastname(lastname);
		// // jb.setUsername(username);
		// jb.setPassword(password);
		// jb.setRole(role);
		//
		// //creating sql queery from above data
		// //user is the actual sql table name and name and password is what it takes
		//// String sql = "insert into User(username,password,role) values(?,?,?)";
		//// String sql2 = "insert into User_Profile(firstName,lastname) values(?,?)";
		// String sql3 = "select * from User where username=?";
		// //String sqlGet = "select * from User where username=?";
		//
		// Class.forName("com.mysql.jdbc.Driver");
		// String url = "jdbc:mysql://localhost:3306/portal";
		// String usernameSQL = "root";
		// String passwordSQL = "";
		// Connection connection =
		// DriverManager.getConnection(url,usernameSQL,passwordSQL);
		//
		//
		//
		//
		// /*
		// try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO
		// PUBLISHER (CODE, PUBLISHER_NAME) VALUES (?, ?)")) {
		// stmt.setString(1, book.getPublisher().getCode());
		// stmt.setString(2, book.getPublisher().getName());
		// stmt.executeUpdate();
		// }
		// */
		// /*
		// try(PreparedStatement psGet = connection.prepareStatement(sqlGet)){
		// //psGet.setString(1, username);
		// //ps.setString(2, password);
		// //ps.setString(3, roles);
		// //fetch the data and store it somewhere
		// ResultSet resultSet = psGet.executeQuery();
		// //PrintWriter out = response.getWriter();
		// while(resultSet.next()) {
		// dbName = resultSet.getString(1);
		// //dbPassword = resultSet.getString("password");
		// //dbRole = resultSet.getString("role");
		// }
		// }
		// */
		// //if (username.equals(dbName) && password.equals(dbPassword)) {
		// // if the username or password incorrect will go here
		// // if not succesfull redirect to error.jsp
		// // response.sendRedirect("error.jsp");
		// // request.getSession().removeAttribute("errorMessage");
		//
		// //if (usernameUpper.equals(dbName) && password.equals(dbPassword)) {
		//
		// try(PreparedStatement ps3 = connection.prepareStatement(sql3)){
		// ps3.setString(1, username);
		// //ps3.setString(2, password);
		// //ps.setString("jb2", jb2);
		// //ps.setString(3, roles);
		// //fetch the data and store it somewhere
		// ResultSet resultSet = ps3.executeQuery();
		// //PrintWriter out = response.getWriter();
		// while(resultSet.next()) {
		// dbName2 = resultSet.getString("username");
		// //dbPassword = resultSet.getString("password");
		// //dbRole = resultSet.getString("role");
		// }
		//
		// if (username.equals(dbName2)) {
		// PrintWriter out4 = response.getWriter();
		// out4.println("jbUSEr is ************** "+dbName2);
		// request.setAttribute("errorMessage", "Username exist in database!");
		// //request.getRequestDispatcher("signup.jsp").forward(request, response);
		// //could also use include
		// }else {
		// String sql = "insert into User(username,password,role) values(?,?,?)";
		// String sql2 = "insert into User_Profile(firstName,lastname) values(?,?)";
		// //execute sql command for users table
		// try(PreparedStatement ps = connection.prepareStatement(sql)){
		// ps.setString(1, username);
		// ps.setString(2, password);
		// ps.setString(3, role);
		// //now need to execute this statement
		// ps.executeUpdate();
		// }
		//
		// //execute sql command for users profile table
		// try(PreparedStatement ps2 = connection.prepareStatement(sql2)){
		// ps2.setString(1, firstName);
		// ps2.setString(2, lastname);
		// //now need to execute this statement
		// ps2.executeUpdate();
		// }
		// }
		// /*
		// jb.setDbName(dbName2);
		//
		// String test = jb.getDbName();
		// PrintWriter out2 = response.getWriter();
		// out2.println("jbUSEr is ************** "+test);
		//
		// String jbUser = jb.getDbName();
		// System.out.println("jbUSEr is ************** "+jbUser);
		// PrintWriter out5 = response.getWriter();
		// out5.println("jbUSEr is ************** "+jbUser);
		// */
		// // if (username.equals(dbName2)) {
		// // //PrintWriter out4 = response.getWriter();
		// // //out4.println("jbUSEr is ************** "+jbUser);
		// // request.setAttribute("errorMessage", "Username exist in database!");
		// // }
		// //else if (usernameUpper.isEmpty()) {
		// if (password.isEmpty()) {
		// request.setAttribute("errorMessage", "Please enter password.");
		// } else if (username.isEmpty()) {
		// request.setAttribute("errorMessage", "Please enter username.");
		// }
		// else if (firstName.isEmpty()) {
		// request.setAttribute("errorMessage", "Please enter first name.");
		// }
		// else if (lastname.isEmpty()) {
		// request.setAttribute("errorMessage", "Please enter last name.");
		// }
		// else {
		// if (role.equals("Supplier")) {
		// request.getSession().setAttribute("currentUser", username);
		// request.getRequestDispatcher("Supplier.jsp").forward(request, response);
		// // request.setAttribute("currentDate", "Please enter username.");
		// }
		//
		// if (role.equals("Wholesaler")) {
		// request.getSession().setAttribute("currentUser", username);
		// request.getRequestDispatcher("Wholesaler.jsp").forward(request, response);
		// }
		//
		// if (role.equals("Retailer")) {
		// request.getSession().setAttribute("currentUser", username);
		// request.getRequestDispatcher("Retailer.jsp").forward(request, response);
		// }
		//
		// if (role.equals("Customer")) {
		// request.getSession().setAttribute("currentUser", username);
		// request.getRequestDispatcher("Customer.jsp").forward(request, response);
		// }
		// }
		//
		//
		// request.getRequestDispatcher("signup.jsp").forward(request, response);
		// //could also use include
		// }
		//
		//
		// //print out what was executed
		// PrintWriter out3 = response.getWriter();
		// out3.println("You have successfully signed up!");
		// //***DONT FORGET TO UPDATE WEB.XML under WEB-INF
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// //sendErrorRedirect(request, response, "/signup.jsp", e);
		// //request.setAttribute("errorMessage", "Username existed");
		// e.printStackTrace();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// request.setAttribute("errorMessage", "Username existed");
		// e.printStackTrace();
		// }
		//
		// //doGet(request, response);
		// }
		//
		// private void sendErrorRedirect(HttpServletRequest request,
		// HttpServletResponse response, String string,
		// ClassNotFoundException e) {
		// // TODO Auto-generated method stub
		// try {
		// request.setAttribute ("javax.servlet.jsp.jspException", e);
		// getServletConfig().getServletContext().getRequestDispatcher(string).forward(request,
		// response);
		// } catch (Exception ex) {
		// //putError("serXXXXX.sendErrorRedirect ", ex);
		// }
	}

}
