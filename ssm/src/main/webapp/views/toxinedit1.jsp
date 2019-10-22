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
<title>修改用户</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/conmen-header.css"/>
<link rel="stylesheet" href="<%=basePath %>/static/css/reset.css" />
<link rel="stylesheet" href="<%=basePath %>/static/css/editdlb.css" />
<script src="<%=basePath%>static/js/jquery.js"></script>

<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"<%=basePath%>QueryCropSpecies",
			type:"post",
			dataType:"json",
			data:{
				cropCategoryId:$("#cropCategoryId").val(),
				
			},
			success:function(data){
				$("#qop").empty();
				var v = "<tr class='info-first info-item'><td>序号</td><td>类别名称</td><td>操作</td></tr>"
				for(var i = 0; i <data.result.length; i ++){
					v +="<tr class='info-item'><td>"+data.result[i].cropSid+"</td><td>"+data.result[i].cropSpecies+"</td><td><a onclick='bianji("+data.result[i].cropSid+")'  class='edit'>编辑</a><a onclick='delte("+data.result[i].cropSid+")' class='delete'>删除</a></td></tr>"
				}																																
				$("#qop").append(v)
			}
		
		});
		
	})
	
	
</script>
</head>
<body onload="onloading()">
<form action="UpdateCrop" method="post" id="fuck">
<div class="xtgl"> <a class="dall user" href="superadmin.html">用户管理</a><a class="chart leibie dactive" href="categorylist.html">类别管理</a><a class="mps dusu" href="categorylist - dusu.html">毒素管理</a> </div> 
<div class="user-content">
  <p class="user-admin"><span>当前页面 : </span><a href="dlb.html">大类别管理/</a><a  href="editdlb.html">修改类别</a></p>
  <div class="user-modify-infolist">
    <p class="user-modify-title">修改类别</p>
    <ul class="modify-list">
      <li class="list-item">
        <label>大类别名称</label>
        <input type="hidden" name="id" value="${cropsqop.id }" id="cropCategoryId"/>
        <input type="text" name="cropcategory" value="${cropsqop.cropcategory}" />
      </li>
      <li class="list-item">
        <label>状态</label>
        <input type="radio" <c:if test="${cropsqop.state == 1}">checked="checked"</c:if> name="state" value="1">
          启用
          <input type="radio" <c:if test="${cropsqop.state == 0}">checked="checked"</c:if> name="state" value="0">
          禁用 <span id="state"></span> </li>
    </ul>
    <div class="modify-option"> <a class="user-modify"  onclick="fuckin()">修改</a><a class="modify-back" onClick="history.go(-1)">返回</a> </div>
  </div>
  <div>
    <div class="addlb"><a href="toxinadd.html">新增类别</a></div>
    <table class="user-info" id="qop">
				<tr class="info-first info-item">
					<td>序号</td>
					<td>类别名称</td>
					<td>操作</td>
				</tr>	
	</table>
    
  </div>
</div>
</form>
<script type="text/javascript">

	  function delte(id){
		  var cropCategoryId = document.getElementById("cropCategoryId").value;
	    if(confirm("你确定要删除吗？")){
	       window.location.href="DeleteById?cropSid="+id+"&cropCategoryId="+cropCategoryId;
	    }else{
	       return false;
	    }
	  }
	  function fuckin(){
		  document.getElementById("fuck").submit();
		  
	  }
	  
</script>
<script type="text/javascript">
	function bianji(cropSid){
		 var cropCategoryId = document.getElementById("cropCategoryId").value;
		 window.location.href="SelectSpOne?cropSid="+cropSid+"&cropCategoryId="+cropCategoryId;
		alert(cropSid)
	}
</script>
</body>
</html>
