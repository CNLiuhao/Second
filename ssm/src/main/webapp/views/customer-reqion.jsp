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
</head>


   
<body>
<header style="height: 50px;background-color: #c0dafb;">
  
  <div class="logo_right_box">
    <ul class="logo_right_left">
      <li><a class="datebrowsing" href="person_first1.html"><span style="padding: 12px;">数据浏览</span></a></li>
      <li><a class="chartview" href="customer - chartview.html"><span style="padding: 12px;">图表查看</span></a></li>
      <li><a class="regional" href="customer - reqion.html" style="color: #58a0fd"><span>地域分布图</span></a></li>
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
<iframe id="mainiframe" width="100%" height="100%" scrolling="no" frameborder="0" onload="reinitIframe()" src="<%=basePath %>views/map.jsp"></iframe>

</body>
</html>
