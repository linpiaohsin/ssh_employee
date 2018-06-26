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
	//ģ������
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//ע��
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
		//��pageBean����ֵջ�� 
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findSal";
	}
	
	/*public String login() {
		System.out.println("loginִ����...");

		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null) {
			this.addActionError("�û������������");
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

	//��ѯ
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		/*ActionContext.getContext().getValueStack().pop();*/
		//��pageBean����ֵջ�� 
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
		//��ѯ���в���
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "saveUI";
	}
	
	//���Ա��
	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}

	//�༭Ա��
	public String edit() {
		//����Ա��id��ѯԱ��
		employee = employeeService.findById(employee.getEid());
		//��ѯ���в��ż���
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}
	
	//�޸�Ա����Ϣ
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//ɾ��Ա��
	public String delete() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
