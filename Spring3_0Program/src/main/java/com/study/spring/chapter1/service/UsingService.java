package com.study.spring.chapter1.service;

import com.study.spring.chapter1.controller.Assembler;

public class UsingService {
	public void useService() {
		//...
		
		Assembler assembler = new Assembler();
		
		// 조립기로부터 사용할 객체를 구함
		WriteArticleServiceImpl service = assembler.getWriteArticleService();
		
		// service 사용
	}
}
