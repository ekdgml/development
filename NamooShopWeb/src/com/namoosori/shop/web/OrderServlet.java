package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = -1588822978316313012L;

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
		String[] orders = req.getParameterValues("orders");
		if (orders != null && orders.length > 0) {
			//주문한 책이 있는 경우 주문목록 화면으로 Forward
			RequestDispatcher dispatcher = req.getRequestDispatcher("orderList.xhtml");
			dispatcher.forward(req, resp);
		} else {
			//주문한 책이 없으면 요청화면으로 redirect
			resp.sendRedirect("main.xhtml");
			htmlPrint(resp, "책을 주문하세요" );
		}
	}
	
	private void htmlPrint(HttpServletResponse resp, String message)
			   throws IOException {
			  resp.setContentType("text/html; charset=euc-kr");
			  PrintWriter out = resp.getWriter();
			  out.println("<script>");
			  out.println("alert('" + message + "');");
			  out.println("</script>");
			 }

	
}

