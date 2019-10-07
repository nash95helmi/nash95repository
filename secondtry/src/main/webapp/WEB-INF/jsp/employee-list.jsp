<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Employee List</title>
	</head>
	<body>
		<h1>Employee List</h1>
		<form action="GET">
		<table cellspacing="2" cellpadding="2" border=2 width="70%">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="list" items="${iList}">
				<tr>
					<td><c:out value="${list.id}" /></td>
					<td><c:out value="${list.firstName}" /></td>
					<td><c:out value="${list.lastName}" /></td>
					<td><c:out value="${list.email}" /></td>
			<!--  	<td><a href='updateEmp?UpdateId=${list.id}'>edit</a></td>  -->
					<td><a href='updateEmp?UpdateId=<c:out value="${list.id}" />'>edit</a></td> 
 					<td><a href='deleteEmp?DeleteId=${list.id}'>delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</form>
		<br>
		<form method="GET" action = "/employee/register">
			<button type="submit" value="Redirect Page" >Create</button>
		</form> 
	</body>
</html>