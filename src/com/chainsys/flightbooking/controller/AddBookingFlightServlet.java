package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.flightbooking.dao.BookingFlightDAO;
import com.chainsys.flightbooking.model.AirlinesFlight;
import com.chainsys.flightbooking.model.BookingAirlines;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.validator.FlightBookingValidator;

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
		AirlinesFlight airlines = new AirlinesFlight();
		airlines.setId(Integer.parseInt(request.getParameter("airlines")));
		booking.setAirlinesId(airlines);
		booking.setAdultSeats(Integer.parseInt(request
				.getParameter("adultseats")));
		booking.setChildSeats(Integer.parseInt(request
				.getParameter("childseats")));
		booking.setInfant(Integer.parseInt(request
				.getParameter("infant")));
		booking.setCoPassangersname(request.getParameter("names"));
		LocalDate date = LocalDate.now();
		booking.setBookingDate(date);
		booking.setPassenger_id(passanger);
		BookingFlightDAO bookingDAO = new BookingFlightDAO();
		try {
			FlightBookingValidator bookingValidator = new FlightBookingValidator();
			bookingValidator.checkFlightBooking(booking);
			bookingDAO.addBookingFlight(booking);
			ArrayList<BookingAirlines> bookingList = new ArrayList<>();
			bookingList.addAll(bookingDAO.findAll());
			request.setAttribute("BOOKING", bookingList);
			RequestDispatcher rd = request
					.getRequestDispatcher("booking_summary.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
