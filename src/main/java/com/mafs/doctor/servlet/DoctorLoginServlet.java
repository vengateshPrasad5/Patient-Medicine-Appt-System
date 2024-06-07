package com.mafs.doctor.servlet;


import com.mafs.dao.DoctorDAO;
import com.mafs.db.DBConnection;
import com.mafs.entity.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/doctorLogin")
public class DoctorLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		DoctorDAO docDAO = new DoctorDAO(DBConnection.getConn());
		
		Doctor doctor = docDAO.loginDoctor(email, password);

		if (doctor != null) { // if doctor exists
			session.setAttribute("doctorObj", doctor);
			resp.sendRedirect("doctor/index.jsp");
		} else {
			session.setAttribute("errorMsg", "Invalid email or password");
			resp.sendRedirect("doctor_login.jsp");
		}

	}

}
