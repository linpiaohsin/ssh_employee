package com.org.employee.domain;

import java.util.List;

/*
 * ��ҳ��װ����
 */
public class PageBean<T> {
	private int currPage;	//��ǰҳ��
	private int pageSize;	//ÿҳ��ʾ�ļ�¼��
	private int totalCount; //�ܼ�¼��
	private int totalPage;	//��ҳ��
	private List<T> list;	//ÿҳ��ʾ������
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
