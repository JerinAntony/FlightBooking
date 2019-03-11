package com.chainsys.flightbooking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.flightbooking.dao.AirlinesDAO;
import com.chainsys.flightbooking.dao.PassangersDAO;
import com.chainsys.flightbooking.model.Airlines;
import com.chainsys.flightbooking.model.Passangers;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Passangers passanger = new Passangers();
		passanger.setEmail(request.getParameter("email"));
		passanger.setPassword(request.getParameter("password"));
		PassangersDAO passangerDAO = new PassangersDAO();
		String error = "";
		try {
			if (!passangerDAO.checkLoginEmail(passanger)) {
				error = "Please Sign Up and Login";
				request.setAttribute("ALERT", error);

				RequestDispatcher rd = request
						.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			} else if (passangerDAO.checkLogin(passanger)) {
				HttpSession session = request.getSession();
				Passangers pass = passangerDAO.getPassanger(passanger);
				String name = pass.getName().toUpperCase();
				session.setAttribute("NAME", name);
				session.setAttribute("PASSANGER", pass);
				session.setAttribute("PASSANGERID", pass.getId());
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);

			} else {
				error = "**Please Check Email and Password**";
				request.setAttribute("ALERT", error);
				RequestDispatcher rd = request
						.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
