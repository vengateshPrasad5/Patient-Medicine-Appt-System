package com.mafs.user.servlet;

import com.mafs.dao.UserDAO;
import com.mafs.db.DBConnection;
import com.mafs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// get all data from signup.jsp page
			String fullName = req.getParameter("fullName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			// Set all data to User Entity
			User user = new User(fullName, email, password);

			// Create Connection with DB
			UserDAO userDAO = new UserDAO(DBConnection.getConn());
			
			//get session
			HttpSession session = req.getSession();
			

			// call userRegister() and pass user object to insert or save user into DB.
			boolean transaction = userDAO.userRegister(user);

			if (transaction) {

				session.setAttribute("successMsg", "Register Successfully");
				resp.sendRedirect("signup.jsp");//redirectURL

			} else {
				
				session.setAttribute("errorMsg", "Something went wrong!");
				resp.sendRedirect("signup.jsp");//redirectURL

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
