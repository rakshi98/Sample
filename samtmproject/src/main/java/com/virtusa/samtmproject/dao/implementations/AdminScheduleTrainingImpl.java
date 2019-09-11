package com.virtusa.samtmproject.dao.implementations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;


import com.virtusa.samtmproject.dao.interfaces.AdminScheduleTrainingDao;
import com.virtusa.samtmproject.helpers.OracleHelper;
import com.virtusa.samtproject.models.AdminScheduleTraining;

public class AdminScheduleTrainingImpl implements AdminScheduleTrainingDao{
	
	private Connection conn;
	private CallableStatement callable;
	private int result;
	private boolean status;
	
	private ResourceBundle rb;
	private Statement statment;
	private ResultSet resultSet;
	
	//instance block
	{
		rb=ResourceBundle.getBundle("db");
	}
	
	

	@Override
	public boolean addAdminScheduleTraining(AdminScheduleTraining adminScheduleTraining) throws SQLException {
		// TODO Auto-generated method stub
		
				try{
					
					conn=OracleHelper.getConnection();
					conn.setAutoCommit(false);
					callable=conn.prepareCall("{call scheduleTraining(?,?,?,?,?,?)}");
					callable.setString(1, adminScheduleTraining.getTrainingId());
					callable.setString(2, adminScheduleTraining.getTrainingName());
					callable.setString(3, adminScheduleTraining.getDomain());
					callable.setDate(4,Date.valueOf(adminScheduleTraining.getStartDate()));
					callable.setDate(5, Date.valueOf((adminScheduleTraining).getEndDate()));
					callable.setString(6, adminScheduleTraining.getVenue());
				
					
					result = callable.executeUpdate();
					if(result>0)
						status=true;
					
					conn.commit();
				}
				catch(SQLException e){
					conn.rollback();
				}
				finally{
					conn.close();
				}
				return status;	}

	@Override
	public List<AdminScheduleTraining> getAllVehicles() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
