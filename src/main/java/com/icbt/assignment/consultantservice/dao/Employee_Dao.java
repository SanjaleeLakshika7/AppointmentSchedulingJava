package com.icbt.assignment.consultantservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
import java.util.List;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.Employee;
import com.icbt.assignment.consultantservice.util.CustomException;

public class Employee_Dao {

	public static List<Employee> GetAll(DataSource datasource){
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		try {
			con = datasource.getConnection();
			sql ="SELECT employee_id, full_name, dob, nic, user_type, address, contact_no, email, password FROM Employee";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
					 
			   String employee_id = rset.getString("employee_id");
               String fullName = rset.getString("full_name");
               String dob = rset.getString("dob");
               String nic = rset.getString("nic");
               String userType = rset.getString("user_type");
               String address = rset.getString("address");
               String contactNo = rset.getString("contact_no");
               String email = rset.getString("email");
               String password = rset.getString("password");
               
               
                Employee employee = new Employee(employee_id, fullName,  dob, nic, userType, address, contactNo, email, password);

               
          
               employees.add(employee);
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return employees;
	}
	
	
	
	public static Employee Get(DataSource datasource,String employeeid){
		Employee employees = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		try {
			con = datasource.getConnection();
			sql ="SELECT employee.employee_id,consultants.consultant_id,consultants.job_type_specialization_id, consultants.country_specialization_id,job_type_specialization.job_type_name,country_specialization.country_name, full_name, dob, nic, user_type, address, contact_no, email, password FROM employee\r\n"
					+ "left join consultants on employee.employee_id = consultants.employee_id\r\n"
					+ "left join job_type_specialization on consultants.job_type_specialization_id = job_type_specialization.job_type_specialization_id\r\n"
					+ "left join country_specialization on consultants.country_specialization_id = country_specialization.country_specialization_id  where employee.employee_id =?";
			stmt = con.prepareStatement(sql);
			 stmt.setString(1, employeeid);
			rset = stmt.executeQuery();
			while(rset.next()) {
					 
			   String employee_id = rset.getString("employee_id");
               String fullName = rset.getString("full_name");
               String dob = rset.getString("dob");
               String nic = rset.getString("nic");
               String userType = rset.getString("user_type");
               String address = rset.getString("address");
               String contactNo = rset.getString("contact_no");
               String email = rset.getString("email");
               String password = rset.getString("password");
               String consultant_id = rset.getString("consultant_id");
               String job_type_name = rset.getString("job_type_name");
               String country_name = rset.getString("country_name");
               
               String country_specialization_id = rset.getString("country_specialization_id");
               String job_type_specialization_id = rset.getString("job_type_specialization_id");
               
               
               
               employees = new Employee(employee_id, fullName,  dob, nic, userType, address, contactNo, email, password, consultant_id,job_type_name,country_name,country_specialization_id,job_type_specialization_id);
              
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return employees;
	}
	
	public static int CheckName(DataSource datasource, String nic) {
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rset = null;
	    int returnval = 0;
	    
	    try {
	        con = datasource.getConnection();
	        String sql = "SELECT * FROM Employee WHERE nic = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, nic);
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
	
	public static void Add(DataSource datasource, Employee employee) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
		String sql = null;
	    
	    try {
	        con = datasource.getConnection();
	        sql = "INSERT INTO employee (employee_id, full_name, dob, nic, user_type, address, contact_no, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, employee.getEmployee_id());
            pstmt.setString(2, employee.getFullName());
            pstmt.setString(3, employee.getDob());  // Assuming dob is a java.util.Date
            pstmt.setString(4, employee.getNic());
            pstmt.setString(5, employee.getUserType());
            pstmt.setString(6, employee.getAddress());
            pstmt.setString(7, employee.getContactNo());
            pstmt.setString(8, employee.getEmail());
            pstmt.setString(9, employee.getPassword());
            pstmt.execute();
	        
	    } catch (Exception e) {
	        throw new CustomException(e.getMessage());
	    } finally {
	    	close(con,pstmt,null);
	    }
	     
	}
	
	
	public static int CheckUpdateName(DataSource datasource, String nic, String employee_id) {
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rset = null;
	    int returnval = 0;
	    
	    try {
	        con = datasource.getConnection();
	        String sql = "SELECT * FROM Employee WHERE nic = ? AND employee_id <> ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, nic);
	        stmt.setString(2, employee_id);
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
	
	public static void Update(DataSource datasource, Employee employee) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
		String sql = null;
	    
	    try {
	        con = datasource.getConnection();
	         sql = "UPDATE employee SET full_name=?, dob=?, nic=?, user_type=?, address=?, contact_no=?, email=?, password=? WHERE employee_id=?";
	        pstmt = con.prepareStatement(sql);
	        
            pstmt.setString(1, employee.getFullName());
            pstmt.setString(2, employee.getDob() );  // Assuming dob is a java.util.Date
            pstmt.setString(3, employee.getNic());
            pstmt.setString(4, employee.getUserType());
            pstmt.setString(5, employee.getAddress());
            pstmt.setString(6, employee.getContactNo());
            pstmt.setString(7, employee.getEmail());
            pstmt.setString(8, employee.getPassword());
            pstmt.setString(9, employee.getEmployee_id());
            pstmt.execute();
	        
	    } catch (Exception e) {
	        throw new CustomException(e.getMessage());
	    } finally {
	    	close(con,pstmt,null);
	    }
	     
	}
	
	public static void Delete(DataSource dataSource, String employee_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "DELETE FROM  employee  WHERE employee_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee_id);
		 	
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
		
	}
	
	
	public static int VerifyLogin(DataSource datasource, String email , String password) {
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rset = null;
	    int returnval = 0;
	    
	    try {
	        con = datasource.getConnection();
	        String sql = "SELECT * FROM Employee WHERE email = ? AND password = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, email);
	        stmt.setString(2, password);
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
	
	public static Employee GetByEmail(DataSource datasource,String emailaddres){
		Employee employees = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		try {
			con = datasource.getConnection();
			sql ="SELECT employee.employee_id,consultants.consultant_id,consultants.job_type_specialization_id, consultants.country_specialization_id,job_type_specialization.job_type_name,country_specialization.country_name, full_name, dob, nic, user_type, address, contact_no, email, password FROM employee\r\n"
					+ "left join consultants on employee.employee_id = consultants.employee_id\r\n"
					+ "left join job_type_specialization on consultants.job_type_specialization_id = job_type_specialization.job_type_specialization_id\r\n"
					+ "left join country_specialization on consultants.country_specialization_id = country_specialization.country_specialization_id  where email =?";
			stmt = con.prepareStatement(sql);
			 stmt.setString(1, emailaddres);
			rset = stmt.executeQuery();
			while(rset.next()) {
					 
			   String employee_id = rset.getString("employee_id");
               String fullName = rset.getString("full_name");
               String dob = rset.getString("dob");
               String nic = rset.getString("nic");
               String userType = rset.getString("user_type");
               String address = rset.getString("address");
               String contactNo = rset.getString("contact_no");
               String email = rset.getString("email");
               String password = rset.getString("password");
               
               String consultant_id = rset.getString("consultant_id");
               String job_type_name = rset.getString("job_type_name");
               String country_name = rset.getString("country_name");
               
               String country_specialization_id = rset.getString("country_specialization_id");
               String job_type_specialization_id = rset.getString("job_type_specialization_id");
               
               employees = new Employee(employee_id, fullName,  dob, nic, userType, address, contactNo, email, password, consultant_id,job_type_name,country_name,country_specialization_id,job_type_specialization_id);
                
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return employees;
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
