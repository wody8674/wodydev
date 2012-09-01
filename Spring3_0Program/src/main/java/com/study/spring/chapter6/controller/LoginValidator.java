package com.study.spring.chapter6.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.study.spring.chapter6.vo.LoginCommand;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object object, Errors error) {
		
		LoginCommand memberInfo = (LoginCommand) object;
		
		if (memberInfo.getUserId() == null || memberInfo.getUserId().trim().isEmpty()) {
			error.rejectValue("userId", "userId.required");
		}
		
		if (memberInfo.getPassword() == null || memberInfo.getPassword().trim().isEmpty()) {
			error.rejectValue("password", "password.required");
		}
		
	}

}
