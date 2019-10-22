<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>图表查看</title>

<link rel="stylesheet" href="<%=basePath %>static/css/p_chartView.css" />
<link rel="stylesheet" href="<%=basePath %>static/css/p_regionalDistribution.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/reset.css" />

</head>
<script type="text/javascript" src="<%=basePath %>static/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/echarts.min.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/person_aa.js" ></script>
<script type="text/javascript" src="<%=basePath %>static/js/hover.js" ></script>
<script type="text/javascript">
	$(function(){
		
		$.ajax({
			url:"<%=basePath%>JustQueryAll",
			type:"post",
			data:{
				
			},
			dataType:"json",
			success:function(qop){
				if(qop.code == 200){
					$("#cropCategory").empty();
					var v ='<option value="0">--请选择--</option>';
					for(var i = 0;i < qop.result.length;i++){
						v +='<option value="'+qop.result[i].id+'">'+qop.result[i].cropcategory+'</option>';
					}
					$("#cropCategory").append(v);
				}
			}
		})
		$("#cropCategory").change(function(){
			$.get("<%=basePath%>QueryCropSpecies",{"cropCategoryId":$("#cropCategory").val()},function(data){
				if(data.code == 200){
					$("#cropSpecies").empty();
					var v = '<option value="0">--请选择--</option>';
					for (var i = 0; i < data.result.length; i++) {
						v +='<option value="'+data.result[i].cropSid+'">'+data.result[i].cropSpecies+'</option>';
					}
					$("#cropSpecies").append(v);
				}
			})
		})
		$("#cropSpecies").change(function(){
			$.ajax({
				url:"<%=basePath%>QeuryProvinceInSinfoBySpecies",
				type:"post",
				data:{
					cropSid:$("#cropSpecies").val()
				},
				dataType:"json",
				success:function(data){
					if(data.code == 200){
						$("#shen").empty();
						var v = '<option  value="请选择">请选择</option>';
						for (var i = 0; i < data.result.length; i++) {
							v +='<option  value="'+data.result[i].addressProvince.code+'">'+data.result[i].addressProvince.pname+'</option>';
						}
						$("#shen").append(v);
					}
				}
				
			})
		})
		$("#shen").change(function(){
			$.ajax({
				url:"<%=basePath%>QeuryTimeInSinfoByProvinec",
				type:"post",
				data:{
					pcode:$("#shen").val()
				},
				dataType:"json",
				success:function(data){
					if(data.code == 200){
						$("#year").empty();
						var v = '<option value="请选择">请选择</option>';
						for (var k = 0; k < data.result.length; k++) {
							v +='<option value="'+data.result[k]+'">'+data.result[k]+'</option>';
						}
						$("#year").append(v);
					}
				}
				
			})
		})
		
		
		
		
	})
	
</script>
<script type="text/javascript">

