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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	int id=Integer.parseInt(request.getParameter("sid"));
	try
	{
		Connection scon=Dbconnect.getConnection();
		Statement st=scon.createStatement();
		String del="delete from student where sid="+id;
		 int i = st.executeUpdate(del);
	
	if(i>0)
	
	{
		out.println("record is delete");
	}
	else
	{
		out.println("record not exists");
	}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

