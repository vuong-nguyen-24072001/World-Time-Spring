<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/admin/new/list" />
<c:url var="editNewURL" value="/admin/new/edit" />
<c:url var="newAPI" value="/api/new" />
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12 stretch-card grid-margin">
						<form:form class="w-100" id="formSubmit" modelAttribute = "model" enctype="multipart/form-data">	
							<form:hidden path="id" id="newId" />
							<div class="form-group col-sm-9">
								<label for="categoryCode" class="text-black">Category:</label> 
								<form:select class="form-control" path="categoryCode">
									<form:option value = "" label = "-- Category --"></form:option>
									<form:options items="${categories}"/>
								</form:select>
							</div>

							<div class="form-group col-sm-9">

								<label for="title" class="text-black">Title</label> <form:input 
									cssClass="form-control" 
									path="title"/>
							</div>

							<div class="form-group col-sm-9">

								<label for="author" class="text-black">Thumbnail</label> <form:input type="file" id="file"
									cssClass="form-control"
									path="thumbnail" />
							</div>
							<div class="form-group col-sm-9">

								<label for="shortDescription" class="text-black">Short
									Description</label> <form:input path="shortDescription" class="form-control" />
							</div>
							
							<div class="form-group col-sm-9">

								<label for="content" class="text-black">Content</label>
								<form:textarea path="content"
									cssClass="form-control"></form:textarea>
							</div>
							<div class="form-group col-sm-9">
								<a href="/" class="btn btn-warning">Cancel</a>
								<button type="button" class="btn btn-primary"
									id="btnAddOrUpdateNew">Save</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var id = $("#newId").val();
			var formDataE = new FormData();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			console.log(formData);
			formData[4].value = (document.getElementById("content_ifr").contentWindow.document.getElementById("tinymce").innerHTML);
			$.each(formData, function(i,v) {
				formDataE.append("" + v.name + "", v.value);
			})
			formDataE.append("file",$('#file')[0].files[0],$('#file')[0].files[0].name);
			for (var pair of formDataE.entries()) {
			    console.log(pair[0]+ ', ' + pair[1]); 
			}
			addNew(formDataE);
			/*  if (id == "") {
				addNew(formDataE);
			} else {
				updateNew(data);
			}  */
			
			function addNew(data){
				console.log("addd");
	        	$.ajax({
	        		url: '${newAPI}',
	                type: 'POST',
	                contentType: false,
	                processData: false,
	                data: data,
	                dataType: 'json',
	                success: function (result) {
	                	console.log(result);
	                	//window.location.href = "${newURL}?alert=success&message=Update Success";
	                },
	                error: function (error) {
	                	console.log(error);
	                	//window.location.href = "${newURL}?alert=danger&message=Update Failure !!!";
	                }
	            });
	        }
	        
	        function updateNew(data){
	        	console.log("update");
	        	$.ajax({
	                url: '${newAPI}',
	                type: 'PUT',
	                contentType: 'application/json',
	                data: data,
	                dataType: 'json',
	                success: function (result) {
	                	window.location.href = "${newURL}?alert=success&message=Update Success";
	                },
	                error: function (error) {
	                	window.location.href = "${newURL}?alert=danger&message=Update Failure !!!";
	                }
	            });
	        }
	        
	        function uploadfile(data){
	        	$.ajax({
	                url: '/uploadfile',
	                type: 'POST',
	                contentType: false,
	                processData: false,
	                data: data,
	                dataType: 'json',
	                success: function (result) {
	                	console.log(result);
	                	//window.location.href = "${newURL}?alert=success&message=Update Success";
	                },
	                error: function (error) {
	                	console.log(error);
	                	//window.location.href = "${newURL}?alert=danger&message=Update Failure !!!";
	                }
	            });
	        }
		})
</script>
</body>
</html>