package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.namooshop.domain.Customer;
import com.namoosori.namooshop.domain.Order;
import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.facade.OrderService;
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/complete.xhtml")
public class CompleteServlet extends HttpServlet {

	private static final long serialVersionUID = -6255426892927710640L;

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
		if (req.getSession().getAttribute("loginId") == null) {
			resp.sendRedirect("login.xhtml");
		} else {
			Order order = new Order();
			ProductService service = NamooShopServiceFactory.getInstance()
					.getProductService();
			String[] nums = req.getParameterValues("number");
			for (String num : nums) {
				Product product = service.getProduct(Integer.parseInt(num));
				order.addProduct(product);
			}
			String payment = req.getParameter("payment");
			String shipment = req.getParameter("shipment");
			order.setPayment(payment);
			order.setShipAddress(shipment);
			order.setCustomer((Customer) req.getSession().getAttribute("loginId"));
			
			OrderService orderService = NamooShopServiceFactory.getInstance().getOrderService();
			orderService.order(order);
			
			//resp.setContentType("text/html; charset=utf-8");

			PrintWriter writer = resp.getWriter();
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>주문 완료</title>");
			writer.println("<link href='./css/complete.css' rel='stylesheet' type ='text/css' />");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("<div id='complete'>");
			writer.println("<form action='main.xhtml'>");
			writer.println("<h1>상품 주문이 완료되었습니다.</h1>");
			writer.println("<input type='submit' value='확인'>");
			writer.println("</form>");
			writer.println("</div>");
			writer.println("</body>");
			writer.println("</html>");
		}
	}

}
