package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.flightbooking.dao.AirlinesFlightDAO;
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
		AirlinesFlight airlines = new AirlinesFlight();
		airlines.setFlightName(request.getParameter("flightname"));
		airlines.setFlightNo(request.getParameter("flightno"));
		airlines.setAdultSeats(Integer.parseInt(request
				.getParameter("adultseats")));
		airlines.setAdultPrice(Integer.parseInt(request
				.getParameter("adultprice")));
		airlines.setChildSeats(Integer.parseInt(request
				.getParameter("childseats")));
		airlines.setChildPrice(Integer.parseInt(request
				.getParameter("childprice")));
		airlines.setStatus(request.getParameter("status"));
		airlines.setFlightClass(request.getParameter("flightclass"));
		AirlinesFlightDAO airlinesDAO = new AirlinesFlightDAO();
		try {
			airlinesDAO.addAirlines(airlines);
			ArrayList<AirlinesFlight> airlinesList = new ArrayList<>();
			airlinesList.addAll(airlinesDAO.findAllAirlines());
			request.setAttribute("AIRLINES", airlinesList);
			RequestDispatcher rd = request
					.getRequestDispatcher("view_airlines.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
