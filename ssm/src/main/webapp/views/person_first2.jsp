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
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/person_frist.css"/>
<link rel="stylesheet" href="<%=basePath %>static/css/p_header.css" />
<script type="text/javascript" src="<%=basePath %>static/js/jquery.js" ></script>
<script type="text/javascript" src="<%=basePath %>static/js/browsing.js" ></script>
<style>
body {
	background-color: #f4f9ff;
}
* {
	margin: 0;
	padding: 0;
}
ul {
	list-style-type: none;
}
.info_food {
	width: 1100px;
	margin: 0 auto;
	margin-top: 53px;
}
.info_food .info_item {
	font-size: 18px;
	font-family: '宋体';
}
.info_food .info_item .info_item_list {
	height: 60px;
}
.info_food .info_item .info_item_list:nth-child(odd) {
	background: #237ae4;
	color: #fff;
}
.info_food .info_item .info_item_list:nth-child(even) {
	background: #e4e9ee;
}
.info_food .info_item .info_item_list .info_name {
	width: 144px;
	/* margin-right: 100px; */
	line-height: 60px;
	display: inline-block;
	text-align: center;
	float: left;
}
.info_food .info_item .wu .info_name {
	/*margin-right: 85px;*/
	display: inline-block;
}
.info_food .info_item .info_item_list ul {
	display: inline-block;
	width: 956px;
}
.info_food .info_item .info_item_list li {
	float: left;
}
.info_food .info_item .info_item_list li input[type =checkbox] {
	width: 16px;
	height: 16px;
	vertical-align: -2px;
	margin-right: 5px;
}
.info_food .info_item .info_item_list ul li label {
	margin-right: 10px;
}
.btn {
	width: 1100px;
	margin: 0 auto;
	margin-top: 30px;
	text-align: center;
}
.btn .back {
	display: inline-block;
	width: 100px;
	margin-right: 100px;
	height: 40px;
	line-height: 40px;
	text-decoration: none;
	background: #237ae4;
	border-radius: 3px;
	color: #fff;
}
.btn .search {
	display: inline-block;
	width: 100px;
	/* margin-right: 100px; */
	height: 40px;
	line-height: 40px;
	text-decoration: none;
	background: #237ae4;
	border: none;
	border-radius: 3px;
	color: #fff;
}
.yi ul {
	height: 60px;
	line-height: 60px;
}
.er ul {
	height: 60px;
	line-height: 60px;
}
.san ul {
	height: 60px;
	line-height: 60px;
}
.si ul {
	height: 60px;
}
.wu ul {
	height: 60px;
	line-height: 60px;
	font-family: '微软雅黑';
}
.wu li span {
	margin-right: 10px;
}
</style>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"<%=basePath%>QueryToxinFromSampleinfo",
			type:"post",
			data:{
				"cropCategoryId":$("#cropcategoryid").val(),	
			},
			dateType:"json",
			success:function(data){
				console.log(data.result.province[0].pname)
				if(data.code == 200){
					$("#toxinmessage").empty();
					$("#abouttime").empty();
					$("#aboutprov").empty();
					var h ='';
					var s ='';
					var y ='';
					
					for (var i = 0; i < data.result.toxin.length; i++) {
						h +='<li><input value="'+data.result.toxin[i].tid+'" type="checkbox" name="toxin" id="liaoning"/><label for="don">'+data.result.toxin[i].toxinType+'</label></li>';
					}
					 for(var j = 0;j < data.result.samtime.length;j++){
						s +='<li><input value="'+data.result.samtime[j]+'" type="checkbox" name="dates" id="y2013" ><label for="y2013">'+data.result.samtime[j]+' </label></li>';
					 }
					
					for(var k = 0;k < data.result.province.length;k++){
						
						y +='<li><input value="'+data.result.province[k].code+'" type="checkbox" name="province" id="liaoning" value="" /><label for="liaoning">'+data.result.province[k].pname+'</label></li>';
					} 
					$("#toxinmessage").append(h);
					$("#abouttime").append(s);
					$("#aboutprov").append(y);
				}
			}
		})
	})
</script>
</head>
<body>
<div class = "info_food">
<body>

<div class = "info_food">
  <form action="QueryMessageByConditions" id="form1">
   <input type="hidden" />
   <input type="hidden" id="cropcategoryid" value="${cropCategoryId }"/>
    <div class = "info_item">
      <div class="info_item_list yi active">
        <label class="info_name">类别</label>
        <ul>
	        <c:forEach items="${species }" var="species">
		        <li>
		          <input type="checkbox" name="breed" id="crop_species" value="${species.cropSid }" />
		          <label for="shuidao" >${species.cropSpecies }</label>
		        </li>
	        </c:forEach>
        </ul>
      </div>
      <div class="info_item_list er">
        <label class="info_name">年份</label>
        <ul id="abouttime">
        	
        </ul>
      </div>
      <div class="info_item_list san">
        <label class="info_name">地区</label>
        <ul id="aboutprov">

           
    

         </ul>
      </div>
      <div class="info_item_list si">
        <label class="info_name">毒素</label>
        <div class="sids">
          <ul  id="toxinmessage" style="margin-top:20px; ">

          </ul>
        </div>
      </div>
      <div class="info_item_list wu">
        <label class="info_name">污染率</label>
        <ul>
          <li>
            <input type="radio" name="pulltion" id="" value="0-100" />
            <span>0~100%</span> </li>
          <li>
            <input type="radio" name="pulltion" id="" value="0-20" />
            <span>0%~20%</span> </li>
          <li>
            <input type="radio" name="pulltion" id="" value="20-40" />
            <span>20%~40%</span> </li>
          <li>
            <input type="radio" name="pulltion" id="" value="40-60" />
            <span>40%~60%</span> </li>
          <li>
            <input type="radio" name="pulltion" id="" value="60-80" />
            <span>60%~80%</span> </li>
          <li>
            <input type="radio" name="pulltion" id="" value="80-100" />
            <span>80%~100%</span> </li>
        </ul>
      </div>
    </div>
    <div class="btn"> <a href="person_first1.html" class="back">上一页</a>
      <input class="search" value="搜索" type="submit"  />
    </div>
  </form>
</div>
<style type="text/css">
  .search{text-align:center;font-size:16px;}

</style>
</body>
</html>
