<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
		<head>
		<meta charset="UTF-8">
		<title>系统管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/conmen-header.css"/>
<link rel="stylesheet" href="<%=basePath %>/static/css/reset.css" />
<link rel="stylesheet" href="<%=basePath %>/static/css/user-management-index.css" />
<link rel="stylesheet" href="<%=basePath %>/static/css/page-con.css" />
<script src="<%=basePath %>/static/js/jquery-1.11.0.min.js"></script>

<script type="text/javascript">
	function sousuo(){
		var name = document.getElementById("username").value;
		window.location.href="QueryAll?username="+name;
	
	}
	function page(num){
		var name = document.getElementById("username").value;
		window.location.href="QueryAll?username="+name + "&pageNum="+num;
	}
</script>
</head>
<body>
<div class="xtgl"> 
<a class="dall dactive public" href="QueryServlet">用户管理</a>
<a class="chart public" href="QueryAllCrop">类别管理</a>
<a class="mps public" href="categorylist - dusu.html">毒素管理</a>
</div>
<div class="user-content">
 <p class="user-admin"><span>当前页面 : </span><a href="QueryServlet">用户管理</a></p>
  <div class="user-search">
    <label>用户名</label>
    <input type="text" name="username" id = "username" value="${username }">
    <a onclick="sousuo()" class="search-btn">搜索</a> <a class="user-add" href="addusermes">新增用户</a> </div>
  <table class = "user-info">
    <tr class="info-first info-item">
      <td>序号</td>
      <td>登录名</td>
      <!-- <td>密码</td> -->
      <td>用户名</td>
      <td>角色</td>
      <td>创建时间</td>
      <td>创建人</td>
      <td>状态</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${page.list}" var = "user">
    <tr class="info-item">
      <td>${user.id }</td>
      <td>${user.loginName }</td>
      <td>${user.username }</td>
      <td>${user.roles.chrole }</td>
      <td>${user.createTime }</td>
      <!-- 1系统管理员，2信息管理员，3客户管理员，4信息权限管理员，5客户 -->
      <td>${user.users.cteateName}</td>
      <td><c:if test="${user.state == 1}">启用</c:if><c:if test="${user.state == 0}">禁用</c:if></td>
      <td><a href="SelectOne?id=${user.id}" class="edit">编辑</a><a href="DeleteUser?id=${user.id}"  class="delete">删除</a></td>
    </tr>
   </c:forEach>
   </table>
  <div class="pageing-con">
    <ul class="pageing-info">
      <li class="pageing-item head"><a data-id="" onclick="page(1)"  title="">首页</a></li>
      <li class="pageing-item prev"><a data-id="" onclick="page(${page.pageNum==1?1:page.pageNum-1 })"  title="">上一页</a></li>
    	<c:if test="${page.pages <=5}" >
    		<c:forEach begin="1" end="${page.pages }" var="i">
    	    	<li class="pageing-item  disabled <c:if test="${i==page.pageNum }">active</c:if>"> <a data-id="2" onclick="page(${i})"  title="">${i}</a></li>
    		</c:forEach>
    	</c:if>
    	<c:if test="${page.pages >5 }">
	    	<c:if test="${page.pageNum+4 <=page.pages }">
	    		<c:forEach begin="${page.pageNum }" end="${page.pageNum+4 }" var="i">
	    		    	<li class="pageing-item  disabled <c:if test="${i == page.pageNum }">active</c:if>" > <a data-id="2" onclick="page(${i})"  title="">${i }</a> </li>
	    		</c:forEach>
	    	</c:if>
	    	<c:if test="${page.pageNum+4 >page.pages }">
	    		<c:forEach begin="${page.pages-4 }" end="${page.pages }" var="i">
	    		    	<li class="pageing-item  disabled <c:if test="${i == page.pageNum }">active</c:if> " > <a data-id="2" onclick="page(${i})"  title="">${i }</a> </li>
	    		</c:forEach>
	    	</c:if>
    	</c:if>
      <li class="pageing-item next"><a data-id="" onclick="page(${page.pageNum==page.pages?page.pages:page.pageNum+1 })" title="">下一页</a></li>
      <li class="pageing-item foot"><a data-id="" onclick="page(${page.pages})"  title="">尾页</a></li>
    </ul>
    </div>
</div>

</body>


</html>
