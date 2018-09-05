package com.mcgarry.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcgarry.model.MemberDetails;
import com.mcgarry.respository.MemberRepository;
import com.mcgarry.respository.util.EncryptPassword;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	//@Autowired
	//private EncryptPassword encryptPassword;
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public MemberDetails getMember(Integer memberId) {
		System.out.println("memberID : " + memberId);
		return memberRepository.getMember(memberId);
	}
	
	
	@Override
	public List<MemberDetails> createMember(MemberDetails member) {
		// TODO Auto-generated method stub
		return memberRepository.createMember(member);
	}


	@Override
	public List<MemberDetails> getAllMembers() {
		return memberRepository.getAllMembers();
	}


	@Override
	public MemberDetails updateMember(MemberDetails member) {
				
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
	public void deleteMember(Integer memberId) {
		memberRepository.deleteMember(memberId);
		
	}

}
