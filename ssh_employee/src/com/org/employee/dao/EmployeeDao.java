package com.org.employee.dao;

import java.util.List;

import com.org.employee.domain.Department;
import com.org.employee.domain.Employee;


public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

	Employee findByName(String ename);

	List<Employee> findByPageBlur(int begin, int pageSize,String string);
	
}
