package com.chainsys.flightbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.flightbooking.model.AirlinesFlight;
import com.chainsys.flightbooking.model.BookingAirlines;
import com.chainsys.flightbooking.util.ConnectionUtil;

public class AirlinesFlightDAO {

	public void addAirlines(AirlinesFlight airlines) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String url = "INSERT INTO airlines_flight(id,flight_name,flight_no,adult_seats,child_seats,adult_price,child_price,status,flight_class) VALUES(seq_airlines_id.NEXTVAL,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedstatement = connection.prepareStatement(url);
		preparedstatement.setString(1, airlines.getFlightName());
		preparedstatement.setString(2, airlines.getFlightNo());
		preparedstatement.setLong(3, airlines.getAdultSeats());
		preparedstatement.setLong(4, airlines.getChildSeats());
		preparedstatement.setDouble(5, airlines.getAdultPrice());
		preparedstatement.setDouble(6, airlines.getChildPrice());
		preparedstatement.setString(7, airlines.getStatus());
		preparedstatement.setString(8, airlines.getFlightClass());
		int row = preparedstatement.executeUpdate();
		System.out.println(row);
	}

	public ArrayList<AirlinesFlight> findAll() throws SQLException {
		ArrayList<AirlinesFlight> airlinesLists = new ArrayList<>();

		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,flight_name,flight_no,adult_seats,child_seats,adult_price,child_price,status,flight_class FROM airlines_flight where status='Y' ORDER BY id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		airlinesLists = new ArrayList<>();
		while (resultset.next()) {
			AirlinesFlight airline = new AirlinesFlight();
			airline.setId(resultset.getInt("id"));
			airline.setFlightName(resultset.getString("flight_name"));
			airline.setFlightNo(resultset.getString("flight_no"));
			airline.setAdultSeats(Integer.parseInt(resultset
					.getString("adult_seats")));
			airline.setChildSeats(Integer.parseInt(resultset
					.getString("child_seats")));
			airline.setAdultPrice(Integer.parseInt(resultset
					.getString("adult_price")));
			airline.setChildPrice(Integer.parseInt(resultset
					.getString("child_price")));
			airline.setStatus(resultset.getString("status"));
			airline.setFlightClass(resultset.getString("flight_class"));
			airlinesLists.add(airline);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return airlinesLists;
	}

	public ArrayList<AirlinesFlight> findAllAirlines() throws SQLException {
		ArrayList<AirlinesFlight> airlinesLists = new ArrayList<>();

		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,flight_name,flight_no,adult_seats,child_seats,adult_price,child_price,status,flight_class FROM airlines_flight ORDER BY id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		airlinesLists = new ArrayList<>();
		while (resultset.next()) {
			AirlinesFlight airline = new AirlinesFlight();
			airline.setId(resultset.getInt("id"));
			airline.setFlightName(resultset.getString("flight_name"));
			airline.setFlightNo(resultset.getString("flight_no"));
			airline.setAdultSeats(Integer.parseInt(resultset
					.getString("adult_seats")));
			airline.setChildSeats(Integer.parseInt(resultset
					.getString("child_seats")));
			airline.setAdultPrice(Integer.parseInt(resultset
					.getString("adult_price")));
			airline.setChildPrice(Integer.parseInt(resultset
					.getString("child_price")));
			airline.setStatus(resultset.getString("status"));
			airline.setFlightClass(resultset.getString("flight_class"));
			airlinesLists.add(airline);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return airlinesLists;
	}

	public AirlinesFlight findById(int airlinesid) throws SQLException {
		AirlinesFlight airline = new AirlinesFlight();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,flight_name,flight_no,adult_seats,child_seats,adult_price,child_price,status,flight_class FROM airlines_flight where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, airlinesid);
		ResultSet resultset = preparedStatement.executeQuery();

		if (resultset.next()) {
			airline = new AirlinesFlight();
			airline.setId(resultset.getInt("id"));
			airline.setFlightName(resultset.getString("flight_name"));
			airline.setFlightNo(resultset.getString("flight_no"));
			airline.setAdultSeats(Integer.parseInt(resultset
					.getString("adult_seats")));
			airline.setChildSeats(Integer.parseInt(resultset
					.getString("child_seats")));
			airline.setAdultPrice(Integer.parseInt(resultset
					.getString("adult_price")));
			airline.setChildPrice(Integer.parseInt(resultset
					.getString("child_price")));
			airline.setStatus(resultset.getString("status"));
			airline.setFlightClass(resultset.getString("flight_class"));
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return airline;
	}

	public AirlinesFlight findByIdClass(int airlinesid, String flightclass)
			throws SQLException {
		AirlinesFlight airline = new AirlinesFlight();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,flight_name,flight_no,adult_seats,child_seats,adult_price,child_price,status,flight_class FROM airlines_flight where id=? and flight_class=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, airlinesid);
		preparedStatement.setString(2, flightclass);
		ResultSet resultset = preparedStatement.executeQuery();

		if (resultset.next()) {
			airline = new AirlinesFlight();
			airline.setId(resultset.getInt("id"));
			airline.setFlightName(resultset.getString("flight_name"));
			airline.setFlightNo(resultset.getString("flight_no"));
			airline.setAdultSeats(Integer.parseInt(resultset
					.getString("adult_seats")));
			airline.setChildSeats(Integer.parseInt(resultset
					.getString("child_seats")));
			airline.setAdultPrice(Integer.parseInt(resultset
					.getString("adult_price")));
			airline.setChildPrice(Integer.parseInt(resultset
					.getString("child_price")));
			airline.setStatus(resultset.getString("status"));
			airline.setFlightClass(resultset.getString("flight_class"));
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return airline;
	}

	public void updateAirlinesSeats(BookingAirlines bookairlines)
			throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String url = "UPDATE airlines_flight SET adult_seats=?,child_seats=?,status=? where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(url);
		AirlinesFlight airline = findById(bookairlines.getAirlinesId().getId());
		if (airline != null) {
			int adultseats = airline.getAdultSeats()
					- bookairlines.getAdultSeats();
			int childseats = airline.getChildSeats()
					- bookairlines.getChildSeats();
			airline.setAdultSeats(adultseats);
			airline.setChildSeats(childseats);
		}
		preparedStatement.setInt(1, airline.getAdultSeats());
		preparedStatement.setInt(2, airline.getChildSeats());
		if (airline.getAdultSeats() != 0 && airline.getChildSeats() != 0) {
			airline.setStatus("Y");
		} else {
			airline.setStatus("N");
		}
		preparedStatement.setString(3, airline.getStatus());
		preparedStatement.setInt(4, airline.getId());

		preparedStatement.executeUpdate();
	}
}
