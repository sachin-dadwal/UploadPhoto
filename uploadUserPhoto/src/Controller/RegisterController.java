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
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   userDAO dao=new userDAO();
   HttpSession session=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(session!=null)
		{
		
		doPost(request, response);
		}
		else
		{
			request.getRequestDispatcher("login.html");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getSession(false);
		Integer userid=Integer.parseInt(request.getParameter("userid"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		Integer mobile=Integer.parseInt(request.getParameter("mobile"));
		String address=request.getParameter("address");
		System.out.println(mobile);
		userDTO dto=new userDTO();
		dto.setUserid(userid);
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setEmail(email);
		dto.setMobile(mobile);
		dto.setAddress(address);
	
		boolean res=dao.insert(dto);
		System.out.println(res);
		if(res)
		{
		session.setAttribute("userid", userid);
		pw.println("User register sucessfully");	
		}
		else
		{
			pw.println("User not registred sucessfully");
		}
		
		request.getRequestDispatcher("upload.jsp").forward(request, response);
	
	}

}
