<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<meta  http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="/TestMessage/static/css/reset.css"/>
<link rel="stylesheet" href="/TestMessage/static/css/login.css" />
<script type="text/javascript" src="/TestMessage/static/js/jquery1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="/TestMessage/static/js/checkLogin.js" ></script>
<script type="text/javascript" src="/TestMessage/static/js/layui-all.js" ></script>
</head>
<body>
<div class="contaner">
  <div class="login-box">
    <p class="loginbox-title">信息管理系统</p>
    <div class="loginbox-head">
      <p>登录</p>
    </div>
    <form class="login-form" action="<%=basePath %>Login" method="post" id="fm1">
      <div class="loginbox-info">
        <ul>
          <li>
            <input id="loginname" type="text" name="loginname"  class="login-name" placeholder="请输入登录账号/手机号"/>
          </li>
          <span id="login_name"></span>
          <li>
            <input type="password" name="password"  class="login-pwd" placeholder="请输入密码">
          </li>
          <span id="password"></span>
          <li><input type="button" value="登录" class="login-sin" onclick="Login()"/></li>
          <li class="login-fpwd"><a class="login-res" href="forgetpwd.html">忘记密码?</a><a class="login-register" href="register.html">立即注册</a></li>
        </ul>
      </div>
    </form>
  </div>
</div>
</body>
<script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
<script type="text/javascript" src="assets/plugins/select2/select2.min.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="assets/scripts/app.js" type="text/javascript"></script>
<script src="assets/scripts/login-soft.js" type="text/javascript"></script>
<script src="app/lib/security/sha256.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script type="text/javascript">
function Login(){
	var name = document.getElementById("loginname").value;
	window.top.location.href="/TestMessage/Login?loginname="+name
	<!--document.getElementById("fm1").submit-->
}

</script>
	<script>

		jQuery(document).ready(function() {
		  App.init();
		  Login.init();
		});
	</script>
</html>
