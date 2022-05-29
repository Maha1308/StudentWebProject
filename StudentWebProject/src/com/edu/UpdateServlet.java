package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("type/html");
	PrintWriter out= response.getWriter();
	String n= request.getParameter("sname");
	int id=Integer.parseInt(request.getParameter("sid"));
	try {
		Connection conn=Dbconnect.getConnection();
		Statement st= conn.createStatement();
		st=conn.createStatement();
		String sql="select * from student where sid="+id;
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
			String up="update student set sname='"+n+"' where sid="+id;
			int i=st.executeUpdate(up);
			if(i>0)
			{
				out.println("update sucessfully");
			}
			
		}
			else 
			{
				out.println("id is not exists");
			}
		}catch(Exception e)
	{
			e.printStackTrace();
	}
	
	
	
	
	
	}

}
