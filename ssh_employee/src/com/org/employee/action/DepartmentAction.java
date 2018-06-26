package com.org.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.org.employee.domain.Department;
import com.org.employee.domain.PageBean;
import com.org.employee.service.DepartmentService;


public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//模型驱动使用的对象
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	//注入
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//分页功能
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//提供查询的方法
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入值栈中
	/*	ActionContext.getContext().getValueStack().pop();*/
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//添加部门（预先）
	public String saveUI() {
		return "saveUI";
	}
	
	//添加部门
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//编辑部门
	public String edit() {
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//修改部门
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//删除部门
	public String delete() {
		//删除之前先查询是否有该部门
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	
}
