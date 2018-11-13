package com.emember.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.emember.model.MemberDetails;

public class MemberRowMapper implements RowMapper<MemberDetails> {

	@Autowired
	public DBDateFormatter dateFormatter;
	
	@Override
	public MemberDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDetails members = new MemberDetails();
		members.setMemberNo(rs.getInt("membershipNo"));
		members.setUserName(rs.getString("username"));
		members.setForename(rs.getString("forename"));
		members.setSurname(rs.getString("surname"));
		members.setAddress_1(rs.getString("address_1"));
		members.setAddress_2(rs.getString("address_2"));
		members.setTown(rs.getString("town"));
		members.setPostcode(rs.getString("postcode"));
		members.setEmail(rs.getString("email"));
		members.setDob(rs.getString("dob"));
		members.setTelephone(rs.getString("telephone"));
		members.setStartDate(rs.getString("startdate"));
		members.setNextRenewalDate(rs.getString("nextRenewalDate"));
		
		System.out.println("RowMapper dob: " + rs.getString("dob"));
		
		return members;
		
	}
}
