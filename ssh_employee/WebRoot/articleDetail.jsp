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
	

	<button class="btn " onclick="javascript:history.go(-1)" > 返回</button>
	<a href="${pageContext.request.contextPath}/article_edit.action?aid=<s:property value="%{model.aid}"/>"><input type="button" class="btn btn-info" value="修改"></button></a>
<a href="${pageContext.request.contextPath}/article_delete.action?aid=<s:property value="%{model.aid}"/>"><input type="button" class="btn btn-success" value="删除"></button></a>
	


</div>
<br/><br/><br/><br/>



<center>

<br/><br/>
<div><s:property value="%{model.title}"/></div><br/><br/>
<p>------------------------------------------------------------------------------------------------</p>
<br/><br/>
<div><s:property value="%{model.content}"/></div>

<br/><br/><br/><br/><br/><br/><br/><br/><br/>
<div>
发布者@<s:property value="%{model.employee.ename}"/><br>
发布时间@	<s:property value="%{model.createTime}"/>
</div>

<br/><br/><br/><br/>


</center>


</body>
</html>