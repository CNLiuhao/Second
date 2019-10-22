<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/conmen-header.css"/>
<link rel="stylesheet" href="<%=basePath%>/static/css/reset.css" />
<link rel="stylesheet" href="<%=basePath%>/static/css/dlb.css" />
<link rel="stylesheet" href="<%=basePath%>/static/css/page-con.css" />
</head>
<body>

<div class="xtgl"> 
<a class="dall public" href="QueryServlet">用户管理</a>
<a class="chart dactive public" href="QueryAllCropServlet">类别管理</a>
<a class="mps public" href="">毒素管理</a>
</div>
<div class="user-content">
  <p class="user-admin"><span>当前页面 : </span><a href="QueryAllCropServlet" style="color: #58a0fd">类别管理</a></p>
  <div class="user-search">
    <p><a class="user-add" href="views/speciesadd.jsp">新增类别</a></p>
  </div>
  <table class = "user-info">
    <tr class="info-first info-item">
      <td>序号</td>
      <td>大类别名称</td>
      <td>操作</td>
    </tr>
    <tr class="info-item">
      <td>编号</td>
      <td>项目</td>
      <td><a class="edit">编辑</a><a onclick="delte('this')" class="delete">删除</a></td>
    </tr>
    <c:forEach items="${page.list }" var="crop">
    <tr class="info-item">
      <td>${crop.id }</td>
      <td>${crop.cropcategory }</td>
      <td><a href="SelectOneCrop?cropid=${crop.id }" class="edit">编辑</a><a onclick="delte(${crop.id})" class="delete">删除</a></td>
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
  <div class="page"> 
  </div>
</div>
<script type="text/javascript">
	  function delte(id){
	    if(confirm("你确定要删除吗？")){
	       window.location.href="DeleteCrop?id="+id;
	    }else{
	       return false;
	    }
	  }
	  function page(num){
			window.location.href="QueryAllCrop?pageNum="+num;
		}
	</script>
</body>

</html>
