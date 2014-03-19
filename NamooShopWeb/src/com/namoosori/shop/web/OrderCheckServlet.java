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
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;


@WebServlet("/confirm.xhtml")
public class OrderCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1458301677091720664L;

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
		Customer customer = (Customer) req.getSession().getAttribute("loginId");
		req.setCharacterEncoding("utf-8");
		if (req.getSession().getAttribute("loginId") == null) {
			resp.sendRedirect("login.xhtml");
		} else {
			resp.setContentType("text/html; charset=utf-8");

			PrintWriter writer = resp.getWriter();
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<meta charset='utf-8'>");
			writer.println("<title>주문화면</title>");
			writer.println("<link href='./CSS/confirm.css' rel='stylesheet' type='text/css' />");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("<div id='orderCheck'>");
			writer.println("<form action='complete.xhtml' method='post'>");
			writer.println("[" + customer.getName() + "] 님이 로그인 하셨습니다.");
			writer.println("<h1>주문 상품</h1>");
			writer.println("<div id='table1'>");
			writer.println("<table>");
			writer.println("<thead>");
			writer.println("<tr>");
			writer.println("<th>상품번호</th>");
			writer.println("<th>상품명</th>");
			writer.println("<th>가격</th>");
			writer.println("</tr>");
			writer.println("</thead>");
			String[] nums = req.getParameterValues("number");
			ProductService Proservice = NamooShopServiceFactory.getInstance()
					.getProductService();
			Order order = new Order();
			for (String num : nums) {
				Product findProduct = Proservice.getProduct(Integer
						.parseInt(num));
				order.addProduct(findProduct);
				writer.println("<tr>");
				writer.println("<td class='num'>" + findProduct.getSerialNo()+"<input type='hidden' name='number' value='"
						+ findProduct.getSerialNo() + "'/></td>");
				writer.println("<td class='name'>" + findProduct.getName() + "</td>");
				writer.println("<td calss='price'>" + String.format("%,d" ,findProduct.getPrice()) + "원 </td>");
				writer.println("</tr>");
			}
			
			writer.println("<tbody>");
			writer.println("</table>");
			writer.println("<h3>주문금액 :"+ String.format("%, d",order.getTotalPrice())+"원</h3>" );
			writer.println("</div>");
			
			writer.println("<h1>주문정보 입력</h1>");
			writer.println("<div id='table2'>");
			writer.println("<table>");
			writer.println("<tr>");
			writer.println("<th>결제방법</th>");
			writer.println("<td>"+req.getParameter("a")+"<input type='hidden' name='payment' value='payment'/></td>");
			writer.println("");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<th>배송지주소</th>");
			writer.println("<td>"+req.getParameter("address")+"<input type='hidden' name='shipment' value='shipment'/></td>");
			writer.println("</tr>");
			writer.println("</table>");
			writer.println("</div>");
			writer.println("<input type='button' onclick='history.back()' value='수정' />");
			writer.println("<input type='submit' value='신청완료' />");
			writer.println("</form>");
			writer.println("</div>");
			writer.println("</body>");
			writer.println("</html>");
		}
	}
}