package com.chainsys.flightbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.util.ConnectionUtil;

public class AirlinesDAO {

	public void addAirline(Airlines airlines) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String url = "INSERT INTO airlines(id,airlines_name) VALUES(seq_airlinesid.NEXTVAL,?)";
		PreparedStatement preparedstatement = connection.prepareStatement(url);
		preparedstatement.setString(1, airlines.getAirlinesName());
		preparedstatement.executeUpdate();
		ConnectionUtil.close(connection, preparedstatement, null);
	}

	public ArrayList<Airlines> findAll() throws SQLException {
		ArrayList<Airlines> airlinesLists = new ArrayList<>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,airlines_name FROM airlines ORDER BY id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		airlinesLists = new ArrayList<>();
		while (resultset.next()) {
			Airlines airline = new Airlines();
			airline.setId(resultset.getInt("id"));
			airline.setAirlinesName(resultset.getString("airlines_name"));
			airlinesLists.add(airline);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return airlinesLists;
	}
}
