package com.icbt.assignment.consultantservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.JobType;
import com.icbt.assignment.consultantservice.util.CustomException;

public class JobType_Dao {
	
	public static List<JobType> GetAll(DataSource datasource){
		List<JobType> jobtypes = new ArrayList<JobType>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		try {
			con = datasource.getConnection();
			sql ="select job_type_specialization_id,job_type_name from job_type_specialization";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				String job_type_specialization_id = rset.getString("job_type_specialization_id");
				String job_type_name =rset.getString("job_type_name");
				
				JobType jobtype = new JobType(job_type_specialization_id, job_type_name);
				jobtypes.add(jobtype);
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return jobtypes;
	}
	
	public static JobType Get(DataSource datasource, String job_type_id) {
	    JobType jobtypes = null;
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rset = null;
	    String sql = null;
	    try {
	        con = datasource.getConnection();
	        sql = "select job_type_specialization_id,job_type_name from job_type_specialization where job_type_specialization_id =?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, job_type_id);
	        rset = stmt.executeQuery();
	        while (rset.next()) {
	            String job_type_specialization_id = rset.getString("job_type_specialization_id");
	            String job_type_name = rset.getString("job_type_name");
	            jobtypes = new JobType(job_type_specialization_id, job_type_name);
	        }
	    } catch (Exception e) {
	    	  throw new CustomException(e.getMessage());
	    } finally {
	        close(con, stmt, rset);
	    }
	    return jobtypes;
	}

	
	public static int CheckName(DataSource datasource, String job_type_name) {
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rset = null;
	    int returnval = 0;
	    
	    try {
	        con = datasource.getConnection();
	        String sql = "SELECT * FROM job_type_specialization WHERE job_type_name = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, job_type_name);
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

	
	public static void Add(DataSource dataSource, JobType JobType) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into job_type_specialization (job_type_specialization_id,job_type_name) values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, JobType.getJob_type_specialization_id());
			pstmt.setString(2, JobType.getJob_type_name());
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
	 
	public static void Update(DataSource dataSource, JobType JobType) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "UPDATE  job_type_specialization SET job_type_name=? WHERE job_type_specialization_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, JobType.getJob_type_name());
			pstmt.setString(2, JobType.getJob_type_specialization_id());
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
 
	public static int CheckUpdateName(DataSource datasource, String job_type_name, String job_type_specialization_id) {

	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rset = null;
	    String sql = null;
	    int returnval = 0;
	    try {
	        con = datasource.getConnection();

	        sql = "SELECT * FROM job_type_specialization WHERE job_type_name = ? AND job_type_specialization_id <> ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, job_type_name);
	        stmt.setString(2, job_type_specialization_id); // Use setString for String parameters

	        rset = stmt.executeQuery(); // Don't pass sql as an argument here
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

	
	public static void Delete(DataSource dataSource, String job_type_specialization_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "DELETE FROM  job_type_specialization  WHERE job_type_specialization_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, job_type_specialization_id);
		 	
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
