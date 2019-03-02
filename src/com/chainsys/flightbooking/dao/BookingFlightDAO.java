package com.chainsys.flightbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.model.BookingAirlines;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.util.ConnectionUtil;

public class BookingFlightDAO {

	public void addBookingFlight(BookingAirlines bookairlines)
			throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String url = "INSERT INTO bookingairlines(id,airlines_id,adult_seats,child_seats,co_passangersname,price,booking_date,passengers_id) VALUES(seq_bookingairlines_id.NEXTVAL,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(url);
		preparedStatement.setInt(1, bookairlines.getAirlinesId().getId());
		preparedStatement.setLong(2, bookairlines.getAdultSeats());
		preparedStatement.setLong(3, bookairlines.getChildSeats());
		preparedStatement.setString(4, bookairlines.getCoPassangersname());
		// Calculating Filght Price Amount
		AirlinesDAO airlinesDAO = new AirlinesDAO();
		Airlines airlines = airlinesDAO.findById(bookairlines.getAirlinesId()
				.getId());
		if (airlines != null) {
			int adultamount = bookairlines.getAdultSeats()
					* airlines.getAdultPrice();
			int childamount = bookairlines.getChildSeats()
					* airlines.getChildPrice();
			int totalamount = adultamount + childamount;
			bookairlines.setPrice(totalamount);
		}
		// Update Booking seats in Airlines
		airlinesDAO.updateAirlinesSeats(bookairlines);
		preparedStatement.setDouble(5, bookairlines.getPrice());
		preparedStatement.setDate(6,
				Date.valueOf(bookairlines.getBookingDate()));
		preparedStatement.setInt(7, bookairlines.getPassenger_id().getId());
		int row = preparedStatement.executeUpdate();
		System.out.println(row);
	}

	public ArrayList<BookingAirlines> findAll() throws SQLException {
		ArrayList<BookingAirlines> bookinghistoryLists = new ArrayList<>();

		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,airlines_id,adult_seats,child_seats,co_passangersname,price,booking_date,passengers_id FROM bookingairlines ORDER BY id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		bookinghistoryLists = new ArrayList<>();
		while (resultset.next()) {
			BookingAirlines booking = new BookingAirlines();
			Airlines airlines;
			booking.setId(resultset.getInt("id"));

			AirlinesDAO airlinesdao = new AirlinesDAO();
			airlines = airlinesdao.findById(resultset.getInt("airlines_id"));
			booking.setAirlinesId(airlines);

			booking.setAdultSeats(Integer.parseInt(resultset
					.getString("adult_seats")));
			booking.setChildSeats(Integer.parseInt(resultset
					.getString("child_seats")));
			booking.setCoPassangersname(resultset
					.getString("co_passangersname"));
			booking.setPrice(resultset.getInt("price"));
			booking.setBookingDate(resultset.getDate("booking_date")
					.toLocalDate());

			Passangers passenger = new Passangers();
			PassangersDAO passangerDAO = new PassangersDAO();
			passenger = passangerDAO.findById(Integer.parseInt(resultset
					.getString("passengers_id")));

			booking.setPassenger_id(passenger);
			bookinghistoryLists.add(booking);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return bookinghistoryLists;
	}
}
