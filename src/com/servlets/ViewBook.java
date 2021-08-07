package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit.BeepAction;

import com.beans.BookBean;
import com.beans.LibrarianBean;
import com.dao.BookDao;
import com.dao.LibrarianDao;
@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
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
				+ "		<title>View Books</title>"
				+ "	</head>"
				+ "	<body>");
		
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
			out.print(
				  "		<div class=\"container-fluid\">"
				+ "			<div class=\"row pt-10\">"
				+ "				<div class=\"col-md-12\">"
				+ "					<h2>All books</h2>"
				+ "				</div>"
				+ "			</div>"
				+ "			<div class=\"row pt-5\">"
				);
		
		List<BookBean> list=BookDao.view();
		
		for(BookBean bean:list){
			out.println(
			"<div class='col-md-3'>"
			+"<div class='book'>"
			+"<div class='book-image'>"
			+"		<img src='"+ bean.getImage() +"'/>"
			+"	</div>"
			+"	<div class='book-actions'>"
			+"		<h5 class='bookname'>"+bean.getName()+"</h5>"
			+"		<p class='bookid'><span>Book ID: </span>"+bean.getBookid()+"</p>"
			+"		<p class='author'><span>Author: </span>"+bean.getAuthor()+"</p>"
			+"		<p class='publisher'><span>Published By: </span>"+bean.getPublisher()+"</p>"
			+"		<p class='issued'><span>Issued: </span>"+bean.getIssued()+"</p>"
			+"		<a href='DeleteBook?bookid="+bean.getBookid()+ "' class='button button-secondary'>Delete Book</a>"
			+"	</div>"
			+"</div>"
			+"</div>"
		);
		}
		
		out.print(
				  "			</div>" 
				+ "		</div>"
				+ "	</body>"
				+ "</html>"
				);
		out.close();
	}
}
