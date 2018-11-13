package com.emember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.emember.util.User;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("In the login method");

		return "login";
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		System.out.println("Login Failed");

		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error403(ModelMap model) {
		return "403";
	}
}

// try https://www.quora.com/How-do-I-pass-the-attribute-value-from-jsp-page-to-spring-controller#
// to get user/password 
//or
//https://www.quora.com/How-do-I-pass-the-attribute-value-from-jsp-page-to-spring-controller#
