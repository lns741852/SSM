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
		<h1>{{num}}</h1>
		<input type="text" v-model="num"/><button @click="num++">+</button>
	</div>
	
	<script type="text/javascript">
		var vue2 = new Vue({
			el:"#box1",
			data:{
				num:0
			},
			beforeCreate(){
				console.log("beforeCreate...");
				console.log("data..."+this.$data);
				console.log("el..."+this.$el);
			},
			created(){
				console.log("created...");
				console.log("data..."+this.$data);
				console.log("el..."+this.$el);
			},
			beforeMount(){
				console.log("beforeMount...");
				console.log("data..."+this.$data);
				console.log("el..."+this.$el);
			},
			mounted(){
				console.log("mounted...");
				console.log("data..."+this.$data);
				console.log("el..."+this.$el);
			},
			beforeUpdate(){
				console.log("beforeUpdate...");
				console.log("data..."+this.$data);
				console.log("el..."+this.$el);
			},
			updated(){
				console.log("updated...");
				console.log("data..."+this.$data);
				console.log("el..."+this.$el);
			},
			beforeDestroy(){
				console("beforeDestroy...........");
			},
			destroyed(){
				console("destroyed...........");
			}
		});
	</script>
</body>
</html>