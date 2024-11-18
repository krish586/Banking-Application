package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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

@WebServlet("/crediturl")
public class CreditController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accnum = Integer.parseInt(request.getParameter("accountnumber"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String typeOfAccount = request.getParameter("toa");
		int password = Integer.parseInt(request.getParameter("pin"));
		String receipt = request.getParameter("receipt");
		
		HttpSession session = request.getSession();
		session.setAttribute("recp", receipt);
		int accountNumber = (int)session.getAttribute("account_num");
		double bankbalance = (double)session.getAttribute("balance_amount");
		int pin = (int) session.getAttribute("pin");
		String toa = (String)session.getAttribute("typeofacc");
		String name = (String)session.getAttribute("name");
		
		UserDao userDao = UserDaoHelp.userDao();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		if(accnum == accountNumber)
		{
			if(amount>0)
			{
				if(amount<bankbalance)
				{
					bankbalance = bankbalance + amount;
					if(password == pin)
					{
						Statement statement = new Statement();
						statement.setTotalBalance(bankbalance);
						statement.setTransactionAmount(amount);
						statement.setTransactionDate(Date.valueOf(LocalDate.now()));
						statement.setTransactionTime(Time.valueOf(LocalTime.now()));
						statement.setTransactionType("Credit");
						statement.setUserAccountNumber(accountNumber);
						statement.setUserName(name);
						if(userDao.debitAmount(accountNumber, password, statement))
						{
							session.setAttribute("Database_amount", bankbalance);
							RequestDispatcher rd = request.getRequestDispatcher("credit.jsp");
							rd.include(request, response);
							writer.println("<center><h1>Amount Debited Successfully...!</h1></center>");
						}
						else
						{
							RequestDispatcher rd = request.getRequestDispatcher("credit.jsp");
							rd.include(request, response);
							writer.println("<center><h1>Transaction Failed...!</h1></center>");
						}
					}
					else
					{
						RequestDispatcher rd = request.getRequestDispatcher("credit.jsp");
						rd.include(request, response);
						writer.println("<center><h1>Invalid password</h1></center>");
					}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("credit.jsp");
					rd.include(request, response);
					writer.println("<center><h1>Insuffient balance</h1></center>");
				}
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("credit.jsp");
				rd.include(request, response);
				writer.println("<center><h1>Invalid amount enter valid amount</h1></center>");
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("credit.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Invalid account number</h1></center>");
		}
	}
}