package com.org.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.employee.dao.EmployeeDao;
import com.org.employee.domain.Department;
import com.org.employee.domain.Employee;
import com.org.employee.domain.PageBean;
import com.org.employee.service.EmployeeService;

/**
 * Ա�������ʵ����
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	//ע��DAO��Ķ���
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	//��½����
	/*@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}*/
	
	@Override
	//ҵ���ʵ�ַ�ҳ��ѯ�Ĺ���
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize =8;	//ÿҳ��ʾ8��
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);	//����ȡ��
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage - 1)*pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//Ա���ı���
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}

	@Override
	//����Ա��id��ѯԱ��
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	//ɾ��Ա��
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

	@Override
	public Employee findByName(String ename) {
		// TODO Auto-generated method stub
		return employeeDao.findByName(ename);
	}
	PageBean<Employee> pageBean = new PageBean<Employee>();
	@Override
	public PageBean<Employee> findByPageBlur(Integer currPage,String string) {
				//��װ��ǰҳ��
				pageBean.setCurrPage(currPage);
				//��װÿҳ��ʾ�ļ�¼��
				int pageSize =10;	//ÿҳ��ʾ10��
				pageBean.setPageSize(pageSize);
				//��װ�ܼ�¼��
				int totalCount = employeeDao.findCount();
				pageBean.setTotalCount(totalCount);
				//��װ��ҳ��
				double tc = totalCount;
				Double num = Math.ceil(tc/pageSize);	//����ȡ��
				pageBean.setTotalPage(num.intValue());
				//��װÿҳ��ʾ������
				int begin = (currPage - 1)*pageSize;
				List<Employee> list = employeeDao.findByPageBlur(begin, pageSize,string);
				pageBean.setList(list);
				return pageBean;
	}

}
