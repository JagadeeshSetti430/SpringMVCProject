<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVC</title>
</head>
<body>
<h1 sytle="color:red">
Register Employee
</h1>
<frm:form modelAttribute="emp">
<table align="center" bgcolor="cyan">

<tr><td>
Employee Name:</td>
<td> <frm:input path="ename"/></td>
</tr>
<tr><td>
Employee job:</td>
<td> <frm:input path="job"/></td>
</tr>
<tr><td>
Employee Salary:</td>
<td> <frm:input path="sal"/></td>
</tr>
<tr><td>
Employee DepartNo:</td>
<td> <frm:input path="deptno"/></td>
</tr>
<tr>
<td><input type="reset" value="reset"/></td>
<td><input type="submit" value="submit"/></td>
</tr>
</table>
 </frm:form>
</body>
</html>