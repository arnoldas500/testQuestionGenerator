
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// this is where control will go from the jsp login post method
		// this is where i check if the username and password are valid or not
		// doGet(request, response);
		// will get our information from the request and by specifying the name of what
		// we want to get ex username
		String username = request.getParameter("username");
		String usernameUpper = username.toUpperCase();
		String password = request.getParameter("password");
		String roles = request.getParameter("roles");
		if (usernameUpper.equals("ICSI518") && password.equals("Fall2017")) {
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
			if (usernameUpper.isEmpty() && password.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter username and password.");
			}
			 else if (usernameUpper.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter username.");
			} else if (password.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter password.");
			} else {
				request.setAttribute("errorMessage", "Invalid username and password.");
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
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}

}
