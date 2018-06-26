package com.org.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.employee.dao.DepartmentDao;
import com.org.employee.domain.Department;
import com.org.employee.domain.PageBean;
import com.org.employee.service.DepartmentService;
/**
 * 部门业务层的实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//注入
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//分页查询部门
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize =8;	//每页显示8条
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);	//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//保存部门
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	//根据部门id查询部门
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	//实现的部门更新
	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	//删除部门
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
}
