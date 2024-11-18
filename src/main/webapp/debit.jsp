<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit</title>
<link rel="stylesheet" href="./debit.css" type="text/css">
</head>
<body>
	<div class="container">
	<h1>Credit of Internet Banking</h1>
	<form class="form" action="debiturl" method="post">
		<span><pre>Account Number  : </pre><input class="input" placeholder="Enter the Account number" name="accountnumber"></span>
		<span><pre>Amount         : </pre><input class="input" placeholder="Enter the amount" name="amount"></span>
		<span><pre>Type of Account : </pre><input class="input" placeholder="Enter the type of account" name="toa"></span>
		<span><pre>Password       : </pre><input class="input" placeholder="Enter the pin" name="pin"></span>
		<span><input id="receipt" type="radio" name="receipt" value="yes"><pre>Do you want the receipt</pre></span>
		<input class="submit" type="submit">
	</form>
	<%
	String receipt = (String)session.getAttribute("recpt");
	String name = (String)session.getAttribute("name");
	Integer account_number = (Integer)session.getAttribute("account_num");
	Object bank_balance = session.getAttribute("balance_amount");
	int n=account_number;
	Double amount=(Double)session.getAttribute("Database_amount");
	String number=n+"";
	String accountNumber="";
	for(int i=0;i<number.length();i++)
	{
		if(i<2) accountNumber+=number.charAt(i);
		else if(i==number.length()-1) accountNumber+=number.charAt(i);
		else accountNumber+="*";
	}
	if(amount!=null && receipt != null)
	{%>
		<side>
		<span class="details"><pre>Account Holder's name :   </pre><h4><%= name %></h4></span>
		<span class="details"><pre>Account Number        :   </pre><h4><%= accountNumber %></h4></span>
		<span class="details"><pre>Account password      :   </pre><h4><%= "****" %></h4></span>
		<span class="details"><pre>Bank Balance          :   </pre><h4><%= amount %>	</h4></span>
		</side>
	<%}%>
	</div>
</body>
</html>