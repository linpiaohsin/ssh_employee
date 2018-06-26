package com.org.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.employee.dao.ArticleDao;
import com.org.employee.domain.Article;
import com.org.employee.domain.Department;
import com.org.employee.domain.Employee;
import com.org.employee.util.HibernateUtil;

public class ArticleDaoImpl implements ArticleDao{
	private HibernateUtil hibernateUtil;
	private Session session;

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Article";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		int count = ((Long) query.setCacheable(true).uniqueResult()).intValue();
		hibernateUtil.closeSession(session);
		if(count > 0 ) {
			//System.out.println(count);
			return count;
		}
		
		return 0;
	}

	@Override
	public List<Article> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Article";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		//按参数位置绑定查询条件
	
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Article> list = query.list(); 
		hibernateUtil.closeSession(session);
		return list;
	}
	@Override
	public void save(Article article) {
		// TODO Auto-generated method stub
		session = hibernateUtil.getSession();
		session.save(article);
		hibernateUtil.closeSession(session);
		
	}
	@Override
	public Article findById(Integer aid) {
		// TODO Auto-generated method stub
		session = hibernateUtil.getSession();
		Article article = (Article) session.get(Article.class, aid);
		hibernateUtil.closeSession(session);
		return article;
	}
	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(article);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}
	@Override
	public void delete(Article article) {
		// TODO Auto-generated method stub
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(article);
		transaction.commit(); 
		hibernateUtil.closeSession(session);
	}
	@Override
	public List<Article> findByByEmpID(int begin, int pageSize, int eno) {
		// TODO Auto-generated method stub
		String hql = "from Article where eno = "+eno;
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Article> list = query.list(); 
		hibernateUtil.closeSession(session);
		return list;
	}

}
