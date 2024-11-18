package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.DAO.UserDao;
import com.jsp.DAO.UserDaoHelp;

@WebServlet("/checkurl")
public class CheckStatementController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("accnum");
		int account = Integer.parseInt(accountNumber);
		String date = request.getParameter("fromDate");
		Date fromDate = Date.valueOf(date);
		String date1 = request.getParameter("toDate");
		Date toDate = Date.valueOf(date1);
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		UserDao userDao = UserDaoHelp.userDao();
		
		HttpSession session = request.getSession();
		ArrayList data = userDao.checkStatement(fromDate, toDate, account);
		if(data != null)
		{
			session.setAttribute("data", data);
			RequestDispatcher rd = request.getRequestDispatcher("checkStatement.jsp");
			rd.include(request, response);
//			writer.println("<center><h1>Data Present</h1><center>");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("checkStatement.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Data Not Present</h1><center>");
		}
	}
}