</script>
<body>

	<!-- 内容顶部路由页显示  -->
	<p class="top_url_box box">
		<span>当前页面 ：</span><a>图表查看</a>
	</p>
	<article class="arcbox box">
		<form action="" method="post">
			<span class="nzw_zl">农作物大类别 </span> 
			<select  name="nzw_spacies" class="nzw_spacies" id="cropCategory">
				<option value="0">--请选择--</option>
				
			</select> 
			<span class="nzw_zl">农作物种类 </span> 
			<select id="cropSpecies" name="nzw_spacies" class="nzw_spacies">
				<option value="0">--请选择--</option>
			</select> 
			
			
			<!-- 省市县下拉框 -->
			<span>地区</span>
			<span class="region">
			<select id="shen" name="province" class="province" >
				<option  value="请选择">请选择</option>
			</select>
			<!-- 时间下拉框 -->
			<span>年份 </span>
			<span class="data_ymd">
			<select id="year" name="year" class="year" >
				<option value="请选择">请选择</option>
			</select>
			
			<span>污染率 </span> 
			<select id="pollutionRate" name="pollutionRate" class="pollutionRate">
				<option value="0-20">0~20%</option>
				<option value="21-40">21~40%</option>
				<option value="41-60">41~60%</option>
				<option value="61-80">61~80%</option>
				<option value="81-100">81~100%</option>
				<option value="0-100">0~100%</option>
			</select>
			<input class="search" type="button" value="搜索" id="find">
		
	</span></span></form></article>
	<article class="echartmap">
		
		<div id="main" class="echart_map" _echarts_instance_="ec_1521172575568" style="-webkit-tap-highlight-color: transparent; user-select: none;"><div style="position: relative; overflow: hidden; width: 940px; height: 600px; padding: 0px; margin: 0px; border-width: 0px; cursor: default;"></div></div>
		<script type="text/javascript" src="<%=basePath %>static/js/linkage3_.js"></script>
		<script type="text/javascript">
			var myChart = echarts.init(document.getElementById('main'));
				var arr=null;
				var arry=null;
				var joker = new Array();
				var wacther = new Array();
				var hanter = new Array();
			$(function(){
				$("#find").click(function(){
					$.ajax({
						url:"<%=basePath%>QueryInSampleInfoByCcPT",
						type:"post",
						data:{
							cropCategoryId:$("#cropCategory").val(),
							cropSpecies:$("#cropSpecies").val(),
							province:$("#shen").val(),
							datetime:$("#year").val(),
							pollutions:$("#pollutionRate").val()
						},
						dataType:"json",
						success:function(data){
							joker=[];
							wacther=[];
							hanter=[];
							if (data.code == 200) {
								for(var i = 0;i < data.result.sampleinfo.length;i++){
									
									hanter.push(data.result.sampleinfo[i].sampleId)
								}
								for (var i = 0; i < data.result.toxininfo.length; i++) {
									
									for (var j = 0; j < data.result.sampleinfo.length; j++) {
									
										if (data.result.sampleinfo[j].infos.hasOwnProperty(i)) {
											wacther[j]=data.result.sampleinfo[j].infos[i].toxinCount+"";
										}else {
											wacther[j]="0";
										}
									}
									wacther=[wacther];
									joker[i] ={name:data.result.toxininfo[i].toxinType,type:'bar',data: wacther[0]};
									
								}
								
								 var sum=0;

								for(var i =0;i<joker.length;i++){

									sum=0;

									for(var j = 0;j<joker[i].data.length;j++){

										sum+=parseFloat(joker[i].data[j]);						

									}

									

									if(sum==0){

										delete joker[i];

									}

								} 
								ojjk();
								
								
								
							}
							
							
					
							
							
							
						}
						
						
					})
				})
				function ojjk(){
					var option={
							legend:{data:[]},
							tooltip:{trigger:'axis'},
							itemStyle:{
										normal:{
												color:function(params){
													var colorList = ['#EFE42A','#64BD3D','#EE9201','#29AAE3', '#B74AE5','#0AAF9F','#E89589','#Edd201','#29ccE3','#B7aaE5','#0fde9F','#444666'];
													return colorList[params.dataIndex];
												}, 
												label:{show:false} 
										} 
							},
							yAxis: {},
							xAxis: {data : [''],axisLabel:{interval: 0}},
							series: []
					};
					
						
				
						option = {
							title : {
								text: '毒素含量统计图',

							},
							tooltip : {
								trigger: 'axis'
							},
							legend: {
								data:['毒素含量']
							},
							toolbox: {
								show : true,
								feature : {
									mark : {show: true},
									dataView : {show: true, readOnly: false},
									magicType : {show: true, type: ['line', 'bar']},
									restore : {show: true},
									saveAsImage : {show: true}
								}
							},
							calculable : true,
							xAxis : [
								{
									type : 'category',
									data : hanter
								}
							],
							yAxis : [
								{
									type : 'value'
								}
							],
							series :joker
						};
						myChart.clear();
						myChart.setOption(option);
				}
				

			
				})
		</script>
	</article>
</body>
</html>
