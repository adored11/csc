package com.mcgarry.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mcgarry.model.MemberDetails;
import com.mcgarry.model.Person;
import com.mcgarry.model.User;

import com.mcgarry.service.MemberService;
import com.mcgarry.service.PersonService;
import com.mcgarry.util.ServiceError;

@Controller
// @SessionAttributes("memberDetails") //stores the below attributes with the
// session
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
    PersonService personservice;
	
	

	@RequestMapping(value = "/myDetails", method = RequestMethod.GET)
	public String myDetails(Model model) {
		MemberDetails memberDetailsModel = new MemberDetails();

		String userName = SecurityContextHolder.getContext().getAuthentication().getName().toString();
		memberDetailsModel = memberService.getMember(userName);
		model.addAttribute("memberDetails", memberDetailsModel);
		
		//DEBUG
		System.out.println("myDetails Test: " + memberDetailsModel.getName());
		System.out.println("myDetails Test: " + memberDetailsModel.getAddress1());
		System.out.println("myDetails Test: " + memberDetailsModel.getMemberNo());
		System.out.println("memberDetailsModel :" + memberDetailsModel.getAddress2());
		System.out.println("getStartDate :" + memberDetailsModel.getStartDate());
		System.out.println("getNextRenewalDate :" + memberDetailsModel.getNextRenewalDate());
		
		return "myDetails";
	}
	
	@RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String sendWithAttach(ModelMap model,@ModelAttribute("info") Person info, BindingResult br) {
		Person personDetails = new Person();
		System.out.println("register Test1: " + personDetails.getName());
      
     if (!br.hasErrors())
        {
    	 System.out.println("register Test2: " + personDetails.getName());
         //Person saveData = personservice.save(info);
         //model.addAttribute("saveData",saveData);
        }
     
     System.out.println("register Test3: " + personDetails.getName());
    // return "renewMember";
     return "register";
 }

	/*
	 * @RequestMapping(value="renewMember", method=RequestMethod.POST) public String
	 * updateGoal(@Valid @ModelAttribute("memberDetails") MemberDetails
	 * renewDetails, BindingResult result) {
	 * 
	 * System.out.println("result has errors " + result.hasErrors());
	 * 
	 * 
	 * if(result.hasErrors()) { return "renewMember"; }
	 * 
	 * return "redirect:displayDetails.html"; }
	 */

	@RequestMapping(value = "/userAdminArea", method = RequestMethod.GET)
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
	

	
	
	

	@RequestMapping(value = "/getMember/{userName}", method = RequestMethod.GET)
	public @ResponseBody MemberDetails getMember(@PathVariable(value = "userName") String userName) {
		System.out.println("JM DEBUG getMember");
		return memberService.getMember(userName);
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

	/*
	 * @RequestMapping(value = "/batchResetPasswords", method = RequestMethod.GET)
	 * public @ResponseBody Object batchResetPasswords() {
	 * System.out.println("JM DEBUG controller");
	 * memberService.batchResetPasswords(); return null; }
	 */

	@RequestMapping(value = "/delete/{memberId}", method = RequestMethod.DELETE)
	public @ResponseBody Object deleteMember(@PathVariable(value = "memberId") Integer memberId) {
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

	@RequestMapping(value = "/getCurrentUserDetails", method = RequestMethod.GET)
	public @ResponseBody MemberDetails getCurrentUserDetails() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName().toString();
		return memberService.getMember(userName);

	}

}
