package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.userDTO;

public class userDAO
{
	Connection con=null;
	PreparedStatement pstmt=null;
	public boolean insert(userDTO dto)
	{
		boolean res=false;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "tiger");
			//String Query=
			pstmt=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pstmt.setInt(1,dto.getUserid());
			pstmt.setString(2,dto.getUsername());
			pstmt.setString(3,dto.getPassword());
			pstmt.setString(4,dto.getEmail());
			pstmt.setInt(5,dto.getMobile());
			pstmt.setString(6,dto.getAddress());
			
			int nori=pstmt.executeUpdate();
			if(nori==1)
			{
				res=true;
				System.out.println("registred sucessfully");
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
		
			e.printStackTrace();
		}
		
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		if(pstmt!=null)
		{
			try {
				pstmt.close();
			} catch (SQLException e) 
			{
			
				e.printStackTrace();
			}
		}
		
		
		return res;
		
	}

	public boolean login(userDTO dto)
	{
		boolean res=false;
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","tiger");
			pstmt=con.prepareStatement("select * from user where username=? and password=?");
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Login sucessfull");
				res=true;		
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
		if(con!=null)
		{
			try
			{
				con.close();
			} catch (SQLException e) 
			{
			
				e.printStackTrace();
			}
		}
		if(pstmt!=null)
		{
			try 
			{
				pstmt.close();
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
		return res;
		
	}


}

