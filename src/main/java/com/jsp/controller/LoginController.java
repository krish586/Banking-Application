package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.DAO.UserDao;
import com.jsp.DAO.UserDaoHelp;
import com.jsp.model.BankUserInfo;

@WebServlet("/loginurl")
public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		int pass = Integer.parseInt(password);
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		UserDao userDao = UserDaoHelp.userDao();
		BankUserInfo user = userDao.login(emailId, pass);
		if(user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getUserName());
			session.setAttribute("account_num", user.getUserAccountNum());
			session.setAttribute("balance_amount", user.getBankBalance());
			session.setAttribute("pin", user.getUserPassword());
			session.setAttribute("typeofacc", user.getTypeOfAccount());
			session.setAttribute("emailId", user.getUserEmailId());
			RequestDispatcher rd = request.getRequestDispatcher("Operations.jsp");
			rd.include(request, response);
//			writer.println("<center><h1>Login Successful</h1></center>");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Login Failed</h1></center>");
		}
	}
}