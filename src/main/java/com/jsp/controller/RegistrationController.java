package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.DAO.UserDao;
import com.jsp.DAO.UserDaoHelp;
import com.jsp.model.BankUserInfo;

@WebServlet("/registrationurl")
public class RegistrationController extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter writer=response.getWriter();
    	response.setContentType("text/html");
		String userName =request.getParameter("name");
    	String userMobilenumber =request.getParameter("mobilenum");
    	String userEmail =request.getParameter("email");
    	String userAddress =request.getParameter("address");
    	String userGender =request.getParameter("gender");
    	String userDob =request.getParameter("dob");
    	Date dateOfBirth = Date.valueOf(userDob);
    	BankUserInfo userInformation = new BankUserInfo();
    	userInformation.setUserName(userName);
    	userInformation.setUserMobileNum(userMobilenumber);
    	userInformation.setUserEmailId(userEmail);
    	userInformation.setUserAddress(userAddress);
    	userInformation.setUserGender(userGender);
    	userInformation.setDaUserDateOfBirth(dateOfBirth);
    	UserDao userDao=UserDaoHelp.userDao();
    	if(userDao.userRegistration(userInformation))
    	{
    		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
    		rd.forward(request, response);
    	}
    	else
    	{
    		RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
    		rd.forward(request, response);
    		writer.println("<center><h1>Registration Failed</h1></center>");
    	}
    }
}
