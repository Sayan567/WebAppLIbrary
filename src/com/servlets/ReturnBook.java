package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.IssueBookBean;
import com.dao.BookDao;
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String callno=request.getParameter("bookid");
		String sstudentid=request.getParameter("studentid");
		int studentid=Integer.parseInt(sstudentid);
		
		int i=BookDao.returnBook(callno,studentid);
		if(i>0){
			request.getRequestDispatcher("returnbooksuccessful.html").include(request, response);
		}else{
			out.println("<h3>Sorry, unable to return book.</h3><p>We may have shortage of books. Kindly visit later.</p>");
		}
		
		out.close();
	}

}
