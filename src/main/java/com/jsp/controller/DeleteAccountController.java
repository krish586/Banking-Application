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

@WebServlet("/deleteaccounturl")
public class DeleteAccountController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int accnum = Integer.parseInt(request.getParameter("account"));
		String email = request.getParameter("email");
		int password = Integer.parseInt(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		int accountNumber = (int)session.getAttribute("account_num");
		int pin = (int) session.getAttribute("pin");
		String emailid = (String)session.getAttribute("emailId");
		
		UserDao userDao = UserDaoHelp.userDao();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		if(accnum == accountNumber)
		{
			if(email.equalsIgnoreCase(emailid))
			{
				if(password==pin)
				{
					if(userDao.deleteAccount(accnum, email, password))
					{
						RequestDispatcher rd = request.getRequestDispatcher("deleteAccount.jsp");
						rd.include(request, response);
						writer.println("<center><h1>Account Deleted Successfully...!</h1></center>");
					}
					else
					{
						RequestDispatcher rd = request.getRequestDispatcher("deleteAccount.jsp");
						rd.include(request, response);
						writer.println("<center><h1>Account Deletion Failed...!</h1></center>");
					}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("deleteAccount.jsp");
					rd.include(request, response);
					writer.println("<center><h1>Invalid password</h1></center>");
				}
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("deleteAccount.jsp");
				rd.include(request, response);
				writer.println("<center><h1>Invalid emailid</h1></center>");
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("deleteAccount.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Invalid account number</h1></center>");
		}
	}
}
