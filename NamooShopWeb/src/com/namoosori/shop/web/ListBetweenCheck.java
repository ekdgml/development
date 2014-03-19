package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orderCheck.do")
public class ListBetweenCheck extends HttpServlet {

	private static final long serialVersionUID = 2396634535603419829L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//
		String[] orders = req.getParameterValues("a");
		String address = req.getParameter("address");
		if (orders != null && orders.length > 0 && address != null) {
			//
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("confirm.xhtml");
			dispatcher.forward(req, resp);
		} else {
			//
			resp.sendRedirect("orderList.xhtml");
		}
	}

}
