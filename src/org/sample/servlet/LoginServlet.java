/*
 * 
 * 
 * Sample Servlet to respond on the post call
 * on the index.jsp and show results in the console
 * 
 * Author					Modified
 * Hilay Khatri				05-31-2012
 * 
 * 
 */

package org.sample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.servlet.service.LoginService;
import org.sample.servlet.service.MongoApp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userID, password, msg;
		
		userID = request.getParameter("userID");
		password = request.getParameter("password");
		
		
		LoginService ls = new LoginService();
		
		MongoApp ma = new MongoApp();
		ma.insert(userID, password);
		msg = ma.display(userID);
		
		System.out.println(msg);
		
		boolean result = ls.authencticate(userID, password);
		
		 	if(result)
		 	{
		 		response.sendRedirect("success.jsp");
		 	return;
		 	}
		 	
		 	else
		 	{
		 		response.sendRedirect("index.jsp");
		 	return;	
		 	}
		 
		 	
	}

}
