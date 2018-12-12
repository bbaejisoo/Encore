<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>부서 리스트</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<h1>부서목록</h1>
<ol>
	<c:forEach var="dept" items="${deptlist}">
	<li>${dept.department_id}===>${dept.department_name}</li>	
	</c:forEach>
</ol>
</body>
</html>