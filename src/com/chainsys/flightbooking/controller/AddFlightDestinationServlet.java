package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.flightbooking.dao.FlightDestinationDAO;
import com.chainsys.flightbooking.model.FlightDestinations;
import com.chainsys.flightbooking.model.Passangers;

/**
 * Servlet implementation class AddFlightDestinationServlet
 */
@WebServlet("/AddFlightDestinationServlet")
public class AddFlightDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int passanger = (int) session.getAttribute("PASSANGERID");
		FlightDestinations flightDestination = new FlightDestinations();
		flightDestination.setPlace(request.getParameter("flightdestination"));
		flightDestination.setCreatedBy(passanger);
		Timestamp datetime = Timestamp.valueOf(LocalDateTime.now());
		flightDestination.setCreatedTime(datetime);
		flightDestination.setUpdatedBy(passanger);
		flightDestination.setUpdatedTime(datetime);
		FlightDestinationDAO flightDestinationDAO = new FlightDestinationDAO();
		try {
			flightDestinationDAO.addFlightDestination(flightDestination);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
