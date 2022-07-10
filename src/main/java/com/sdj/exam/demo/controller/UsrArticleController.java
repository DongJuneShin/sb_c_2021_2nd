package com.sdj.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdj.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	private int articlesLastId;
	private List<Article> articles;
	
	public UsrArticleController() {
		articlesLastId=0;
		articles= new ArrayList<>();
	}
	
	@RequestMapping("/usr/article/doGet")
	@ResponseBody
	public Article doGet(String title, String body) {
		int id=articlesLastId+1;
		Article article= new Article(id, title, body);
		
		articles.add(article);
		articlesLastId=id;
		
		return article;
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
	
		return articles;
	}
}