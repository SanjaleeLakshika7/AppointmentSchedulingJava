package com.icbt.assignment.consultantservice.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.dao.JobType_Dao;
import com.icbt.assignment.consultantservice.entities.JobType;

public class JobType_Service {
	
	public static List<JobType> GetAll(DataSource datasource){
		return JobType_Dao.GetAll(datasource);
	}
	
	public static JobType Get(DataSource datasource,String job_type_specialization_id){
		return JobType_Dao.Get(datasource,job_type_specialization_id);
	}
	
	public static boolean CheckName(DataSource datasource , String job_type_name, String job_type_specialization_id) {
		int CheckInfo = 0;
		if(job_type_specialization_id == null || job_type_specialization_id.isEmpty() || job_type_specialization_id.trim().isEmpty()) {
			CheckInfo = JobType_Dao.CheckName(datasource, job_type_name);
		}
		else {
			CheckInfo = JobType_Dao.CheckUpdateName(datasource, job_type_specialization_id, job_type_name);
		}
		
		if(CheckInfo == 0)
		{
			return true;
			
		}else {
			return false;
		}
		
		
	}
	
	public static void Add(DataSource datasource, JobType country) {
		JobType_Dao.Add(datasource, country);
	}
	
	public static void Update(DataSource datasource, JobType country) {
		JobType_Dao.Update(datasource, country);
	}
	
	public static void Delete(DataSource dataSource, String job_type_specialization_id) {
		JobType_Dao.Delete(dataSource, job_type_specialization_id);
	
	}
	
	 
}
