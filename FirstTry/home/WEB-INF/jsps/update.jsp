<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.updatebtn {
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

<title>Insert title here</title>
</head>
<body>
	<form method="post">
	<h1>Update Student</h1>
	<% User userObj = (User) request.getAttribute("UID"); %>
	<table cellspacing="2" cellpadding="2" border="2" width="70%" >
	<% 
		if(request.getAttribute("UID") != null){ 
			int UserID = userObj.getUserId();
			String pwd = userObj.getPassword();
			String fname = userObj.getFirstname();
			String lname = userObj.getLastname();
			String email = userObj.getEmail();
	%>
			<tr><td>UserID</td><td><%=UserID %></td></tr>
			<tr><td>Password:</td><td><input type='text' name='password' value='<%=pwd %>'/></td></tr>
			<tr><td>FirstName:</td><td><input type='text' name='fname' value='<%=fname %>'/></td></tr>
			<tr><td>LastName:</td><td><input type='text' name='lname' value='<%=lname %>'/></td></tr>
			<tr><td>Email:</td><td><input type='text' name='email' value='<%=email %>'/></td></tr>
	<% 	}
	%>
	</table>
	
	<button type="submit" class="updatebtn" name="act" value="update_click" >Update</button>
	</form>
</body>
</html>