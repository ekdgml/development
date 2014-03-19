<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입완료</title>
</head>
<body>

<%request.setCharacterEncoding("utf-8"); %>

<p>이것은 회원가입 결과페이지 입니다.</p>
이름: ${param.name} <br/>
이메일: ${param.email} <br/>
패스워드: ${param.password} <br/>
</body>
</html>