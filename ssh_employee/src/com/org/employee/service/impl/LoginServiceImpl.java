package com.org.employee.service.impl;

import com.org.employee.dao.LoginDao;
import com.org.employee.domain.Employee;
import com.org.employee.domain.Login;
import com.org.employee.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao loginDao;
	
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public Login login(Login login) {
		// TODO Auto-generated method stub
		
		Login existEmployee = loginDao.findByUsernameAndPassword(login);
		return existEmployee;
	}

}
