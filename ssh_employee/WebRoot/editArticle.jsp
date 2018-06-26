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


<br/>
<br/>
<!-- action对应一个action标签，id对应提交时的对应关系 -->
<s:form id="saveForm" action="article_update?eno=1" method="post" namespace="/" theme="simple">

<s:hidden name="aid" value="%{model.aid}"></s:hidden>
	<table class="table ">
		<tr>
		  <td>标题：</td>
		  <td><s:textfield name="title" value="%{model.title}" cssClass="form-control"/></td>
		</tr>
		<tr>
		  <td>内容：</td>
		
		
		  <td>
		     <s:textarea rows="5" cols="50" name="content" value="%{model.content}"  cssClass="form-control"></s:textarea>
		  </td>
		</tr>
	</table>
<center>
<a href="javascript:document.getElementById('saveForm').submit()"><input type="button" class="btn btn-info" value="保存"/></a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)"><input type="button" class="btn btn-success" value="返回"/></a>
</center>

</s:form>
</body>
</html> 