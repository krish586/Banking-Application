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
import com.jsp.model.Statement;

@WebServlet("/changepasswordurl")
public class ChangePasswordController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int accnum = Integer.parseInt(request.getParameter("account"));
		String email = request.getParameter("email");
		int password = Integer.parseInt(request.getParameter("password"));
		int newpassword = Integer.parseInt(request.getParameter("new"));
		
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
					if(userDao.changePassword(accnum, email, password, newpassword))
					{
						RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
						rd.include(request, response);
						writer.println("<center><h1>Password Changed Successfully...!</h1></center>");
					}
					else
					{
						RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
						rd.include(request, response);
						writer.println("<center><h1>Changing Password Failed...!</h1></center>");
					}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
					rd.include(request, response);
					writer.println("<center><h1>Invalid password</h1></center>");
				}
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
				rd.include(request, response);
				writer.println("<center><h1>Invalid emailid</h1></center>");
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Invalid account number</h1></center>");
		}
	}
}
