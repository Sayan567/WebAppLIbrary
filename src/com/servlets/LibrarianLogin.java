package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LibrarianDao;
@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		if(LibrarianDao.authenticate(email, password)){
			
			HttpSession session=request.getSession();
			session.setAttribute("email",email);
			request.getRequestDispatcher("homelibrarian.html").include(request, response);
		}
		else{
			
			out.println("<h3>Username or password error</h3>");
		}
		
		out.close();
	}

}
