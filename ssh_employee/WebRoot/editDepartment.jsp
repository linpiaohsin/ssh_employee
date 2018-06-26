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
<p>新增部门</p>



<br/>
<!-- action对应一个action标签，id对应提交时的对应关系 -->
<s:form id="saveForm" action="department_update" method="post" namespace="/" theme="simple">
<!-- 隐藏域，指明修改的是哪个部门 -->
<s:hidden name="did" value="%{model.did}"></s:hidden>
	<table class="table">
		<tr>
		  <td>部门名称：</td>
		  <td><s:textfield name="dname" value="%{model.dname}" cssClass="form-control"/></td>
		</tr>
		<tr>
		  <td>部门介绍：</td>


	
		  
		  <td>
		     <s:textarea rows="5" cols="50" name="ddesc" value="%{model.ddesc}" cssClass="form-control"></s:textarea>
		  </td>
		</tr>
	</table>
<center>	
	<a href="javascript:document.getElementById('saveForm').submit()"><input type="button" class="btn btn-info" value="保存"/></a> &nbsp;&nbsp;
	<a href="javascript:history.go(-1)"><input type="button" class="btn btn-success" value="返回"/> </a>
</center>
</s:form>
</body>
</html> 