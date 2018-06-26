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

<div>发表通知</div>
<!-- action对应一个action标签，id对应提交时的对应关系 -->
<s:form id="saveForm" action="article_save?eno=1"  method="post" namespace="/" theme="simple">
	<table class="table ">
		<tr>
		  <td>标题：</td>
		  <td><s:textfield name="title"  cssClass="form-control"/></td>
		</tr>
		<tr>
		  <td>内容：</td>	
		  <td>
		     <s:textarea rows="5" cols="50" name="content" cssClass="form-control"></s:textarea>
		  </td>
	


		</tr>
		
	</table>
</s:form>
<center>
	<s:property value="#session.existEmployee.eid"/>
	<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
	<a href="javascript:history.go(-1)">退回 </a>
</center>
</body>
</html> 