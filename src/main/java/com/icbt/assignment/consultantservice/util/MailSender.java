package com.icbt.assignment.consultantservice.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.icbt.assignment.consultantservice.entities.Appointments;
import com.icbt.assignment.consultantservice.entities.Job_Seekers;
 

public class MailSender {
	public static void SendMail(String subject,Job_Seekers job_Seekers,Appointments appointments)
	{
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth",true);
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
		properties.put("mail.smtp.starttls.enable",true);
		properties.put("mail.transport.protocol","smtp");
		Session session = Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("dushmanp123@gmail.com","qjmcsylsnjczscku");
			}
		});
		Message message = new MimeMessage(session);
		try {
			message.setSubject(subject);
			message.setHeader("Content-Type", "text/html");
			message.setContent("<td style=\"padding:40px 20px;\" id=\"yui_3_13_0_ym1_1_1392534689432_2560\">\n" +
	                "\t\t\t\t<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" id=\"yui_3_13_0_ym1_1_1392534689432_2559\">\n" +
	                "\t\t\t\t\t<tbody id=\"yui_3_13_0_ym1_1_1392534689432_2558\"><tr id=\"yui_3_13_0_ym1_1_1392534689432_2600\">\n" +
	                "\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#272727\" style=\"padding:20px 10px;\" id=\"yui_3_13_0_ym1_1_1392534689432_2599\">\n" +
	                "\t\t\t\t\t\t\t<a rel=\"nofollow\" target=\"_blank\" href=\"#\" id=\"yui_3_13_0_ym1_1_1392534689432_2604\">\n" +
	                "\t\t\t\t\t\t\t\t<img src=\"/images/logo-mk-en.png\" alt=\"Taxi\" title=\"taxi\" border=\"0\" width=\"160\" height=\"30\" id=\"yui_3_13_0_ym1_1_1392534689432_2603\">\n" +
	                "\t\t\t\t\t\t\t</a>\n" +
	                "\t\t\t\t\t\t</td>\n" +
	                "\t\t\t\t\t</tr>\n" +
	                "\t\t\t\t\t<tr id=\"yui_3_13_0_ym1_1_1392534689432_2557\">\n" +
	                "\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" style=\"color:#6F6E6E;font-size:16px;font-family:Lato, Helvetica, Arial, sans-serif;\" id=\"yui_3_13_0_ym1_1_1392534689432_2556\">\n" +
	                "\t\t\t\t\t\t\t<p align=\"center\" style=\"margin:30px 30px 0;\" id=\"yui_3_13_0_ym1_1_1392534689432_2555\">\n" +
	                "\t\t\t\t\t\t\t\t Dear <span style=\"color:#A7CA01;font-size:26px;\" id=\"yui_3_13_0_ym1_1_1392534689432_2597\">"+ job_Seekers.getFull_name() + " ,</span>\n" +
	                "\t\t\t\t\t\t\t\t<br><br>\n" +
	                "\t\t\t\t\t\t\t\t<b>Welcome to <span style=\"color:#A7CA01;\">GO</span>The Jobs</b><br>\n" +
	              
	                "\t\t\t\t\t\t\t</p>\n" +
	                "\t\t\t\t\t\t\t<p style=\"margin:20px 30px 0;text-indent:20px;\">\n" +
	                "\t\t\t\t\t\t\t<p style=\"margin:20px 30px 0;text-indent:20px;\">\n" +
	                "\t\t\t\t\t\t\t\t\n" +
	                "\t\t\t\t\t\t\t</p>\n" +
	                "\t\t\t\t\t\t\t<ul style=\"margin:20px 30px 0 60px;padding:0;color:#A7CA01;\">\n" +
	                "\t\t\t\t\t\t\t\t<li>\n" +
	              
	                "\t\t\t\t\t\t\t\t\tAppointment Number :"+ appointments.getAppointment_id() +"\n" +
	                "\t\t\t\t\t\t\t\t</li>\n" +
	                "\t\t\t\t\t\t\t\t<li>\n" +
	                "\t\t\t\t\t\t\t\t\tName :"+ job_Seekers.getFull_name() +"\n" +
	                "\t\t\t\t\t\t\t\t</li>\n" +
	                "\t\t\t\t\t\t\t\t<li>\n" +
	                "\t\t\t\t\t\t\t\t\tSchedule on :"+ appointments.getAppointmentDate() +"\\t - "+ appointments.getAppointmentTime() +"\n" +
	                "\t\t\t\t\t\t\t\t</li>\n" +
	                "\t\t\t\t\t\t\t\t<li>\n" +
	                "\t\t\t\t\t\t\t\t\tConsultant :"+ appointments.getConsultant_id() +"\n" +
	                "\t\t\t\t\t\t\t\t</li>\n" +
	                "\t\t\t\t\t\t\t\t<li>\n" +
	                "\t\t\t\t\t\t\t\t\tAppointment Status :"+ appointments.getStatus() +"\n" +
	                "\t\t\t\t\t\t\t\t</li>\n" +
	                "\t\t\t\t\t\t\t\t<li>\n" +
	                "\t\t\t\t\t\t\t\t\tJob Selected :"+ appointments.getJob_type_specialization_id() + " (" +appointments.getCountry_specialization_id()+")" +"\n" +
	                "\t\t\t\t\t\t\t\t</li>\n" +
	               
	                "\t\t\t\t\t\t\t</ul>\n" +
	                "\t\t\t\t\t\t\t<p align=\"center\" style=\"margin:20px 30px 30px;\">\n" +
	                "\t\t\t\t\t\t\t\t<b>We wish you Appointment Intereaction will be great!</b>\n" +
	                "\t\t\t\t\t\t\t\t<br><br><br>\n" +
	                 "\t\t\t\t\t\t\t</p>\n" +
	                "\t\t\t\t\t\t</td>\n" +
	                "\t\t\t\t\t</tr>\n" +
	                "\t\t\t\t\t<tr>\n" +
	                "\t\t\t\t\t\t<td align=\"center\" bgcolor=\"#EDEDED\" style=\"color:#6F6E6E;font-size:9px;font-family:Lato, Helvetica, Arial, sans-serif;padding:10px;\">\n" +
	                "\t\t\t\t\t\t\tThis email has been sent by <a rel=\"nofollow\" target=\"_blank\" href=\"#\" style=\"text-decoration:underline;color:#A7CA01;\">GOCHEETHA Taxi</a>, an Online Taxi Service Platform  by Dushman.<br>\n" +
	                "\t\t\t\t\t\t\tPlease contact our customer service if you think that you’ve received this email by mistake.\n" +
	                "\t\t\t\t\t\t</td>\n" +
	                "\t\t\t\t\t</tr>\n" +
	                "\t\t\t\t\t<tr>\n" +
	            
	                "\t\t\t\t\t\t\t</tbody></table>\n" +
	                "\t\t\t\t\t\t</td>\n" +
	                "\t\t\t\t\t</tr>\n" +
	                "\t\t\t\t</tbody></table>\n" +
	                "\t\t\t</td>", "text/html");
			Address addressTo = new InternetAddress(job_Seekers.getEmail());
			message.setRecipient(Message.RecipientType.TO, addressTo);
			Transport.send(message);
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new CustomException(e.getMessage());
		}

	}

	
}
