<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Second</title>
</head>
<body>

	<h1>두번째 jsp입니다.</h1>
	<p>우이우이우이</p>
	<%-- 
	<%@include file="number_table.jsp"%>--%>

	<%
	pageContext.setAttribute("name", "홍길동2");
	%>
	<jsp:include page="number_table.jsp">
	<jsp:param value="HongGilDong2" name="name"/> 
	</jsp:include>


</body>
</html>