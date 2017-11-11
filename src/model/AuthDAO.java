package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
