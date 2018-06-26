package com.org.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.org.employee.domain.Department;
import com.org.employee.domain.PageBean;
import com.org.employee.service.DepartmentService;


public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//ģ������ʹ�õĶ���
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	//ע��
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//��ҳ����
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//�ṩ��ѯ�ķ���
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//��pageBean����ֵջ��
	/*	ActionContext.getContext().getValueStack().pop();*/
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//��Ӳ��ţ�Ԥ�ȣ�
	public String saveUI() {
		return "saveUI";
	}
	
	//��Ӳ���
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//�༭����
	public String edit() {
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//�޸Ĳ���
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//ɾ������
	public String delete() {
		//ɾ��֮ǰ�Ȳ�ѯ�Ƿ��иò���
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	
}
