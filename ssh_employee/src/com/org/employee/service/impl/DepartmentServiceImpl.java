package com.org.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.employee.dao.DepartmentDao;
import com.org.employee.domain.Department;
import com.org.employee.domain.PageBean;
import com.org.employee.service.DepartmentService;
/**
 * ����ҵ����ʵ����
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//ע��
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//��ҳ��ѯ����
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize =8;	//ÿҳ��ʾ8��
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);	//����ȡ��
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//���沿��
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	//���ݲ���id��ѯ����
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	//ʵ�ֵĲ��Ÿ���
	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	//ɾ������
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
}
