package com.study.spring.chapter1.controller;

import com.study.spring.chapter1.dao.ArticleDao;
import com.study.spring.chapter1.dao.MySQLArticleDao;
import com.study.spring.chapter1.service.WriteArticleServiceImpl;

public class Assembler {
	public WriteArticleServiceImpl getWriteArticleService() {
		ArticleDao articleDao = new MySQLArticleDao();
		WriteArticleServiceImpl service = new WriteArticleServiceImpl(articleDao);
		
		return service;
	}
}
