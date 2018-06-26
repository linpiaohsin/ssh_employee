package com.org.employee.service.impl;

import java.util.List;

import com.org.employee.dao.ArticleDao;
import com.org.employee.domain.Article;
import com.org.employee.domain.Department;
import com.org.employee.domain.Employee;
import com.org.employee.domain.PageBean;
import com.org.employee.service.ArticleService;
import com.sun.accessibility.internal.resources.accessibility;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDao articleDao ;
	
	public ArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public PageBean<Article> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Article> pageBean = new PageBean<Article>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize =8;	//每页显示8条
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = articleDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);	//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1)*pageSize;
		List<Article> list = articleDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Article article) {
		// TODO Auto-generated method stub
		articleDao.save(article);
		
	}

	@Override
	public Article findByID(Integer aid) {
		// TODO Auto-generated method stub
		return articleDao.findById(aid);
	}

	@Override
	public Article findById(Integer aid) {
		// TODO Auto-generated method stub
		return articleDao.findById(aid);
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		articleDao.update(article);
	}

	@Override
	public void delete(Article article) {
		// TODO Auto-generated method stub
		articleDao.delete(article);
	}
	PageBean<Article> pageBean = new PageBean<Article>();
	@Override
	public PageBean<Article> findByEmpID(Integer currPage, int eno) {
		// TODO Auto-generated method stub
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize =10;	//每页显示10条
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = articleDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);	//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1)*pageSize;
		List<Article> list = articleDao.findByByEmpID(begin, pageSize,eno);
		pageBean.setList(list);
		return pageBean;
	}



}
