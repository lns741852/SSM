<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://cdn.jsdelivr.net/npm/vue"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
	<title>v-for</title>
</head>
<body>
	<div id="box1">
		<!-- 使用v-for标签，打印1-10 -->
		<ul>
			<li v-for="i in 10" v-if="i%2==0" style="background:#ccc">{{i}}</li>
			<li v-else style="background:#666">{{i}}</li>
		</ul>
		<!-- 遍历list集合:List<Map<String,Object>> List<JavaBean> -->
		<hr>
		<table border="1px" width="600px">
			<tr v-for="(book,index) in books">
				<td>{{index+1}}</td>
				<td>{{book.bName}}</td>
				<td>{{book.price}}</td>
				<td>
					<span v-if="book.num<=20" style="color:red">{{book.num}}</span>
					<span v-else>{{book.num}}</span>
				</td>
			</tr>
		</table>
		<!-- 遍历Map集合或者JavaBean -->
		<ul>
			<li v-for="(v,k,i) in user">
				{{i+1}}---{{k}}---{{v}}
			</li>
		</ul>
		<!-- 演示v-show与v-if的区别 -->
		<!-- v-if -->
		<span v-if="username=='admin'">v-if此用户为超级管理员</span>
		<!-- v-show -->
		<span v-show="username=='admin'">v-show此用户为超级管理员</span>
	</div>
	
	<script type="text/javascript">
		var vue2 = new Vue({
			el:"#box1",
			data:{
				books:[
					{"bName":"java从入门到放弃","price":19800,"num":50},
					{"bName":"Spring","price":9.9,"num":20},
					{"bName":"Vue从入门到放弃","price":30,"num":5}
				],
				user:{"uName":"王二麻子","gender":"1","age":18},
				username:'aa'
			}
		});
	</script>
</body>
</html>