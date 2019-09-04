<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="org.model.User"%>
<%@page import="java.util.Iterator"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all page</title>
<style>
/* Set a style for the button */
.btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
</style>
</head>
<body>
<form action="GET">
	<% ArrayList<User> allList = (ArrayList) request.getAttribute("AllList"); %>
	<h1>View all page</h1>
	
	<table cellspacing="2" cellpadding="2" border=2 width="70%">
 
		<tr><th>User ID</th><th>Password</th><th>First Name</th><th>Last Name</th><th>Email</th></tr>
			<%
			// Iterating through subjectList
 
			if(request.getAttribute("AllList") != null)  // Null check for the object
			{
 				Iterator<User> iterator = allList.iterator();  // Iterator interface
 
 				while(iterator.hasNext())  // iterate through all the data until the last record
 				{
 					User usrDetails = iterator.next(); //assign individual employee record to the employee class object
			 	%>
 		<!--   	<tr><td><%=usrDetails.getUserId()%><input name="UserID" value="<%=usrDetails.getUserId()%>" readonly></input></td> -->
 				<tr><td><input name="UserID" value="<%=usrDetails.getUserId()%>" readonly></input></td>
 				<td><%=usrDetails.getPassword()%><output name="Password"></output></td>
 				<td><%=usrDetails.getFirstname()%><output name="FirstName"></output></td>
 				<td><%=usrDetails.getLastname()%><output name="LastName"></output></td>
 				<td><%=usrDetails.getEmail()%><output name="Email"></output></td>
 		<!-- 	<td><button type="submit" class="btn" name="act" value="GetupdateID_click" >Update</button></td> 	-->
 				<td><a href='Home?id=<%=usrDetails.getUserId() %>'>edit</a></td>
 				<td><a href='Home?idDelete=<%=usrDetails.getUserId() %>'>delete</a></td>
 		<!--	<td><button type="submit" class="btn" name="act" value="delete_click" >Delete</button></td> 		-->
 			</tr>
 			<%
 		}		
	}%>
	</table>
	<a href='Home'>Register</a>
	</form>
	<form method="post">
		<button type="submit" class="btn" name="act" value="create_click" >Create</button>
	</form> 
</body>
</html>