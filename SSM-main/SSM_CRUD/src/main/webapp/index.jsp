<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- JSTP標籤 -->    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en"  xmlns:th="http://www.thymeleaf.org">

<head>
	
		<!-- 訪問路徑 前墜-->
		<%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Signin Template for Bootstrap</title>
		
		<!-- 引入jquery-->
		<script type="text/javascript" src="${APP_PATH}/static/js/jquery.min.js"></script>
		
		<!-- Bootstrap core CSS 路徑-->
		<link href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom styles for this template 路徑-->
		<script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
				
	</head>	
	<body>	
		<!-- update互動視窗 -->
		<div class="modal fade" id="empUpdateModle" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">更新員工</h5>
		      </div>		      
		      <div class="modal-body">
		        <!-- 表單 -->
		        <form class="form-horizontal" id="form_update_emp">
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">empName</label>
					  <div class="col-sm-10">					  
							<q class="form-control-static" id="empName_update_static"></q>
					  </div>
					</div>
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">email</label>
					  <div class="col-sm-10">
					    <input type="text" name="email" class="form-control" id="email_update_emp" placeholder="test@gmail.com">
					    <!-- 放錯誤提示訊息 -->
					  	<span class="help-block"></span>
					  </div>
					</div>	
				
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">gender</label>
					  <input class="form-check-input" type="radio" name="gender" id="genderB_update_emp" value="M"> 男
					</div>
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">gender</label>
					  <input class="form-check-input" type="radio" name="gender" id="genderG_update_emp" value="F"> 女
					</div>		
				
					<div class="form-group">
						<label  class="col-sm-2 col-form-label col-form-label-sm">deptName</label>
						<div class="col-sm-10">	
							<select name="dId" id="dept_update_select" class="form-select" aria-label="Default select example">
							</select>
						</div>							
					</div>																												
				</form>		
			  </div>
		      <div class="modal-footer">
		            <button data-dismiss="modal" class="btn btn-default" type="button" id="emp_close">關閉</button>
		            <button class="btn btn-primary" type="button" id="emp_update_btn">送出</button>
		      </div>
		     </div>
		    </div>
		  </div>
		</div>
	
	
		<!-- add互動視窗 -->
		<div class="modal fade" id="empAddModle" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">添加員工</h5>
		      </div>		      
		      <div class="modal-body">
		        <!-- 表單 -->
		        <form class="form-horizontal" id="form_save_emp">
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">empName</label>
					  <div class="col-sm-10">
						  <input type="text" name="empName" class="form-control" id="name_add_emp" placeholder="name">
						  <span class="help-block"></span>
					  </div>
					</div>
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">email</label>
					  <div class="col-sm-10">
					    <input type="text" name="email" class="form-control" id="email_add_emp" placeholder="test@gmail.com">
					    <!-- 放錯誤提示訊息 -->
					  	<span class="help-block"></span>
					  </div>
					</div>	
				
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">gender</label>
					  <input class="form-check-input" type="radio" name="gender" id="genderB_add_emp" value="M"  checked="checked"> 男
					</div>
					<div class="form-group">
					  <label  class="col-sm-2 col-form-label col-form-label-sm">gender</label>
					  <input class="form-check-input" type="radio" name="gender" id="genderG_add_emp" value="F"> 女
					</div>		
				
					<div class="form-group">
						<label  class="col-sm-2 col-form-label col-form-label-sm">deptName</label>
						<div class="col-sm-10">	
							<select name="dId" id="dept_select" class="form-select" aria-label="Default select example">
							</select>
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

	<div class="container">
		  <div class="row"></div>
		  	<div class="col-md-12">
		  		SSM-CRUD
		  	</div>
		  <div class="row">
		  		<div class="col-md-4 col-md-offset-8">
		  			<button class="btn btn-primary" id="emp_add_modal_btn">
		  				<span class="glyphicon glyphicon-align-left"  aria-hidden="true"></span>新增		
		  			</button>
		  			<button class="btn btn-danger" id="emp_delete_all_btn">
		  				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>刪除
		  			</button>
		  		</div>
		  </div>
		  <div class="row"></div>
		  		<div class="col-md-12">
		  			<table class="table table-striped" id="emps_table">
		  			<thead>
						<tr>
							<th>							
								<input type="checkbox" id="check_all"/>
							</th>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>	
							<th>操作</th>								
						</tr>
					</thead>
					<tbody>
					
					</tbody>															
					</table>
		  		</div>		  
		  <div class="row">		  
		  	<div class="col-md-6" id="page_info_area">
	  	
		  	</div>
		  	<div class="col-md-6" id="page_nav_area">
		  	
		  	</div>
		  </div>		  
	</div>
	


	
	<!-- $為jQuery訪問頁面後載入 -->
	<script type="text/javascript">
	
		var totalRecord,currentPage
		
		$(function(){
			//總分頁資料查詢
			to_page(1);		
		});
	
		//發GET請求到emps，參數pn=1，成功訪問將Json字串傳入result
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH}/emps",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					//表單編輯
					build_emp_table(result);
					//分頁訊息編輯
					build_page_info(result);	
					//分頁欄編輯
					build_page_nav(result);
				}
			});						
		};
	
		
		function build_emp_table(result){
			//清空
			$("#emps_table tbody").empty();
			//Json串接
			var emps = result.extend.pageInfo.list;
			//jQuery遍歷，item為當前對象
			$.each(emps,function(index,item){
				//jQuery串接
				var checkBoxTd =$("<td><input type='checkbox' class='check_item'/></td>")
				var empIdTd =$("<td></td>").append(item.empId);
				var empNameTd =$("<td></td>").append(item.empName);
				var genderTd =$("<td></td>").append(item.gender =='M'?'男':'女');
				var emailTd =$("<td></td>").append(item.email);
				var deptNameTd =$("<td></td>").append(item.department.deptName);
				
				var editBtn =$("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
				.append("<span></span>").addClass("glyphicon glyphicon-align-left").append("UPDATE");
				//將id加入按鈕自訂屬性中
				editBtn.attr("edit-id",item.empId);
				
				var delBtn =$("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
				.append("<span></span>").addClass("glyphicon glyphicon-star").append("DELETE");
			
				delBtn.attr("del-id",item.empId);
				
				var btn =$("<td></td>").append(editBtn).append(" ").append(delBtn);
				
				
				$("<tr></tr>").append(checkBoxTd).append(empIdTd).append(empNameTd).
					append(genderTd).append(emailTd).append(deptNameTd)
					.append(btn).appendTo("#emps_table tbody");
				

			});
			
		}
		function build_page_info(result){
			$("#page_info_area").empty();
			var emps = result.extend.pageInfo;
			$("#page_info_area").append("第"+emps.pageNum+"頁, 總頁數"+emps.pages+", 總筆數"+emps.total);
			
			totalRecord = emps.total;
			currentPage = emps.pageNum;
		}
		
		
		function build_page_nav(result){
			$("#page_nav_area").empty()
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append($("<a></a>").append("第一頁").attr("href","#"));			
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
			if(result.extend.pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{				
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum-1);
				});
			}
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));	
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末頁").attr("href","#"));				
			if(result.extend.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{			
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum+1);
				});
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});			
			}
			ul.append(firstPageLi).append(prePageLi);
			
			//顯示可視分頁
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
				if(result.extend.pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				
				ul.append(numLi);
			});
			
			ul.append(nextPageLi).append(lastPageLi);
			
			//整合分頁
			$("<nav></nav>").append(ul).appendTo("#page_nav_area");
			
		}
		
		/**/
		
		//新增
		$("#emp_add_modal_btn").click(function(){
			//重製彈出視窗
			reset_form("#empAddModle form")
			//拿部門資料
			getDepts("#dept_select");	
			//彈出視窗
			$("#empAddModle").modal('show')										
		});
		
		
		function reset_form(ele){
			//清空表單，reset為DOM對象的方法
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
			
		}
		
				
		function getDepts(ele){			
			$(ele).empty();
			$.ajax({
				url:"${APP_PATH}/depts",
				type:"GET",				
				success:function(result){					
					$.each(result.extend.depts,function(){
						var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
						optionEle.appendTo(ele);
					});
				}
			});
		}
		
		
		//****************************************************
		
		//前端效驗
		function validate_add_form(){
			
			var com_validate = true;
			var empName =$("#name_add_emp").val();
			var regName =/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,16}$)/;
			//不匹配 = true
			if(!regName.test(empName)){
				//alert("姓名錯誤");		
				show_validate_msg("#name_add_emp","error","少於6個字")						
				com_validate = false;
			}else{
				show_validate_msg("#name_add_emp","success","")						
			};
			
			
			var email =$("#email_add_emp").val();
			var regEmail =/^([a-zA-Z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
			if(!regEmail.test(email)){
				//alert("油箱錯誤");
				show_validate_msg("#email_add_emp","error","油箱~格式錯誤")
				com_validate = false;
			}else{
				show_validate_msg("#email_add_emp","success","")							
			};
			
			return com_validate;
			
			
		}
		
		//前端效驗狀態統一
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
				url:"${APP_PATH}/emp",
				type:"POST",
				//序列化表單內容，表單中的name必須等於實體類的名稱
				//接收參數必須是String 
				data:$("#form_save_emp").serialize(),
				success:function(result){
					if(result.code==200){
						//關閉視窗
						$("#empAddModle").modal('hide')
					
						//跳轉到末頁，須設定全域變數
						to_page(totalRecord)						
					}else{
						if(undefined != result.extend.errorFields.empName){
							show_validate_msg("#name_add_emp","error",result.extend.errorFields.empName)
						}
						if(undefined != result.extend.errorFields.email){
							show_validate_msg("#email_add_emp","error",result.extend.errorFields.email)
						}

					}

				}
			});
							
		});
		
		//後端帳號重複驗證
		$("#name_add_emp").change(function(){
			//輸入框的值
			var empName = this.value;				
			$.ajax({
				url:"${APP_PATH}/checkuser",
				data:"empName="+empName,
				type:"POST",
				success:function(result){
					if(result.code == 200){
						show_validate_msg("#name_add_emp","success","用戶可用");
						$("#emp_save").attr("ajax-va", "success");					
					}else{
						show_validate_msg("#name_add_emp","error",result.extend.va_msg);
						$("#emp_save").attr("ajax-va", "error");
					}
				}
			});
							
		});
		
		//更新按鈕
		$(document).on("click",".edit_btn",function(){			
			getDepts("#dept_update_select");
			getEmp($(this).attr("edit-id"));
			//將id傳給彈出視窗的update按鈕
			$("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"))
			$("#empUpdateModle").modal({			
				backdrop:"static"
				
			});						
		});
		
				
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/emp/"+id,
				type:"GET",
				success:function(result){
					var empData =result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					//val直接為表單付值
					$("#email_update_emp").val(empData.email);
					$("#empUpdateModle input[name=gender]").val([empData.gender]);
					$("#empUpdateModle select").val([empData.dId]);
					
				}
			});
			
			
		}
		
		//彈出視窗更新按鈕
		$("#emp_update_btn").click(function(){	
	
			var email = $("#email_update_emp").val()
			var regEmail =/^([a-zA-Z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
				if(!regEmail.test(email)){
					show_validate_msg("#email_update_emp","error","油箱~格式錯誤")
					return false
				}else{
					show_validate_msg("#email_update_emp","success","")							
				}
			
				
				//發送更新
				$.ajax({
					url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
					type:"POST",
					//序列化表單內容，表單中的name必須等於實體類的名稱
					data:$("#form_update_emp").serialize()+"&_method=PUT",
					success:function(result){
						if(result.code==200){
							//關閉視窗
							$("#empUpdateModle").modal('hide')
						
							//跳轉到末頁，須設定全域變數
							to_page(currentPage)						
						}else{
							if(undefined != result.extend.errorFields.email){
								show_validate_msg("#email_add_emp","error",result.extend.errorFields.email)
							}

						}

					}
				});									
		});
		
		//刪除按鈕
		$(document).on("click",".delete_btn",function(){			
			var empName =$(this).parents("tr").find("td:eq(2)").text();
			var empId = $(this).attr("del-id");
			if(confirm("刪除"+empName)){			
				$.ajax({
					url:"${APP_PATH}/emp/"+empId,
					type:"DELETE",
					success:function(result){					
						to_page(currentPage)
					}									
				});
				
			}
		});
		
		//全選按鈕
		$("#check_all").click(function(){
			//將check_item的屬性 =check_all
			$(".check_item").prop("checked",$(this).prop("checked"))
		});
		
		//每次點擊按鈕
		$(document).on("click",".check_item",function(){
			//以選取的個數 =全部
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag)
		});
		
		
		//批量刪除
		$("#emp_delete_all_btn").click(function(){
			var empNames ="";		
			var del_idstr ="";
			//串接以選員工
			$.each($(".check_item:checked"),function(){
				empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			//去除最後一個.
			empNames = empNames.substring(0,empNames.length-1);
			del_idstr = del_idstr.substring(0,del_idstr.length-1);			
			if( empNames.length >0){
				if(confirm("刪除"+empNames)){
					$.ajax({
						url:"${APP_PATH}/emp/"+del_idstr,
						type:"DELETE",
						success:function(result){					
							to_page(currentPage)
						}									
					});
				}
			}else{
				alert("未選擇員工")
			}
		});

		

	</script>
	</body>
</html>