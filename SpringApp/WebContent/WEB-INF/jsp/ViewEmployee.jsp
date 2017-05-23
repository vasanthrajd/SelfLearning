<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viewing the Employee Details</title>
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
   	<h2> Viewing the Employee Details</h2>
   	<table border="2" width="70%" cellpadding="2">
   	<tr>
   		<th>Id</th>
   		<th>Name</th>
   		<th>Salary</th>
   		<th>Designation</th>
   	</tr>
   		<c:forEach var="emp" items="${list}">
   			<tr>
   				<td> ${emp.id} </td>
   				<td> ${emp.name} </td>
   				<td> ${emp.salary} </td>
   				<td> ${emp.designation} </td>
   			</tr>
   		</c:forEach>   		
   </table>
   <br>
		<a href="index.jsp" >
		Click here to load the Home page
   </a>
   </div>  
</body>
</html>