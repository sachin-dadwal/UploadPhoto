package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  HttpSession session=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(session!=null)
		{
			doPost(request, response);
		}
		else
		{
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String message="";
		
		request.getSession(false);
		session.invalidate();
		PrintWriter pw=response.getWriter();
		pw.println("logout sucessfully");
		message="logout sucessfully";
		request.setAttribute("message", message);
	request.getRequestDispatcher("login.html").forward(request, response);
	}
	
}
