package com.chainsys.flightbooking.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDispatcherForward {

	public static void forward(String msg,String page, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("DISPLAY", msg);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
