package com.org.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.org.employee.dao.LoginDao;
import com.org.employee.domain.Employee;
import com.org.employee.domain.Login;
import com.org.employee.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao {
	private HibernateUtil hibernateUtil;
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	private Session session;
	@Override
	public Login findByUsernameAndPassword(Login login) {
		// TODO Auto-generated method stub
		String hql = "from Login where username=? and password=?";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql); 
		query.setParameter(0, login.getUsername());
		query.setParameter(1, login.getPassword());
		List<Login> lists = query.list(); 
		hibernateUtil.closeSession(session);
		if(lists.size() > 0) {
			return lists.get(0);
		}
		return null;
	}

}
