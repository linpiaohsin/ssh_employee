<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<div class="pull-right">
	
	<s:form action="employee_search.action" namespace="/" method="post" cssStyle="float:left">
		<s:textfield cssClass="form-control" name="ename"/>
		<input type="submit" class="btn btn-info pull-right" value="精准查询" > 
	</s:form>
	<button class="btn " onclick="javascript:history.go(-1)" style="float:left"> 返回</button>
	<s:form action="employee_saveUI.action" namespace="/" method="post"  cssStyle="float:left">
		<input type="submit" class="btn btn-info pull-right" value="添加员工" > 
	
	</s:form>

</div>
<br/>

<p>查询结果如下:</p>
<table class="table table-bordered table-striped">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
</thead>
<tbody>
<s:form id="saveForm" action="employee_search" method="post" namespace="/" theme="simple">
	<tr>
		<td align="center"><s:property value="%{model.eno}"/></td>
		<td align="center"><s:property value="%{model.ename}"/></td>
		<td align="center"><s:property value="%{model.sex}"/></td>
		<td align="center"><s:date name="%{model.birthday}" format="yyyy-MM-dd"/></td>
		<td align="center"><s:date name="%{model.joinDate}" format="yyyy-MM-dd"/></td>
		<td align="center"><s:property value="%{model.department.dname}"/></td>
		<td align="center"><a href="${pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="%{model.eno}"/>"><input type="button" class="btn btn-info" value="修改"></input></a></td>
		<td align="center"><a href="${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="%{model.eno}"/>"><input type="button" class="btn btn-success" value="删除"></input></a></td>
	</tr>
</s:form>
</tbody>
</table>
<br/>


</body>
</html>