<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<base href="<%=basePath %>">
<link href="<%=basePath %>/static/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath %>static/bootstrap/css/bootstrap.min.css">

<!-- 版本要大於1.9 -->
<script type="text/javascript" src="<%=basePath %>/static/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath %>static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>

<body>

   	<div  id="empAddModle" class="modal fade" tabindex="-1"  role="dialog">
		  <div class="modal-dialog"  role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">添加房型</h5>
		      </div>		      
		      <div class="modal-body">
		        <!-- 表單 -->
		        <form class="form-horizontal" id="form_save_emp" >
					<div id="idText"class="form-group" style="display:none">
						<label  class="col-sm-2 col-form-label col-form-label-sm">ID</label>
					  <div class="col-sm-10">
						  <input type="text" name="id" class="form-control" id="id" placeholder="id">
						  <span class="help-block"></span>
					  </div>
					</div>
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">房型</label>
					  <div class="col-sm-10">
					    <input type="text" name="roomTypeName" class="form-control" id="roomTypeName" placeholder="請輸入...">
					    <!-- 放錯誤提示訊息 -->
					  	<span class="help-block"></span>
					  </div>
					</div>	
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">價格</label>
					  <div class="col-sm-10">
					    <input type="text" name="price" class="form-control" id="price" placeholder="請輸入...">
					    <!-- 放錯誤提示訊息 -->
					  	<span class="help-block"></span>
					  </div>
					</div>	
																												
				</form>		
			  </div>
		      <div class="modal-footer">
		            <button data-dismiss="modal" class="btn btn-default" type="button" id="emp_close">關閉</button>
		            <button class="btn btn-primary" type="button" id="emp_save">新增</button>
		      </div>
		     </div>
		    </div>
		  </div>
		</div>




<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="main.html">客房管理</a></li>
    <li><a href="#">客房类型管理</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div  id="emp_add_modal_btn" class="tools">
    <ul class="toolbar">
      <li  class="click"><span><img src="<%=basePath %>/static/images/t01.png" /></span>添加</li>
    </ul>
    
    
  </div>
  <table class="tablelist">
    <thead>
      <tr>  
        <th>編號</th>
        <th>房間類型</th>
        <th>房間單價</th>
        <th width="300">操作</th>
      </tr>
    </thead>
    <tbody>
 
    </tbody>
  </table>
    		<div class="col-md-6" id="page_info_area">
	  	
		  	</div>
		  	<div class="col-md-6" id="page_nav_area">
		  	
		  	</div>
  

