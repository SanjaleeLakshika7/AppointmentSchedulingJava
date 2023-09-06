package com.icbt.assignment.consultantservice.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.NumberFomart;

public class CommonDao {

	public static NumberFomart GetNumberFormat(DataSource dataSource, String tableName) {
	NumberFomart numberFormat = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rset  = null;
	String sql = null;
	
	try {
		con = dataSource.getConnection();
		sql= "select * from number_primary_key_generator where table_name = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, tableName);
		rset= stmt.executeQuery();
		
		while(rset.next()) {
			String table_name = rset.getString("table_name");
			String prefix = rset.getString("prefix");
			int number_Part = rset.getInt("number_Part");
			numberFormat = new NumberFomart(table_name,prefix,number_Part);
			
		}	
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
		close(con,stmt,null);
	}
	
	return numberFormat;
}

public static int SetNumberFormat(DataSource dataSource, String table_name, int number_Part ) {
		
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;

	try {
		con = dataSource.getConnection();
		 sql = "UPDATE number_primary_key_generator SET number_Part=? WHERE table_name=?";
		 pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, number_Part);
		pstmt.setString(2, table_name);
	
		pstmt.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(con, pstmt, null);
	}
	
	return number_Part	;
}
	

private static void close(Connection con,Statement stmt,ResultSet rset) {
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
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
