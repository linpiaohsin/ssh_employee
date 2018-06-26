<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<script type="text/javascript">
	function dothings(){
	  var txt1=document.getElementById("username");
	  var txt2=document.getElementById("password");
	  txt1.value="";
	  txt2.value="";
	  txt1.focus();
	  txt2.focus();
	 }
</script>

<title>登陆</title>

<jsp:include page="bootstrap.jsp"></jsp:include>
</head>

<body >

<div align="center" >
<br>
	   	<h1>人事管理系统(乞丐版)</h1>
	   	<br>	<br>	<br>	<br>	<br>	
	<div style="width:500px">
         
		<s:form action="login_login" method="post" namespace="/">
			<p style="color:red;"><s:actionerror/></p>
				<table class="table " >
					<tr>
						<td style="font-size:17px">用户名:</td>
						<td><input type="text" class="form-control" name="username"  id="username"></td>
					</tr>
					
					<tr>
						<td  style="font-size:17px">密&nbsp&nbsp&nbsp码:</td>
						<td><input type="password" class="form-control" name="password" id="password"></td>
						
					</tr>
					<tr>
						<td colspan="2"  align="center">
						<br>
							<input type="submit" value="登录" class=" btn btn-info" >
							<input type="button" value="重置" class=" btn btn-success"  onclick="dothings()">
						</td>
					</tr >
				</table>
			
		
		</s:form>
	</div>
</div>

</body>

</html>

