package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.flightbooking.dao.AirlinesDAO;
import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.util.RequestDispatcherForward;
import com.chainsys.flightbooking.validator.AirlinesValidator;

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
		HttpSession session = request.getSession(false);
		int passengerid = (int) session.getAttribute("PASSANGERID");
		Airlines airlines = new Airlines();
		List<Airlines> airlinesList = new ArrayList<>();
		airlines.setAirlinesName(request.getParameter("airlines"));
		airlines.setCreatedBy(passengerid);
		Timestamp datetime = Timestamp.valueOf(LocalDateTime.now());
		airlines.setCreatedTime(datetime);
		airlines.setUpdatedBy(passengerid);
		airlines.setUpdatedTime(datetime);
		AirlinesDAO airlinesDAO = new AirlinesDAO();
		AirlinesValidator airlinesValidator = new AirlinesValidator();
		try {
			if (!airlinesValidator.validString(airlines.getAirlinesName())) {
				System.out.println("inside if");
				String error = "Please enter a valid Airlines Name";
				String page = "airlines.jsp";
				airlinesList = airlinesDAO.findAll();
				request.setAttribute("AIRLINES", airlinesList);
				RequestDispatcherForward
						.forward(error, page, request, response);
			} else if (airlinesValidator.airlinesAlreadyExists(airlines
					.getAirlinesName())) {
				System.out.println("insdie");
				String error = "Airlines Name Already Available";
				String page = "airlines.jsp";
				airlinesList = airlinesDAO.findAll();
				request.setAttribute("AIRLINES", airlinesList);
				RequestDispatcherForward
						.forward(error, page, request, response);
			} else {
				boolean sucess=airlinesDAO.addAirline(airlines);
				if(sucess){
					String msg="Airlines Added Sucessfully";
					request.setAttribute("SUCESS", msg);
				}else{
					String msg="Insertion Failed";
					request.setAttribute("SUCESS", msg);
				}
				airlinesList = airlinesDAO.findAll();
				request.setAttribute("AIRLINES", airlinesList);
				RequestDispatcher rd = request
						.getRequestDispatcher("airlines.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
