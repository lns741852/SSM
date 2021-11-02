<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>结账退房</title>
<link href="<%=basePath %>/static/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath %>/static/css/select.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath %>/static/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>/static/js/select-ui.min.js"></script>

<script type="text/javascript"
	src="<%=basePath %>/static/js/laydate/laydate.js"></script>


<script type="text/javascript">



$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
	
	
	
});


</script>

<style>
	li{
		 height:20px;
	}
</style>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">客房管理</a></li>
			<li><a href="#">添加客房</a></li>
		</ul>
	</div>
	<div class="formbody" >
		<div class="formtitle">
			<span>添加客房</span>
		</div>
		<div id="usual1" class="usual">
			<div id="tab1" class="tabson" >
				<ul class="forminfo" >
					<li style="margin-top: 20px;"><label for="name">房間號<b>*</b></label>
						<div class="vocation">
							<input id="roomNum" name="roomNum" type="text" class="dfinput"
								style="width: 344px;" />
						</div></li>
						
					<li><label>房間類型<b>*</b></label>
						<div class="vocation">
							<select id="roomType" class="select1" name="roomType">
							</select>
						</div></li>

					<li id="rt" style="display: none"><label>房間單價<b>*</b></label>
						<div class="vocation">
							<input id="roomPrice" name="roomPrice" type="text" class="dfinput"
								style="width: 344px;" readonly="readonly" />
						</div></li>

					<li><label>房間狀態<b>*</b></label>
						<div class="vocation">
							<select id="roomState" class="select1" name="roomStatus">
								<option value="0">空閒</option>
								<option value="1">已入住</option>
								<option value="2">打掃</option>
							</select>
						</div></li>
				</ul>
				<div>
					<button class="btn btn-primary" type="button" id="saveRoom">新增</button>
					<button class="btn btn-primary" type="button" id="clear">清空表單</button>
				</div>
			</div>		
		</div>
		<script type="text/javascript">
	$(function(){
		//下拉選單如果用click，value值會改變
		$("#roomType").focus(function(){
			$.ajax({
				url:"<%=basePath %>/getRoomType.do",
				type:"POST",
				dataType:"json",
				success:function(rs){
					var rs = rs.data
					var content = "";
					
					//下拉選單拚串
					for(var i in rs){
						content+="<option price="+rs[i].room_price+" value="+rs[i].id+">"+rs[i].room_type_name+"</option>";
					}
					jQuery("#roomType").html(content);
				},
				error:function(){
					
				}
			});
		});
		
		//给房间类型下拉框添加change事件
		$("#roomType").change(function(){
			var price = $(this).find("option:selected").attr("price");
			$("input[name=roomPrice]").val(price);
			$("#rt").show('3000');
			//jQuery(".forminfo").append("<li><label>房间单价<b>*</b></label><div class='vocation'><input name='room_price' type='text' class='dfinput' style='width:344px;' readonly='readonly'/></div></li>");
		});
	});
	
	
	$("#saveRoom").click(function(){
		$.ajax({
			url:"<%=basePath %>/saveRoom.do",
			type:"POST",
			data:{
				"roomNum":$("#roomNum").val(),
				"roomTypeId":$("#roomType option:selected").val(),				
				"roomState":$("#roomState option:selected").val(),					
			},
			success:function(rs){				
					window.location.href="<%=basePath %>/showRoom.do";
			},
			error:function(){
				
			}
		});

		
	});
	
	
</script>

		<script type="text/javascript"> 
  
      $("#usual1 ul").idTabs(); 
    </script>
		<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	
	!function(){
laydate.skin('qianhuang');
laydate({elem: '#Calendar'});
laydate.skin('qianhuang');
laydate({elem: '#Calendar2'});
}();
$(function dd(){
		var d=new Date(),str="";
		str+=(d.getFullYear()+"-");
		str+="0";
		str+=(d.getMonth()+1+"-");
		str+=d.getDate();
		$("#Calendar").attr("value",str);
		$("#Calendar2").attr("value",str);
	});

	</script>
	</div>
</body>
</html>
