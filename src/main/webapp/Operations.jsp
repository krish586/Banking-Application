 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="operation.css" type="text/css">
</head>

<body>
	<div class="container">
		<%
		String name = (String)session.getAttribute("name");
		Integer account_number = (Integer)session.getAttribute("account_num");
		Object bank_balance = session.getAttribute("balance_amount");
		%>
		<h1>Welcome to Internet Banking</h1>
		<span>
			<pre>User Name     : </pre>
			<h4>
				<%= name %>
			</h4>
		</span>
		<span>
			<pre>Account Number : </pre>
			<h4>
				<%= account_number %>
			</h4>
		</span>
		<span>
			<pre>Balance Amount : </pre>
			<h4>
				<%= bank_balance %>
			</h4>
		</span>
		<div id="operations">
			<a href="credit.jsp"><button>Debit</button></a>
			<a href="debit.jsp"><button> Credit</button></a>
			<a href="checkStatement.jsp"><button>Check Statement</button></a>
			<a href="changePassword.jsp"><button>Change Password</button></a>
			<a href="deleteAccount.jsp"><button>Delete Account</button></a>
		</div>
	</div>
</body>

</html>