package com.chainsys.flightbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.util.ConnectionUtil;

public class PassangersDAO {

	/**
	 * Method to Add Registeration Passenger
	 * 
	 * @param passanger
	 * @throws SQLException
	 */
	public void addPassangers(Passangers passanger) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String url = "INSERT INTO passengers(id,name,email,phonenumber,father_dateofbirth,username,password,created_date) VALUES (seq_passengers_id.NEXTVAL,?,?,?,?,?,?,?)";
			preparedstatement = connection.prepareStatement(url);
			preparedstatement.setString(1, passanger.getName());
			preparedstatement.setString(2, passanger.getEmail());
			preparedstatement.setLong(3, passanger.getPhonenumber());
			preparedstatement.setDate(4,
					Date.valueOf(passanger.getFather_DateOfBirth()));
			preparedstatement.setString(5, passanger.getUsername());
			preparedstatement.setString(6, passanger.getPassword());
			preparedstatement.setTimestamp(7, passanger.getCreated_date());
			preparedstatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, null);
		}
	}

	/**
	 * Method to find passenger by Id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Passangers findById(int id) throws SQLException {
		Passangers passanger = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,email,phonenumber,username,password,created_date FROM passengers where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				passanger = new Passangers();
				passanger.setId(resultset.getInt("id"));
				passanger.setName(resultset.getString("name"));
				passanger.setEmail(resultset.getString("email"));
				// passanger.setPhonenumber(resultset.getInt("phonenumber"));
				passanger.setUsername(resultset.getString("username"));
				passanger.setPassword(resultset.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return passanger;
	}

	/**
	 * Method to check
	 * 
	 * @param passanger
	 * @return
	 * @throws SQLException
	 */
	public boolean checkLogin(Passangers passanger) throws SQLException {
		boolean isValue = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,email,phonenumber,father_dateofbirth,username,password FROM passengers where email=? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, passanger.getEmail());
			preparedStatement.setString(2, passanger.getPassword());
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				isValue = true;
			} else {
				isValue = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return isValue;
	}

	public boolean checkLoginEmail(Passangers passanger) throws SQLException {
		boolean isValue = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,email,phonenumber,father_dateofbirth,username,password FROM passengers where email=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, passanger.getEmail());
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				isValue = true;
			} else {
				isValue = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return isValue;
	}

	public Passangers getPassanger(Passangers passanger) throws SQLException {
		Passangers passangerobj = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,email,phonenumber,father_dateofbirth,username,password FROM passengers where email=? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, passanger.getEmail());
			preparedStatement.setString(2, passanger.getPassword());
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				passangerobj = new Passangers();
				passangerobj.setId(resultset.getInt("id"));
				passangerobj.setName(resultset.getString("name"));
				passangerobj.setEmail(resultset.getString("email"));
				passangerobj.setPhonenumber(resultset.getLong("phonenumber"));
				passangerobj.setUsername(resultset.getString("username"));
				passangerobj.setPassword(resultset.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return passangerobj;

	}

	public Passangers checkForgetPassword(Passangers passanger)
			throws SQLException {
		Passangers forgetpassanger = null;
		Connection connection = null;
		ResultSet resultset = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,email,phonenumber,father_dateofbirth,username,password FROM passengers where phonenumber=? and email=? and father_dateofbirth=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, passanger.getPhonenumber());
			preparedStatement.setString(2, passanger.getEmail());
			preparedStatement.setDate(3,
					Date.valueOf(passanger.getFather_DateOfBirth()));
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				forgetpassanger = new Passangers();
				forgetpassanger.setId(resultset.getInt("id"));
				forgetpassanger.setName(resultset.getString("name"));
				forgetpassanger.setEmail(resultset.getString("email"));
				forgetpassanger
						.setPhonenumber(resultset.getLong("phonenumber"));
				forgetpassanger.setFather_DateOfBirth(resultset.getDate(
						"father_dateofbirth").toLocalDate());
				forgetpassanger.setUsername(resultset.getString("username"));
				forgetpassanger.setPassword(resultset.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return forgetpassanger;
	}

	/**Method to update change password
	 * @param passanger
	 * @throws SQLException
	 */
	public void changePassword(Passangers passanger) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE passengers SET password=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, passanger.getPassword());
			preparedStatement.setInt(2, passanger.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	public boolean checkUsername(String username) throws SQLException {
		Connection connection = null;
		ResultSet resultset = null;
		boolean isAvailable = false;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT username FROM passengers where username=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				isAvailable = true;
			} else {
				isAvailable = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return isAvailable;
	}

}
