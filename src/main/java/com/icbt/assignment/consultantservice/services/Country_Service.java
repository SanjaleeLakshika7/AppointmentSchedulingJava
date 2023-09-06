package com.icbt.assignment.consultantservice.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.dao.Country_Dao;
import com.icbt.assignment.consultantservice.entities.Country_Specialization;

public class Country_Service {
	
	public static List<Country_Specialization> GetAll(DataSource datasource){
		return Country_Dao.GetAll(datasource);
	}
	
	public static Country_Specialization Get(DataSource datasource,String country_specialization_id){
		return Country_Dao.Get(datasource,country_specialization_id);
	}
	
	public static boolean CheckCountryName(DataSource datasource , String Country_name, String Country_specialization_id) {
		int CheckInfo = 0;
		if(Country_specialization_id == null || Country_specialization_id.isEmpty() || Country_specialization_id.trim().isEmpty()) {
			CheckInfo = Country_Dao.CheckCountryName(datasource, Country_name);
		}
		else {
			CheckInfo = Country_Dao.CheckUpdateCountryName(datasource, Country_specialization_id, Country_name);
		}
		
		if(CheckInfo == 0)
		{
			return true;
			
		}else {
			return false;
		}
		
		
	}
	
	public static void Add(DataSource datasource, Country_Specialization country) {
		Country_Dao.Add(datasource, country);
	}
	
	public static void Update(DataSource datasource, Country_Specialization country) {
		Country_Dao.Update(datasource, country);
	}
	
	public static void Delete(DataSource dataSource, String country_specialization_id) {
		Country_Dao.Delete(dataSource, country_specialization_id);
	
	}
	
	 
}
