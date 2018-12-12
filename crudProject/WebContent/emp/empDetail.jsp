<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<hr>
<h1>직원정보수정</h1>
<form action="empById.go" method="post">
직원번호 : <input type="number" name="employee_id" value="${emp.employee_id }"><br>
이름 : <input type="text" name="first_name" value="${emp.first_name }"><br>
성 : <input type="text" name="last_name" value="${emp.last_name }"><br>
이메일 : <input type="email" name="email" value="${emp.email }"><br>
전화번호 : <input type="tel" name="phone_number" value="${emp.phone_number }"><br>
커미션 : <input type="text" name="commission_pct" value="${emp.commission_pct }"><br>
부서번호 : 
<select name="department_id">
	<c:forEach var="dept" items="${deptlist}">
		<option value="${dept.department_id}" ${dept.department_id==emp.department_id?"selected":""}>
		${dept.department_name}
		</option>
	</c:forEach>
</select><br>

직책 : 
<select name="job_id">
	<c:forEach var="job" items="${joblist}">
		<option value="${job.job_id }" ${job.job_id==emp.job_id?"selected":""}>
		${job.job_title}
		</option>
	</c:forEach>
</select><br>

매니저 : 
<select name = "manager_id">
	<c:forEach var="mgr" items="${mgrlist}">
		<option value="${mgr.employee_id}" ${mgr.employee_id==emp.manager_id?"selected":""}>
		${mgr.emp_name}
		</option>
	</c:forEach>
</select><br>

입사일 : <input type="date" name="hire_date" value="${emp.hire_date }"><br>
급여 : <input type="number" name="salary" value="${emp.salary }"><br>
<input type="submit" value="수정하기">
</form>
</body>
</html>