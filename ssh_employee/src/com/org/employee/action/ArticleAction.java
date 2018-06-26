package com.org.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.org.employee.domain.Article;
import com.org.employee.domain.Department;
import com.org.employee.domain.Employee;
import com.org.employee.domain.PageBean;
import com.org.employee.service.ArticleService;
import com.org.employee.service.EmployeeService;

public class ArticleAction extends ActionSupport  implements ModelDriven<Article>{
	private Article article = new Article();
	private int eno;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}

	private ArticleService articleService;
/*	public ArticleService getArticleService() {
		return articleService;
	}*/
	Employee employee= new Employee();
	EmployeeService employeeService;
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	//添加

	public String save() {
		employee=employeeService.findById(eno);
	/*	System.out.println(eno);*/
		article.setEmployee(employee);
	    articleService.save(article);
		return "saveSuccess";
	}

	public String saveUI() {
		return "saveUI";
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//查询 
	public String findAll() {
		PageBean<Article> pageBean = articleService.findByPage(currPage);
		//pageBean存入值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	// 特定某条通知详情
	public String findDetail() {
/*		System.out.println(article.getAid());*/
		article = articleService.findByID(article.getAid());
	
		return "findDetailSuccess";
	}
	public String  edit() {
		article = articleService.findById(article.getAid());
		return "editSuccess";
	}
	public String update() {
		employee=employeeService.findById(eno);
		/*	System.out.println(eno);*/
		article.setEmployee(employee);
		articleService.update(article);
		return "updateSuccess";
	}
	//删除
	public String delete() {
		//删除之前先查询是否有
		article = articleService.findById(article.getAid());
		articleService.delete(article);
		return "deleteSuccess";
	}
	//查询本人发布的
	public String  findMine() {
/*		System.out.println(eno);*/
		PageBean<Article> pageBean = articleService.findByEmpID(currPage,1);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findMine";
	}
}
