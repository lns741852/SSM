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
	<title>vue1</title>
</head>
<body>
	<div id="box1">
		<!-- v-model指令：就是将vue中的某个属性与某个标签进行绑定 -->
		<input type="text" v-model="bookName">
		<!-- 插值表达式：取出vue中的某个属性值 -->
		<span>{{bookName}}---{{price}}---{{num}}</span>
		<!-- v-text：取出vue中的某个属性值 -->
		<span v-text="bookName"></span>
	</div>
	<script type="text/javascript">
		var vue1 = new Vue({
			el:"#box1",
			data:{
				bookName:"java从入门到放弃",
				price:19800,
				num:10
			}
		});
	</script>
	
	<hr>
	<!-- vue中的v-on指令：演示单击事件 -->
	<div id="box2">
		<input type="text" v-model="num"/>
		<!-- <button v-on:click="num++">+</button> -->
		<button @click="num++">+</button>
	</div>
	<script type="text/javascript">
		var vue2 = new Vue({
			el:"#box2",
			data:{
				num:0
			}
		});
	</script>
	
	<!-- 演示批量选中 -->
	<div id="box3">
		<h1>爱好：</h1>
		<input v-model="hobbies" type="checkbox" value="1">足球<br>
		<input v-model="hobbies" type="checkbox" value="2">篮球<br>
		<input v-model="hobbies" type="checkbox" value="3">游泳<br>
		<input v-model="hobbies" type="checkbox" value="4">跳舞<br>
		
		<h1>您的爱好为：</h1>
		<span>{{hobbies.join(",")}}  {{name}}</span>
		
		<h1>演示v-text与v-html指令的区别</h1>
		<span v-text="name"></span>
		<span v-html="name"></span>
	</div>
	<script type="text/javascript">
		var vue3 = new Vue({
			el:"#box3",
			data:{
				hobbies:[],
				name:"<h1>王二麻子</h1>"
			}
		});
	</script>
</body>
</html>