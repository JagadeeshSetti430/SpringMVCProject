<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVC</title>
</head>
<body>
<a href="emp_add"> register</a>
<h1> ${resultMsg}</h1>
<c:choose>
<c:when test="${!empty empList}">

<table border="1" align="center" bgcolor="cyan">
<tr>
<th>empno</th>
<th>ename</th>
<th>job</th>
<th>Salary</th>
<th>Deptno</th>
<th>Operation</th>
</tr>
<c:forEach var="emp" items="${empList}">
<tr style="color:blue">
<td>${emp.empno}</td>
<td>${emp.ename}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptno}</td>
<td><a href="emp_edit?no=${emp.empno}"> edit</a>
<a href="emp_delete?no=${emp.empno}">delete </a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align: center"> Employee Not Found</h1>
</c:otherwise>
</c:choose>
<center>
<a href="emp_add">Add Employee </a>&nbsp;&nbsp;&nbsp;
<a href="./"> Home</a>
</center>
</body>
</html>