package com.jsp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.jsp.model.Statement;
import com.jsp.model.BankUserInfo;

public class UserDaoImplementation implements UserDao{
	Random random = new Random();
	String url = "jdbc:mysql://localhost:3306/scott?user=root&password=1234";

	@Override
	public boolean userRegistration(BankUserInfo userinfo) {
		System.out.println(userinfo);
		String insert = "insert into bankuserinfo(UserNmae, UserMobileNum, UserEmailId, UserAddress, UserGender, UserDateOfBirth, UserAccountNum, UserPassword, BankBalance, BankIfsc_Code, TypeOfAccount)values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setString(1,userinfo.getUserName());
			ps.setString(2,userinfo.getUserMobileNum());
			ps.setString(3,userinfo.getUserEmailId());
			ps.setString(4,userinfo.getUserAddress());
			ps.setString(5,userinfo.getUserGender());
			ps.setDate(6,userinfo.getDaUserDateOfBirth());
			int acc_num = random.nextInt(10000000);
			if(acc_num<1000000)
			{
				acc_num+=1000000;
			}
			ps.setInt(7, acc_num);
			int password = random.nextInt(10000);
			if(password<1000)
			{
				password+=1000;
			}
			ps.setInt(8,password);
			ps.setDouble(9,userinfo.getBankBalance());
			ps.setString(10,"Jsp0923");
			ps.setString(11,"Savings");
			int updatedRows = ps.executeUpdate();
			if(updatedRows != 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public BankUserInfo login(String email,int pass) {
		String select = "select * from BankUserInfo where UserEmail=? and UserPassword=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setString(1, email);
			ps.setInt(2, pass);
			ResultSet rs = ps.executeQuery();
			BankUserInfo user = new BankUserInfo();
			if(rs.isBeforeFirst())
			{
				if(rs.next())
				{
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString("UserNmae"));
					user.setUserMobileNum(rs.getString("UserMobileNum"));
					user.setUserEmailId(rs.getString("UserEmail"));
					user.setUserAddress(rs.getString("UserAddress"));
					user.setUserGender(rs.getString("UserGender"));
					user.setDaUserDateOfBirth(rs.getDate("UserDateOfBirth"));
					user.setUserAccountNum(rs.getInt("UserAccountNum"));
					user.setUserPassword(rs.getInt("UserPassword"));
					user.setBankBalance(rs.getDouble("BankBalance"));
					user.setBankIfscCode(rs.getString("BankIfsc_Code"));
					user.setTypeOfAccount(rs.getString("TypeOfAccount"));
					return user;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean debitAmount(int accountnumber, int password, Statement statement) {
		String update = "update BankUserInfo set BankBalance=? where UserAccountNum=? and UserPassword=?";
		String insert = "insert into statement(UserName, TransactionDate, TransactionTime, TransactionType, TransactionAmount, TotalBalance, UserAccountNumber)values(?,?,?,?,?,?,?)";
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps1 = connection.prepareStatement(update);
			ps1.setDouble(1, statement.getTotalBalance());
			ps1.setInt(2, accountnumber);
			ps1.setInt(3, password);
			int updatedRows = ps1.executeUpdate();
			if(updatedRows != 0)
			{
				PreparedStatement ps2 = connection.prepareStatement(insert);
				ps2.setString(1, statement.getUserName());
				ps2.setDate(2, statement.getTransactionDate());
				ps2.setTime(3, statement.getTransactionTime());
				ps2.setString(4, statement.getTransactionType());
				ps2.setDouble(5, statement.getTransactionAmount());
				ps2.setDouble(6, statement.getTotalBalance());
				ps2.setInt(7, statement.getUserAccountNumber());
				int updatedrows = ps2.executeUpdate();
				if(updatedrows != 0)
				{
					return true;
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList checkStatement(Date fromDate, Date toDate, int account) 
	{
		String select = "select * from statement where useraccountnumber=? and transactiondate between ? and ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setInt(1, account);
			ps.setDate(2, fromDate);
			ps.setDate(3, toDate);
			ResultSet rs = ps.executeQuery();
			if(rs.isBeforeFirst())
			{
				ArrayList data = new ArrayList();
				while(rs.next())
				{
					Statement statement = new Statement();
					statement.setUserName(rs.getString("username"));
					statement.setTransactionDate(rs.getDate("transactiondate"));
					statement.setTransactionTime(rs.getTime("transactiontime"));
					statement.setTransactionType(rs.getString("transactiontype"));
					statement.setTransactionAmount(rs.getDouble("transactionamount"));
					statement.setTransactionId(rs.getInt("transactionid"));
					statement.setTotalBalance(rs.getDouble("totalbalance"));
					statement.setUserAccountNumber(rs.getInt("useraccountnumber"));
					data.add(statement);
				}
				return data;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean creditAmount(int accountnumber, int password, Statement statement) {
		String update = "update BankUserInfo set BankBalance=? where UserAccountNum=? and UserPassword=?";
		String insert = "insert into statement(UserName, TransactionDate, TransactionTime, TransactionType, TransactionAmount, TotalBalance, UserAccountNumber)values(?,?,?,?,?,?,?)";
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps1 = connection.prepareStatement(update);
			ps1.setDouble(1, statement.getTotalBalance());
			ps1.setInt(2, accountnumber);
			ps1.setInt(3, password);
			int updatedRows = ps1.executeUpdate();
			if(updatedRows != 0)
			{
				PreparedStatement ps2 = connection.prepareStatement(insert);
				ps2.setString(1, statement.getUserName());
				ps2.setDate(2, statement.getTransactionDate());
				ps2.setTime(3, statement.getTransactionTime());
				ps2.setString(4, statement.getTransactionType());
				ps2.setDouble(5, statement.getTransactionAmount());
				ps2.setDouble(6, statement.getTotalBalance());
				ps2.setInt(7, statement.getUserAccountNumber());
				int updatedrows = ps2.executeUpdate();
				if(updatedrows != 0)
				{
					return true;
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean changePassword(int accountnumber, String email, int password, int newpassword) {
		String update = "update BankUserInfo set UserPassword=? where UserAccountNum=? and UserEmailId=? and UserPassword=?";
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps1 = connection.prepareStatement(update);
			ps1.setDouble(1, newpassword);
			ps1.setInt(2, accountnumber);
			ps1.setString(3, email);
			ps1.setInt(4, password);
			int updatedRows = ps1.executeUpdate();
			if(updatedRows != 0)
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteAccount(int accountnumber, String email, int password) {
		String update = "delete from BankUserInfo where UserAccountNum=? and UserEmailId=? and UserPassword=?";
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps1 = connection.prepareStatement(update);
			ps1.setInt(1, accountnumber);
			ps1.setString(2, email);
			ps1.setInt(3, password);
			int updatedRows = ps1.executeUpdate();
			if(updatedRows != 0)
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}