package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthDAO {
	
	private static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/portal";
			String usernameSQL = "root";
			String passwordSQL = "";
			connection = DriverManager.getConnection(url,usernameSQL,passwordSQL);
			System.out.println("Connection successful!");
		} catch (ClassNotFoundException e) {
			
			//sendErrorRedirect(request, response, "/signup.jsp", e);
			//request.setAttribute("errorMessage", "Username existed");
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}

	public static int signupUser(ModelMVC m, String sql) {
		//String sql = "insert into User(username,password,role) values(?,?,?)";
		int i = 0;
		Connection connection = connect();
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			//setting the values
			ps.setString(1, m.getUsername());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getRole());
			//now need to execute this statement
			i = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
	}

	

}
