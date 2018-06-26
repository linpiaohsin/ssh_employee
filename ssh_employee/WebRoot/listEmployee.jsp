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
	<s:form action="employee_findBlur.action" namespace="/" method="post" cssStyle="float:left">
		<s:textfield cssClass="form-control" name="ename"/>
		<input type="submit" class="btn btn-info pull-right" value="模糊查询" > 
	</s:form>
	<input type="submit" class="btn btn-info pull-right" value="打印" onclick="window.print();" > 
	<s:form action="employee_saveUI.action" namespace="/" method="post"  cssStyle="float:left">
		<input type="submit" class="btn btn-info pull-right" value="添加员工" > 
	
	</s:form>

</div>
<br/>


<table class="table table-bordered table-striped">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">阿里邮箱账号</td>
<td align="center">密码</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
</thead>
<tbody>
<s:iterator value="list" var="e">
	<tr>
		<td align="center"><s:property value="#e.eno"/></td>
		<td align="center"><s:property value="#e.ename"/></td>
		<td align="center"><s:property value="#e.sex"/></td>
		<td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
		<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
		<td align="center"><s:property value="#e.department.dname"/></td>
		<td align="center"><s:property value="#e.username"/></td>
		<td align="center"><s:property value="#e.password"/></td>
		<td align="center"><a href="${pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="#e.eid"/>"><input type="button" class="btn btn-info" value="修改"></input></a></td>
		<td align="center"><a href="${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"/>"><input type="button" class="btn btn-success" value="删除"></input></a></td>
	</tr>
</s:iterator>
</tbody>
</table>
<br/>

<table table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
   <span class="pull-right">总记录数：<s:property value="totalCount" /></span>&nbsp;&nbsp;
   <span>
	   <s:if test="currPage != 1">
	       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=1">首页</a>&nbsp;&nbsp;
	       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage-1"/>">上一页</a>&nbsp;&nbsp;
	   </s:if>
	   <s:if test="currPage != totalPage">
	       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage+1"/>">下一页</a>&nbsp;&nbsp;
	       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="totalPage"/>">尾页</a>&nbsp;&nbsp;
	   </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>