<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	
	
	var totalRecord,currentPage,shouldVerify=true
	
	$(function(){
		//總分頁資料查詢
		queryPageUser(0);		
	});

	

     function queryPageUser(pageno){
         //初始化頁面，傳入後端
         var jsonObj = {
     			"pageno" :pageno,
     			"pagesize" :5
     			
     	};
         
    	$.ajax({
    		type : "POST",
    		data : jsonObj,						
    		url : "<%=basePath %>getAllRoomType.do",
    		beforeSend : function(){    		
    			return true ;
    		},
    		/*result可以接受一個對象或一個Map集合
    		對象:success.屬性
    		Map:success.Key
    		*/
    		success : function(result){			    		
    			if(result.success){
    				var page = result.pageInfo ;
    				var data = page.list ;
    				//清空表單內容
    				var content = '';
    				
    				//i迴圈當前筆數，n為data索引            			
    				$.each(data,function(i,n){
    					content+='<tr>';
        				content+='  <td>'+n.id+'</td>';
        				content+='  <td>'+n.room_type_name+'</td>';
        				content+='  <td>'+n.room_price+'</td>';
        				content+='  <td>';          				
        				//使用\將'轉意，否則會被當成拼串的符號                			
        				content+='	  <button type="button" class="btn btn-default edit_btn" id="'+n.id+'">修改</button>';
        				//在方法中要聲明成字串，否則會被當成變數                				
        				content+='	  <button type="button" class="btn btn-default  delete_btn" id="'+n.id+'">刪除</button>';
        				content+='  </td>';
        				content+='</tr>';
    				});

    				//顯示在標籤中
    				$("tbody").html(content);
    				
    				build_page_info(page);	
					//分頁欄編輯
					build_page_nav(page);
    								
    				
    			}else{
    				window.alert("加載數據失敗");
    			}
    		},
    		error : function(){
    			window.alert("加載數據失敗");
    		}
    	});
     }
	
     function build_page_info(page){
			$("#page_info_area").empty();
			$("#page_info_area").append("第"+page.pageNum+"頁, 總頁數"+page.pages+", 總筆數"+page.total);
			
			totalRecord = page.total;
			currentPage = page.pageNum;
		}
		
		
		function build_page_nav(page){
			$("#page_nav_area").empty()
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append($("<a></a>").append("第一頁"));			
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if(page.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{				
				firstPageLi.click(function(){
					queryPageUser(1);
				});
				prePageLi.click(function(){
					queryPageUser(page.pageNum-1);
				});
			}
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));	
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末頁"));				
			if(page.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{			
				nextPageLi.click(function(){
					queryPageUser(page.pageNum+1);
				});
				lastPageLi.click(function(){
					queryPageUser(page.pages);
				});			
			}
			ul.append(firstPageLi).append(prePageLi);
			
			//顯示可視分頁
			$.each(page.navigatepageNums,function(index,item){
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if(page.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					queryPageUser(item);
				});
				
				ul.append(numLi);
			});
			
			ul.append(nextPageLi).append(lastPageLi);
			
			//整合分頁
			$("<nav></nav>").append(ul).appendTo("#page_nav_area");
			
		}
		
		
		//新增
		$("#emp_add_modal_btn").click(function(){
			
			$("#idText").hide()				
			//重製彈出視窗
			reset_form("#empAddModle form")
			//彈出視窗
			$("#empAddModle").modal('show')						
		});
     
		function reset_form(ele){
			//清空表單，reset為DOM對象的方法
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
			
		}
		
		
		//儲存
		$("#emp_save").click(function(){
			//前端效驗結果

			if(!validate_add_form()){
				return false;
			};
			//後端效驗結果
			if($(this).attr("ajax-va")== "error"){
				return false;
			};
			
			$.ajax({
				url:"<%=basePath %>saveRoomType.do",
				type:"POST",
				//序列化表單內容，表單中的name必須等於實體類的名稱
				//接收參數必須是String 
				data:$("#form_save_emp").serialize(),
				success:function(result){
					if(result.success){
						//關閉視窗
						$("#empAddModle").modal('hide')
					
						//跳轉到末頁，須設定全域變數
						queryPageUser(totalRecord+1)						
					}else{
						if(undefined != result.extend.errorFields.roomTypeName){
							show_validate_msg("#roomTypeName","error",result.extend.errorFields.roomTypeName)
						}
						
						if(undefined != result.extend.errorFields.price){
							show_validate_msg("#price","error",result.extend.errorFields.price)
						}


					}

				}
			});
							
		});

		
		
		//前端效驗
		function validate_add_form(){

			
			var com_validate = true;
			var roomType =$("#roomTypeName").val();
			var regName =/^[\u2E80-\u9FFF]{2,5}$/;
			//不匹配 = true
			if(!regName.test(roomType)){
				//alert("姓名錯誤");		
				show_validate_msg("#roomTypeName","error","請輸入兩個以上的中文")						
				com_validate = false;
			}else{
				show_validate_msg("#roomTypeName","success","")						
			};
			
			var email =$("#price").val();
			var regEmail =/^([1-9]{1})([0-9]+)$/
			if(!regEmail.test(email)){
				//alert("油箱錯誤");
				show_validate_msg("#price","error","價格輸入錯誤")
				com_validate = false;
			}else{
				show_validate_msg("#price","success","")							
			};
			
			return com_validate;
			
			
		}
	
		
		//校驗回傳值顯示
		function show_validate_msg(ele,status,msg){
			$(ele).parent().removeClass("has-error has-success");
			$(ele).next("span").text(msg);	
			
			if(status == "error"){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}else{
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);							
			}
		}
		
		//後端帳號重複驗證
		$("#roomTypeName").change(function(){			
				var roomTypeName = this.value;				
				$.ajax({
					url:"<%=basePath %>roomTypeCheck.do",
					data:{
						"roomTypeName":roomTypeName,
						"shouldVerify":shouldVerify
					},
					type:"POST",
					success:function(result){
						if(result.success){
							show_validate_msg("#roomTypeName","success","用戶可用");
							$("#emp_save").attr("ajax-va", "success");					
						}else{
							show_validate_msg("#roomTypeName","error",result.extend.va_msg);
							$("#emp_save").attr("ajax-va", "error");
						}
					}
				});
				
			//輸入框的值						
		});
		
		//更新
		$(document).on("click",".edit_btn",function(){					
			getEmp($(this).attr("id"));
			$("#empAddModle").modal({			
				backdrop:"show"
			});	
			
			shouldVerify = false;
		});
		
		
		function getEmp(id){
			$.ajax({
				url:"<%=basePath %>roomTypeCheckById.do",
				type:"POST",
				data:{
					"id":id
				},
				success:function(result){
					var roomType =result.extend.roomType;
					$("#id").val(roomType.id);
					//val直接為表單付值
					$("#roomTypeName").val(roomType.room_type_name);
					$("#price").val(roomType.room_price);		
					$("#idText").show();
					
				}
			});
			
			
		}
		
		//刪除
		$(document).on("click",".delete_btn",function(){			
			var roomTypeName =$(this).parents("tr").find("td:eq(1)").text();
			var id = $(this).attr("id");
			if(confirm("刪除"+roomTypeName)){			
				$.ajax({
					url:"<%=basePath %>roomTypeDeleteById.do",
					data:{
						"id":id
					},
					type:"POST",
					success:function(result){					
						queryPageUser(currentPage)
					}									
				});
				
			}
		});
		
		

	
	
	
</script>
</body>
</html>
