package com.icbt.assignment.consultantservice.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.Employee;
import com.icbt.assignment.consultantservice.services.Employee_Service;


@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/consultationservicedb_application")
	private DataSource dataSource;
	
    public LoginControllerServlet() {
        super();
  
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginAuthentication(request,response);
		
	}
	private void LoginAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		try {
			if (Employee_Service.VerifyLogin(dataSource, email, password)) {
				Employee employee = Employee_Service.GetByEmail(dataSource, email);
				
				session.setAttribute("employee_id", employee.getEmployee_id());
				session.setAttribute("full_name", employee.getFullName());
				session.setAttribute("user_type", employee.getUserType());
				session.setAttribute("email", employee.getEmail());
				session.setAttribute("contact_no", employee.getContactNo());
				session.setAttribute("password", employee.getPassword());
				
				
			 
				
				response.sendRedirect("index.jsp");
				
				if(employee.getUserType() == "admin") {
					session.setAttribute("showadmin", "show");
					session.setAttribute("showcon", "d-none");
				}
				if(employee.getUserType() == "normal") {
					session.setAttribute("showadmin", "d-none");
					session.setAttribute("showcon", "show");
				}
				
			} else {
				request.setAttribute("exceptionerror","User Credinatial incorrect");
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	
	}

}
