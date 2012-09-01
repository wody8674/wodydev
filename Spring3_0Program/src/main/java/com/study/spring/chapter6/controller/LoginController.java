package com.study.spring.chapter6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.chapter6.service.AuthenticationException;
import com.study.spring.chapter6.service.Authenticator;
import com.study.spring.chapter6.vo.LoginCommand;

@Controller
@RequestMapping("/chapter6/login.do")
public class LoginController {
	/*
	private String formViewName = "chapter6/login";
	private Authenticator authenticator = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(LoginCommand loginCommand, BindingResult result) {
		
		new LoginValidator().validate(loginCommand, result);
		
		if (result.hasErrors()) {
			return formViewName;
		} 
		
		try {
			authenticator.authenticate(loginCommand);
			return "redirect:/chaptor6/form";
		} catch (AuthenticationException e) {
			result.reject("invalidIdOrPassword", new Object[] {loginCommand.getUserId()}, null);
			return formViewName;
		}
	}*/
}
