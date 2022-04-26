<%@include file="/common/taglib.jsp"%>
<c:url var="newAPI" value="/api/new"/>
<c:url var ="NewURL" value="/admin-new"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>News List</title>
	</head>

	<body>
		<div class="main-content">
		<form action="<c:url value = '/quan-tri/bai-viet/danh-sach'/>" id="formSubmit" method="get" />
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="/home?page=1">Home Page</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<c:if test="${param.message != null}">
							<div class="alert alert-${param.alert}">${param.message}</div>
						</c:if>
						<div class="row">
							<div class="col-xs-12">
								<c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
								</c:if>
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<c:url var="createNewURL" value="/admin/new/edit" />
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='${createNewURL}'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button" onclick="confirmDeleteNews()"
														class="dt-button buttons-html5 btn btn-white btn-primary hidden" data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th></th>
														<th>Tittle</th>
														<th>Short Description</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${model.listResult}">
														<tr>
															<td><input type="checkbox" onclick="checkClickDeteleNew()" id="checkbox_${item.id}" value="${item.id}"></td>
															<td>${item.title}</td>
															<td>${item.shortDescription}</td>
															<td>
																<c:url var="updateNewURL" value="/admin/new/edit">
																	<c:param name="id" value="${item.id}"/>
																</c:url>
																<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																   title="Cập nhật bài viết" href='${updateNewURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																</a>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<ul class="pagination" id="pagination"></ul>
											<input type = "hidden" id = "page" value = "" name = "page"/>
											<input type = "hidden" id = "limit" value = "" name = "limit"/>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
		</div>
		<!-- /.main-content -->
		
		<script>
		
			function checkClickDeteleNew() {
				if (getAllChecked().length) {
					$('#btnDelete').removeClass("hidden");
					$('#btnDelete').addClass("show");
				} else {
					$('#btnDelete').removeClass("show");
					$('#btnDelete').addClass("hidden");				
				}
			}
		
			function confirmDeleteNews() {
				swal({
					title: 'Are you sure?',
					  text: "You won't be able to revert this!",
					  icon: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Yes, delete'
					}).then(function(isConfirm) {
					  if (isConfirm) {
							deleteNews(getAllChecked());
					  }
					});
			}
			
			function getAllChecked() {
				return $('tbody input[type=checkbox]:checked').map(function () {
		            return $(this).val();
		        }).get();
			}
			
			function deleteNews(data) {
				console.log(data);
				$.ajax({
		            url: '${newAPI}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {
		                window.location.href = "${newURL}?alert=success&message=delete_success";
		            },
		            error: function (error) {
		            	window.location.href = "${newURL}?alert=danger&message=error_delete";
		            }
		        });
			}
		</script>
	</body>

	</html>