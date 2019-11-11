<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List under </title>
</head>

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

<body>
	<h2>List of Employee under ${managerName}</h2>
	<br>
		<button
			onclick="window.location.href = 'http://localhost:8088/employee/createEmployee?managerId=${managerID}';">
			Create Employee
		</button>
	<br>
	
	<form action="GET">
	<table id="managers">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Position ID</th>
			<th>Department ID</th>
			<th>Employment Type</th>
			<th>Employee Manager</th>
			<th> </th>
			<th> </th>
			<th> </th>
			<th> </th>
			<th> </th>
		</tr>
		<c:forEach var="list" items="${employeeList}">
			<tr>
				<td>${list.id}</td>
				<td>${list.empFName}</td>
				<td>${list.empLName}</td>
				<td>${list.empPosId}</td>
				<td>${list.empDept}</td>
				<td>${list.empType}</td>
				<td>${list.empManager}</td>
				<td><a href='viewManager?ViewId=${list.id}&PositionId=${list.empPosId}&DepartmentId=${list.empDept}&PositionId=${list.empManager}'>View</a></td>
				<td><a href='updateMng?UpdateId=${list.id}&PositionId=${list.empPosId}&DepartmentId=${list.empDept}&PositionId=${list.empManager}'>Edit</a></td> 
 				<td><a href='deleteMng?DeleteId=${list.id}'>Delete</a></td>
 				<td><a href='printMng?PrintId=${list.id}'>Print</a></td>
 				<td><a href='printMng?QMBSId=${list.id}'>QMBS</a></td>
			</tr>
		</c:forEach>
	</table>
	</form>                                                      
	<br>
	<button
		onclick="window.location.href = 'http://localhost:8083/manager/findAll';">
		Manager HomePage
	</button>
</body>
</html>