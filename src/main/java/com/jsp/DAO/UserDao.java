package com.jsp.DAO;

import java.sql.Date;
import java.util.ArrayList;

import com.jsp.model.BankUserInfo;
import com.jsp.model.Statement;

public interface UserDao
{
	boolean userRegistration(BankUserInfo userInfo);
	BankUserInfo login(String email,int password);
	boolean debitAmount(int accountnumber, int password, Statement statement);
	boolean creditAmount(int accountnumber, int password, Statement statement);
	ArrayList checkStatement(Date fromDate,Date toDate,int account);
	boolean changePassword(int accountnumber,String email,int password,int newpassword);
	boolean deleteAccount(int accountnumber,String email,int password);
}
