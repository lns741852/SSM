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
	<title>vue2</title>
</head>
<body>
	<!-- vue中的methods属性 -->
	<div id="box1">
		<button v-on:click="ccc('百度')">百度</button>
		<button @click="ccc('新浪')">新浪</button>
	</div>
	<script type="text/javascript">
		var vue1 = new Vue({
			el:"#box1",
			methods:{
				aaa(){
					console.log("百度");
				},
				bbb(){
					console.log("新浪");
				},
				ccc(msg){
					console.log(msg)
				}
			}
		});
	</script>
	
	<hr/>
	
	<!-- vue中事件冒泡 -->
	<div id="box2">
		<div @click="aaa('我是div')" style="width:100px;height:100px;background:red">
			<button @click.stop="aaa('我是按钮')">我是一个按钮</button>
		</div>
		<!-- 事件阻止 -->
		<a href="http://www.baidu.com" @click.prevent="bd">百度</a>
		<br>
		<input type="text" v-model="uName"><span v-once>{{uName}}</span>
	</div>
	<script type="text/javascript">
		var vue2 = new Vue({
			el:"#box2",
			data:{
				uName:"小明"
			},
			methods:{
				aaa(msg){
					console.log(msg);
				},
				bd(){
					console.log("点击百度一下");
				}
			}
		});
	</script>
	
</body>
</html>