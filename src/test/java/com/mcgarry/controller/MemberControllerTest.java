package com.mcgarry.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.mcgarry.model.MemberDetails;

import org.junit.Ignore;
import org.junit.Test;

public class MemberControllerTest  {
	
	private String encPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String guestHashedPassword = passwordEncoder.encode(password);
		System.out.println(guestHashedPassword);
		return guestHashedPassword;
	}
	
	//@Ignore
	@Test
	public void testCreateMember() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MemberDetails member = new MemberDetails();
		member.setMemberNo(4);
		member.setUserName("guest");
		member.setName("Test4");
		member.setSurname("TestSur4");
		member.setAddress1("4 Test Road");
		member.setAddress2(null);
		member.setTown("Testville");
		member.setPostcode("AB44 4CD");
		member.setEmail(null);
		member.setDob("01/01/2004");
		member.setTelephone(null);
		member.setStartDate(null);
		member.setNextRenewalDate(null);
		//member.setPassword(encPassword("test1234"));
		
		member = restTemplate.postForObject("http://localhost:8080/eMembership/createMember", member, MemberDetails.class);
	}
	
	
	@Test
	public void testGetAllMembers() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<MemberDetails>> memberDetailsResponse = restTemplate.exchange(
				"http://localhost:8080/eMembership/getAllMembers", HttpMethod.GET, 
				null, new ParameterizedTypeReference<List<MemberDetails>>() {
		});
		
		List<MemberDetails> details = memberDetailsResponse.getBody();
		
		for (MemberDetails member: details ) {
			System.out.println("Membership No: " + member.getMemberNo());
			System.out.println("FirstName: " + member.getName());
			System.out.println("Surname: " + member.getSurname());
			System.out.println("Address Line 1: " + member.getAddress1());
			System.out.println("Town: " + member.getTown());
			System.out.println("Postcode: " + member.getPostcode());
			System.out.println("DOB: " + member.getDob());
		}	
	}
	
	@Test
	public void testGetMember() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MemberDetails member = restTemplate.getForObject("http://localhost:8080/eMembership/getMember/1", MemberDetails.class);
		
		System.out.println("Member Name: " + member.getName() + " Member Town: " + member.getTown());
		
	}
	
	@Test
	public void testUpdateMemberDetails() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MemberDetails member = restTemplate.getForObject("http://localhost:8080/eMembership/getMember/1", MemberDetails.class);
		
		System.out.println("Member Name: " + member.getName() + " Member Town: " + member.getTown());
		member.setTown("Irvine");
		
		restTemplate.put("http://localhost:8080/eMembership/getMember", member);
	
		System.out.println("Member Name: " + member.getName() + " Town Changed to: - " + member.getTown());
	}
	
	
	@Test
	public void testBatchUpdateMembers() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getForObject("http://localhost:8080/eMembership/batchUpdate", Object.class);
	}
	
	@Test
	public void testDeleteMember() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.delete("http://localhost:8080/eMembership/delete/4");
	}
	
	@Test
	public void testExceptionIsThrown() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getForObject("http://localhost:8080/eMembership/testException", Object.class);
	}
	
	/*@Ignore
	@Test
	public void testBatchResetPasswords() {
		
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("JM DEBUG test 1");
		restTemplate.getForObject("http://localhost:8080/eMembership/batchResetPasswords", Object.class);
	
		System.out.println("JM DEBUG test 2");
		//member.setPassword(encPassword("test1234"));
	
	}*/
	
	
	
}
