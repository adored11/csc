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
		members.setName(rs.getString("forename"));
		members.setSurname(rs.getString("surname"));
		members.setAddress1(rs.getString("address_1"));
		members.setTown(rs.getString("town"));
		members.setPostcode(rs.getString("postcode"));
		members.setDob(rs.getString("dob"));
		
		return members;
	}
}
