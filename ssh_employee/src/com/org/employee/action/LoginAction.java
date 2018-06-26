package com.org.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.org.employee.domain.Employee;
import com.org.employee.domain.Login;
import com.org.employee.service.LoginService;

public class LoginAction extends ActionSupport implements ModelDriven<Login> {
	Login login = new Login();
	LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@Override
	public Login getModel() {
		// TODO Auto-generated method stub
		return login;
	}
	public String login() {
			Login existEmployee = loginService.login(login);
			if(existEmployee == null) {
				this.addActionError("用户名或密码错误！");
				return INPUT;
			} else{

				ActionContext.getContext().getSession().put("existEmployee", existEmployee);
				return SUCCESS;
			}
		}
}
