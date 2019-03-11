package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.flightbooking.dao.AirlinesDAO;
import com.chainsys.flightbooking.dao.BookingFlightDAO;
import com.chainsys.flightbooking.dao.FlightDestinationDAO;
import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.model.BookingAirlines;
import com.chainsys.flightbooking.model.FlightDestinations;
import com.chainsys.flightbooking.util.RequestDispatcherForward;

/**
 * Servlet implementation class AirlinesServlet
 */
@WebServlet("/AirlinesServlet")
public class AirlinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AirlinesDAO airlinesDAO = new AirlinesDAO();
		String buttonvalue = "";
		String cancenbutton = "";
		String ticketCancellation = "";
		String pnrno = "";
		String flightdestination = "";
		String airlinesflight = "";
		if (request.getParameter("addairlines") != null) {
			buttonvalue = request.getParameter("addairlines");
		}
		if (request.getParameter("calcellation") != null) {
			cancenbutton = request.getParameter("calcellation");
		}
		if (request.getParameter("ticketcancelbypnr") != null
				&& request.getParameter("pnrstatus") != null) {
			ticketCancellation = request.getParameter("ticketcancelbypnr");
			pnrno = request.getParameter("pnrstatus");
		}
		if (request.getParameter("addflightdestination") != null) {
			flightdestination = request.getParameter("addflightdestination");
		}
		if (request.getParameter("addairlinesflight") != null) {
			airlinesflight = request.getParameter("addairlinesflight");
		}
		try {
			if (buttonvalue.equals("airlines")) {
				ArrayList<Airlines> airlinesList = airlinesDAO.findAll();
				request.setAttribute("AIRLINES", airlinesList);
				RequestDispatcher rd = request
						.getRequestDispatcher("airlines.jsp");
				rd.forward(request, response);
			} else if (cancenbutton.equals("ticketcancel")) {
				RequestDispatcher rd = request
						.getRequestDispatcher("ticket_cancellation.jsp");
				rd.forward(request, response);
			} else if (ticketCancellation.equals("ticketcancelbypnr")) {
				BookingFlightDAO bookingflightDAO = new BookingFlightDAO();

				ArrayList<BookingAirlines> bookingsummary = bookingflightDAO
						.findBookingDetailsByPNRno(pnrno);
				request.setAttribute("BOOKING", bookingsummary);
				RequestDispatcher rd = request
						.getRequestDispatcher("ticket_cancellation.jsp");
				rd.forward(request, response);
			} else if (flightdestination.equals("addflightdestination")) {
				FlightDestinationDAO flightDestinationDAO = new FlightDestinationDAO();
				List<FlightDestinations> flightDestinationList = flightDestinationDAO
						.findAll();
				request.setAttribute("FLIFHTDEST", flightDestinationList);
				String page = "flight_destination.jsp";
				RequestDispatcherForward.forward(null, page, request, response);
			} else if (airlinesflight.equals("addairlinesflight")) {
				ArrayList<Airlines> airlinesList = airlinesDAO.findAll();
				request.setAttribute("AIRLINE", airlinesList);
				RequestDispatcher rd = request
						.getRequestDispatcher("airlines_flight.jsp");
				rd.forward(request, response);
			}

			else {
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
