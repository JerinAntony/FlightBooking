package com.chainsys.flightbooking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.flightbooking.dao.PassangersDAO;
import com.chainsys.flightbooking.model.Passangers;
import com.chainsys.flightbooking.util.RequestDispatcherForward;

/**
 * Servlet implementation class ChnagePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Passangers passanger = new Passangers();
		HttpSession session = request.getSession(false);
		Passangers sessionpassangers = (Passangers) session
				.getAttribute("PASSANGER");

		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");

		PassangersDAO passangerDAO = new PassangersDAO();
		String message = "";
		String page = "change_password.jsp";
		try {
			if (confirmpassword.equals(newpassword)) {
				if (oldpassword.equalsIgnoreCase(sessionpassangers
						.getPassword())) {
					passanger.setPassword(newpassword);
					passanger.setId(sessionpassangers.getId());
					passangerDAO.changePassword(passanger);
				} else {
					message = "**Old Password Does Not Match**";
					RequestDispatcherForward.forward(message, page, request,
							response);
				}
			} else {
				message = "Confirm Password and New Password Does not match";
				RequestDispatcherForward.forward(message, page, request,
						response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
