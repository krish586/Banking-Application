package com.jsp.model;

import java.sql.Date;

public class BankUserInfo
{
	private int UserId;
	private String UserName;
	private String UserMobileNum;
	private String UserEmailId;
	private String UserAddress;
	private String UserGender;
	private Date DaUserDateOfBirth;
	private int UserAccountNum;
	private int UserPassword;
	private double BankBalance;
	public String BankIfscCode;
	public String TypeOfAccount;
	public BankUserInfo()
	{
		super();
	}
	public BankUserInfo(int userId, String userName, String userMobileNum, String userEmailId, String userAddress,
			String userGender, Date daUserDateOfBirth, int userAccountNum, int userPassword, double bankBalance,
			String bankIfscCode, String typeOfAccount)
	{
		super();
		UserId = userId;
		UserName = userName;
		UserMobileNum = userMobileNum;
		UserEmailId = userEmailId;
		UserAddress = userAddress;
		UserGender = userGender;
		DaUserDateOfBirth = daUserDateOfBirth;
		UserAccountNum = userAccountNum;
		UserPassword = userPassword;
		BankBalance = bankBalance;
		BankIfscCode = bankIfscCode;
		TypeOfAccount = typeOfAccount;
	}
	public int getUserId()
	{
		return UserId;
	}
	public void setUserId(int userId)
	{
		UserId = userId;
	}
	public String getUserName()
	{
		return UserName;
	}
	public void setUserName(String userName)
	{
		UserName = userName;
	}
	public String getUserMobileNum()
	{
		return UserMobileNum;
	}
	public void setUserMobileNum(String userMobileNum)
	{
		UserMobileNum = userMobileNum;
	}
	public String getUserEmailId()
	{
		return UserEmailId;
	}
	public void setUserEmailId(String userEmailId) 
	{
		UserEmailId = userEmailId;
	}
	public String getUserAddress() 
	{
		return UserAddress;
	}
	public void setUserAddress(String userAddress) 
	{
		UserAddress = userAddress;
	}
	public String getUserGender() 
	{
		return UserGender;
	}
	public void setUserGender(String userGender) 
	{
		UserGender = userGender;
	}
	public Date getDaUserDateOfBirth()
	{
		return DaUserDateOfBirth;
	}
	public void setDaUserDateOfBirth(Date daUserDateOfBirth)
	{
		DaUserDateOfBirth = daUserDateOfBirth;
	}
	public int getUserAccountNum()
	{
		return UserAccountNum;
	}
	public void setUserAccountNum(int userAccountNum) 
	{
		UserAccountNum = userAccountNum;
	}
	public int getUserPassword() 
	{
		return UserPassword;
	}
	public void setUserPassword(int userPassword) 
	{
		UserPassword = userPassword;
	}
	public double getBankBalance()
	{
		return BankBalance;
	}
	public void setBankBalance(double bankBalance) 
	{
		BankBalance = bankBalance;
	}
	public String getBankIfscCode() 
	{
		return BankIfscCode;
	}
	public void setBankIfscCode(String bankIfscCode)
	{
		BankIfscCode = bankIfscCode;
	}
	public String getTypeOfAccount() 
	{
		return TypeOfAccount;
	}
	public void setTypeOfAccount(String typeOfAccount) 
	{
		TypeOfAccount = typeOfAccount;
	}
	@Override
	public String toString() 
	{
		return "UserInfo [UserId=" + UserId + ", UserName=" + UserName + ", UserMobileNum=" + UserMobileNum
				+ ", UserEmailId=" + UserEmailId + ", UserAddress=" + UserAddress + ", UserGender=" + UserGender
				+ ", DaUserDateOfBirth=" + DaUserDateOfBirth + ", UserAccountNum=" + UserAccountNum + ", UserPassword="
				+ UserPassword + ", BankBalance=" + BankBalance + ", BankIfscCode=" + BankIfscCode + ", TypeOfAccount="
				+ TypeOfAccount + "]";
	}
	
}
