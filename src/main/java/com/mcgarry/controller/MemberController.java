package com.mcgarry.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mcgarry.model.MemberDetails;
import com.mcgarry.service.MemberService;
import com.mcgarry.util.ServiceError;
//http://localhost:8080/FitnessTracker/addGoal.html
@Controller
@SessionAttributes("memberDetails") 	//stores the below attributes with the session
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="renewMember", method=RequestMethod.GET)
	public String renewMember(Model model) {
		MemberDetails renewDetails = new MemberDetails();
		renewDetails.getMemberNo();
		renewDetails.getName();
		renewDetails.getSurname();
		renewDetails.getAddress1();
		renewDetails.getAddress2();
		renewDetails.getTown();
		renewDetails.getPostcode();
		renewDetails.getEmail();
		renewDetails.getDob();
		renewDetails.getTelephone();
		renewDetails.getStartDate();
		renewDetails.getNextRenewalDate();
		
		model.addAttribute("memberDetails", renewDetails);
		
		return "renewMember";
	}
	
	@RequestMapping(value="renewMember", method=RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("memberDetails") MemberDetails renewDetails, BindingResult result) {
		
		System.out.println("result has errors " + result.hasErrors());
		
		
		if(result.hasErrors()) {
			return "renewMember";
		}
		
		return "redirect:displayDetails.html";
	}
	
	@RequestMapping(value="/userAdminArea", method=RequestMethod.GET)
	public String updateMember(Model model) {
		MemberDetails renewDetails = new MemberDetails();
		renewDetails.getMemberNo();
		renewDetails.getName();
		renewDetails.getSurname();
		renewDetails.getAddress1();
		renewDetails.getAddress2();
		renewDetails.getTown();
		renewDetails.getPostcode();
		renewDetails.getEmail();
		renewDetails.getDob();
		renewDetails.getTelephone();
		renewDetails.getStartDate();
		renewDetails.getNextRenewalDate();
		
		model.addAttribute("memberDetailsAdmin", renewDetails);
		
		return "userAdminArea";
	}
	
	@RequestMapping(value = "/getMember/{memberId}", method = RequestMethod.GET)
	public @ResponseBody MemberDetails getMember(@PathVariable(value="memberId") Integer memberId) {
		return memberService.getMember(memberId);
	}
	
	@RequestMapping(value = "/getAllMembers", method = RequestMethod.GET)
	public @ResponseBody List<MemberDetails> getAllMembers() {
		return memberService.getAllMembers();
	}
	
	@RequestMapping(value = "/createMember", method = RequestMethod.POST)
	public @ResponseBody List<MemberDetails> createMember(@RequestBody MemberDetails member) {
		return memberService.createMember(member);
	}
	
	@RequestMapping(value = "/getMember", method = RequestMethod.PUT)
	public @ResponseBody MemberDetails updateMember(@RequestBody MemberDetails member) {
		return memberService.updateMember(member);
	}
	
	@RequestMapping(value = "/batchUpdate", method = RequestMethod.GET)
	public @ResponseBody Object batch() {
		memberService.batch();
		return null;
	}
	
	/*@RequestMapping(value = "/batchResetPasswords", method = RequestMethod.GET)
	public @ResponseBody Object batchResetPasswords() {
		System.out.println("JM DEBUG controller");
		memberService.batchResetPasswords();
		return null;
	}*/
	
	@RequestMapping(value = "/delete/{memberId}", method = RequestMethod.DELETE)
	public @ResponseBody Object deleteMember(@PathVariable(value="memberId") Integer memberId) {
		memberService.deleteMember(memberId);
		return null;
	}
	
	@RequestMapping(value = "/testException", method = RequestMethod.GET)
	public @ResponseBody Object testException() {
		throw new DataAccessException("Testing Exception is thrown") {
			
		};
		
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

}
