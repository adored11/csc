package com.mcgarry.respository;

import java.util.List;

import com.mcgarry.model.MemberDetails;

public interface MemberRepository {
	
	List<MemberDetails> createMember(MemberDetails member);

	MemberDetails getMember(Integer memberId);

	List<MemberDetails> getAllMembers();

	MemberDetails updateMember(MemberDetails member);

	void updateMembers(List<Object[]> pairs);

	void updateAllMembersPasswords(List<Object[]> pairs);

	void deleteMember(Integer memberId);


}
