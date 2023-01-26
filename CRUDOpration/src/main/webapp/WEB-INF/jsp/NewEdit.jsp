<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<script>

function edit(id){
	
	
	window.location.href = "http://localhost:8080/getid?=id"+id;
		
}


</script>
<body>
<div class="container">


<center>
<h2>Add Update User!</h2>
<br>
<form action="/add" method="post" >
<input type="hidden" name="flag" id="flag" value="${flag}" placeholder="">
<input type="hidden" name="editid" id="editid" value="${editid}" placeholder="">


FristName:<input type="text" name="fristName" value="${user.fristName}" placeholder="Enter Firstname">
<br>
<br>
LastName:<input type="text" name="lastName"  value="${user.lastName}" placeholder="Enter Lastname">
<br>
<br>
Date Of Birth:<input type="date" name="dateofBirth"  value="${user.dateofBirth}" placeholder="">
<br>
<br>
Username:<input type="text" name="username"  value="${user.username}" placeholder="Enter Lastname">
<br>
<br>
Password:<input type="text" name="password"  value="${user.password}" placeholder="Enter Lastname">



<br>
<br>
Email:<input type="text" name="email" placeholder="Enter Lastname">




<br>
<br>

<input type="submit" value="AddUpdate">
</form>
</center>
</div>


</body>

</html>