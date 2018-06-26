<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head><jsp:include page="bootstrap.jsp"></jsp:include></head>
<body>
<p>编辑员工信息</p>





<br/>
<!-- action对应一个action标签，id对应提交时的对应关系 -->
<s:form id="saveForm" action="employee_update" method="post" namespace="/" theme="simple">
<!-- 隐藏域，指明修改的是哪个部门 -->
<s:hidden name="eid" value="%{model.eid}"></s:hidden>

	<table class="table">
		<tr>
		  <td  align="center">姓名：</td>
		  <td><s:textfield name="ename" value="%{model.ename}" cssClass="form-control"/></td>
		
		  <td  align="center">性别：</td>
		  <td><s:textfield name="sex" list="{'男','女'}" value="%{model.sex}" cssClass="form-control"/></td>
		</tr>
		<tr>
		<td align="center">阿里邮箱：</td>
		<td><s:textfield name="username" value="%{model.username}" cssClass="form-control"/></td>
		<td align="center">密码：</td>
		<td><s:password name="password"  value="%{model.password}" showPassword="true" cssClass="form-control"/></td>
	</tr>
	<tr>
		<td align="center">出生日期：</td>
		<td><input type="text" name="birthday" value="<s:date name="model.birthday" format="yyyy-MM-dd" />" cssClass="form-control"/></td>
		<td align="center">入职时间：</td>
		<td><input type="text" name="joinDate" value="<s:date name="model.joinDate" format="yyyy-MM-dd"/>" cssClass="form-control"/></td>
	</tr>
	
	<tr>
		<td align="center">所属部门：</td>
		<!-- 展示所有部门 -->
		<td><s:select name="department.did" list="list" value="%{model.department.did}" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"/></td>
		<td align="center">编号：</td>
		<td><s:textfield name="eno" value="%{model.eno}"/></td>
	</tr>
</table>
</s:form>
<center>
	<a href="javascript:document.getElementById('saveForm').submit()"><input type="button" class="btn btn-info" value="保存"/></a> &nbsp;&nbsp;
	<a href="javascript:history.go(-1)"><input type="button" class="btn btn-success" value="返回"/> </a>
</center>
</body>
</html> 