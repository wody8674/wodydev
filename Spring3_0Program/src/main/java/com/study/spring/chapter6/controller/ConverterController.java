package com.study.spring.chapter6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chapter6/converter.do")
public class ConverterController {

	@RequestMapping(method=RequestMethod.POST)
	public String simpleTestForm() {
		return "chapter6/testform";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String simpleTestForm2(@RequestBody String body) {
		
		System.out.println(body);
		return "chapter6/testform";
	}
	
	
}
