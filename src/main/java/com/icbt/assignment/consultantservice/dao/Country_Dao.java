package com.icbt.assignment.consultantservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.Country_Specialization;
import com.icbt.assignment.consultantservice.util.CustomException;

public class Country_Dao {
	
	public static List<Country_Specialization> GetAll(DataSource datasource){
		List<Country_Specialization> countries = new ArrayList<Country_Specialization>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		try {
			con = datasource.getConnection();
			sql ="select country_specialization_id,country_name from country_specialization";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				String country_specialization_id = rset.getString("country_specialization_id");
				String country_name =rset.getString("country_name");
				
				Country_Specialization country_Specialization = new Country_Specialization(country_specialization_id, country_name);
				countries.add(country_Specialization);
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return countries;
	}
	
	public static Country_Specialization Get(DataSource datasource, String country_specialization_id) {
	    Country_Specialization countries = null;
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rset = null;
	    String sql = null;
	    try {
	        con = datasource.getConnection();
	        sql = "select country_specialization_id,country_name from country_specialization where country_specialization_id =?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, country_specialization_id);
	        rset = stmt.executeQuery();
	        while (rset.next()) {
	            String country_specializationid = rset.getString("country_specialization_id");
	            String country_name = rset.getString("country_name");
	            countries = new Country_Specialization(country_specializationid, country_name);
	        }
	    } catch (Exception e) {
	    	  throw new CustomException(e.getMessage());
	    } finally {
	        close(con, stmt, rset);
	    }
	    return countries;
	}

	
	public static int CheckCountryName(DataSource datasource, String country_name) {
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rset = null;
	    int returnval = 0;
	    
	    try {
	        con = datasource.getConnection();
	        String sql = "SELECT * FROM country_specialization WHERE country_name = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, country_name);
	        rset = stmt.executeQuery(); // Execute the prepared statement
	        
	        if (rset.next()) {
	            returnval = 1;
	        } else {
	            returnval = 0;
	        }
	    } catch (Exception e) {
	        throw new CustomException(e.getMessage());
	    } finally {
	        close(con, stmt, rset);
	    }
	    return returnval;
	}

	
	public static void Add(DataSource dataSource, Country_Specialization country_Specialization) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into country_specialization (country_specialization_id,country_name) values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, country_Specialization.getCountry_specialization_id());
			pstmt.setString(2, country_Specialization.getCountry_name());
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
	 
	public static void Update(DataSource dataSource, Country_Specialization country_Specialization) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "UPDATE  country_specialization SET country_name=? WHERE country_specialization_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, country_Specialization.getCountry_name());
			pstmt.setString(2, country_Specialization.getCountry_specialization_id());
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
 
	public static int CheckUpdateCountryName(DataSource datasource,String country_name,String country_specialization_id){
		 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		int returnval= 0;
		try {
			con = datasource.getConnection();
		 
		     sql = "SELECT * FROM country_specialization WHERE country_name = ? AND country_specialization_id <>?";
		      
			stmt = con.prepareStatement(sql);
			stmt.setString(1, country_name);
			stmt.setNString(2, country_specialization_id);
			rset = stmt.executeQuery(sql);
			if(rset.next()) {
				returnval =1;
			}
			else {
				returnval =0;
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return returnval;
	}
	
	public static void Delete(DataSource dataSource, String country_specialization_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "DELETE FROM  country_specialization  WHERE country_specialization_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, country_specialization_id);
		 	
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
		
	}

	private static void close(Connection con, Statement stmt, ResultSet rset) {
		 try {
			 	if(rset != null)
				{
					rset.close();
				}
				if(stmt != null)
				{
					stmt.close();
				}
				
				if(con != null)
				{
					con.close();
				}
		 }
		 catch (SQLException e) {
			throw new CustomException(e.getMessage());
		}
	}

	
}
