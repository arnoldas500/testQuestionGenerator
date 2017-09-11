

import java.io.IOException;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//this is where control will go from the jsp login post method 
		//this is where i check if the username and password are valid or not
		//doGet(request, response);
		//will get our information from the request and by specifying the name of what we want to get ex username
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String roles = request.getParameter("roles");
		if(username.equals("ICSI518") && password.equals("Fall2017")) {
			//if login is successfull then redirect to members jsp page
            //	request.getSession().removeAttribute("errorMessage");
			//response.sendRedirect("members.jsp");
			if(roles.equals("Supplier")) {
				request.getRequestDispatcher("Supplier.jsp").forward(request, response);
			}
			
			if(roles.equals("Wholesaler")) {
				request.getRequestDispatcher("Wholesaler.jsp").forward(request, response);
			}
			
			//request.getRequestDispatcher("members.jsp").forward(request, response);
		}else { //if the username or password incorrect will go here
			//if not succesfull redirect to error.jsp
			//response.sendRedirect("error.jsp");
			//	request.getSession().removeAttribute("errorMessage");
			if(username.equals("ICSI518") && password.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter password.");
			}
			else if(username.isEmpty() && password.equals("Fall2017")) {
				request.setAttribute("errorMessage", "Please enter username.");
			}
			else if(username.isEmpty() && password.isEmpty()) {
				request.setAttribute("errorMessage", "Please enter username and password.");
			}else {
				request.setAttribute("errorMessage", "Invalid username and password.");
			}
			/*
			if(!(username.equals("ICSI518")) && !(password.equals("Fall2017"))) {
				request.getSession().setAttribute("errorMessage", "Invalid username and password.");
			}*/
			//request.getSession().setAttribute("errorMessage", "Please enter username and password");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		

	}

}
