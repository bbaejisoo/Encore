<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직책리스트</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<h1>직책조회</h1>
<ol>
	<c:forEach var="job" items="${joblist}">
	<li>${job.job_id}===>${job.job_title}</li>	
	</c:forEach>
</ol>
</body>
</html>