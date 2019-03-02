package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.flightbooking.dao.PassangersDAO;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.util.RequestDispatcherForward;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Passangers passanger = new Passangers();
		passanger
				.setPhonenumber(Long.parseLong(request.getParameter("phoneno")));
		passanger.setEmail(request.getParameter("email"));
		passanger.setFather_DateOfBirth(LocalDate.parse(request
				.getParameter("fatherdob")));
		PassangersDAO passangerDAO = new PassangersDAO();
		String displaymessage = "";
		try {
			if (!passangerDAO.checkLoginEmail(passanger)) {
				displaymessage = "Your not a valid User";
				String page = "forget_password.jsp";
				RequestDispatcherForward.forward(displaymessage, page, request,
						response);
			}
			if (passangerDAO.checkForgetPassword(passanger) != null) {
				Passangers forgetpassanger = passangerDAO
						.checkForgetPassword(passanger);
				displaymessage = "Your Password is "
						+ forgetpassanger.getPassword();
				String page = "forget_password.jsp";
				RequestDispatcherForward.forward(displaymessage, page, request,
						response);
			} else {
				displaymessage = "**Please Check with your credencials";
				String page = "forget_password.jsp";
				RequestDispatcherForward.forward(displaymessage, page, request,
						response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
