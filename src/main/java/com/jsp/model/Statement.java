package com.jsp.model;

import java.sql.Date;
import java.sql.Time;

public class Statement
{
	private String UserName;
	private Date TransactionDate;
	private Time TransactionTime;
	private String TransactionType;
	private double TransactionAmount;
	private int TransactionId;
	private double TotalBalance;
	private int UserAccountNumber;
	public Statement()
	{
		super();
	}
	public Statement(String userName, Date transactionDate, Time transactionTime, String transactionType,
			double transactionAmount, int transactionId, double totalBalance, int userAccountNumber) 
	{
		super();
		UserName = userName;
		TransactionDate = transactionDate;
		TransactionTime = transactionTime;
		TransactionType = transactionType;
		TransactionAmount = transactionAmount;
		TransactionId = transactionId;
		TotalBalance = totalBalance;
		UserAccountNumber = userAccountNumber;
	}
	public String getUserName() 
	{
		return UserName;
	}
	public void setUserName(String userName)
	{
		UserName = userName;
	}
	public Date getTransactionDate() 
	{
		return TransactionDate;
	}
	public void setTransactionDate(Date transactionDate)
	{
		TransactionDate = transactionDate;
	}
	public Time getTransactionTime()
	{
		return TransactionTime;
	}
	public void setTransactionTime(Time transactionTime)
	{
		TransactionTime = transactionTime;
	}
	public String getTransactionType()
	{
		return TransactionType;
	}
	public void setTransactionType(String transactionType)
	{
		TransactionType = transactionType;
	}
	public double getTransactionAmount()
	{
		return TransactionAmount;
	}
	public void setTransactionAmount(double transactionAmount)
	{
		TransactionAmount = transactionAmount;
	}
	public int getTransactionId() 
	{
		return TransactionId;
	}
	public void setTransactionId(int transactionId)
	{
		TransactionId = transactionId;
	}
	public double getTotalBalance()
	{
		return TotalBalance;
	}
	public void setTotalBalance(double totalBalance)
	{
		TotalBalance = totalBalance;
	}
	public int getUserAccountNumber()
	{
		return UserAccountNumber;
	}
	public void setUserAccountNumber(int userAccountNumber) 
	{
		UserAccountNumber = userAccountNumber;
	}
	@Override
	public String toString()
	{
		return "Statement [UserName=" + UserName + ", TransactionDate=" + TransactionDate + ", TransactionTime="
				+ TransactionTime + ", TransactionType=" + TransactionType + ", TransactionAmount=" + TransactionAmount
				+ ", TransactionId=" + TransactionId + ", TotalBalance=" + TotalBalance + ", UserAccountNumber="
				+ UserAccountNumber + "]";
	}
	
}
