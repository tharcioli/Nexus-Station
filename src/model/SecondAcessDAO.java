package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecondAcessDAO {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/nexusDataBase";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Th7391710173";

	public boolean verificarPalavraCorreta(String userID, String accessWork) {

		String query = "SELECT COUNT(*) FROM players WHERE userID = ? AND acessWork = ?";
		boolean palavraCorreta = false;

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, userID);
			statement.setString(2, accessWork);

			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next()) {

					int count = resultSet.getInt(1);
					palavraCorreta = count > 0;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return palavraCorreta;
	}

	public String buscarDica(String userID) {

		String tip = null;
		String query = "SELECT tip FROM players WHERE userID = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, userID);

			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next())
					tip = resultSet.getString("tip");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return tip;
	}
}
