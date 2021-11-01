<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en"  xmlns:th="http://www.thymeleaf.org">


	<head>
		<%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Signin Template for Bootstrap</title>
		
		<!-- 引入jquery-->
		<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.2.1.slim.min.js"></script>
		
		<!-- Bootstrap core CSS 路徑-->
		<link href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom styles for this template 路徑-->
		<script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
				
	</head>
	
	<body>
	
	<div class="container">
		  <div class="row"></div>
		  	<div class="col-md-12">
		  		SSM-CRUD
		  	</div>
		  <div class="row">
		  		<div class="col-md-4 col-md-offset-8">
		  			<button class="btn btn-primary">
		  				<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>ADD 			
		  			</button>
		  			<button class="btn btn-danger">
		  				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>DELETE
		  			</button>
		  		</div>
		  </div>
		  <div class="row"></div>
		  		<div class="col-md-12">
		  			<table class="table table-striped">
						<tr>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>	
							<th>操作</th>								
						</tr>
						
						<c:forEach items="${pageInfo.list}" var="emp">
							<tr>
								<th>${emp.empId}</th>
								<th>${emp.empName}</th>
								<th>${emp.gender=="M"?"男":"女"}</th>
								<th>${emp.email}</th>
								<th>${emp.department.deptName}</th>	
								<th>操作</th>
								<th>
									<button class="btn btn-primary">
						  				<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>UPDATE 			
						  			</button>
						  			<button class="btn btn-danger">
						  				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>DELETE
						  			</button>													
								</th>								
							</tr>										
						</c:forEach>					
					</table>
		  		</div>		  
		  <div class="row">		  
		  	<div class="col-md-6">
		  		now ${pageInfo.pageNum },total page ${pageInfo.pages}, total number ${pageInfo.total }
		  	
		  	</div>
		  	<div class="col-md-6">
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  
				  <li><a href="${APP_PATH}/emps?pn=1">Title</a></li>
				  
				  
				  <c:if test="${pageInfo.hasPreviousPage }">
				  	<li class="page-item">
				      <a class="page-link" href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>				  
				  </c:if>


				    
				    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
				    	<c:if test="${page_Num == pageInfo.pageNum}">				    
				    		<li  class="active"><a href="#">${page_Num}</a></li>
				    	</c:if>
				    	<c:if test="${page_Num != pageInfo.pageNum}">				    
				    		<li><a href="${APP_PATH}/emps?pn=${page_Num}">${page_Num}</a></li>
				    	</c:if>
				    </c:forEach>
			    
				  <c:if test="${pageInfo.hasNextPage }">
				    <li class="page-item">
				      <a class="page-link" href="${APP_PATH}/emps?pn=${pageInfo.pageNum+1 }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>			  
				  </c:if>
			    
				    <li><a href="${APP_PATH}/emps?pn=${pageInfo.pages }">End</a></li>
				  </ul>
				</nav>		  	
		  	</div>
		  </div>
		  
	</div>
	

	</body>

</html>