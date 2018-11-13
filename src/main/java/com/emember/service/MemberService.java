package com.emember.service;

import java.util.List;

import com.emember.model.LoginAndDetails;
import com.emember.model.MemberDetails;

public interface MemberService {

	MemberDetails getMember(String userName);

	List<LoginAndDetails> createMember(LoginAndDetails member);

	List<MemberDetails> getAllMembers();

	LoginAndDetails updateMember(LoginAndDetails member);

	void batch();

	void batchResetPasswords();

	void deleteMember(Integer memberId, String userName);

	void deleteJohn(Integer memberId, String userName);

}
