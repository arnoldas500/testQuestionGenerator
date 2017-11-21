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
import model.MCQuestions;

/**
 * Servlet implementation class AnswerQuestions
 */
@WebServlet("/AnswerQuestions")
public class AnswerQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int qcounter = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerQuestions() {
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
		String action = request.getParameter("action");

		if ("AMCQuestionsServlet".equals(action)) {
//			int NqNum = 0;
//			int Nattempt = 0;
			request.getRequestDispatcher("/AMCQuestions.jsp").forward(request, response);
			//qNum = 0;
			//int i = 0;
			//i+=1;
			//System.out.println("testing i is :"+i);
			//request.getRequestDispatcher("/AMCQuestions.jsp").forward(request, response);
			
//			String answerUser = request.getParameter("answer");
//			String submit = request.getParameter("submit");
//			String next = request.getParameter("next");
//			//int qNum = request.getParameter("qNum");
//			int num = 1;
//			int userId = 0;
//			qcounter++;
//			System.out.println("qcounter "+qcounter);
//			try {
//				
//				userId = AuthDAO.getMCQ_id();
//				//userId -= 1;
//				//m.setUserId(userId);
//				System.out.println("Current user ID is : " + userId);
//				
//				System.out.println("inside try ");
//				System.out.println("user chosen answer "+ answerUser);
//				if(next != null) {
//					num +=1;
//					System.out.println("next Q, number "+ num);
//				}
//				System.out.println("question number "+ num);
//				System.out.println("butten pressed "+ submit);
//				System.out.println("butten pressed "+ next);
//				
//
//				/*
//				 * 
//				 * 
//				 */
//
//				MCQuestions amcq = new MCQuestions();
//
//				// this is where control will go from the jsp login post method
//				// this is where i check if the username and password are valid or not
//				// doGet(request, response);
//				// will get our information from the request and by specifying the name of what
//				// we want to get ex username
////				String username = request.getParameter("username");
////				String usernameUpper = username.toUpperCase();
////				String password = request.getParameter("password");
////				String roles = request.getParameter("roles");
//				// String signUp = request.getParameter("signUp");
//				String questions = null;
//				String choiceA = null;
//				String choiceB = null;
//				String choiceC = null;
//				String choiceD = null;
//				String answer = null;
//				String hint1 = null;
//				String hint2 = null;
//				String hint3 = null;
//				String feedback = null;
//				//int mcq_id = (Integer) null;
//
//				// creating sql queery from above data to fetch the data from the mySQL database
//				// String sql = "select * from User where username=? and password=? and role=?";
//				//String sql = "select * from MCQestions where questions=? and choiceA=? and choiceB=? and choiceC=? and choiceD=? and answer=? and hint1=? and hint2=? and hint3=? and feedback=?";
//				// String sql2 = "insert into User_Profile(firstName,lastname) values(?,?)";
//				String sql = "select * from MCQuestions where mcq_id=" + 1;
//
//				Class.forName("com.mysql.jdbc.Driver");
//
//				String url = "jdbc:mysql://localhost:3306/csi518";
//				String usernameSQL = "root";
//				String passwordSQL = "";
//				Connection connection = DriverManager.getConnection(url, usernameSQL, passwordSQL);
//
//				// execute sql command for users table
//				try (PreparedStatement ps = connection.prepareStatement(sql)) {
//					System.out.println("Connected to get mcQestions!");
////					ps.setString(1, questions);
////					ps.setString(2, choiceA);
////					ps.setString(3, roles);
//					int mcq_id = 1;
//					// ps.setString("jb2", jb2);
//					// ps.setString(3, roles);
//					// fetch the data and store it somewhere
//					ResultSet resultSet = ps.executeQuery();
//					PrintWriter out = response.getWriter();
//					while (resultSet.next()) {
//						questions = resultSet.getString("questions");
//						choiceA = resultSet.getString("choiceA");
//						choiceB = resultSet.getString("choiceB");
//						choiceC = resultSet.getString("choiceC");
//						choiceD = resultSet.getString("choiceD");
//						//answer = resultSet.getString("answer");
//						answer = resultSet.getString("answer");
//						hint1 = resultSet.getString("hint1");
//						hint2 = resultSet.getString("hint2");
//						hint3 = resultSet.getString("hint3");
//						feedback = resultSet.getString("feedback");
//						mcq_id = resultSet.getInt("mcq_id");
//					}
//
//					amcq.setQuestions(questions);
//					amcq.setChoiceA(choiceA);
//					amcq.setChoiceB(choiceB);
//					amcq.setChoiceC(choiceC);
//					amcq.setChoiceD(choiceD);
//					amcq.setAnswer(answer);
//					amcq.setHint1(hint1);
//					amcq.setHint2(hint2);
//					amcq.setHint3(hint3);
//					amcq.setFeedback(feedback);
//					amcq.setMcq_id(mcq_id);
//					
//					
//
//					String test = amcq.getQuestions();
//					PrintWriter out2 = response.getWriter();
//					out2.println("jbUSEr is **************  " + test);
//					System.out.println("jbUSEr is **************  " + test);;
//					
//					//User m = new User();
//					//m = AuthDAO.getUserById(userId);
//					
//					
//					//MCQuestions mcq = new MCQuestions();
//					//amcq = AuthDAO.getMCQById(mcq_id);
//					System.out.print("*testing get mcquestion by id for hint 1 : " + amcq.getHint1());
//
//					request.getSession().setAttribute("questions", amcq.getQuestions());
//					request.getSession().setAttribute("choiceA", amcq.getChoiceA());
//					request.getSession().setAttribute("choiceB", amcq.getChoiceB());
//					request.getSession().setAttribute("choiceC", amcq.getChoiceC());
//					request.getSession().setAttribute("choiceD", amcq.getChoiceD());
//					request.getSession().setAttribute("answer", amcq.getAnswer());
//					request.getSession().setAttribute("hint1", amcq.getHint1());
//					request.getSession().setAttribute("hint2", amcq.getHint2());
//					request.getSession().setAttribute("hint3", amcq.getHint3());
//					request.getSession().setAttribute("feedback", amcq.getFeedback());
//					//tryng to set question number
//					num+=1;
//					request.getSession().setAttribute("qNum", amcq.getMcq_id());
//					
//					//request.setAttribute("questions", amcq.getQuestions());
//					
//					request.getRequestDispatcher("/AMCQuestions.jsp").forward(request, response);
//					
//					/*
//					 * //checking if information actually exist in the database
//					 * if(username.equals(dbName) && password.equals(dbPassword) &&
//					 * roles.equals(dbRole)) { out.println("You have successfully signed in!");
//					 * }else { //response.sendRedirect("login.jsp"); RequestDispatcher rd =
//					 * request.getRequestDispatcher("login.jsp"); rd.include(request, response);
//					 * //could also use forward instead of include }
//					 */
//
//					// if (usernameUpper.equals(dbName) && password.equals(dbPassword)) {
//					//if (username.equals(dbName) && password.equals(dbPassword) && roles.equals(dbRole)) {
//						// if login is successfull then redirect to members jsp page
//						// request.getSession().removeAttribute("errorMessage");
//						// response.sendRedirect("members.jsp");
//
////						userId = AuthDAO.getUserId();
////						userId -= 1;
////						jb2.setUserId(userId);
//						//System.out.println("Current user ID is : " + userId);
////						User m = new User();
////						m = AuthDAO.getUserById(userId);
////						System.out.print("testing get user by id for Firstname : " + m.getFirstname());
////						System.out.print("testing get user by id for Firstname : " + m.getLastname());
//
//						//if (roles.equals("Student")) {
////							request.getSession().setAttribute("currentUser", username);
////							request.getSession().setAttribute("roles", roles);
//							//request.getSession().setAttribute("firstName", m.getFirstname());
//							//request.getSession().setAttribute("lastName", m.getLastname());
//							//request.getRequestDispatcher("Student.jsp").forward(request, response);
//							// request.setAttribute("currentDate", "Please enter username.");
//						//}
//
//						
//						//request.getRequestDispatcher("Login.jsp").forward(request, response); // could also use include
//					//}
//
//				}
//
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				System.out.println("exception");
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println("exception");
//				e.printStackTrace();
//			}
//			
//			
		} else if ("ANuQuestionsServlet".equals(action)) {
//			int NqNum = 0;
//			int Nattempt = 0;
			request.getRequestDispatcher("/ANuQuestion.jsp").forward(request, response);
		}
		
		doGet(request, response);
	}

}
