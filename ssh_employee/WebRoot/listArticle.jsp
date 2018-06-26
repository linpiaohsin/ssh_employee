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
<form action="article_saveUI.action" namesapce="/"  method="post" style="float: left">
<input type="submit" value="发布通知"  class="btn btn-info">
</form>
<form action="article_findMine.action?eno=1" namesapce="/"  method="post" style="float: left">
<input type="submit" value="我发布的"  class="btn btn-success">
</form>
</div>
<br/>
<table class="table table-bordered table-striped">
<thead>
   <tr align="center">
    	<td >标题</td>
    	<td>内容</td>
		<td>发布时间</td>
   		
   </tr>
</thead>
<tbody>
<s:iterator value="list" var="a">
	<tr>
		<td align="center"><a href="${pageContext.request.contextPath }/article_findDetail.action?aid=<s:property value="#a.aid"/>"><s:property value="#a.title"/></a></td>
		<td align="center"><s:property value="#a.content"></s:property></td>
		<td align="center"><s:property value="#a.createTime"></s:property></td>
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
       <a href="${pageContext.request.contextPath }/article_findAll.action?currPage=1">首页</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/article_findAll.action?currPage=<s:property value="currPage-1"/>">上一页</a>&nbsp;&nbsp;
   </s:if>
   <s:if test="currPage != totalPage">
       <a href="${pageContext.request.contextPath }/article_findAll.action?currPage=<s:property value="currPage+1"/>">下一页</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/article_findAll.action?currPage=<s:property value="totalPage"/>">尾页</a>&nbsp;&nbsp;
   </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>