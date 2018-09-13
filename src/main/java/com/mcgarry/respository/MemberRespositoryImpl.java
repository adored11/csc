package com.mcgarry.respository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mcgarry.model.MemberDetails;
import com.mcgarry.respository.util.MemberRowMapper;

@Repository("memberRepository")
public class MemberRespositoryImpl implements MemberRepository{

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MemberDetails> getAllMembers() {
				
		/*MemberDetails member = new MemberDetails();
		member.setName("TestName");
		List<MemberDetails> members = new ArrayList<>();
		members.add(member);*/
		
		List<MemberDetails> members = jdbcTemplate.query("select * from userdetails", new MemberRowMapper());
		
		return members;
	}
	
	@Override
	public MemberDetails getMember(String userName) {
		MemberDetails member = jdbcTemplate.queryForObject("select * from userdetails where username = ?", new MemberRowMapper(), userName);
		
		return member;
	}

	@Override
	public List<MemberDetails> createMember(MemberDetails member) {
		
		jdbcTemplate.update("insert into userdetails(membershipNo, username, forename, surname, address_1, address_2, town, postcode, email, dob, telephone, startdate, nextRenewalDate) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
			member.getMemberNo(),
			member.getUserName(),
			member.getName(),
			member.getSurname(),
			member.getAddress1(),
			member.getAddress2(),
			member.getTown(),
			member.getPostcode(),
			member.getEmail(),
			member.getDob(),
			member.getTelephone(),
			member.getStartDate(),
			member.getNextRenewalDate()
		);
		
		return null;
		
		//jdbcTemplate.update("insert into ride (name, duration) values (?,?)", ride.getName(), ride.getDuration());
		
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				
//				PreparedStatement ps = con.prepareStatement("insert into ride (name, duration) values (?,?)", new String [] {"id"});
//				ps.setString(1, ride.getName());
//				ps.setInt(2, ride.getDuration());
//				return ps;
//			}
//		}, keyHolder);
//		
//		Number id = keyHolder.getKey();
		
		/*SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("memberId");
		
		Map<String, Object> data = new HashMap<>();
		data.put("membershipNo", member.getMemberNo());
		data.put("name", member.getName());
		
		List<String> columns = new ArrayList<>();
		columns.add("membershipNo");
		columns.add("name");
		
		insert.setTableName("userdetails");
		insert.setColumnNames(columns);
		Number memberId = insert.executeAndReturnKey(data);
		
		return getMember(memberId.intValue());*/
	}

	@Override
	public MemberDetails updateMember(MemberDetails member) {
		
		jdbcTemplate.update("update userdetails set town = ? where membershipNo = ?",
				member.getTown(), member.getMemberNo());
		
		return member;
	}

	@Override
	public void updateMembers(List<Object[]> pairs) {
		jdbcTemplate.batchUpdate("update userdetails set startdate = ? where membershipNo = ?",	pairs);
		
	}

	@Override
	public void updateAllMembersPasswords(List<Object[]> pairs) {
		jdbcTemplate.batchUpdate("update userdetails set password = ? where membershipNo = ?",	pairs);
		
	}

	@Override
	public void deleteMember(Integer memberId) {
		//jdbcTemplate.update("delete from userdetails where membershipNo = ?", memberId);
		
		// use above or alternatively using Named Params:-
		
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", memberId);
		
		namedTemplate.update("delete from userdetails where membershipNo = :id", paramMap);
		
		
	}
}
