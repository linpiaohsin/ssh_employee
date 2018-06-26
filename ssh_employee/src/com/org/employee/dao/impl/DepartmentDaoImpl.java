package com.org.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.org.employee.dao.DepartmentDao;
import com.org.employee.domain.Department;
import com.org.employee.domain.Employee;
import com.org.employee.util.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	private HibernateUtil hibernateUtil;
	private Session session;
	
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	//统计总数目
	public int findCount() {
		String hql = "select count(*) from Department";
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

	@SuppressWarnings("unchecked")
	@Override
	//查询每页显示的数据
	public List<Department> findByPage(int begin, int pageSize) {
		String hql = "from Department";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Department> list = query.list(); 
		hibernateUtil.closeSession(session);
		return list;
	}

	@Override
	//存储部门
	public void save(Department department) {
		session = hibernateUtil.getSession();
		session.save(department);
		hibernateUtil.closeSession(session);
	}

	@Override
	//根据部门id查询部门
	public Department findById(Integer did) {
		session = hibernateUtil.getSession();
		Department department = (Department) session.get(Department.class, did);
		hibernateUtil.closeSession(session);
		return department;
	}

	@Override
	//修改部门
	public void update(Department department) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(department);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	@Override
	//删除部门
	public void delete(Department department) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(department);
		transaction.commit(); 
		hibernateUtil.closeSession(session);
	}

	@Override
	//查询所有部门
	public List<Department> findAll() {
		String hql = "from Department";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Department> list = query.list(); 
		hibernateUtil.closeSession(session);
		return list;
	}
}
