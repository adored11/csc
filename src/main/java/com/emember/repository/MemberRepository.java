package com.emember.repository;

import java.util.List;

import com.emember.model.LoginAndDetails;
import com.emember.model.MemberDetails;

public interface MemberRepository {
	
	List<LoginAndDetails> createMember(LoginAndDetails member);

	MemberDetails getMember(String userName);

	List<MemberDetails> getAllMembers();

	LoginAndDetails updateMember(LoginAndDetails member);

	void updateMembers(List<Object[]> pairs);

	void updateAllMembersPasswords(List<Object[]> pairs);

	void deleteMember(Integer memberId, String userName);

	void deleteJohn(Integer memberId, String userName);


}
