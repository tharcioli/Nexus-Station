package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/nexusDataBase";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Th7391710173";

	public void cadastrarUsuario(CadastroVO players) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			String sql = "INSERT INTO players (userID, email, password, acessWork, tip) VALUES (?, ?, ?, ?, ?)";

			statement = connection.prepareStatement(sql);

			statement.setString(1, players.getUserID());
			statement.setString(2, players.getEmail());
			statement.setString(3, players.getPassword());
			statement.setString(4, players.getAcessWork());
			statement.setString(5, players.getTip());

			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

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

	public boolean verificarEmailExistente(String email) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT email FROM players WHERE email = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			resultSet = statement.executeQuery();

			return resultSet.next(); // Retorna true se o email já existe no banco de dados.

		} catch (SQLException e) {

			e.printStackTrace();
			return false; // Em caso de erro, retorna false.

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