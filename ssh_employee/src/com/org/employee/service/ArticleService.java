package com.org.employee.service;

import com.org.employee.domain.Article;
import com.org.employee.domain.Employee;
import com.org.employee.domain.PageBean;

public interface ArticleService {

	PageBean<Article> findByPage(Integer currPage);

	void save(Article article);

	Article findByID(Integer aid);

	Article findById(Integer aid);

	void update(Article article);

	void delete(Article article);

	PageBean<Article> findByEmpID(Integer currPage, int eno);




	
}
