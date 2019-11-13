package com.revature.gradingsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.gradingsystem.controller.ResultController;

public class StudentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get Input
				String regNo = request.getParameter("regno");
				System.out.println("REG-NO :"+regNo);
				
				int regno = Integer.parseInt(regNo);
				
				String json = new ResultController().studentResult(regno);
					
				//write the json as a response
				PrintWriter out = response.getWriter();
				out.write(json);
				out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
