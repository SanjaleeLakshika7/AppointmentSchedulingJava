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

import com.icbt.assignment.consultantservice.entities.Employee;

import com.icbt.assignment.consultantservice.services.CommonServices;
import com.icbt.assignment.consultantservice.services.Employee_Service;

import com.icbt.assignment.consultantservice.util.EntityValidator;
 
 

 
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/consultationservicedb_application")
	private DataSource dataSource;
   
    public EmployeeControllerServlet() {
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
			  	List<Employee> employee = Employee_Service.GetAll(dataSource);
			    request.setAttribute("employee", employee);
				request.setAttribute("exceptionerrorshow", "d-none");
				request.getRequestDispatcher("/employee_list.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/employee_list.jsp").forward(request, response);
			}
		  
		
	}
	
	private void showAddScreen(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/add_employee.jsp").forward(request, response);
	}
	
	

	private void addInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tableName ="employee";
		String full_name = request.getParameter("full_name");
		String dob  = request.getParameter("dob");
		String nic = request.getParameter("nic");
	 	 
	 	
		
		try {
			
			 if (Employee_Service.CheckName(dataSource, nic, null)) {
				 	String employee_id = CommonServices.GetNumberFormat(dataSource, tableName);
				 	 
				 	
				 	
				 	String user_type = request.getParameter("user_type");
				 	String address = request.getParameter("address");
				 	String contact_no = request.getParameter("contact_no");
				 	String email = request.getParameter("email");
				 	String password = request.getParameter("password");
				 	
				 	
				 	Employee employee = new Employee(employee_id, full_name,dob, nic, user_type, address, contact_no, email, password);
					EntityValidator<Employee> validator = new EntityValidator<Employee>();
					String errors = validator.validate(employee);
					
					if (!errors.isEmpty()) {
						request.setAttribute("employee", employee);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/add_employee.jsp").forward(request, response);
					} else {
						Employee_Service.Add(dataSource, employee);
						CommonServices.SetNumberFormat(dataSource, tableName);
						response.sendRedirect("EmployeeControllerServlet?command=SHOW-LIST");
					}
			} else {
				request.setAttribute("exceptionerror","NIC already exists");
				request.setAttribute("exceptionerrorshow", "");
				showAddScreen(request,response);
			}
				
				
			 
			
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			showAddScreen(request,response);
		}
		
	}
	
	
	
	private void ShowEditScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String employee_id = request.getParameter("id");
			Employee employee = Employee_Service.Get(dataSource, employee_id);
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("/update_employee.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/update_employee.jsp").forward(request, response);

		}
		
	}
	
	private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String nic = request.getParameter("nic");
		
		String employee_id = request.getParameter("employee_id");
	 	 
		try {
			
			 if (Employee_Service.CheckName(dataSource, "1", employee_id)) {
				 	
				 	
				 	String full_name = request.getParameter("full_name");
					String dob  = request.getParameter("dob");
				 	String user_type = request.getParameter("user_type");
				 	String address = request.getParameter("address");
				 	String contact_no = request.getParameter("contact_no");
				 	String email = request.getParameter("email");
				 	String password = request.getParameter("password");
				 	
				 	
				 	Employee employee = new Employee(employee_id, full_name,dob, nic, user_type, address, contact_no, email, password);
					EntityValidator<Employee> validator = new EntityValidator<Employee>();
					String errors = validator.validate(employee);
					
					if (!errors.isEmpty()) {
						request.setAttribute("employee", employee);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/update_employee.jsp").forward(request, response);
					} else {
						Employee_Service.Update(dataSource, employee);
						 
						response.sendRedirect("EmployeeControllerServlet?command=SHOW-LIST");
					}
			} else {
				request.setAttribute("exceptionerror","NIC already exists");
				request.setAttribute("exceptionerrorshow", "");
				showAddScreen(request,response);
			}
				
				
			 
			
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			showAddScreen(request,response);
		}
		
	}
	
	private void deleteInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employee_id = request.getParameter("id");
		Employee_Service.Delete(dataSource, employee_id);
		mainList(request, response);
		
	}

	


}
