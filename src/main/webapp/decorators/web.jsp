<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>World Time</title>
<link href="<c:url value='/template/web/css/app.css'/>" rel="stylesheet"
	type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">

<link href="<c:url value='/template/web/fonts/icomoon/style.css'/>"
	rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="<c:url value='/template/web/css/owl.carousel.min.css'/>">


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value='/template/web/css/bootstrap.min.css'/>">

<!-- Style -->

<link rel="stylesheet"
	href="<c:url value='/template/web//css/style.css'/>">
	
	<script src="<c:url value='/template/web/js/jquery-3.3.1.min.js'/>"></script>
</head>
<body>


	<%@ include file="/common/web/header.jsp"%>

	<dec:body />

	<%@ include file="/common/web/footer.jsp"%>

	<script
		src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"
		referrerpolicy="origin"></script>
	<script>
		tinymce.init({
			selector : 'textarea'
		});
	</script>
	<script src="https://kit.fontawesome.com/ed7bf01ebf.js"
		crossorigin="anonymous"></script>

	<script src="<c:url value='/template/web/js/popper.min.js'/>"></script>

	<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>

	<script src="<c:url value='/template/web/js/main.js'/>"></script>

</body>
</html>