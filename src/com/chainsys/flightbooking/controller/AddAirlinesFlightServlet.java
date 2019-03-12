package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.flightbooking.dao.AirlinesFlightDAO;
import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.model.AirlinesFlight;

/**
 * Servlet implementation class AddAirlinesServlet
 */
@WebServlet("/AddAirlinesFlightServlet")
public class AddAirlinesFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int passengerid = (int) session.getAttribute("PASSANGERID");
		AirlinesFlight airlinesFlight = new AirlinesFlight();
		Airlines airline = new Airlines();
		airline.setId(Integer.parseInt(request.getParameter("airlines")));
		airlinesFlight.setFlightName(airline);
		airlinesFlight.setFlightNo(request.getParameter("flightno"));
		airlinesFlight.setAdultSeats(Integer.parseInt(request
				.getParameter("adultseats")));
		airlinesFlight.setAdultPrice(Integer.parseInt(request
				.getParameter("adultprice")));
		airlinesFlight.setChildSeats(Integer.parseInt(request
				.getParameter("childseats")));
		airlinesFlight.setChildPrice(Integer.parseInt(request
				.getParameter("childprice")));
		airlinesFlight.setStatus(request.getParameter("status"));
		airlinesFlight.setFlightClass(request.getParameter("flightclass"));
		airlinesFlight.setCreatedBy(passengerid);
		Timestamp datetime = Timestamp.valueOf(LocalDateTime.now());
		airlinesFlight.setCreatedTime(datetime);
		airlinesFlight.setUpdatedBy(passengerid);
		airlinesFlight.setUpdatedTime(datetime);
		AirlinesFlightDAO airlinesDAO = new AirlinesFlightDAO();
		try {
			airlinesDAO.addAirlinesFlight(airlinesFlight);
			ArrayList<AirlinesFlight> airlinesList = new ArrayList<>();
			airlinesList.addAll(airlinesDAO.findAllAirlines());
			request.setAttribute("AIRLINES", airlinesList);
			RequestDispatcher rd = request
					.getRequestDispatcher("view_airlines.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			String msg="Unable to Add Flights";
			request.setAttribute("ERROR", msg);
			RequestDispatcher rd = request
					.getRequestDispatcher("airlines_flight.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}

	}

}
