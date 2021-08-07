package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BookBean;
import com.dao.BookDao;
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		String bookid=request.getParameter("bookid");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String image = request.getParameter("image");
		
		
		BookBean bean=new BookBean(bookid,name,author,publisher, 0, image);
		int i=BookDao.save(bean);
		if(i>0){
			request.getRequestDispatcher("bookadditionsuccessful.html").include(request, response);
		}
	
	
		out.close();
	}

}
