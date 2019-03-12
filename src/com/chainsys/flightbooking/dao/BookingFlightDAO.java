package com.chainsys.flightbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.model.AirlinesFlight;
import com.chainsys.flightbooking.model.BookingAirlines;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.util.ConnectionUtil;

public class BookingFlightDAO {

	/**
	 * Method to add Booking Flight Details
	 * 
	 * @param bookairlines
	 * @return
	 * @throws SQLException
	 */
	public boolean addBookingFlight(BookingAirlines bookairlines)
			throws SQLException {
		boolean isSucess = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String url = "INSERT INTO bookingairlines(id,airlines_id,adult_seats,child_seats,infant,co_passangersname,price,booking_date,passengers_id,cancel_status,pnr_no,created_by,created_time,updated_by,updated_time) VALUES(seq_bookingairlines_id.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(url);
			preparedStatement.setInt(1, bookairlines.getAirlinesId().getId());
			preparedStatement.setLong(2, bookairlines.getAdultSeats());
			preparedStatement.setLong(3, bookairlines.getChildSeats());
			preparedStatement.setInt(4, bookairlines.getInfant());
			preparedStatement.setString(5, bookairlines.getCoPassangersname());
			// Calculating Filght Price Amount
			AirlinesFlightDAO airlinesDAO = new AirlinesFlightDAO();
			AirlinesFlight airlines = airlinesDAO.findById(bookairlines
					.getAirlinesId().getId());
			if (airlines != null) {
				int adultamount = bookairlines.getAdultSeats()
						* airlines.getAdultPrice();
				int childamount = bookairlines.getChildSeats()
						* airlines.getChildPrice();
				int totalamount = adultamount + childamount;
				bookairlines.setPrice(totalamount);
			}
			preparedStatement.setDouble(6, bookairlines.getPrice());
			preparedStatement.setDate(7,
					Date.valueOf(bookairlines.getBookingDate()));
			preparedStatement.setInt(8, bookairlines.getPassenger_id().getId());
			preparedStatement.setInt(9, bookairlines.getCancelStatus());
			preparedStatement.setString(10, bookairlines.getPnrNo());
			preparedStatement.setInt(11, bookairlines.getCreatedBy());
			preparedStatement.setTimestamp(12, bookairlines.getCreatedTime());
			preparedStatement.setInt(13, bookairlines.getUpdatedBy());
			preparedStatement.setTimestamp(14, bookairlines.getUpdatedTime());
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				isSucess = true;
				// Update Booking seats in Airlines
				airlinesDAO.updateAirlinesSeats(bookairlines);
			} else {
				isSucess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return isSucess;
	}

	/**
	 * Method to get all booking Details
	 * 
	 * @return
	 */
	public List<BookingAirlines> findBookingDetails() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<BookingAirlines> bookinghistoryLists = new ArrayList<>();
		String Url = "select a.airlines_name as airlinesname,f.flight_no as flightno,f.flight_class as flightclass,ba.infant as infant,ba.co_passangersname as copassangers,ba.adult_seats as adultseats,ba.child_seats as childseats,ba.price as price,ba.booking_date as bookingdate,ba.cancel_status as cancelstatus,ba.pnr_no as pnrno,p.name as passangername from BOOKINGAIRLINES ba "
				+ "join AIRLINES_FLIGHT f on ba.airlines_id=f.id "
				+ "join airlines a on f.flight_name=a.id "
				+ "join passengers p on ba.passengers_id=p.id";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(Url);
			ResultSet resultset = preparedStatement.executeQuery();
			bookinghistoryLists = new ArrayList<>();
			while (resultset.next()) {
				BookingAirlines booking = new BookingAirlines();
				AirlinesFlight airlinesflight = new AirlinesFlight();
				Airlines airlinesname = new Airlines();
				airlinesname.setAirlinesName(resultset
						.getString("airlinesname"));
				airlinesflight.setFlightName(airlinesname);

				airlinesflight.setFlightNo(resultset.getString("flightno"));
				airlinesflight.setFlightClass(resultset
						.getString("flightclass"));
				booking.setInfant(Integer.parseInt(resultset
						.getString("infant")));
				booking.setCoPassangersname(resultset.getString("copassangers"));
				booking.setAirlinesId(airlinesflight);
				booking.setAdultSeats(Integer.parseInt(resultset
						.getString("adultseats")));
				booking.setChildSeats(Integer.parseInt(resultset
						.getString("childseats")));
				booking.setPrice(resultset.getInt("price"));
				booking.setBookingDate(resultset.getDate("bookingdate")
						.toLocalDate());
				booking.setCancelStatus(resultset.getInt("cancelstatus"));
				booking.setPnrNo(resultset.getString("pnrno"));
				Passangers passenger = new Passangers();
				passenger.setName(resultset.getString("passangername"));

				booking.setPassenger_id(passenger);
				bookinghistoryLists.add(booking);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return bookinghistoryLists;
	}

