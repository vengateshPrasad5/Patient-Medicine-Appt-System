package com.mafs.dao;


import com.mafs.entity.Specialist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpecialistDAO {
	
	private Connection conn;

	public SpecialistDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addSpecialist(String sp) {
		
		boolean transaction = false;
		
		try {
			
			String sql = "insert into specialist (specialist_name) values(?)";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, sp);
			
			pstmt.executeUpdate();
			
			transaction = true;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return transaction;
		
	}

    // used to show list of specialist
	public List<Specialist> getAllSpecialist(){
		
		List<Specialist> spList = new ArrayList<Specialist>();
		
		Specialist specialistObj = null;
		
		try {
			
			String sql = "select * from specialist";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				//create object
				specialistObj = new Specialist();
				specialistObj.setId(resultSet.getInt(1));//column index number 1 -(id)
				specialistObj.setSpecialistName(resultSet.getString(2));//column index number 2 -(specialist_name)
				
				//now add specialist object into List 
				spList.add(specialistObj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return spList;
	}

}
