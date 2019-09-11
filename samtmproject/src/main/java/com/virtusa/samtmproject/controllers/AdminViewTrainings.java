package com.virtusa.samtmproject.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalclaim.insurance.dao.implementations.VehicleImpl;
import com.globalclaim.insurance.dao.interfaces.VehicleDao;
import com.globalclaim.insurance.models.Vehicle;
import com.google.gson.Gson;
import com.virtusa.samtmproject.dao.implementations.AdminScheduleTrainingImpl;
import com.virtusa.samtmproject.dao.interfaces.AdminScheduleTrainingDao;

/**
 * Servlet implementation class AdminViewTrainings
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AdminViewTrainings" })
public class AdminViewTrainings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewTrainings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// TODO Auto-generated method stub
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				AdminScheduleTrainingDao vehicleDao=new AdminScheduleTrainingImpl();
				try
				{
					List<Admin> vehicleList=vehicleDao.getAllVehicles();
				//converting java object to javascript object(json)
					response.getWriter().write(new Gson().toJson(vehicleList));

				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				
			}
	}

}
