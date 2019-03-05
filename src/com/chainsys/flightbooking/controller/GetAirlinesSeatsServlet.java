package com.chainsys.flightbooking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.flightbooking.dao.AirlinesFlightDAO;
import com.chainsys.flightbooking.model.AirlinesFlight;

@WebServlet("/GetAirlinesSeatsServlet")
public class GetAirlinesSeatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int airlineid = Integer.parseInt(request.getParameter("airLines"));
		String flightclass = request.getParameter("flightClass");
		System.out.println(airlineid);
		System.out.println(flightclass);
		AirlinesFlightDAO airlinedao = new AirlinesFlightDAO();
		try {

			AirlinesFlight airlines = airlinedao.findByIdClass(airlineid,
					flightclass);
			// Adult and Child Seats Count append in string and pass to
			// app.ajax.js
			int[] adultcount = new int[airlines.getAdultSeats()];
			int[] childcount = new int[airlines.getChildSeats()];
			StringBuilder adountCounts = new StringBuilder();
			adountCounts.append("a");
			for (int i = 1; i <= adultcount.length; i++) {
				adountCounts.append("," + i);
			}
			StringBuilder childCount = new StringBuilder();
			childCount.append("c");
			for (int i = 0; i <= childcount.length; i++) {
				childCount.append("," + i);
			}
			StringBuilder adultchild = new StringBuilder();
			adultchild.append(adountCounts + "," + childCount);
			response.setContentType("text/plain");
			response.getWriter().write(adultchild.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
