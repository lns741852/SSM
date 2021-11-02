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
	<title>vue4</title>
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
	<!-- computed属性 -->
	<div id="box2">
		<button @click="aaa">查看vue中的this</button>
		请输入您的书名：<input type="text" v-model="bookName"><br/>
		您购买书的详细信息为：{{bName}}
	</div>
	<script type="text/javascript">
		var vue2 = new Vue({
			el:"#box2",
			data:{
				bookName:"Java从入门到放弃"
			},
			computed:{//计算属性
				bName(){
					return this.bookName+"--清华大学出版社";
				}
			},
			methods:{
				aaa(){
					console.log(this);
					
				}
			}
		});
	</script>
</body>
</html>