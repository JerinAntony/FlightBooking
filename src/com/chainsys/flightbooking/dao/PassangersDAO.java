package com.chainsys.flightbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.util.ConnectionUtil;

public class PassangersDAO {

	public void addPassangers(Passangers passanger) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String url = "INSERT INTO passengers(id,name,email,phonenumber,father_dateofbirth,username,password,created_date) VALUES (seq_passengers_id.NEXTVAL,?,?,?,?,?,?,?)";
		PreparedStatement preparedstatement = connection.prepareStatement(url);
		preparedstatement.setString(1, passanger.getName());
		preparedstatement.setString(2, passanger.getEmail());
		preparedstatement.setLong(3, passanger.getPhonenumber());
		preparedstatement.setDate(4,
				Date.valueOf(passanger.getFather_DateOfBirth()));
		preparedstatement.setString(5, passanger.getUsername());
		preparedstatement.setString(6, passanger.getPassword());
		preparedstatement.setTimestamp(7, passanger.getCreated_date());
		int row = preparedstatement.executeUpdate();
		ConnectionUtil.close(connection, preparedstatement, null);
	}

	public Passangers findById(int id) throws SQLException {
		Passangers passanger = null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,email,phonenumber,username,password,created_date FROM passengers where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset = preparedStatement.executeQuery();

		if (resultset.next()) {
			passanger = new Passangers();
			passanger.setId(resultset.getInt("id"));
			passanger.setName(resultset.getString("name"));
			passanger.setEmail(resultset.getString("email"));
		//	passanger.setPhonenumber(resultset.getInt("phonenumber"));
			passanger.setUsername(resultset.getString("username"));
			passanger.setPassword(resultset.getString("password"));
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return passanger;
	}

	public boolean checkLogin(Passangers passanger) throws SQLException {
		boolean isValue = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,email,phonenumber,father_dateofbirth,username,password FROM passengers where email=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, passanger.getEmail());
		preparedStatement.setString(2, passanger.getPassword());
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			isValue = true;
		} else {
			isValue = false;
		}
		ConnectionUtil.close(connection, preparedStatement, resultset);
		return isValue;
	}

	public boolean checkLoginEmail(Passangers passanger) throws SQLException {
		boolean isValue = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,email,phonenumber,father_dateofbirth,username,password FROM passengers where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, passanger.getEmail());

		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			isValue = true;
		} else {
			isValue = false;
		}
		ConnectionUtil.close(connection, preparedStatement, resultset);
		return isValue;
	}

	public Passangers getPassanger(Passangers passanger) throws SQLException {
		Passangers passangerobj = null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,email,phonenumber,father_dateofbirth,username,password FROM passengers where email=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, passanger.getEmail());
		preparedStatement.setString(2, passanger.getPassword());
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			passangerobj = new Passangers();
			passangerobj.setId(resultset.getInt("id"));
			passangerobj.setName(resultset.getString("name"));
			passangerobj.setEmail(resultset.getString("email"));
			passangerobj.setPhonenumber(resultset.getLong("phonenumber"));
			passangerobj.setUsername(resultset.getString("username"));
			passangerobj.setPassword(resultset.getString("password"));
		}
		ConnectionUtil.close(connection, preparedStatement, resultset);
		return passangerobj;
	}

	public Passangers checkForgetPassword(Passangers passanger)
			throws SQLException {
		Passangers forgetpassanger = null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,email,phonenumber,father_dateofbirth,username,password FROM passengers where phonenumber=? and email=? and father_dateofbirth=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, passanger.getPhonenumber());
		preparedStatement.setString(2, passanger.getEmail());
		preparedStatement.setDate(3,
				Date.valueOf(passanger.getFather_DateOfBirth()));
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			forgetpassanger = new Passangers();
			forgetpassanger.setId(resultset.getInt("id"));
			forgetpassanger.setName(resultset.getString("name"));
			forgetpassanger.setEmail(resultset.getString("email"));
			forgetpassanger.setPhonenumber(resultset.getLong("phonenumber"));
			forgetpassanger.setFather_DateOfBirth(resultset.getDate(
					"father_dateofbirth").toLocalDate());
			forgetpassanger.setUsername(resultset.getString("username"));
			forgetpassanger.setPassword(resultset.getString("password"));
		}
		ConnectionUtil.close(connection, preparedStatement, resultset);
		return forgetpassanger;
	}

	public void changePassword(Passangers passanger) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE passengers SET password=? where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, passanger.getPassword());
		preparedStatement.setInt(2, passanger.getId());
		preparedStatement.executeUpdate();
		ConnectionUtil.close(connection, preparedStatement, null);
	}

}
