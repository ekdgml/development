<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
	<%
		request.setAttribute("myName", "박상희");
	%>
	이것은 EL로 출력한 숫자 : ${myName}
	<br />
	<%=request.getAttribute("myName")%><br />--%>

	<c:set var="dan" value="${param.dan}" />
<c:choose>
<%--<c:when test="${dan.matches('[2-9]'}"> --%>
<c:when test="${dan>=2 && dan<=9}">
	<c:forEach var="num" begin="1" end="9" step="1">
	${dan} * ${num} = ${num*dan}<br />
	</c:forEach>
</c:when>

<c:otherwise>
2에서 9까지의 숫자만 입력하세요.
</c:otherwise>

</c:choose>

</body>
</html>