package com.emember.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.emember.model.LoginAndDetails;
import com.emember.model.MemberDetails;
import com.emember.repository.MemberRepository;
import com.emember.repository.util.DBDateFormatter;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	//@Autowired
	//private EncryptPassword encryptPassword;
	
	@Autowired
	public DBDateFormatter dateFormatter;
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public MemberDetails getMember(String userName) {
		System.out.println("memberID : " + userName);
		return memberRepository.getMember(userName);
	}
	
	
	@Override
	@Transactional
	public List<LoginAndDetails> createMember(LoginAndDetails member) {
		// TODO Auto-generated method stub
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("status of tran = " + status);
		System.out.println("JM in service createmember username: " + member.getUserLogin());
		System.out.println("JM in service createmember dobday:"+ member.getMemberDetails().getDobDay());
		String dob = member.getMemberDetails().getDobDay() + "/" + member.getMemberDetails().getDobMonth() + "/"
				+ member.getMemberDetails().getDobYear();
		System.out.println("dob=" + dob);
		String formattedDob = dateFormatter.formatDateToDB(dob);
		System.out.println("formatted date returned: " + formattedDob);
		member.getMemberDetails().setDob(formattedDob);;
		return memberRepository.createMember(member);
	}


	@Override
	public List<MemberDetails> getAllMembers() {
		return memberRepository.getAllMembers();
	}


	@Override
	public LoginAndDetails updateMember(LoginAndDetails member) {
				
		return memberRepository.updateMember(member);
	}


	@Override
	@Transactional
	public void batch() {
		
		List<MemberDetails> members = memberRepository.getAllMembers();
		
		List<Object[]> pairs = new ArrayList<>();
		
		for (MemberDetails member : members) {
			Object [] tmp = {new Date(), member.getMemberNo()};
			pairs.add(tmp);
		}
		
		memberRepository.updateMembers(pairs);
		
		throw new DataAccessException("Testing Exeption Handling") {		
		};
	}


	@Override
	public void batchResetPasswords() {
		List<MemberDetails> members = memberRepository.getAllMembers();
		
		List<Object[]> pairs = new ArrayList<>();
		System.out.println("JM DEBUG 1");
		
		for (MemberDetails member : members) {
			//Object [] tmp = {encryptPassword.encPassword("test1234"), member.getMemberNo()};
			Object [] tmp = {"test1234", member.getMemberNo()};
			pairs.add(tmp);
		}
		System.out.println("JM DEBUG pairs obj: " + pairs.toString());
		memberRepository.updateAllMembersPasswords(pairs);
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = {java.lang.Exception.class})
	public void deleteMember(Integer memberId, String userName) {
		
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("status of tran = " + status.isNewTransaction());
		
		System.out.println("JM DEBUG service id and user:" + memberId + ", " + userName);
		memberRepository.deleteMember(memberId, userName);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = {java.lang.Exception.class})
	public void deleteJohn(Integer memberId, String userName) {
		
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("status of tran = " + status.isNewTransaction());
		
		System.out.println("JM DEBUG deleteJohn service id and user:" + memberId + ", " + userName);
		memberRepository.deleteJohn(memberId, userName);
		
	}

}
