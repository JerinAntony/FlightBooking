package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.flightbooking.dao.AirlinesFlightDAO;
import com.chainsys.flightbooking.dao.BookingFlightDAO;
import com.chainsys.flightbooking.model.AirlinesFlight;
import com.chainsys.flightbooking.model.BookingAirlines;
import com.chainsys.flightbooking.util.RequestDispatcherForward;

/**
 * Servlet implementation class TicketCancellationServlet
 */
@WebServlet("/TicketCancellationServlet")
public class TicketCancellationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookingid = request.getParameter("ticketid");
		BookingAirlines booking = new BookingAirlines();
		booking.setId(Integer.parseInt(bookingid));
		booking.setCancelStatus(1);
		AirlinesFlight airlinesflight = new AirlinesFlight();
		airlinesflight.setId(Integer.parseInt(request
				.getParameter("airlinesid")));
		airlinesflight.setAdultSeats(Integer.parseInt(request
				.getParameter("adultseats")));
		airlinesflight.setChildSeats(Integer.parseInt(request
				.getParameter("childseats")));
		BookingFlightDAO bookingDAO = new BookingFlightDAO();
		AirlinesFlightDAO airlinesDAO = new AirlinesFlightDAO();
		try {
			if (bookingDAO.cancelTicket(booking)) {
				String msg = "Ticket Cancelled Sucessfully";
				String page = "ticket_cancellation.jsp";
				RequestDispatcherForward.forward(msg, page, request, response);
				airlinesDAO.updateCancelledSeats(airlinesflight);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
