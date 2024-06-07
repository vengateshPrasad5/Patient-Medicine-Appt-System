package com.mafs.user.servlet;

import com.mafs.dao.AppointmentDAO;
import com.mafs.db.DBConnection;
import com.mafs.entity.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	int userId	= Integer.parseInt(req.getParameter("userId"));
	String fullName = req.getParameter("fullName");
	String gender = req.getParameter("gender");
	String age = req.getParameter("age");
	String appointmentDate = req.getParameter("appointmentDate");
	String email = req.getParameter("email");
	String phone = req.getParameter("phone");
	String diseases = req.getParameter("diseases");
	int doctorId = Integer.parseInt(req.getParameter("doctorNameSelect"));
	String address = req.getParameter("address");
	
	
	Appointment appointment = new Appointment(userId, fullName, gender, age, appointmentDate, email, phone, diseases, doctorId, address, "Pending");
	
	AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConn());
	boolean transaction = appointmentDAO.addAppointment(appointment);
	
	//get session
	HttpSession session = req.getSession();
	
	if(transaction) {
		
		session.setAttribute("successMsg", "Appointment is recorded Successfully.");
		resp.sendRedirect("user_appointment.jsp");

	}
	else {
		
		session.setAttribute("errorMsg", "Something went wrong on server!");
		resp.sendRedirect("user_appointment.jsp");
		
	}
		
	}
	
}
