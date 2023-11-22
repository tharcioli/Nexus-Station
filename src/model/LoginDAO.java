package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/nexusDataBase";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Th7391710173";

	public boolean verificarUserIDExistente(String userID) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT userID FROM players WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			resultSet = statement.executeQuery();

			return resultSet.next();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {
			
			try {

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public boolean verificarCredenciais(String userID, String password) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT userID FROM players WHERE userID = ? AND password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			statement.setString(2, password);
			resultSet = statement.executeQuery();

			return resultSet.next();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {

			try {

				if (resultSet != null)
					resultSet.close();

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public boolean verificarCredenciaisSecundarias(String userID, String acessWork) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT userID FROM players WHERE userID = ? AND acessWork = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			statement.setString(2, acessWork);
			resultSet = statement.executeQuery();

			return resultSet.next();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {

			try {

				if (resultSet != null)
					resultSet.close();

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}