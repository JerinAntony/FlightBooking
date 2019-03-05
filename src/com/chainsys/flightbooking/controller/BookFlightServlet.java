package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.flightbooking.dao.AirlinesDAO;
import com.chainsys.flightbooking.dao.AirlinesFlightDAO;
import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.model.AirlinesFlight;

/**
 * Servlet implementation class BookFlightServlet
 */
@WebServlet("/BookFlightServlet")
public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AirlinesDAO airlinesDAO = new AirlinesDAO();
		try {
			ArrayList<Airlines> airlinesList = new ArrayList<>();
			Airlines airlines = new Airlines();
			airlinesList.add(airlines);
			airlinesList.addAll(airlinesDAO.findAll());
			System.out.println(airlinesList.size());
			request.setAttribute("AIRLINES", airlinesList);
			RequestDispatcher rd = request
					.getRequestDispatcher("booking_airlines.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
