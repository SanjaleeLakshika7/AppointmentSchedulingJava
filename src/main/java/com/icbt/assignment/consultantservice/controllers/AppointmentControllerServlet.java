package com.icbt.assignment.consultantservice.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

 
import com.icbt.assignment.consultantservice.entities.AppointmentDetails;
import com.icbt.assignment.consultantservice.entities.Appointments;
 
import com.icbt.assignment.consultantservice.entities.Country_Specialization;
import com.icbt.assignment.consultantservice.entities.JobType;
import com.icbt.assignment.consultantservice.entities.Job_Seekers;
import com.icbt.assignment.consultantservice.services.Appointments_Services;
import com.icbt.assignment.consultantservice.services.CommonServices;
 
import com.icbt.assignment.consultantservice.services.Country_Service;
import com.icbt.assignment.consultantservice.services.JobType_Service;
import com.icbt.assignment.consultantservice.services.Job_Seekers_Services;
import com.icbt.assignment.consultantservice.util.EntityValidator;
import com.icbt.assignment.consultantservice.util.MailSender;
 

@WebServlet("/AppointmentControllerServlet")
public class AppointmentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/consultationservicedb_application")
	private DataSource dataSource;

    public AppointmentControllerServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =request.getParameter("command");
		  if(command == null )
		{
			  showAllList(request,response);
		}
		  if(command.equals("SHOW-ALL") )
			{
				  showAllList(request,response);
			}
		else if(command.equals("SHOW-NEW") )
		{
			mainList(request,response);
		}
		else if(command.equals("SHOW-ACCEPT") )
		{
			showAcceptedList(request,response);
		}
		else if(command.equals("SHOW-COMPLETE") )
		{
			showCompletedList(request, response);
		}
		else if(command.equals("SHOW-ADDDATA") )
		{
			showAddScreen(request,response);
		}
		  
	    if(command.equals("UPDATE-ACCEPTED") )
		{
			updateAcceptData(request,response);
		}

		if(command.equals("UPDATE-REJECT") )
		{
			updateRejectData(request, response);
		}
		
		if(command.equals("UPDATE-COMPLETED") )
		{
			updateCompletedData(request, response);
		}	
			
	  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =request.getParameter("command");
		if(command.equals("ADDDATA") )
		{
			addInfo(request,response);
		}
		
		if(command.equals("UPDATE-ACCEPTED") )
		{
			updateAcceptData(request,response);
		}
		
		if(command.equals("UPDATE-REJECT") )
		{
			updateRejectData(request, response);
		}
		
		if(command.equals("UPDATE-COMPLETED") )
		{
			updateCompletedData(request, response);
		}
			
		 
	}
	

	private void showAllList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 	 
			 
			  	List<AppointmentDetails> appointmentDetails = Appointments_Services.GetAll(dataSource) ;
			    request.setAttribute("appointmentDetails_lists", appointmentDetails);
				request.setAttribute("exceptionerrorshow", "d-none");
				request.getRequestDispatcher("/all-appointment.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/all-appointment.jsp").forward(request, response);
			}
		  
		
	}
	private void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 	HttpSession session = request.getSession();
			 	String Status = "Pending"; // Ensure that 'Pending' is enclosed in single quotes
			 	String consultant_id=(String)session.getAttribute("consultant_id"); 
			 	String job_type_specialization_id=(String)session.getAttribute("job_type_specialization_id"); 
			 	String country_specialization_id=(String)session.getAttribute("country_specialization_id"); 
 
			 
			  	List<AppointmentDetails> appointmentDetails = Appointments_Services.GetAppointment(dataSource, Status, job_type_specialization_id, country_specialization_id) ;
			    request.setAttribute("appointmentDetails_lists", appointmentDetails);
				request.setAttribute("exceptionerrorshow", "d-none");
				request.getRequestDispatcher("/new-appointment.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/new-appointment.jsp").forward(request, response);
			}
		  
		
	}
	
	
	private void showAcceptedList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 	HttpSession session = request.getSession();
			 	String Status = "Accepted";
			 	String consultant_id=(String)session.getAttribute("consultant_id"); 
			 	String job_type_specialization_id=(String)session.getAttribute("job_type_specialization_id"); 
			 	String country_specialization_id=(String)session.getAttribute("country_specialization_id"); 

			 
			  	List<AppointmentDetails> appointmentDetails = Appointments_Services.GetAppointment(dataSource, Status, job_type_specialization_id, country_specialization_id) ;
			    request.setAttribute("appointmentDetails_lists", appointmentDetails);
				request.setAttribute("exceptionerrorshow", "d-none");
				request.getRequestDispatcher("/ongoing-appointment.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/ongoing-appointment.jsp").forward(request, response);
			}
		  
		
	}
	
	
	private void showCompletedList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 	HttpSession session = request.getSession();
			 	String Status = "Completed";
			 	String consultant_id=(String)session.getAttribute("consultant_id"); 
			 	String job_type_specialization_id=(String)session.getAttribute("job_type_specialization_id"); 
			 	String country_specialization_id=(String)session.getAttribute("country_specialization_id"); 

			 
			  	List<AppointmentDetails> appointmentDetails = Appointments_Services.GetAppointment(dataSource, Status, job_type_specialization_id, country_specialization_id) ;
			    request.setAttribute("appointmentDetails_lists", appointmentDetails);
				request.setAttribute("exceptionerrorshow", "d-none");
				request.getRequestDispatcher("/complete-appointment.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/complete-appointment.jsp").forward(request, response);
			}
		  
		
	}
	
	private void showAddScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	
			List<Country_Specialization> Country_SpecializationDrp =  Country_Service.GetAll(dataSource);
			request.setAttribute("Country_SpecializationDrp", Country_SpecializationDrp);
			
			List<JobType> jobTypes =  JobType_Service.GetAll(dataSource);
			request.setAttribute("jobTypesDrp", jobTypes);
	
		
		request.getRequestDispatcher("/add_appointment.jsp").forward(request, response);
	}catch (Exception e) {
		request.setAttribute("exceptionerror", e.toString());
		request.setAttribute("exceptionerrorshow", "");
		request.getRequestDispatcher("/add_appointment.jsp").forward(request, response);
	}
		
	}
	
	
	private void addInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 
		String tableappointmentsName ="appointments";
		String tablejob_seekersName ="job_seekers";
		
		
		String full_name = request.getParameter("full_name");
		String contact_number = request.getParameter("contact_number");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		String appointmentDate = request.getParameter("appointmentDate");
		String appointmentTime = request.getParameter("appointmentTime");
		String job_type_specialization_id = request.getParameter("job_type_specialization_id");
		String country_specialization_id = request.getParameter("country_specialization_id");
		
		try {
			
		 
				 	String appointments_id = CommonServices.GetNumberFormat(dataSource, tableappointmentsName);
				 	String job_seekers_id = CommonServices.GetNumberFormat(dataSource, tablejob_seekersName);
					Job_Seekers job_Seekers = new Job_Seekers(job_seekers_id,full_name,contact_number,email,address);
					Appointments appointments = new Appointments(appointments_id,"",job_seekers_id,appointmentDate,appointmentTime, "Pending",job_type_specialization_id,country_specialization_id);
					
					EntityValidator<Job_Seekers> validator = new EntityValidator<Job_Seekers>();
					String errors = validator.validate(job_Seekers);
					
					if (!errors.isEmpty()) {
						request.setAttribute("job_Seekers", job_Seekers);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/add_appointment.jsp").forward(request, response);
					} else {
						Job_Seekers_Services.Add(dataSource, job_Seekers);
						Appointments_Services.Add(dataSource, appointments);
						CommonServices.SetNumberFormat(dataSource, tableappointmentsName);
						CommonServices.SetNumberFormat(dataSource, tablejob_seekersName);
						MailSender.SendMail("Pending Appointment - The Jobs Taxi",job_Seekers,appointments);
						response.sendRedirect("indexcus.jsp");
					}
			 
				
				
			 
			
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			showAddScreen(request,response);
		}
		
	}
	
	private void updateAcceptData(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();  
		String consultant_id=(String)session.getAttribute("consultant_id"); 
		 
		String status = "Accepted";
		String appointment_id = request.getParameter("appointment_id");  
		
		try {
			Appointments_Services.updateAppointment(dataSource, consultant_id, status, appointment_id);
			showAcceptedList(request,response);
		} catch (Exception e) {
			
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/new-appointment.jsp").forward(request, response);
		}
		
	}
	
	private void updateRejectData(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();  
		String consultant_id=(String)session.getAttribute("consultant_id"); 
		 
		String status = "Reject";
		String appointment_id = request.getParameter("appointment_id");  
		
		try {
			Appointments_Services.updateAppointment(dataSource, consultant_id, status, appointment_id);
			mainList(request,response);
		} catch (Exception e) {
			
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/new-appointment.jsp").forward(request, response);
		}
		
	}
	
	private void updateCompletedData(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();  
		String consultant_id=(String)session.getAttribute("consultant_id"); 
		 
		String status = "Completed";
		String appointment_id = request.getParameter("appointment_id");  
		
		try {
			Appointments_Services.updateAppointment(dataSource, consultant_id, status, appointment_id);
			showCompletedList(request,response);
		} catch (Exception e) {
			
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/ongoing-appointment.jsp").forward(request, response);
		}
		
	}

}
