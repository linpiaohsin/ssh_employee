package com.org.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.org.employee.dao.EmployeeDao;
import com.org.employee.domain.Department;
import com.org.employee.domain.Employee;
import com.org.employee.util.HibernateUtil;
/**
 * 员工管理的DAO的实现
 */
public class EmployeeDaoImpl implements EmployeeDao {
	
	private HibernateUtil hibernateUtil;
	private Session session;
	
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username=? and password=?";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql); 
		query.setParameter(0, employee.getUsername());
		query.setParameter(1, employee.getPassword());
		List<Employee> lists = query.list(); 
		hibernateUtil.closeSession(session);
		if(lists.size() > 0) {
			return lists.get(0);
		}
		return null;
	}

	@Override
	//查询总的数目
	public int findCount() {
		String hql = "select count(*) from Employee";
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
	//按页查询每页显示的数据
	public List<Employee> findByPage(int begin, int pageSize) {
		String hql = "from Employee";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Employee> list = query.list(); 
		hibernateUtil.closeSession(session);
		return list;
	}

	@Override
	//保存员工
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		//根据部门id分发工资
		int did = employee.getDepartment().getDid();
		if(did==124){
			employee.setSalary(8000);
		}else if(did == 125){
			employee.setSalary(7000);
		}else if(did == 126){
			employee.setSalary(9000);
		}else if(did == 130){
			employee.setSalary(6000);
		}else if(did == 135){
			employee.setSalary(6000);
		}else {
			employee.setSalary(5000);
		}				
		session = hibernateUtil.getSession();
		session.save(employee);
		hibernateUtil.closeSession(session);
	}

	@Override
	//DAO中根据员工id查询员工
	public Employee findById(Integer eid) {
		session = hibernateUtil.getSession();
		Employee employee = (Employee) session.get(Employee.class, eid);
		hibernateUtil.closeSession(session);
		return employee;
	}
	//根据姓名查找
	@Override
	public Employee findByName(String ename) {
		// TODO Auto-generated method stub
		String hql = "from Employee where ename=? ";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql); 
		query.setParameter(0, ename);
	
		List<Employee> lists = query.list(); 
		hibernateUtil.closeSession(session);
		if(lists.size() > 0) {
			return lists.get(0);
		}
		return null;
	}
	@Override
	//修改员工信息
	public void update(Employee employee) {
		/*System.out.println(employee.getDepartment().getDid()); */
		int did = employee.getDepartment().getDid();
		if(did==124){
			employee.setSalary(8000);
		}else if(did == 125){
			employee.setSalary(7000);
		}else if(did == 126){
			employee.setSalary(9000);
		}else if(did == 130){
			employee.setSalary(6000);
		}else if(did == 135){
			employee.setSalary(6000);
		}else {
			employee.setSalary(5000);
		}
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	@Override
	//删除员工的方法
	public void delete(Employee employee) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(employee);
		transaction.commit(); 
		hibernateUtil.closeSession(session);
	}
	//模糊查询雇员
	@Override
	public List<Employee> findByPageBlur(int begin, int pageSize,String string) {
		// TODO Auto-generated method stub
		String hql = "from Employee as a where a.ename like :name";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		query.setString("name", "%"+string+"%");
		List<Employee> list = query.list(); 
		hibernateUtil.closeSession(session);
		return list;
	}
	
}
