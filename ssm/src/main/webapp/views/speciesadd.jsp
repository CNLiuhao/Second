<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增大类别</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/conmen-header.css"/>
<link rel="stylesheet" href="<%=basePath %>/static/css/reset.css" />
<link rel="stylesheet" href="<%=basePath %>/static/css/adddlb.css" />
</head>
<body>

<div class="xtgl"> <a class="dall user" href="superadmin.html">用户管理</a><a class="chart leibie dactive" href="categorylist.html">类别管理</a><a class="mps dusu" href="categorylist - dusu.html">毒素管理</a> </div>
<div class="user-content">
  <p class="user-admin"><span>当前页面 : </span><a href="dlb.html">大类别管理/</a><a href="adddlb.html">新增类别</a></p>
  <div class="user-add-infolist">
    <p class="user-add-title">新增类别</p>
    <form action="<%=basePath %>/InsertCropServlet" method="post" id="form3">
      <ul class="add-list">
        <li class="list-item">
        <input type="hidden" name="cropCategoryId" id="cropCategoryId" value="${cropCategoryId }"/>
          <label>类别名称</label>
          <input type="text" name="crop_species" id="speciesname" value="${cropSpecies.cropSpecies}"/>
        </li>
         <li class="list-item">
        <label>状态</label>
        <input type="radio" <c:if test="${cropSpecies.state == 1}">checked="checked"</c:if> name="state" value="1">
          启用
          <input type="radio" <c:if test="${cropSpecies.state == 0}">checked="checked"</c:if> name="state" value="0">
          禁用 <span id="state"></span> </li>
      <div class="add-option"> <a class="user-save" onclick="baocun()">保存</a><a class="add-back" onclick="history.go(-1)">返回</a> </div>
    </form>
  </div>
</div>
</body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	/*   function baocun(){
	   var speciesname=$("#speciesname").val();
	   var url="jiaoyanspecies";
	   var parms={"speciesname":speciesname};
	   $.post(url,parms,function(date){
	      var  name=JSON.parse(date);
	      if(name!=true){
	        document.forms[0].submit();
	      }else{
	        alert("该类别名已经存在！");
	        return false;
	      }
	   })
	    
	   }*/
	   function baocun(){
		   
		   document.getElementById("form3").submit();
	   }
	   
	</script>
</html>
