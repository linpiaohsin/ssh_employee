package com.org.employee.dao;

import com.org.employee.domain.Login;

public interface LoginDao {

	Login findByUsernameAndPassword(Login login);

}
