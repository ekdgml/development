<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First</title>
</head>
<body>

	<!-- html주석 -->
	<%-- jsp주석 --%>
	<h1>이번에는 성공해야지!!!!!!!!!!!</h1>
	<%
		pageContext.setAttribute("name", "홍길동");
	%>
	<%-- 지시자 --%>
	<%@include file="number_table.jsp"%>

	<%--jsp include 표준액션 
	<jsp:include page="number_table.jsp" />--%>
	<%-- 선언문 --%>
	<%!int number = 10;%>

	<%-- 표현식 전역변수! --%>
	<%=number%>


	<%-- 스크립트릿 : 메소드 안에 선언된 지역변수! --%>
	<%
		number++;
		out.print(number + "<br/>");

		int count = 10;
		count++;
		out.print(count + "<br/>");

		int dan = 2;
		for (int i = 1; i < 10; i++) {
			out.println(String.format("%d * %d = %d <br/>", dan, i,
					(dan * i)));
		}
	%>
</body>
</html>