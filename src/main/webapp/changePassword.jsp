<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./changePassword.css" type="text/css">
</head>
<body>
	<div class="container">
	<form class="form" action="changepasswordurl" method="post">
		<h1>Change Password</h1>
		<span><pre>Account Number   : </pre><input class="input" placeholder="Enter the account number" name="account"></span>
		<span><pre>User Email Id    : </pre><input class="input" placeholder="Enter the email id" name="email"></span>
		<span><pre>Present Password : </pre><input class="input" placeholder="Enter the present password" name="password"></span>
		<span><pre>New Password     : </pre><input class="input" placeholder="Enter the new password" name="new"></span>
		<input class="submit" type="submit">
	</form>
</div>
</body>
</html>