package com.org.employee.service;

import com.org.employee.domain.Employee;
import com.org.employee.domain.PageBean;


public interface EmployeeService {

/*	Employee login(Employee employee);*/

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

	Employee findByName(String ename);

	PageBean<Employee> findByPageBlur(Integer currPage,String string);

}
