package com.org.employee.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.org.employee.domain.Department;
import com.org.employee.domain.Employee;
import com.org.employee.domain.PageBean;
import com.org.employee.service.DepartmentService;
import com.org.employee.service.EmployeeService;


public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//注入
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public String  findSal() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		/*ActionContext.getContext().getValueStack().pop();*/
		//将pageBean存入值栈中 
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findSal";
	}
	
	/*public String login() {
		System.out.println("login执行了...");

		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null) {
			this.addActionError("用户名或密码错误！");
			return INPUT;
		} else{

			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}*/
	

	private Integer currPage=1;
		
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//查询
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		/*ActionContext.getContext().getValueStack().pop();*/
		//将pageBean存入值栈中 
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	public String search() {
		employee = employeeService.findByName(employee.getEname());
		return "search";
	}
	 public String findBlur(){
		PageBean<Employee> pageBean = employeeService.findByPageBlur(currPage,employee.getEname());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findBlur";
		 
	 }


	public String saveUI() {
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "saveUI";
	}
	
	//添加员工
	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}

	//编辑员工
	public String edit() {
		//根据员工id查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有部门集合
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}
	
	//修改员工信息
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//删除员工
	public String delete() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
