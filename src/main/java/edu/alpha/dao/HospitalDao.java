package edu.alpha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalDao {

	// Using Statement
	/*
	 * public void saveHospital(int hospitalId, String hospitalName, String email,
	 * long phoneNumber) { try { // Step 1 load the Driver
	 * Class.forName("com.mysql.cj.jdbc.Driver"); // Step 2 Get the Connection
	 * String dbUrl = "jdbc:mysql://localhost:3306"; String user = "root"; String
	 * password = "root";
	 * 
	 * Connection connection = DriverManager.getConnection(dbUrl, user, password);
	 * 
	 * // Step 3 Write the Query and Create the Statement
	 * 
	 * String sqlQuery = "insert into carapp_jdbc.hospital values(102,'Manipal'," +
	 * "'info@manipal.in',7026976652)";
	 * 
	 * Statement statement = connection.createStatement();
	 * 
	 * // Step 4 is to Execute the Query and Process the Result
	 * 
	 * int result = statement.executeUpdate(sqlQuery); if (result == 1) {
	 * System.out.println("Hospial Info Added!!"); } else {
	 * System.err.println("Hospial Info Not Added!!!"); } // Step 5 Is to Close the
	 * Connection
	 * 
	 * connection.close(); statement.close();
	 * 
	 * } catch (ClassNotFoundException e) {
	 * System.err.println("Driver Class Not Found"); } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 */

	public void saveHospital(int hospitalId, String hospitalName, String email, long phoneNumber) {
		try {
			// Step 1 load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 2 Get the Connection
			String dbUrl = "jdbc:mysql://localhost:3306";
			String user = "root";
			String password = "root";

			Connection connection = DriverManager.getConnection(dbUrl, user, password);

			// Step 3 Write the Query and Create the Statement

			String sqlQuery = "insert into carapp_jdbc.hospital values(?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

			// To Replace the PlaceHolders with actual values we have Helper methods are
			// setDataTypes(Position of placeHolders, values)

			preparedStatement.setInt(1, hospitalId);
			preparedStatement.setString(2, hospitalName);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, phoneNumber);

			// Step 4 is to Execute the Query and Process the Result

			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				System.out.println("Hospial Info Added!!");
			} else {
				System.err.println("Hospial Info Not Added!!!");
			}
			// Step 5 Is to Close the Connection

			connection.close();
			preparedStatement.close();

		} catch (ClassNotFoundException e) {
			System.err.println("Driver Class Not Found");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateHospital(int hospitalId, String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(dbUrl, user, password);

			String sqlQuery = "UPDATE carapp_jdbc.hospital SET email=? WHERE hospitalId=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, hospitalId);

			if (preparedStatement.executeUpdate() == 1) {
				System.out.println("Hospital Email Updated!!!");
			} else {
				System.out.println("Hospital Email Not Updated!!!");
			}

			connection.close();
			preparedStatement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void findById(int hospitalId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String dbUrl = "jdbc:mysql://localhost:3306";
			String user = "root";
			String password = "root";

			Connection connection = DriverManager.getConnection(dbUrl, user, password);

			String sqlQuery = "SELECT * FROM carapp_jdbc.hospital WHERE hospitalId=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, hospitalId);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				System.out.print("HospitalId = " + resultSet.getInt(1) + "\t");
				System.out.print("HospitalName = " + resultSet.getString(2) + "\t");
				System.out.print("HospitalEmail = " + resultSet.getString(3) + "\t");
				System.out.println("HospitalPhoneNumber = " + resultSet.getLong(4) + "\t");

			} else {
				System.err.println("Hospital With the Given Id Not Found");
			}

			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void findAll() {

	}

	public void deleteHospital(int hospitalId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String dbUrl = "jdbc:mysql://localhost:3306";
			String user = "root";
			String password = "root";

			Connection connection = DriverManager.getConnection(dbUrl, user, password);
			String sqlQuery = "DELETE FROM carapp_jdbc.hospital WHERE hospitalId=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, hospitalId);

			if (preparedStatement.executeUpdate() == 1) {
				System.out.println("Hospital With the Given Id Is Removed");
			} else {
				System.err.println("Hospital With the Given Id Not Found");
			}

			connection.close();
			preparedStatement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
