<%@page import="java.util.ListIterator"%>
<%@page import="com.jsp.model.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./checkStatement.css" type="text/css">
</head>
<body>
	<div class="maincontainer">
		<div class="container">
			<h1>Check Statement</h1>
			<form class="form" action="checkurl" method="post">
				<span><pre>Account Number  :</pre><input class="input" placeholder="Enter the Account Number" name="accnum"></span>
				<span><pre>From Date      :</pre><input class="input" placeholder="Enter the From Date" name="fromDate"></span>
				<span><pre>To Date        :</pre><input class="input" placeholder="Enter the To Date" name="toDate"></span>
				<input class="submit" type="submit">
			</form>
		
		<% 
		ArrayList arr = (ArrayList)session.getAttribute("data");
			if(arr != null)
			{%>
			<table border="1" cellpadding="10">
				<tr>
					<th>User Name</th>
					<th>Transaction Date</th>
					<th>Transaction Time</th>
					<th>Transaction Type</th>
					<th>Transaction Amount</th>
					<th>Transaction Id</th>
					<th>Total Balance</th>
					<th>User Account Number</th>
				</tr>
			<%
			ListIterator li =  arr.listIterator();
			while(li.hasNext())
			{
				Statement st = (Statement)li.next();	
			%>
				<tr>
					<td><%=st.getUserName()%></td>
					<td><%=st.getTransactionDate() %></td>
					<td><%=st.getTransactionTime() %></td>
					<td><%=st.getTransactionType() %></td>
					<td><%=st.getTransactionAmount() %></td>
					<td><%=st.getTransactionId() %></td>
					<td><%=st.getTotalBalance() %></td>
					<td><%=st.getUserAccountNumber() %></td>
				</tr>
			<% }%>
			</table>
			<% }
		%>
		</div>
	</div>
</body>
</html>