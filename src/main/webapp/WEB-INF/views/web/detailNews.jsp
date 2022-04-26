<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-xl-12">
							<div class="card-title">
								<h1>
									${model.title}
								</h1>
								<p class="fs-13 mb-1 text-muted">
	                                    <span class="mr-2">
	                                        Author
	                                    </span>10 Minutes ago
								</p>
							</div>
							<div class="row">
								<div class="col-xl-9 col-lg-8 col-sm-6">
									<div class="description-news">
										${model.content}
									</div>
								</div>
								<div class="col-xl-3 col-lg-4 col-sm-6">
									<div class="border-bottom pb-3 mb-3">
										<h4>Other news</h4>
									</div>

									<c:forEach var="item" items="${modelNewsTop3.listResult}">
										<div class="border-bottom pb-3 mb-3">
											<div class="row">
												<div class="col-sm-5 pr-2">
													<div class="rotate-img">
														<img src="/uploads/thumbnail/${item.thumbnail}" alt="thumb"
															 class="img-fluid w-100">
													</div>
												</div>
												<div class="col-sm-7 pl-2">
													<h5 class="title-last-news">
														<a class="" href="/home/news/${item.id}">
																${item.title}
														</a>
													</h5>
													<p class="fs-13 text-muted mb-0">
		                                                    <span class="mr-2">${item.createdBy}
															</span>10
														Minutes ago
													</p>
													<p class="mb-0 fs-13 title-last-news">
															${item.shortDescription}
													</p>
												</div>
											</div>
										</div>
									</c:forEach>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>