package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BookBean;
import com.beans.IssueBookBean;
import com.dao.BookDao;
@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print(
				"<!DOCTYPE html>"
				+ "<html lang=\"en\">"
				+ "	<head>"
				+ "		<meta charset=\"UTF-8\" />"
				+ "		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />"
				+ "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
				+ "		<link rel=\"stylesheet\" href=\"css/bootstrap-grid.min.css\" />"
				+ "		<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />"
				+ "		<link rel=\"stylesheet\" href=\"css/styles.css\" />"
				+ "		<script defer src=\"js/bootstrap.min.js\"></script>"
				+ "		<title>View Issued Books</title>"
				+ "	</head>"
				+ "	<body>");
		
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
			out.print(
				  "		<div class=\"container-fluid\">"
				+ "			<div class=\"row pt-10\">"
				+ "<div class=\"col-md-12\">"
				+ "<h2>Viewing Issued Books</h2>"
				+ "</div>"
				+ "</div>"
				+ "<div class=\"row pt-5\">"
				+ "<div class=\"col-md-12\">"
				+ "<table class=\"table table-hover\">"
				+ "						<thead>"
				+ "							<tr>"
				+ "								<th scope=\"col\">Book ID</th>"
				+ "								<th scope=\"col\">Student ID</th>"
				+ "								<th scope=\"col\">Student Name</th>"
				+ "								<th scope=\"col\">Student Phone No.</th>"
				+ "								<th scope=\"col\">Issued Date</th>"
				+ "								<th scope=\"col\">Return Status</th>"
				+ "							</tr>"
				+ "						</thead>"
				+ "						<tbody>"
				+ ""
					);
		List<IssueBookBean> list=BookDao.viewIssuedBooks();
		
		for(IssueBookBean bean:list){
			out.println("<tr><th scope=\"row\">"+bean.getBookid()+"</th><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
		}
		out.print(
				"</tbody>"
				+"</table>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</body>"
				+ "</html>");		
		out.close();
	}
}
