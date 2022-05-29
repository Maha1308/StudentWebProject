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
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	int id=Integer.parseInt(request.getParameter("sid"));
	Connection scon=Dbconnect.getConnection();
	try
	{
		Statement st=scon.createStatement();
		String sql="Select * from student where sid="+id;
		ResultSet rt=st.executeQuery(sql);
		out.println("<!DOCTYPE html><head><title>Student Details</title></head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><th><sid></th><th>sname</th><th>spass</th><th>sfees</th></tr>");
		if(rt.next())
		{
			out.println("<tr>");
			out.println("<td>"+rt.getInt("sid")+"</td>");
			out.println("<td>"+rt.getString("sname")+"</td>");
			out.println("<td>"+rt.getString("spass")+"</td>");
			out.println("<td>"+rt.getFloat("sfees")+"</td>");
			out.println("</tr>");
			
		}
		
		else
		{
			out.println(rt.getString("id not exists"));
		}
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}

}
}
