package com.icbt.assignment.consultantservice.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.dao.Employee_Dao;
 
import com.icbt.assignment.consultantservice.entities.Employee;
 

public class Employee_Service {
	
	public static List<Employee> GetAll(DataSource datasource){
		return Employee_Dao.GetAll(datasource);
	}
	
	public static Employee Get(DataSource datasource, String employee_id){
		return Employee_Dao.Get(datasource,employee_id);
	}
	
	public static boolean CheckName(DataSource datasource , String nic, String employee_id) {
		int CheckInfo = 0;
		if(employee_id == null || employee_id.isEmpty() || employee_id.trim().isEmpty()) {
			CheckInfo = Employee_Dao.CheckName(datasource, nic);
		}
		else {
			CheckInfo = Employee_Dao.CheckUpdateName(datasource,nic, employee_id);
		}
		
		if(CheckInfo == 0)
		{
			return true;
			
		}else {
			return false;
		}
		
		
	}
	
	public static void Add(DataSource datasource, Employee employee) {
		Employee_Dao.Add(datasource, employee);
	}
	
	public static void Update(DataSource datasource, Employee employee) {
		Employee_Dao.Update(datasource, employee);
	}
	
	public static void Delete(DataSource dataSource, String employee_id) {
		Employee_Dao.Delete(dataSource, employee_id);
	
	}
	
	public static boolean VerifyLogin(DataSource datasource, String email , String password) {
	
		int checkCredinatial = Employee_Dao.VerifyLogin(datasource, email,password);
		
		if(checkCredinatial == 0)
		{
			return false;
			
		}else {
			return true;
		}
	
	}
	
	public static Employee GetByEmail(DataSource datasource,String emailaddres){
		return Employee_Dao.GetByEmail(datasource,emailaddres);
	
	}
	

	
}
