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

import com.icbt.assignment.consultantservice.entities.Consultants;
import com.icbt.assignment.consultantservice.entities.Country_Specialization;
import com.icbt.assignment.consultantservice.entities.Employee;
import com.icbt.assignment.consultantservice.entities.JobType;
import com.icbt.assignment.consultantservice.services.CommonServices;
import com.icbt.assignment.consultantservice.services.Consultant_Service;
import com.icbt.assignment.consultantservice.services.Country_Service;
import com.icbt.assignment.consultantservice.services.Employee_Service;
import com.icbt.assignment.consultantservice.services.JobType_Service;
import com.icbt.assignment.consultantservice.util.EntityValidator;
 


@WebServlet("/ConsultantControllerServlet")
public class ConsultantControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/consultationservicedb_application")
	private DataSource dataSource;
 
    public ConsultantControllerServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		 
	
	}
	
	private void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			  	List<Consultants> consultant = Consultant_Service.GetAll(dataSource);
			    request.setAttribute("Consultant_lists", consultant);
				request.setAttribute("exceptionerrorshow", "d-none");
				request.getRequestDispatcher("/consultant_list.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/consultant_list.jsp").forward(request, response);
			}
		  
		
	}
	
	private void showAddScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		List<Country_Specialization> Country_SpecializationDrp =  Country_Service.GetAll(dataSource);
		request.setAttribute("Country_SpecializationDrp", Country_SpecializationDrp);
		
		List<JobType> jobTypes =  JobType_Service.GetAll(dataSource);
		request.setAttribute("jobTypesDrp", jobTypes);
		
		List<Employee> employees =  Employee_Service.GetAll(dataSource);
		request.setAttribute("employeesDrp", employees);
		
		
		request.getRequestDispatcher("/add_consultant.jsp").forward(request, response);
	}catch (Exception e) {
		request.setAttribute("exceptionerror", e.toString());
		request.setAttribute("exceptionerrorshow", "");
		request.getRequestDispatcher("/add_consultant.jsp").forward(request, response);
	}
		
	}
	
	private void addInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 
		String tableName ="consultants";
		
		String employee_id = request.getParameter("employee_id");
		String job_type_specialization_id = request.getParameter("job_type_specialization_id");
		String country_specialization_id = request.getParameter("country_specialization_id");
		try {
			
		 
				 	String consultant_id = CommonServices.GetNumberFormat(dataSource, tableName);
					Consultants consultants = new Consultants(consultant_id,employee_id,job_type_specialization_id,country_specialization_id);
					
					EntityValidator<Consultants> validator = new EntityValidator<Consultants>();
					String errors = validator.validate(consultants);
					
					if (!errors.isEmpty()) {
						request.setAttribute("Consultants", consultants);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/add_consultant.jsp").forward(request, response);
					} else {
						Consultant_Service.Add(dataSource, consultants);
						CommonServices.SetNumberFormat(dataSource, tableName);
						response.sendRedirect("ConsultantControllerServlet?command=SHOW-LIST");
					}
			 
				
				
			 
			
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			showAddScreen(request,response);
		}
		
	}
	
	
	private void deleteInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String country_specialization_id = request.getParameter("id");
		Consultant_Service.Delete(dataSource, country_specialization_id);
		mainList(request, response);
		
	}

}
