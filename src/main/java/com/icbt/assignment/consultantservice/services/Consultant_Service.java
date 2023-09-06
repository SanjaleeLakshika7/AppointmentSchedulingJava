package com.icbt.assignment.consultantservice.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.dao.Consultants_Dao;
import com.icbt.assignment.consultantservice.entities.Consultants;

public class Consultant_Service {
	
	public static List<Consultants> GetAll(DataSource datasource){
		return Consultants_Dao.GetAll(datasource);
	}
	
	public static void Add(DataSource datasource, Consultants consultants) {
		Consultants_Dao.Add(datasource, consultants);
	}
	

	
	public static void Delete(DataSource dataSource, String consultant_id) {
		Consultants_Dao.Delete(dataSource, consultant_id);
	
	}
}
