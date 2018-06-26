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
<form action="department_saveUI.action" namesapce="/"  method="post">
<input type="submit" value="新增部门"  class="btn btn-info">
</form>
</div>
<br/>
<table class="table table-bordered table-striped">
<thead>
   <tr align="center">
    	<td >部门名称</td>
    	<td>部门简介</td>
   		<td >编辑</td>
   		<td  >删除</td>
   </tr>
</thead>
<tbody>
<s:iterator value="list" var="d">
	<tr>
		<td align="center"><s:property value="#d.dname"/></td>
		<td align="center"><s:property value="#d.ddesc"></s:property></td>

		<td align="center"><a href="${pageContext.request.contextPath}/department_edit.action?did=<s:property value="#d.did"/>"><input type="button" class="btn btn-info" value="修改"></button></a></td>
		<td align="center"><a href="${pageContext.request.contextPath}/department_delete.action?did=<s:property value="#d.did"/>"><input type="button" class="btn btn-success" value="删除"></button></a></td>
	</tr>
</s:iterator>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
   <span>总记录数：<s:property value="totalCount"/>&nbsp;&nbsp;</span>&nbsp;&nbsp;
   <span>
   <s:if test="currPage != 1">
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=1">首页</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage-1"/>">上一页</a>&nbsp;&nbsp;
   </s:if>
   <s:if test="currPage != totalPage">
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage+1"/>">下一页</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="totalPage"/>">尾页</a>&nbsp;&nbsp;
   </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>