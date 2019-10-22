<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户</title>
<link rel="stylesheet" type="text/css" href="../static/css/conmen-header.css"/>
<link rel="stylesheet" href="../static/css/reset.css" />
<link rel="stylesheet" href="../static/css/editdlb.css" />

<link rel="stylesheet" href="../static/css/adddlb.css" />
</head>
<body>
<div class="xtgl"> <a class="dall public" href="superadmin.html">用户管理</a> <a class="chart dactive public" href="categorylist.html">类别管理</a> <a class="mps public" href="categorylist - dusu.html">毒素管理</a> </div>


<div class="user-content">
  <p class="user-admin"><span>当前页面 : </span><a href="dlb.html">大类别管理/</a><a href="adddlb.html" style="color: #58a0fd">新增类别</a></p>
  <div class="user-modify-infolist">
    <p class="user-modify-title">修改类别</p>
    <form action="speciesedit?id=${species.id }" method="post">
      <ul class="modify-list">
        <input type="hidden" name="id" value="${species.id }"/>
        <input type="hidden" name="crop_category_id" value="${species.crop_category_id }"/>
        <li class="list-item">
          <label>类别名称</label>
          <input type="text" name="crop_species" value=""/>
        </li>
        <li class="list-item">
          <label>状态</label>
          
            <input type="radio" name="state" value="1" checked="checked" />
            启用
            <input type="radio" name="state" value="0" />
            禁用 
         
        </li>
      </ul>
      <div class="modify-option"> <a class="user-modify">修改</a><a class="modify-back" onclick="history.go(-1)">返回</a> </div>
    </form>
  </div>
</div>
<script type="text/javascript">
	   function xiugai(){
	      if(confirm("你确定要修改？")){
	        document.forms[0].submit();
	      }else{
	         return false;
	      }
	   }
	</script>
	
	</body>

</html>
