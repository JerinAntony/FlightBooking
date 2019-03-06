package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.flightbooking.dao.BookingFlightDAO;
import com.chainsys.flightbooking.model.BookingAirlines;

/**
 * Servlet implementation class BookingSummaryServlet
 */
@WebServlet("/BookingSummaryServlet")
public class BookingSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookingFlightDAO bookingDAO = new BookingFlightDAO();

		ArrayList<BookingAirlines> bookingList = new ArrayList<>();
		try {
			bookingList.addAll(bookingDAO.findBookingDetails());
			request.setAttribute("BOOKING", bookingList);
			RequestDispatcher rd = request
					.getRequestDispatcher("booking_summary.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
