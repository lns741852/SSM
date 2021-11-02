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
	<title>vue3</title>
	<style type="text/css">
		.c1{
			width:100px;
			height:100px;
			background-color:red;
		}
		.c2{
			width:100px;
			height:100px;
			background-color:green;
		}
	</style>
</head>
<body>
	
	<!-- v-bind指令 -->
	<div id="box1">
		<button @click="skin='c1'">皮肤1</button><button @click="skin='c2'">皮肤2</button>
		<div v-bind:id="aaa" v-bind:class="skin" style="width:100px;height:100px;border:solid 1px red">
		</div>
	</div>
	<script type="text/javascript">
		var vue1 = new Vue({
			el:"#box1",
			data:{
				skin:"",
				aaa:"box1"
			},
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
	<hr />
	
</body>
</html>