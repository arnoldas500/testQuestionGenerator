package authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.MCQuestions;
import model.User;

/**
 * Servlet implementation class MCQuestionsServlet
 */
@WebServlet("/MCQuestionsServlet")
public class MCQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MCQuestionsServlet() {
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
		// retriving all paramenters from JSP page
				String questions = request.getParameter("questions");
				String choiceA = request.getParameter("choiceA");
				String choiceB = request.getParameter("choiceB");
				String choiceC = request.getParameter("choiceC");
				String choiceD = request.getParameter("choiceD");
				String answer = request.getParameter("answer");
				String hint1 = request.getParameter("hint1");
				String hint2 = request.getParameter("hint2");
				String hint3 = request.getParameter("hint3");
				String feedback = request.getParameter("feedback");
				int userId = 0;
				String dbName2 = null;

				// setting all the values in the model class object
				MCQuestions mcq = new MCQuestions();
				
				mcq.setQuestions(questions);
				mcq.setChoiceA(choiceA);
				mcq.setChoiceB(choiceB);
				mcq.setChoiceC(choiceC);
				mcq.setChoiceD(choiceD);
				mcq.setAnswer(answer);
				mcq.setHint1(hint1);
				mcq.setHint2(hint2);
				mcq.setHint3(hint3);
				mcq.setFeedback(feedback);

				
				String sql3 = "select * from User where username=?";
				
				
				// calling a method in DAO class to insert data into table
				String sql = "insert into MCQuestions(questions,choiceA,choiceB,choiceC,choiceD,answer,hint1,hint2,hint3,feedback) values(?,?,?,?,?,?,?,?,?,?)";
				int i = AuthDAO.enterNewMCQuestion(mcq, sql);

				if (i != 0) {
					System.out.println("Values inserted successfully into MCQuestions table!");

				} else {
					System.out.println("Error! Values not inserted into User table!");
				}

		
		
		doGet(request, response);
	}

}
