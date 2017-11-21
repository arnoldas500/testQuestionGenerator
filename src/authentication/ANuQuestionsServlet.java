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
import model.NuQuestions;

/**
 * Servlet implementation class ANuQuestionsServlet
 */
@WebServlet("/ANuQuestionsServlet")
public class ANuQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//global var for counter
		public int NqNum = 0;
		public int Nattempt = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ANuQuestionsServlet() {
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
		// TODO Auto-generated method stub
				String answerUser = request.getParameter("answer");
				String submit = request.getParameter("submit");
				String next = request.getParameter("next");
				//int NqNum = request.getParameter("NqNum");
				int num = 1;
				int nuq_id1 = 0;
				//NqNum is the question number
//				qNum++;
//				System.out.println("\nqNum "+qNum);
				try {
					
					nuq_id1 = AuthDAO.getNuQ_id();
					//userId -= 1;
					//m.setUserId(userId);
					nuq_id1--;
					System.out.println("Current mcq_id is : " + nuq_id1);
					
					System.out.println("inside try ");
					System.out.println("user chosen answer "+ answerUser);
					if(next != null) {
						NqNum++;
						System.out.println("\n NqNum "+NqNum);
						//reset Nattempt counter
						Nattempt=0;
					}
					
					if(submit != null) {
						Nattempt++;
						System.out.println("\n Nattempt "+Nattempt);
						//use cases here
					}
					//System.out.println("question number "+ num);
					System.out.println("butten pressed "+ submit);
					System.out.println("butten pressed "+ next);
					

					/*
					 * 
					 * 
					 */

					//MCQuestions nuq = new MCQuestions();
					NuQuestions nuq = new NuQuestions();

					// this is where control will go from the jsp login post method
					// this is where i check if the username and password are valid or not
					// doGet(request, response);
					// will get our information from the request and by specifying the name of what
					// we want to get ex username
//					String username = request.getParameter("username");
//					String usernameUpper = username.toUpperCase();
//					String password = request.getParameter("password");
//					String roles = request.getParameter("roles");
					// String signUp = request.getParameter("signUp");
					String questions = null;
					
					String answer = null;
					String hint1 = null;
					String hint2 = null;
					String hint3 = null;
					String feedback = null;
					Boolean correct = true;
					//int mcq_id = (Integer) null;

					// creating sql queery from above data to fetch the data from the mySQL database
					// String sql = "select * from User where username=? and password=? and role=?";
					//String sql = "select * from MCQestions where questions=? and choiceA=? and choiceB=? and choiceC=? and choiceD=? and answer=? and hint1=? and hint2=? and hint3=? and feedback=?";
					// String sql2 = "insert into User_Profile(firstName,lastname) values(?,?)";
					String sql = "select * from NuQuestions where nuq_id=" + NqNum;

					Class.forName("com.mysql.jdbc.Driver");

					String url = "jdbc:mysql://localhost:3306/csi518";
					String usernameSQL = "root";
					String passwordSQL = "";
					Connection connection = DriverManager.getConnection(url, usernameSQL, passwordSQL);

					// execute sql command for users table
					try (PreparedStatement ps = connection.prepareStatement(sql)) {
						System.out.println("Connected to get mcQestions!");
//						ps.setString(1, questions);
//						ps.setString(2, choiceA);
//						ps.setString(3, roles);
						int nuq_id = 1;
						// ps.setString("jb2", jb2);
						// ps.setString(3, roles);
						// fetch the data and store it somewhere
						ResultSet resultSet = ps.executeQuery();
						PrintWriter out = response.getWriter();
						while (resultSet.next()) {
							questions = resultSet.getString("question");
							
							//answer = resultSet.getString("answer");
							answer = resultSet.getString("answer");
							hint1 = resultSet.getString("hint1");
							hint2 = resultSet.getString("hint2");
							hint3 = resultSet.getString("hint3");
							feedback = resultSet.getString("feedback");
							nuq_id = resultSet.getInt("nuq_id");
						}

						nuq.setQuestion(questions);
						
						nuq.setAnswer(answer);
						nuq.setHint1(hint1);
						nuq.setHint2(hint2);
						nuq.setHint3(hint3);
						nuq.setFeedback(feedback);
						//nuq.setMcq_id(mcq_id);
						nuq.setNuq_id(nuq_id);
						
						

						String test = nuq.getQuestion();
						PrintWriter out2 = response.getWriter();
						out2.println("jbUSEr is **************  " + test);
						System.out.println("jbUSEr is **************  " + test);;
						
						//User m = new User();
						//m = AuthDAO.getUserById(userId);
						
						
						//MCQuestions mcq = new MCQuestions();
						//nuq = AuthDAO.getMCQById(mcq_id);
						System.out.print("*testing get mcquestion by id for hint 1 : " + nuq.getHint1());

						request.getSession().setAttribute("questions", nuq.getQuestion());
//						request.getSession().setAttribute("choiceA", nuq.getChoiceA());
//						request.getSession().setAttribute("choiceB", nuq.getChoiceB());
//						request.getSession().setAttribute("choiceC", nuq.getChoiceC());
//						request.getSession().setAttribute("choiceD", nuq.getChoiceD());
						//request.getSession().setAttribute("answer", nuq.getAnswer());
						System.out.print("\nDBanswer is : "+nuq.getAnswer());
						System.out.print("\nUser selectd answer is : "+answerUser);
						
						
						
						
						if(Nattempt < 1 && correct) {
							request.getSession().setAttribute("hint1", "");
							request.getSession().setAttribute("hint2", "");
							request.getSession().setAttribute("hint3", "");
							request.getSession().setAttribute("message", "");
							request.getSession().setAttribute("feedback", "");
							request.getSession().setAttribute("flag", "");
							
						}
						if (Nattempt >=1 && correct) {
							request.getSession().setAttribute("hint1", nuq.getHint1());
							request.getSession().setAttribute("flag", "Incorrect! Nattempt "+ Nattempt);
						}else {
							request.getSession().setAttribute("hint1", "");
						}
						if (Nattempt >=2 && correct) {
							request.getSession().setAttribute("hint2", nuq.getHint2());
							request.getSession().setAttribute("flag", "Incorrect! Nattempt "+ Nattempt);
						}else {
							request.getSession().setAttribute("hint2", "");
						}
						if (Nattempt >=3 && correct) {
							request.getSession().setAttribute("hint3", nuq.getHint3());
							request.getSession().setAttribute("message", "out of chances, right answer is: "+nuq.getAnswer());
							request.getSession().setAttribute("feedback", nuq.getFeedback());
							request.getSession().setAttribute("flag", "Incorrect! Nattempt "+ Nattempt);
						}else {
							request.getSession().setAttribute("hint3", "");
							request.getSession().setAttribute("message", "");
							request.getSession().setAttribute("feedback", "");
						}
						
						if (answerUser.equals(nuq.getAnswer())) {
							request.getSession().setAttribute("flag", "Correct!");
							request.getSession().setAttribute("message", "Correct!");
							request.getSession().setAttribute("feedback", "This is test 2");
							correct = false;
						}
						
						request.getSession().setAttribute("NqNum", NqNum);
						
						System.out.print("\nNqNum is : "+NqNum);
						System.out.print("\nMCQ ID1 is : "+nuq_id1);
						if ((nuq_id1 == NqNum) && (submit == null)) {
							request.getSession().setAttribute("flag", "This is the last question!");
							request.getSession().setAttribute("message", "This is the last question!");
						}else if ((NqNum > nuq_id1) && (submit == null)) {
							request.getSession().setAttribute("flag", "There is no more questions!");
							request.getSession().setAttribute("message", "There is no more questions!");
							request.getSession().setAttribute("hint1", "");
							request.getSession().setAttribute("hint2", "");
							request.getSession().setAttribute("hint3", "");
							//request.getSession().setAttribute("message", "");
							request.getSession().setAttribute("feedback", "");
						}
						
						//tryng to set question number
						num+=1;
						
						
						//request.setAttribute("questions", nuq.getQuestions());
						
						request.getRequestDispatcher("/ANuQuestion.jsp").forward(request, response);
						
						

					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("exception");
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("exception");
					e.printStackTrace();
				}
		//doGet(request, response);
	}

}
