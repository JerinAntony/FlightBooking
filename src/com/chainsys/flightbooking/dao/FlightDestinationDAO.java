package com.chainsys.flightbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.model.FlightDestinations;
import com.chainsys.flightbooking.util.ConnectionUtil;

public class FlightDestinationDAO {

	public boolean addFlightDestination(FlightDestinations flightdestination)
			throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isStatus = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO flight_destinations(id,place,created_by,created_time,updated_by,updated_time) values(flight_destinations_id_seq.NEXTVAL,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, flightdestination.getPlace());
			preparedStatement.setInt(2, flightdestination.getCreatedBy());
			preparedStatement.setTimestamp(3,
					flightdestination.getCreatedTime());
			preparedStatement.setInt(4, flightdestination.getUpdatedBy());
			preparedStatement.setTimestamp(5,
					flightdestination.getUpdatedTime());
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				isStatus = true;
			} else {
				isStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Insert Destination");
		}
		return isStatus;
	}
	
	public List<FlightDestinations> findAll() throws SQLException {
		List<FlightDestinations> airlinesLists = new ArrayList<>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,place FROM FLIGHT_DESTINATIONS ORDER BY id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		airlinesLists = new ArrayList<>();
		while (resultset.next()) {
			FlightDestinations flightdestination = new FlightDestinations();
			flightdestination.setId(resultset.getInt("id"));
			flightdestination.setPlace(resultset.getString("place"));
			airlinesLists.add(flightdestination);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return airlinesLists;
	}
}
