package com.org.employee.service;

import java.util.List;

import com.org.employee.domain.Department;
import com.org.employee.domain.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
