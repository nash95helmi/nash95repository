<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="/employee/save">
		<h1>Register</h1>
		<p>Please fill in this form to create an account.</p>
		<hr>
		
		<label for="firstname"><b>FirstName</b></label>
    	<input type="text" placeholder="Enter FirstName" name="firstName" >
    	<br>
    	<label for="lastname"><b>LastName</b></label>
    	<input type="text" placeholder="Enter LastName" name="lastName" >
    	<br>
    	<label for="email"><b>Email</b></label>
    	<input type="text" placeholder="Enter Email" name="email" >
    	<br>
    	<button type="submit" value="Save" >Save</button>
	</form>
	
</body>
</html>