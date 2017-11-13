package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import authentication.MCQuestions;

public class AuthDAO {

	// method to create connection to database
	private static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/csi518";
			String usernameSQL = "root";
			String passwordSQL = "";
			connection = DriverManager.getConnection(url, usernameSQL, passwordSQL);
			System.out.println("Connection successful!");
		} catch (ClassNotFoundException e) {

			// sendErrorRedirect(request, response, "/signup.jsp", e);
			// request.setAttribute("errorMessage", "Username existed");
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return connection;
	}

	public static int checkUserNameAvailable(User m, String sql3) {
		// String sql3 = "select * from User where username=?";
		int k = 0;
		String dbName2 = null;
		Connection connection = connect();
		try (PreparedStatement ps3 = connection.prepareStatement(sql3)) {
			ps3.setString(1, m.getUsername());
			// ps3.setString(2, password);
			// ps.setString("jb2", jb2);
			// ps.setString(3, roles);
			// fetch the data and store it somewhere
			ResultSet resultSet = ps3.executeQuery();
			// PrintWriter out = response.getWriter();
			while (resultSet.next()) {
				dbName2 = resultSet.getString("username");
				// dbPassword = resultSet.getString("password");
				// dbRole = resultSet.getString("role");
			}
			System.out.println("Username from database is : " + dbName2);
			// out.println("jbUSEr is ************** "+test);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (dbName2 == null) {
			k++;
		} else {
			k = 0;
		}

		return k;
	}
	//enterNewNuQuestion
	// method to insert new info into nuquesions into database
		public static int enterNewNuQuestion(NuQuestions nuq, String sql) {
			//String sql = "insert into MCQuestions(questions,answer,hint1,hint2,hint3,feedback) values(?,?,?,?,?,?,?)";

			int i = 0;
			Connection connection = connect();
			try (PreparedStatement ps = connection.prepareStatement(sql)) {
				// setting the values
				ps.setString(1, nuq.getQuestion());
				ps.setString(2, nuq.getAnswer());
				ps.setString(3, nuq.getHint1());
				ps.setString(4, nuq.getHint2());
				ps.setString(5, nuq.getHint3());
				ps.setString(6, nuq.getFeedback());
				// now need to execute this statement
				i = ps.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return i;
		}
	
	
	// method to insert new info into mcquesions into database
	public static int enterNewMCQuestion(MCQuestions mcq, String sql) {
		//String sql = "insert into MCQuestions(questions,choiceA,choiceB,choiceB,choiceC,choiceD,answer,hint1,hint2,hint3,feedback) values(?,?,?,?,?,?,?,?,?,?,?)";

		int i = 0;
		Connection connection = connect();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			// setting the values
			ps.setString(1, mcq.getQuestions());
			ps.setString(2, mcq.getChoiceA());
			ps.setString(3, mcq.getChoiceB());
			ps.setString(4, mcq.getChoiceC());
			ps.setString(5, mcq.getChoiceD());
			ps.setString(6, mcq.getAnswer());
			ps.setString(7, mcq.getHint1());
			ps.setString(8, mcq.getHint2());
			ps.setString(9, mcq.getHint3());
			ps.setString(10, mcq.getFeedback());
			// now need to execute this statement
			i = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return i;
	}

	// method to insert new users into database
	public static int signupUser(User m, String sql) {
		// String sql = "insert into User(username,password,role) values(?,?,?)";
		int i = 0;
		Connection connection = connect();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			// setting the values
			ps.setString(1, m.getUsername());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getRole());
			// now need to execute this statement
			i = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return i;
	}

	public static int signupUser_Profile(User m, String sql2) {
		// String sql2 = "insert into User_Profile(firstName,lastname) values(?,?)";
		int j = 0;
		Connection connection = connect();
		try (PreparedStatement ps2 = connection.prepareStatement(sql2)) {
			ps2.setInt(1, m.getUserId());
			ps2.setString(2, m.getFirstname());
			ps2.setString(3, m.getLastname());
			// now need to execute this statement
			j = ps2.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return j;
	}

	// method to get NuQuestions nuq_id
			public static int getNuQ_id() {

				int ID = -1;
				try (Connection connection = connect()) {
					String sql = "SELECT nuq_id FROM NuQuestions ORDER BY nuq_id DESC LIMIT 1";
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery(sql);

					if (rs.next()) {
						ID = rs.getInt("nuq_id");
						ID += 1;
					} else { // if table is empty then start the id from 1
						ID = 1;
					}

					rs.close();
					st.close();

				} catch (SQLException e) {
					// sendErrorRedirect(request, response, "/signup.jsp", e);
					// request.setAttribute("errorMessage", "Username existed");
					e.printStackTrace();
				}

				return ID;
			}
	
	// method to get MCQuestions mcq_id
		public static int getMCQ_id() {

			int ID = -1;
			try (Connection connection = connect()) {
				String sql = "SELECT mcq_id FROM MCQuestions ORDER BY mcq_id DESC LIMIT 1";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);

				if (rs.next()) {
					ID = rs.getInt("mcq_id");
					ID += 1;
				} else { // if table is empty then start the id from 1
					ID = 1;
				}

				rs.close();
				st.close();

			} catch (SQLException e) {
				// sendErrorRedirect(request, response, "/signup.jsp", e);
				// request.setAttribute("errorMessage", "Username existed");
				e.printStackTrace();
			}

			return ID;
		}
	
	
	
	// method to get user id
	public static int getUserId() {

		int ID = -1;
		try (Connection connection = connect()) {
			String sql = "SELECT userId FROM User ORDER BY userId DESC LIMIT 1";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				ID = rs.getInt("userId");
				ID += 1;
			} else { // if table is empty then start the id from 1
				ID = 1;
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			// sendErrorRedirect(request, response, "/signup.jsp", e);
			// request.setAttribute("errorMessage", "Username existed");
			e.printStackTrace();
		}

		return ID;
	}
	
	public static NuQuestions getNuQById(int nuq_id) {
		NuQuestions nuq = new NuQuestions();
		try (Connection connection = connect()) {
			String sql = "SELECT * FROM User_Profile WHERE userId=" + nuq_id;
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				nuq.setNuq_id(nuq_id);
				// m.setFirstname("firstname");
				nuq.setQuestion(rs.getString("questions"));
				
				nuq.setAnswer(rs.getString("answer"));
				nuq.setHint1(rs.getString("hint1"));
				nuq.setHint2(rs.getString("hint2"));
				nuq.setHint3(rs.getString("hint3"));
				nuq.setFeedback(rs.getString("feedback"));

			}

			System.out.print("Checking if got answers : " + nuq.getAnswer());
			System.out.print("Checking if got feedback : " + nuq.getFeedback());
			rs.close();
			st.close();

		} catch (SQLException e) {
			// sendErrorRedirect(request, response, "/signup.jsp", e);
			// request.setAttribute("errorMessage", "Username existed");
			e.printStackTrace();
		}

		return nuq;
	}

	
	public static MCQuestions getMCQById(int mcq_id) {
		MCQuestions mcq = new MCQuestions();
		try (Connection connection = connect()) {
			String sql = "SELECT * FROM User_Profile WHERE userId=" + mcq_id;
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				mcq.setMcq_id(mcq_id);
				// m.setFirstname("firstname");
				mcq.setQuestions(rs.getString("questions"));
				mcq.setChoiceA(rs.getString("choiceA"));
				mcq.setChoiceB(rs.getString("choiceB"));
				mcq.setChoiceC(rs.getString("choiceC"));
				mcq.setChoiceD(rs.getString("choiceD"));
				mcq.setAnswer(rs.getString("answer"));
				mcq.setHint1(rs.getString("hint1"));
				mcq.setHint2(rs.getString("hint2"));
				mcq.setHint3(rs.getString("hint3"));
				mcq.setFeedback(rs.getString("feedback"));

			}

			System.out.print("Checking if got answers : " + mcq.getAnswer());
			System.out.print("Checking if got feedback : " + mcq.getFeedback());
			rs.close();
			st.close();

		} catch (SQLException e) {
			// sendErrorRedirect(request, response, "/signup.jsp", e);
			// request.setAttribute("errorMessage", "Username existed");
			e.printStackTrace();
		}

		return mcq;
	}

	public static User getUserById(int userId) {
		User m = new User();
		try (Connection connection = connect()) {
			String sql = "SELECT * FROM User_Profile WHERE userId=" + userId;
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				m.setUserId(userId);
				// m.setFirstname("firstname");
				m.setFirstname(rs.getString("firstname"));
				m.setLastname(rs.getString("lastname"));
				m.setUsername(rs.getString("username"));

			}

			System.out.print("Checking if got first name : " + m.getFirstname());
			System.out.print("Checking if got last name : " + m.getLastname());
			rs.close();
			st.close();

		} catch (SQLException e) {
			// sendErrorRedirect(request, response, "/signup.jsp", e);
			// request.setAttribute("errorMessage", "Username existed");
			e.printStackTrace();
		}

		return m;
	}

}
