<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<jsp:include page="bootstrap.jsp"></jsp:include>
<title></title>

<script type="text/javascript" src="dtree.js"></script>
</head>

<body>
<div>
	 
	 	  <div>
	 	  	<span class="" style="font-size:20px"> 欢迎您：<s:property value="#session.existEmployee.username"/></span>
		  </div>
		  <br>
		  <!-- <form class="navbar-form navbar-right" role="search">
			  <div class="form-group">
			    <input type="text" class="form-control" placeholder="Search">
			  </div>
	  		  <button type="submit" class="btn btn-default">Submit</button>
		  </form> -->

	
	<div class="dtree" style="clear: both;float:left">
  	<script type="text/javascript">
    d=new dTree('d');

    d.add('01','-1','人事管理系统');
    d.add('0101','01','人事部');
    d.add('010101','0101','部门管理','${pageContext.request.contextPath}/department_findAll.action','','show_info');
    d.add('010102','0101','员工管理','${pageContext.request.contextPath}/employee_findAll.action','','show_info');
    d.add('010103','0101','薪酬管理','${pageContext.request.contextPath}/employee_findSal.action','','show_info');  
    d.add('0102','01','通知公告发布','${pageContext.request.contextPath}/article_findAll.action','','show_info');
    
    document.write(d);
  	</script>
	</div>
  
    <iframe  style=" clear: both ; width: 1380px ; height: 700px"  frameborder="no" border="0" name = "show_info" >
    
	</iframe> 
</div>


</body>

</html>

