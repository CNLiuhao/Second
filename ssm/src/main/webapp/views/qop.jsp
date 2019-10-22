<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" style="text-align:center">
		<c:forEach items="${infos.list }" var="sampleinfo">
			<tr>
				<td>${sampleinfo.id }</td>
				<td>${sampleinfo.sampleId}</td>
				<td>${sampleinfo.addressProvince.pname}</td>
				<td>${sampleinfo.addressCity.cname}</td>
				<td>${sampleinfo.addressTown.tname}</td>
		        <td>${sampleinfo.cropSpecies.cropSpecies}</td>
		        <td>${sampleinfo.samplingTime}</td>
		        <td>${sampleinfo.inputTime}</td>
		        <td>${sampleinfo.pollutionRate}</td>
		        <td> 
		        	<c:forEach items="${sampleinfo.infos }" var="sampletoxin">
			        	${sampletoxin.info.toxinType }
			        </c:forEach>
       		    </td>
			</tr>
		</c:forEach>
	</table>
	<a onclick="page(1)">首页</a>
	<a onclick="page(${infos.pageNum==1?1:infos.pageNum-1 })">上一页</a>
	<a onclick="page(${infos.pageNum==infos.pages?infos.pages:infos.pageNum+1 })">下一页</a>
	<a onclick="page(${infos.pages})">尾页</a>
	<p>总页数${infos.pages }</p>
</body>
<script type="text/javascript">
	function page(pageNum){
		
		window.location.href="queryallinfo?pageNum="+pageNum;
		
	}
	
</script>
</html>