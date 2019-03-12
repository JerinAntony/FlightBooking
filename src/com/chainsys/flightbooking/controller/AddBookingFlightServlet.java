package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.flightbooking.dao.AirlinesDAO;
import com.chainsys.flightbooking.dao.AirlinesFlightDAO;
import com.chainsys.flightbooking.dao.BookingFlightDAO;
import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.model.AirlinesFlight;
import com.chainsys.flightbooking.model.BookingAirlines;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.util.ConnectionUtil;

/**
 * Servlet implementation class AddBookingFlightServlet
 */
@WebServlet("/AddBookingFlightServlet")
public class AddBookingFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Passangers passanger = (Passangers) session.getAttribute("PASSANGER");
		BookingAirlines booking = new BookingAirlines();
		int airlineid = Integer.parseInt(request.getParameter("airlines"));
		String flightclass = request.getParameter("flightclass");
		AirlinesFlight airlinesFlight = new AirlinesFlight();

		AirlinesFlightDAO airlinesFlightDAO = new AirlinesFlightDAO();

		try {
			airlinesFlight = airlinesFlightDAO.findByIdClass(airlineid,
					flightclass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		booking.setAirlinesId(airlinesFlight);
		booking.setAdultSeats(Integer.parseInt(request
				.getParameter("adultseats")));
		booking.setChildSeats(Integer.parseInt(request
				.getParameter("childseats")));
		booking.setInfant(Integer.parseInt(request.getParameter("infant")));
		booking.setCoPassangersname(request.getParameter("names"));
		LocalDate date = LocalDate.now();
		booking.setBookingDate(date);
		booking.setPassenger_id(passanger);
		booking.setCancelStatus(0);
		// Generate PNR NO for Passangers
		StringBuilder sb = new StringBuilder();
		LocalDate day = LocalDate.now();
		sb.append("PNR" + "" + day.getDayOfMonth());
		sb.append(passanger.getName().substring(1, 4).toUpperCase());
		booking.setPnrNo(sb.toString());
		Timestamp datetime = Timestamp.valueOf(LocalDateTime.now());
		booking.setCreatedBy(passanger.getId());
		booking.setCreatedTime(datetime);
		booking.setUpdatedBy(passanger.getId());
		booking.setUpdatedTime(datetime);
		BookingFlightDAO bookingDAO = new BookingFlightDAO();
		try {
			bookingDAO.addBookingFlight(booking);
			ArrayList<BookingAirlines> bookingList = new ArrayList<>();
			bookingList.addAll(bookingDAO.findBookingDetails());
			request.setAttribute("BOOKING", bookingList);
			RequestDispatcher rd = request
					.getRequestDispatcher("booking_summary.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("ERRORMSG", e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("booking_airlines.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

	public AirlinesFlight findByIdClass(int airlinesid, String flightclass)
			throws SQLException {
		AirlinesFlight airline = new AirlinesFlight();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,flight_name,flight_no,adult_seats,child_seats,adult_price,child_price,status,flight_class FROM airlines_flight where flight_name=? and flight_class=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, airlinesid);
		preparedStatement.setString(2, flightclass);
		ResultSet resultset = preparedStatement.executeQuery();
		AirlinesDAO airlineDAO = new AirlinesDAO();
		if (resultset.next()) {
			airline = new AirlinesFlight();
			airline.setId(resultset.getInt("id"));
			Airlines airlinename = airlineDAO.findById(Integer
					.parseInt(resultset.getString("flight_name")));
			airline.setFlightName(airlinename);
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

}
