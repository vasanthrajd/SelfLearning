<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding the Employee Details</title>
<style type="text/css">
body {
	background-image: url('https://crunchify.com/bg.png');
}
</style>
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<br>
	<div style="text-align: center">
	<h2> Adding the Employee Details </h2>
	<form:form method="post" action="saveEmployee.html">
		<table>
			<tr>
				<td> Name : </td>
				<td> <form:input path="name" /></td>
			</tr>
			<tr>
				<td> Salary : </td>
				<td> <form:input path="salary"/> </td>
			</tr>
			<tr>
				<td> Designation : </td>
				<td> <form:input path="designation"/> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Save Employee" />
				</td>
			</tr> 
		</table>
	</form:form>
</div>
</body>
</html>