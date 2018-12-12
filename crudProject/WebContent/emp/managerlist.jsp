<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매니저 리스트</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<h1>매니저목록</h1>
<table border="1">
<tr>
	<td>직원번호</td>
	<td>매니저</td>
</tr>
<c:forEach items="${managerlist}" var="manager">
	<tr>
	<td><a href="managerlist.go?empid=${manager.employee_id }">${manager.emp_name }</a></td>
	<td>${manager.employee_id }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>