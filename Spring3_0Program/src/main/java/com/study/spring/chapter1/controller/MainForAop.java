package com.study.spring.chapter1.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.chapter1.service.WriteArticleService;

public class MainForAop {

	public static void main(String[] args) {
		
		String[] configLocations = new String[] { "../applicationContext.xml", "../commonConcern.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		
		WriteArticleService articleService = (WriteArticleService) context.getBean("writeArticleService");
		
		articleService.write(new Article());
	}
}
