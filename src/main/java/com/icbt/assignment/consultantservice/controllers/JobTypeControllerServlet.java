package com.icbt.assignment.consultantservice.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.JobType;
import com.icbt.assignment.consultantservice.services.CommonServices;
import com.icbt.assignment.consultantservice.services.JobType_Service;
import com.icbt.assignment.consultantservice.util.EntityValidator;
 
@WebServlet("/JobTypeControllerServlet")
public class JobTypeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/consultationservicedb_application")
	private DataSource dataSource;
    
    public JobTypeControllerServlet() {
        super();
         
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 String command = null;
	 command = request.getParameter("command");
	    if(command == null )
		{
			mainList(request,response);
		}
		else if(command.equals("SHOW-LIST") )
		{
			mainList(request,response);
		}
		else if(command.equals("SHOW-ADDDATA") )
		{
			showAddScreen(request,response);
		}
		else if(command.equals("SHOW-UPDATE") )
		{
			ShowEditScreen(request,response);
		}
		else
		{
			deleteInfo(request,response);
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String command =request.getParameter("command");
		
		if(command.equals("ADDDATA") )
		{
			addInfo(request,response);
		}
		if(command.equals("UPDATEDATA") )
		{
			updateInfo(request,response);
		}
		
		 
	}



	private void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			  	List<JobType> jobtype = JobType_Service.GetAll(dataSource);
			    request.setAttribute("JobType_lists", jobtype);
				request.setAttribute("exceptionerrorshow", "d-none");
				request.getRequestDispatcher("/job_type_list.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/job_type_list.jsp").forward(request, response);
			}
		  
		
	}

	private void showAddScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/add_job_type.jsp").forward(request, response);
		
	}
	
	private void addInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 
		String tableName ="job_type_specialization";
		String job_type_name = request.getParameter("job_type_name");
		
		try {
			
			 if (JobType_Service.CheckName(dataSource, job_type_name, null)) {
				 	String job_type_specialization_id = CommonServices.GetNumberFormat(dataSource, tableName);
				 	JobType jobType = new JobType(job_type_specialization_id,job_type_name);
					
					EntityValidator<JobType> validator = new EntityValidator<JobType>();
					String errors = validator.validate(jobType);
					
					if (!errors.isEmpty()) {
						request.setAttribute("JobType", jobType);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/add_job_type.jsp").forward(request, response);
					} else {
						JobType_Service.Add(dataSource, jobType);
						CommonServices.SetNumberFormat(dataSource, tableName);
						response.sendRedirect("JobTypeControllerServlet?command=SHOW-LIST");
					}
			} else {
				request.setAttribute("exceptionerror","Job Type Name already exists");
				request.setAttribute("exceptionerrorshow", "");
				showAddScreen(request,response);
			}
				
				
			 
			
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			showAddScreen(request,response);
		}
		
	}
	

	private void ShowEditScreen(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			String job_type_specialization_id = request.getParameter("id");
			JobType jobtype = JobType_Service.Get(dataSource, job_type_specialization_id);
			request.setAttribute("JobType", jobtype);
			request.getRequestDispatcher("/update_job_type.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/update_job_type.jsp").forward(request, response);

		}

		
	}
	
	private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job_type_name =request.getParameter("job_type_name");
		 
		String job_type_specialization_id = request.getParameter("job_type_specialization_id");
		JobType jobtype = new JobType(job_type_specialization_id,job_type_name);
		
		try {
			
			 if (JobType_Service.CheckName(dataSource, job_type_name, job_type_specialization_id)) {
				 	 	
					EntityValidator<JobType> validator = new EntityValidator<JobType>();
					String errors = validator.validate(jobtype);
					request.setAttribute("exceptionerrorshow", "d-none");
					if (!errors.isEmpty()) {
						request.setAttribute("JobType", jobtype);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/update_job_type.jsp").forward(request, response);
					} else {
						JobType_Service.Update(dataSource, jobtype);
 
						response.sendRedirect("JobTypeControllerServlet?command=SHOW-LIST");
					}
			} else {
				request.setAttribute("exceptionerror","Job Type Name already exists");
				request.setAttribute("exceptionerrorshow", "");
				request.setAttribute("JobType",jobtype);
				
				ShowEditScreen(request, response);
			}
				
				
			 
			
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			ShowEditScreen(request,response);
		}
		
		
	}
	
	private void deleteInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String job_type_specialization_id = request.getParameter("id");
		JobType_Service.Delete(dataSource, job_type_specialization_id);
		mainList(request, response);
		
	}

}
