package com.study.spring.chapter6.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.study.spring.chapter6.vo.ValidatorVo;

public class MemberInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object validator, Errors error) {
		ValidatorVo valiVo = (ValidatorVo) validator;
		
		if (valiVo.getUserId() == null || valiVo.getUserId().trim().isEmpty()) {
			//System.out.println("userId required fail");
			error.rejectValue("userid", "required");
		}
		
		if (valiVo.getTitle() == null || valiVo.getTitle().trim().isEmpty()) {
			//System.out.println("title required fail");
			error.rejectValue("title", "required");
		}
	}

}
