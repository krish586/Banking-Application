<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="registration.css" type="text/css">
</head>
<body>
<div class="container">
	<form class="form" action="registrationurl">
		<h1>Internet Banking Registration</h1>
		<side>
		<span><pre>User Name     : </pre><input class="input" placeholder="Enter the name" name="name"></span>
		<span><pre>Mobile Number  : </pre><input class="input" placeholder="Enter the mobile Number" name="mobilenum"></span>
		<span><pre>Email         : </pre><input class="input" placeholder="Enter the email" name="email"></span>
		<span><pre>Address       : </pre><input class="input" placeholder="Enter the Address" name="address"></span>
		<span><pre>Gender        : </pre><input class="input" placeholder="Enter the gender" name="gender"></span>
		<span><pre>Date of Birth  : </pre><input class="input" placeholder="Enter the Date of Birth" name="dob"></span>
		<input class="submit" type="submit">
		</side>
	</form>
</div>
</body>
</html>