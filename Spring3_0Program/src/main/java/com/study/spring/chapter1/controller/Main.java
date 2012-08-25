package com.study.spring.chapter1.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.study.spring.chapter1.service.WriteArticleService;

public class Main {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("/com/study/spring/chapter1/applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		
		WriteArticleService articleService = (WriteArticleService) beanFactory.getBean("writeArticleService");
		articleService.write(new Article());
		
		System.out.println(articleService);
	}

}
