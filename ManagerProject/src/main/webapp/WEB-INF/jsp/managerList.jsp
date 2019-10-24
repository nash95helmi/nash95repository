<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	#managers {
  		font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  		border-collapse: collapse;
  		width: 100%;
	}

	#managers td, #managers th {
  		border: 1px solid #ddd;
  		padding: 8px;
	}

	#managers tr:nth-child(even){background-color: #f2f2f2;}

	#managers tr:hover {background-color: #ddd;}

	#managers th {
  		padding-top: 12px;
  		padding-bottom: 12px;
  		text-align: left;
  		background-color: #4CAF50;
  		color: white;
	}
</style>

</head>
<body>
	
	<h2>List of Managers</h2>
	<form action="GET">
	<table id="managers">
		<tr>
			<th>Manager ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Position ID</th>
			<th>Department ID</th>
			<th>Status</th>
			<th> </th>
			<th> </th>
			<th> </th>
			<th> </th>
		</tr>
		<c:forEach var="list" items="${mList}">
			<tr>
				<td><c:out value="${list.id}"></c:out></td>
				<td><c:out value="${list.managerFName}"></c:out></td>
				<td><c:out value="${list.managerLName}"></c:out></td>
				<td><c:out value="${list.managerPos}"></c:out></td>
				<td><c:out value="${list.managerDept}"></c:out></td>
				<td><c:out value="${list.managerSta}"></c:out></td>
				<td><a href='viewManager?ManagerId=${list.id}&PositionId=${list.managerPos}&DepartmentId=${list.managerDept}'>View</a></td>
				<td><a href='updateMng?UpdateId=${list.id}&PositionId=${list.managerPos}&DepartmentId=${list.managerDept}'>Edit</a></td> 
 				<td><a href='deleteMng?DeleteId=${list.id}'>Delete</a></td>
 				<td><a href='printMng?PrintId=${list.id}'>Print</a></td>
			</tr>
		</c:forEach>
	</table>
	</form>
	<br>
	<form method="GET" action = "/manager/register">
		<button type="submit" value="Redirect Page" >Create</button>
	</form> 
	
</body>
</html>