<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--	<h1>Update Employee details</h1>
		<h2>${employee.id}</h2>
		<h2>${employee.firstName}</h2>
		<h2>${employee.lastName}</h2>
		<h2>${employee.email}</h2>  	-->
	
		<form method="GET" action="/employee/SaveUpd">
		<h1>Update the rec</h1>
		<p>Please fill in this form to create an account.</p>
		<hr>
		
<!--  	  	<b>ID : ${employee.id}</b>
			<label for="firstname"><b>FirstName</b></label>
    		<input type="text" placeholder="Enter FirstName" name="firstName" value="${employee.firstName}" >
    		<br>
    		<label for="lastname"><b>LastName</b></label>
    		<input type="text" placeholder="Enter LastName" name="lastName" value="${employee.lastName}">
    		<br>
    		<label for="email"><b>Email</b></label>
    		<input type="text" placeholder="Enter Email" name="email" value="${employee.email}">
    		<br>	-->
    		
    		
   		   	<table cellspacing="2" cellpadding="2" border="2" width="70%" >
		  		<tr><td>UserID:</td><td><input type='text' name='updid' value=<c:out value="${employee.id}" /> readonly/></td></tr>
				<tr><td>FirstName:</td><td><input type='text' name='fname' value=<c:out value="${employee.firstName}" />/></td></tr>
				<tr><td>LastName:</td><td><input type='text' name='lname' value=<c:out value="${employee.lastName}" />/></td></tr>
				<tr><td>Email:</td><td><input type='text' name='email' value=<c:out value="${employee.email}" />/></td></tr>
		</table>	 
			
			
			<br>
			<button type="submit" value="SaveUpd" >Save</button>
			
	</form>
	
</body>
</html>