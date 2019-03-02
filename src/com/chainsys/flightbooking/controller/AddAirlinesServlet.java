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
import com.chainsys.flightbooking.model.Airlines;

/**
 * Servlet implementation class AddAirlinesServlet
 */
@WebServlet("/AddAirlinesServlet")
public class AddAirlinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Airlines airlines = new Airlines();
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
		AirlinesDAO airlinesDAO = new AirlinesDAO();
		try {
			airlinesDAO.addAirlines(airlines);
			ArrayList<Airlines> airlinesList = new ArrayList<>();
			airlinesList.addAll(airlinesDAO.findAll());
			request.setAttribute("AIRLINES", airlinesList);
			RequestDispatcher rd = request
					.getRequestDispatcher("view_airlines.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
