package com.study.spring.chapter1.service;

import com.study.spring.chapter1.controller.Article;
import com.study.spring.chapter1.dao.ArticleDao;

public class WriteArticleServiceImpl implements WriteArticleService{
	private ArticleDao articleDao;
	
	// 생성자에서 의존하는 객체를 전달받음
	public WriteArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void write(Article article) {
		
	}
}
