package com.mafs.dao;


import com.mafs.entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

	private Connection conn;

	public DoctorDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerDoctor(Doctor doctor) {

		boolean transaction = false;

		try {

			String sql = "insert into doctor(fullName,dateOfBirth,qualification,specialist,email,phone,password) values(?,?,?,?,?,?,?)";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, doctor.getFullName());
			pstmt.setString(2, doctor.getDateOfBirth());
			pstmt.setString(3, doctor.getQualification());
			pstmt.setString(4, doctor.getSpecialist());
			pstmt.setString(5, doctor.getEmail());
			pstmt.setString(6, doctor.getPhone());
			pstmt.setString(7, doctor.getPassword());

			pstmt.executeUpdate();
			transaction = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transaction;
	}

	// getAllDoctors list
	public List<Doctor> getAllDoctor() {

		Doctor doctor = null;
		List<Doctor> docList = new ArrayList<Doctor>();

		try {

			String sql = "select * from doctor order by id desc";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				doctor = new Doctor();

				doctor.setId(resultSet.getInt("id"));
				doctor.setFullName(resultSet.getString("fullName"));
				doctor.setDateOfBirth(resultSet.getString("dateOfBirth"));
				doctor.setQualification(resultSet.getString("qualification"));
				doctor.setSpecialist(resultSet.getString("specialist"));
				doctor.setEmail(resultSet.getString("email"));
				doctor.setPhone(resultSet.getString("phone"));
				doctor.setPassword(resultSet.getString("password"));
				docList.add(doctor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return docList;
	}

	// get doctor by id
	public Doctor getDoctorById(int id) {

		Doctor doctor = null;

		try {

			String sql = "select * from doctor where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				doctor = new Doctor();

				doctor.setId(resultSet.getInt("id"));
				doctor.setFullName(resultSet.getString("fullName"));
				doctor.setDateOfBirth(resultSet.getString("dateOfBirth"));
				doctor.setQualification(resultSet.getString("qualification"));
				doctor.setSpecialist(resultSet.getString("specialist"));
				doctor.setEmail(resultSet.getString("email"));
				doctor.setPhone(resultSet.getString("phone"));
				doctor.setPassword(resultSet.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctor;
	}

	// update doctors by id
	public boolean updateDoctor(Doctor doctor) {

		boolean transaction = false;

		try {

			String sql = "update doctor set fullName=?,dateOfBirth=?,qualification=?,specialist=?,email=?,phone=?,password=? where id=?";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, doctor.getFullName());
			pstmt.setString(2, doctor.getDateOfBirth());
			pstmt.setString(3, doctor.getQualification());
			pstmt.setString(4, doctor.getSpecialist());
			pstmt.setString(5, doctor.getEmail());
			pstmt.setString(6, doctor.getPhone());
			pstmt.setString(7, doctor.getPassword());
			// need to set id also for update
			pstmt.setInt(8, doctor.getId());

			pstmt.executeUpdate();
			transaction = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transaction;
	}

	// delete doctors by id
	public boolean deleteDoctorById(int id) {

		boolean transaction = false;

		try {

			String sql = "delete from doctor where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			transaction = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transaction;
	}

	// doctor login
	public Doctor loginDoctor(String email, String password) {

		Doctor doctor = null;

		try {

			String sql = "select * from doctor where email=? and password=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				doctor = new Doctor();

				doctor.setId(resultSet.getInt(1));
				doctor.setFullName(resultSet.getString(2));
				doctor.setDateOfBirth(resultSet.getString(3));
				doctor.setQualification(resultSet.getString(4));
				doctor.setSpecialist(resultSet.getString(5));
				doctor.setEmail(resultSet.getString(6));
				doctor.setPhone(resultSet.getString(7));
				doctor.setPassword(resultSet.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctor;

	}

	// Count total Doctor Number
	public int countTotalDoctor() {

		int count = 0;

		try {

			String sql = "select * from doctor";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	// Count total Appointment Number
	public int countTotalAppointment() {

		int count = 0;

		try {

			String sql = "select * from appointment";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	// Count total number of Appointment for a specific doctor
	public int countTotalAppointmentByDoctorId(int doctorId) {

		int count = 0;

		try {

			String sql = "select * from appointment where doctorId=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, doctorId);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	// Count total User Number
	public int countTotalUser() {

		int count = 0;

		try {

			String sql = "select * from user";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	// Count total Specialist Number
	public int countTotalSpecialist() {

		int count = 0;

		try {

			String sql = "select * from specialist";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	// check old password
	public boolean checkOldPassword(int doctorId, String oldPassword) {

		boolean transaction = false;

		try {

			String sql = "select * from doctor where id=? and password=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, doctorId);
			pstmt.setString(2, oldPassword);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				transaction = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transaction;
	}

	// change password
	public boolean changePassword(int doctorId, String newPassword) {

		boolean transaction = false;

		try {

			String sql = "update doctor set password=? where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, doctorId);

			pstmt.executeUpdate();

			transaction = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transaction;
	}

	// edit doctor profile in doctor panel edit profile
	public boolean editDoctorProfile(Doctor doctor) {

		boolean transaction = false;

		try {

			//String sql = "update doctor set fullName=?,dateOfBirth=?,qualification=?,specialist=?,email=?,phone=?,password=? where id=?";
			String sql = "update doctor set fullName=?,dateOfBirth=?,qualification=?,specialist=?,email=?,phone=? where id=?";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, doctor.getFullName());
			pstmt.setString(2, doctor.getDateOfBirth());
			pstmt.setString(3, doctor.getQualification());
			pstmt.setString(4, doctor.getSpecialist());
			pstmt.setString(5, doctor.getEmail());
			pstmt.setString(6, doctor.getPhone());
			pstmt.setInt(7, doctor.getId());

			pstmt.executeUpdate();
			// if query updated or all okay than
			transaction = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transaction;
	}

}
