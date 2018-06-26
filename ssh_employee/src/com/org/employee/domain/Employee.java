package com.org.employee.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ա����ʵ��
 */
public class Employee {
	private Integer salary=0;//����
	private Integer eid;	//Ա��id
	private String ename;	//Ա������
	private String sex;		//Ա���Ա�
	private Date birthday;	//Ա������
	private Date joinDate;	//Ա����ְʱ��
	private String eno;		//Ա�����
	private String username;//�û���
	private String password;//Ա������
	private Set<Article> articles = new HashSet<Article>();
	//Ա�������Ĳ���
	private Department department;
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	
	
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
