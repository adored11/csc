package com.mcgarry.service;

import java.util.List;

import com.mcgarry.model.MemberDetails;

public interface MemberService {

	MemberDetails getMember(Integer memberId);

	List<MemberDetails> createMember(MemberDetails member);

	List<MemberDetails> getAllMembers();

	MemberDetails updateMember(MemberDetails member);

	void batch();

	void batchResetPasswords();

	void deleteMember(Integer memberId);

}
