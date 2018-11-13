package com.emember.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.emember.model.LoginAndDetails;
import com.emember.model.MemberDetails;
import com.emember.repository.util.DBDateFormatter;
import com.emember.repository.util.MemberRowMapper;

@Repository("memberRepository")
public class MemberRepositoryImpl implements MemberRepository {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Autowired
	public DBDateFormatter dateFormatter;

	// @Autowired
	// public PasswordEncoder passwordEncoder;
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public List<MemberDetails> getAllMembers() {

		/*
		 * MemberDetails member = new MemberDetails(); member.setName("TestName");
		 * List<MemberDetails> members = new ArrayList<>(); members.add(member);
		 */

		List<MemberDetails> members = jdbcTemplate.query("select * from userdetails", new MemberRowMapper());
		System.out.println("Repo members: " + members.toString());
		return members;
	}

	@Override
	public MemberDetails getMember(String username) {
		MemberDetails member = jdbcTemplate.queryForObject("select * from userdetails where username = ?",
				new MemberRowMapper(), username);
		System.out.println("member name and dob: " + member.getForename() + " " + member.getDob());
		member.setDob(dateFormatter.formatDateFromDB(member.getDob()));
		System.out.println("member dob: " + member.getDob());
		return member;
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = {java.lang.Exception.class})
	public List<LoginAndDetails> createMember(LoginAndDetails member) {
		try {
			TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
			System.out.println("status of tran = " + status);
			
			
		jdbcTemplate.update("insert into users(username, password, enabled) values(?,?,?)",
				member.getUserLogin().getUserName(), passwordEncoder.encode(member.getUserLogin().getPassword()),
				member.getUserLogin().isEnabled());
		
		System.out.println("Updated USERS");

		jdbcTemplate.update("insert into authorities(username, authority) values(?,?)",
				member.getUserLogin().getUserName(), member.getAuthority().getAuthority());

		System.out.println("Updated AUTHORITIES");
		
		jdbcTemplate.update(
				"insert into userdetails(membershipNo, username, forename, surname, address_1, address_2, town, postcode, email, dob, telephone, startDate, nextRenewalDate) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				member.getMemberDetails().getMemberNo(), member.getUserLogin().getUserName(),
				member.getMemberDetails().getForename(), member.getMemberDetails().getSurname(),
				member.getMemberDetails().getAddress_1(), member.getMemberDetails().getAddress_2(),
				member.getMemberDetails().getTown(), member.getMemberDetails().getPostcode(),
				member.getMemberDetails().getEmail(), member.getMemberDetails().getDob(),
				member.getMemberDetails().getTelephone(), member.getMemberDetails().getStartDate(),
				member.getMemberDetails().getNextRenewalDate());
		
		System.out.println("Updated USERDETAILS");
		
		}
		catch (Exception e) {
			System.out.println("Exception thrown in SQL");
			e.printStackTrace();
			//throw new DataAccessException("Testing Exeption Handling") {};
			throw new RuntimeException("JM DEBUG Throwing RuntimeException");
			//throw new Exception("JM DEBUG Throwing Exception");
		}
		return null;
		//throw new DataAccessException("Testing Exeption Handling") {};

	}

	@Override
	public LoginAndDetails updateMember(LoginAndDetails member) {

		jdbcTemplate.update("update userdetails set town = ? where membershipNo = ?",
				member.getMemberDetails().getTown(), member.getMemberDetails().getMemberNo());

		return member;
	}

	@Override
	public void updateMembers(List<Object[]> pairs) {
		jdbcTemplate.batchUpdate("update userdetails set startdate = ? where membershipNo = ?", pairs);

	}

	@Override
	public void updateAllMembersPasswords(List<Object[]> pairs) {
		jdbcTemplate.batchUpdate("update userdetails set password = ? where membershipNo = ?", pairs);

	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED, rollbackFor = {java.lang.Exception.class})
	public void deleteMember(Integer memberId, String userName) {
		// jdbcTemplate.update("delete from userdetails where membershipNo = ?",
		// memberId);

		// use above or alternatively using Named Params:-
		System.out.println("JM DEBUG repository id and user:" + memberId + ", " + userName);

		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		//TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		//System.out.println("status of tran = " + status);

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", memberId);
		paramMap.put("userName", userName);
		System.out.println("id: " + paramMap.get("id") + " " + "userName: " + paramMap.get("userName") );
		
		System.out.println("deleting from authorities");
		namedTemplate.update("delete from authorities where username = :userName", paramMap); 
		
		System.out.println("deleting from userdetails");
		namedTemplate.update("delete from userdetails where membershipNo = :id", paramMap);
		
		System.out.println("deleting from users");
		namedTemplate.update("delete from users where username = :userName", paramMap);

	}

	@Override
	public void deleteJohn(Integer memberId, String userName) {
		// TODO Auto-generated method stub
		
	}
}
