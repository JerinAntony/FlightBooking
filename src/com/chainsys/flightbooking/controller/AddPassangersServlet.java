package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.flightbooking.dao.PassangersDAO;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.util.RequestDispatcherForward;
import com.chainsys.flightbooking.validator.AirlinesValidator;

/**
 * Servlet implementation class AddPassangersServlet
 */
@WebServlet("/AddPassangersServlet")
public class AddPassangersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Passangers passanger = new Passangers();
		passanger.setName(request.getParameter("name"));
		passanger.setEmail(request.getParameter("email"));
		passanger.setPhonenumber(Long.parseLong(request.getParameter("phone")));
		LocalDate fatherdob = LocalDate
				.parse(request.getParameter("fatherdob"));
		passanger.setFather_DateOfBirth(fatherdob);
		passanger.setUsername(request.getParameter("username"));
		passanger.setPassword(request.getParameter("password"));
		LocalDateTime datetime = LocalDateTime.now();
		Timestamp createddatetime = Timestamp.valueOf(datetime);
		passanger.setCreated_date(createddatetime);
		PassangersDAO passangersDAO = new PassangersDAO();
		AirlinesValidator airlinesValidator = new AirlinesValidator();
		try {
			if (passangersDAO.checkLoginEmail(passanger)) {
				String msg = "Email Already Exists";
				String page = "passanger_registration.jsp";
				RequestDispatcherForward.forward(msg, page, request, response);
			} else if (airlinesValidator.dobValidate(fatherdob)) {
				String msg = "Please Enter Valid DOB";
				String page = "passanger_registration.jsp";
				RequestDispatcherForward.forward(msg, page, request, response);
			} else if (passangersDAO.checkUsername(passanger.getUsername())) {
				String msg = "Username Already Exists";
				String page = "passanger_registration.jsp";
				RequestDispatcherForward.forward(msg, page, request, response);
			}

			else {
				passangersDAO.addPassangers(passanger);
				RequestDispatcher rd = request
						.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
