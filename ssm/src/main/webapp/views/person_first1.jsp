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
<script type="text/javascript">
	$(function(){
		var btns = new Array();
		$(".cropid").each(function(key,value){
		   btns[key]=($(this).val());
		}) ;
		$.ajax({
			url:"<%=basePath %>JustQueryAll",
			type:"post",
			dataType:"json",
			data:{
				
			},
			success:function(data){
				if(data.code == 200){
					$("#cropcategory").empty();
					var v = '';
					for(var i = 0;i < data.result.length;i++){
						v +='<li class="food_item_list ';
						var bool = false;
						for(var j = 0;j < btns.length;j++){
							
							if(btns[j] == data.result[i].id){
								bool = true;
							}
						}
						if (!bool) {
							v+= ' yi ';
						}
						v+='"><a  style="text-decoration: none;display: block;" href="<%=basePath%>SelectCropSpeciesBycropId?cropCategoryId='+data.result[i].id+'">'+data.result[i].cropcategory+' </a></li>';
					}
						
					$("#cropcategory").append(v);
				}
			}
		})
			
	})
	 
</script>
</head>
<body>
<header style="height: 50px;background-color: #c0dafb;">
  
  <div class="logo_right_box">
  <input type="hidden" value="1" class="q"/>
    <ul class="logo_right_left">
      <li><a class="datebrowsing" href="person_first1.jsp"><span style="padding: 12px; color: #58a0fd">数据浏览</span></a></li>
      <li><a class="chartview" href="<%=basePath %>views/customer-chartview.jsp"><span style="padding: 12px;">图表查看</span></a></li>
      <li><a class="regional" href="<%=basePath %>views/customer-reqion.jsp"><span>地域分布图</span></a></li>
    </ul>
    <ul class="logo_2right">
      <li class="grzx_a"> <a class="gerencenter"><span class="logo_bt" id="logo_mycenter">个人中心</span></a>
        <div id="dropdown_box" style="top: 50px; right: -15px; z-index: 888; display: none;">
          <ul class="dropdown_ul">
            <li class="dropdown_li"><a class="llhistry" href="person_DataBrowsing.html"><span>浏览记录</span></a></li>
            <li class="dropdown_li"><a class="updatebro" href="person_DataBrowsin.html"><span>下载记录</span></a></li>
            <li class="dropdown_li"><a class="pwdup" href="person_updatePassword.html"><span>密码修改</span></a></li>
          </ul>
        </div>
      </li>
    </ul>
  </div>
</header>
<div class = "food_class">

	<c:forEach items="${cropId }" var="crop">
	
	  <input class="cropid" type="hidden" value="${crop.id }" />
	
	</c:forEach>
  <ul class= "food_item"  id="cropcategory">
    <!--  <li class="food_item_list"><a style="text-decoration: none;display: block;" href="person_first2.html">水果类 </a></li>
    <li class="food_item_list "><a style="text-decoration: none;display: block;" href="person_first2.html">谷物类 </a></li>
    <li class="food_item_list "><a style="text-decoration: none;display: block;" href="person_first2.html">坚果类 </a></li>
    <li class="food_item_list "><a style="text-decoration: none;display: block;" href="person_first2.html">香辛类 </a></li>
    <li class="food_item_list "><a style="text-decoration: none;display: block;" href="person_first2.html">饲料类 </a></li>
    <li class="food_item_list yi"><a style="text-decoration: none;display: block;" href="person_first2.html" disable:disable>饲料类 </a></li>
    <div class="clearfix"></div>-->
  </ul>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('.yi a').removeAttr('href');//去掉a标签中的href属性
		$('.yi a').removeAttr('onclick');//去掉a标签中的onclick事件
	});
</script>
<script type="text/javascript" src="<%=basePath %>static/js/jquery.js" ></script>
<script>

			$('.food_item').click(function(e){
				if(e.target.nodeName === "LI"){
					$(e.target).addClass('active').siblings().removeClass('active');
					window.location.href='index.html';
				}
			})

	</script>
<script type="text/javascript" src="<%=basePath %>static/js/jquery-2.1.0.js" ></script>
<script>
		$(function(){
			$('.food_item').click(function(e){
				if(e.target.nodeName === "LI"){
				    $(e.target).addClass('active').siblings().removeClass('active');
				}
			})
		});

		function shousuo(id){
		//alert(id);
		location.href="searchByCategory?id="+id;
		}
	</script>
</html>