	/**
	 * Method to Find ticket by pnr no and cancel ticket
	 * 
	 * @param pnrno
	 * @return
	 */
	public List<BookingAirlines> findBookingDetailsByPNRno(String pnrno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<BookingAirlines> bookinghistoryLists = new ArrayList<>();
		String Url = "select a.airlines_name as airlinesname,f.flight_no as flightno,f.flight_class as flightclass,f.id as airlineflightid,ba.infant as infant,ba.co_passangersname as copassangers,ba.adult_seats as adultseats,ba.child_seats as childseats,ba.price as price,ba.booking_date as bookingdate,ba.id as bookingid,p.name as passangername from BOOKINGAIRLINES ba "
				+ "join AIRLINES_FLIGHT f on ba.airlines_id=f.id "
				+ "join airlines a on f.flight_name=a.id "
				+ "join passengers p on ba.passengers_id=p.id where ba.pnr_no=? and ba.cancel_status=?";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(Url);
			preparedStatement.setString(1, pnrno);
			preparedStatement.setInt(2, 0);
			ResultSet resultset = preparedStatement.executeQuery();
			bookinghistoryLists = new ArrayList<>();
			while (resultset.next()) {
				BookingAirlines booking = new BookingAirlines();
				AirlinesFlight airlinesflight = new AirlinesFlight();
				Airlines airlinesname = new Airlines();
				airlinesname.setAirlinesName(resultset
						.getString("airlinesname"));
				airlinesflight.setFlightName(airlinesname);

				airlinesflight.setFlightNo(resultset.getString("flightno"));
				airlinesflight.setFlightClass(resultset
						.getString("flightclass"));
				airlinesflight.setId(resultset.getInt("airlineflightid"));
				booking.setInfant(Integer.parseInt(resultset
						.getString("infant")));
				booking.setCoPassangersname(resultset.getString("copassangers"));
				booking.setAirlinesId(airlinesflight);
				booking.setAdultSeats(Integer.parseInt(resultset
						.getString("adultseats")));
				booking.setChildSeats(Integer.parseInt(resultset
						.getString("childseats")));
				booking.setPrice(resultset.getInt("price"));
				booking.setBookingDate(resultset.getDate("bookingdate")
						.toLocalDate());
				booking.setId(resultset.getInt("bookingid"));
				Passangers passenger = new Passangers();
				passenger.setName(resultset.getString("passangername"));

				booking.setPassenger_id(passenger);
				bookinghistoryLists.add(booking);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return bookinghistoryLists;
	}

	/**
	 * Method to Update Cancel ticket Status
	 * 
	 * @param booking
	 * @return
	 */
	/**
	 * @param booking
	 * @return
	 */
	public boolean cancelTicket(BookingAirlines booking) {
		boolean isStatus = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "UPDATE bookingairlines SET cancel_status=? where id=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, booking.getCancelStatus());
			preparedStatement.setInt(2, booking.getId());

			int row = preparedStatement.executeUpdate();
			if (row != 0) {
				isStatus = true;
			} else {
				isStatus = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isStatus;
	}

}
