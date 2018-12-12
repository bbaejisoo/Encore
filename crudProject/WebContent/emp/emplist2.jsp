
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table border="1">
<tr>
	<td>직원번호</td>
	<td>이름</td>
	<td>성</td>
	<td>이메일</td>
	<td>이메일2</td>
	<td>전화번호</td>
	<td>직급</td>
	<td>입사일</td>
	<td>부서</td>
	<td>급여</td>
	<td>매니저</td>
	<td>커미션</td>
	<td></td>
</tr>
<c:forEach items="${emps }" var="emp">
	<tr>
		<td><a href="empById.go?empid=${emp.employee_id }">${emp.employee_id }</a></td>
		<td>${emp.first_name }</td>
		<td>${emp.last_name }</td>
		<td>${emp.email }</td>
		<td>${fn:substring(emp.email, 0, 2) }</td>
		<td>${emp.phone_number }</td>
		<td>${emp.job_id }</td>
		<td>
		<fmt:formatDate value="${emp.hire_date }" dateStyle="long"/>
		</td>
		<td>${emp.department_id }</td>
		<td>
		<fmt:formatNumber value="${emp.salary }" type="currency" currencySymbol="$"></fmt:formatNumber>
		</td>
		<td>${emp.manager_id }</td>
		<td>${emp.commission_pct }</td>
		<td><button onclick="call(${emp.employee_id});">삭제</button></td>
	</tr>
</c:forEach>

</table>