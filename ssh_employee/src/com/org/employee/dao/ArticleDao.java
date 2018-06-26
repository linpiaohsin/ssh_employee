package com.org.employee.dao;

import java.util.List;

import com.org.employee.domain.Article;

public interface ArticleDao {

	int findCount();

	List<Article> findByPage(int begin, int pageSize);

	void save(Article article);

	Article findById(Integer aid);

	void update(Article article);

	void delete(Article article);

	List<Article> findByByEmpID(int begin, int pageSize, int eno);

}
