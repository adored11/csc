package com.emember.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.emember.model.Employee;
import com.emember.model.LoginAndDetails;
import com.emember.model.MemberDetails;
import com.emember.service.MemberService;

@Controller
// @SessionAttributes("memberDetails") //stores the below attributes with the
// session
public class MemberController {

	@Autowired
	private MemberService memberService;


	@RequestMapping(value = "/myDetails", method = RequestMethod.GET)
	public String myDetails(Model model) {
		MemberDetails memberDetailsModel = new MemberDetails();

		String userName = SecurityContextHolder.getContext().getAuthentication().getName().toString();
		System.out.println("JM DEBUG in controller, username = " + userName);
		if (userName.equals("admin")) {
			return "userAdminArea";
		} else {
		memberDetailsModel = memberService.getMember(userName);
		model.addAttribute("memberDetails", memberDetailsModel);
		
		// DEBUG
		System.out.println("myDetails Test: " + memberDetailsModel.getForename());
		System.out.println("myDetails Test: " + memberDetailsModel.getAddress_1());
		System.out.println("myDetails Test: " + memberDetailsModel.getMemberNo());
		System.out.println("memberDetailsModel :" + memberDetailsModel.getAddress_2());
		System.out.println("getStartDate :" + memberDetailsModel.getStartDate());
		System.out.println("getNextRenewalDate :" + memberDetailsModel.getNextRenewalDate());
		System.out.println("DOB :" + memberDetailsModel.getDob());
		
			return "myDetails";
		}
		
	}

	/*@RequestMapping(value = "/register", method = {RequestMethod.GET})
	public ModelAndView registration() {
		MemberDetails member = new MemberDetails();
		System.out.println("register Test1: " + member.getForename());
		return new ModelAndView("register", "member", new MemberDetails());
	}*/
	
	@RequestMapping(value = "/register", method = {RequestMethod.GET})
	public ModelAndView registration(ModelMap modelMap) {
		System.out.println("JM1");
		ModelAndView modelAndView=new ModelAndView();
		LoginAndDetails loginAndDetails = new LoginAndDetails();
		modelMap.addAttribute("loginAndDetails", loginAndDetails);
	    modelAndView.addAllObjects(modelMap);
	    modelAndView.setViewName("register");
	    System.out.println("JM2");
	    Map< String, String > months = new LinkedHashMap<String, String>();
		months.put("jan", "January");
		months.put("feb", "February");
		months.put("mar", "March");
		months.put("apr", "April");
		months.put("may", "May");
		months.put("jun", "June");
		months.put("jul", "July");
		months.put("aug", "August");
		months.put("sep", "September");
		months.put("oct", "October");
		months.put("nov", "November");
		months.put("dec", "December");
         
		modelAndView.addObject("monthsMap", months);

	    return modelAndView;
	}
	
	
	/*@RequestMapping(value = "/register", method = {RequestMethod.GET})
	public String registrationTest(Model model) {
		MemberDetails member = new MemberDetails();
		UserLogin userLogin = new UserLogin();
		model.addAttribute("membershipNo", member.getMemberNo());
		model.addAttribute("username", userLogin.getUserName());
		model.addAttribute("forename", member.getForename());
		model.addAttribute("surname", member.getSurname());
		model.addAttribute("address_1", member.getAddress_1());
		model.addAttribute("address_2", member.getAddress_2());
		model.addAttribute("town", member.getTown());
		model.addAttribute("postcode", member.getPostcode());
		model.addAttribute("email", member.getEmail());
		model.addAttribute("dob", member.getDob());
		model.addAttribute("telephone", member.getTelephone());
		model.addAttribute("startDate", member.getStartDate());
		model.addAttribute("nextRenewalDate", member.getNextRenewalDate());
		model.addAttribute("password", userLogin.getPassword());
		model.addAttribute("enabled", false);
		
		return "register";
	}*/

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
		renewDetails.getForename();
		renewDetails.getSurname();
		renewDetails.getAddress_1();
		renewDetails.getAddress_2();
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
	/*@RequestMapping(value = "/getMemberByUserName", method = RequestMethod.GET)
	public @ResponseBody MemberDetails getMember() {
		System.out.println("JM DEBUG getMember");
		String userName="john";
		return memberService.getMember(userName);
	}*/

	@RequestMapping(value = "/getAllMembers", method = RequestMethod.GET)
	public @ResponseBody List<MemberDetails> getAllMembers() {
		System.out.println("JM DEBUG getALLMember");
		return memberService.getAllMembers();
	}

	
	/*@RequestMapping(value = "/testCreateMember", method = RequestMethod.POST)
	public @ResponseBody List<LoginAndDetails> createMember(@RequestBody LoginAndDetails member) {
		System.out.println("JM DEBUG createMember username" + member.getMemberDetails().getUserName());
		return memberService.createMember(member); 
	}*/
	 

	@RequestMapping(value = "/createMember", method = RequestMethod.POST)
	public List<LoginAndDetails> createMember(@ModelAttribute LoginAndDetails member) {
		System.out.println("JM DEBUG createMember username" + member.getMemberDetails());
		return memberService.createMember(member);
	}

	@RequestMapping(value = "/getMember", method = RequestMethod.PUT)
	public @ResponseBody LoginAndDetails updateMember(@RequestBody LoginAndDetails member) {
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

	@RequestMapping(value = "/delete/{memberId}/{userName}", method = RequestMethod.DELETE)
	public @ResponseBody Object deleteMember(@PathVariable(value = "memberId") Integer memberId, 
			@PathVariable(value = "userName") String userName) {
		System.out.println("JM DEBUG controller id and user:" + memberId + ", " + userName);
		memberService.deleteMember(memberId, userName);
		return null;
	}

	@RequestMapping(value = "/testException", method = RequestMethod.GET)
	public @ResponseBody Object testException() {
		throw new DataAccessException("Testing Exception is thrown") {

		};

	}

	/*@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		System.out.println("JM In handle()");
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}*/

	@RequestMapping(value = "/getCurrentUserDetails", method = RequestMethod.GET)
	public @ResponseBody MemberDetails getCurrentUserDetails() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName().toString();
		return memberService.getMember(userName);

	}
	
	//https://www.baeldung.com/spring-mvc-form-tutorial  -for testing 
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("employeeHome", "employee", new Employee());
    }
 
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee")Employee employee, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "403";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employeeView";
    }
	

}
