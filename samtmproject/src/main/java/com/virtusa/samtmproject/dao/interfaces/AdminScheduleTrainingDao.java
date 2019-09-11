package com.virtusa.samtmproject.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.samtproject.models.AdminScheduleTraining;

public interface AdminScheduleTrainingDao {
	boolean addAdminScheduleTraining(AdminScheduleTraining adminScheduleTraining) throws SQLException; //insert
	List<AdminScheduleTraining> getAllVehicles() throws SQLException; //select all


}
