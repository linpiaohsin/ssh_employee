package com.org.employee.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Article {
		Employee employee;
		Integer aid;//���ӱ��
		String title;//���ӱ���
		String content;//��������
	/*	List<String> comment = new ArrayList<String>()  ;//����
*/		Timestamp createTime = new Timestamp(System.currentTimeMillis());;//���·���ʱ��

		public Timestamp getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Timestamp createTime) {
			this.createTime = createTime;
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		public Integer getAid() {
			return aid;
		}
		
	/*	public List<String> getComment() {
			return comment;
		}
		public void setComment(List<String> comment) {
			this.comment = comment;
		}*/
		public void setAid(Integer aid) {
			this.aid = aid;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
}
