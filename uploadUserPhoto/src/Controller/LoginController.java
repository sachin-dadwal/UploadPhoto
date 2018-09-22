package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDAO;
import DTO.userDTO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;  
	userDAO dao=new userDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String message="";
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		PrintWriter pw=response.getWriter();
		request.setAttribute("username", username);
		
		userDTO dto=new userDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		
		
		boolean res=dao.login(dto);
		
		if(res)
		{
			session = request.getSession(true);
			session.setAttribute("username", username);
		pw.println("Login Sucessfully");
		message="Login Sucessfully";
		}
		else
		{
			System.out.println("Login not sucessfully");
			message="Login Sucessfully";
		}
		//request.setAttribute("message", message);
		request.getRequestDispatcher("upload.jsp").forward(request, response);
		
					
	}

}
