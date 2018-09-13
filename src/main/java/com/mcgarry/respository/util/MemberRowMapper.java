package com.mcgarry.respository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mcgarry.model.MemberDetails;

public class MemberRowMapper implements RowMapper<MemberDetails> {

	@Override
	public MemberDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDetails members = new MemberDetails();
		members.setMemberNo(rs.getInt("membershipNo"));
		members.setUserName(rs.getString("username"));
		members.setName(rs.getString("forename"));
		members.setSurname(rs.getString("surname"));
		members.setAddress1(rs.getString("address_1"));
		members.setAddress2(rs.getString("address_2"));
		members.setTown(rs.getString("town"));
		members.setPostcode(rs.getString("postcode"));
		members.setEmail(rs.getString("email"));
		members.setDob(rs.getString("dob"));
		members.setTelephone(rs.getString("telephone"));
		members.setStartDate(rs.getString("startdate"));
		members.setNextRenewalDate(rs.getString("nextRenewalDate"));
		
		return members;
	}
}
