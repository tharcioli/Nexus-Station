package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPanelDAO {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/nexusDataBase";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Th7391710173";

	public String getUserEmail(String userID) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT email FROM players WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getString("email");
			}

			return null;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

				if (resultSet != null)
					resultSet.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public String getUserPassword(String userID) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT password FROM players WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getString("password");
			}

			return null;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

				if (resultSet != null)
					resultSet.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public String getUserAcessWork(String userID) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT acessWork FROM players WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getString("acessWork");
			}

			return null;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

				if (resultSet != null)
					resultSet.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public String getUserTip(String userID) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT tip FROM players WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getString("tip");
			}

			return null;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

				if (resultSet != null)
					resultSet.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public boolean deleteUser(String userID) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "DELETE FROM players WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);

			int rowsDeleted = statement.executeUpdate();

			if (rowsDeleted > 0)
				return true;

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

		return false;
	}

	public boolean canUpdateUserID(String userID, String newUserID) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT COUNT(*) FROM players WHERE userID = ? AND userID != ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newUserID);
			statement.setString(2, userID);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				int count = resultSet.getInt(1);
				return count == 0;
			}

			return false;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {

			try {

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

				if (resultSet != null)
					resultSet.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public boolean updateUserID(String userID, String newUserID) {

		if (!canUpdateUserID(userID, newUserID))
			return false;

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "UPDATE players SET userID = ? WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newUserID);
			statement.setString(2, userID);

			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;

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

	public boolean canUpdateEmail(String userID, String newEmail) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT COUNT(*) FROM players WHERE email = ? AND userID != ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newEmail);
			statement.setString(2, userID);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				int count = resultSet.getInt(1);
				return count == 0;
			}

			return false;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {

			try {

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();

				if (resultSet != null)
					resultSet.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public boolean updateEmail(String userID, String newEmail) {

		if (!canUpdateEmail(userID, newEmail))
			return false;

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "UPDATE players SET email = ? WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newEmail);
			statement.setString(2, userID);

			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;

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

	public boolean updatePassword(String userID, String newPassword) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "UPDATE players SET password = ? WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newPassword);
			statement.setString(2, userID);

			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;

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

	public boolean updateAcessWork(String userID, String newAcessWork) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "UPDATE players SET acessWork = ? WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newAcessWork);
			statement.setString(2, userID);

			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;

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

	public boolean updateTip(String userID, String newTip) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "UPDATE players SET tip = ? WHERE userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newTip);
			statement.setString(2, userID);

			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;

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

}
