<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>World Time</title>
</head>
<body>
	<div class="flash-news-banner">
		<div class="container">
			<div class="d-lg-flex align-items-center justify-content-between">
				<div class="d-flex align-items-center">
					<span class="badge badge-dark mr-3">Flash news</span>
					<p class="mb-0">Lorem Ipsum has been the industry's standard
						dummy text ever since the 1500s.</p>
				</div>
				<div class="d-flex">
					<span class="mr-3 text-danger">Thank you for visiting my
						website</span>
				</div>
			</div>
		</div>
	</div>

	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-xl-8 stretch-card grid-margin">
					<div class="position-relative">
					
						<img src="<c:url value = '/template/web/images/banner.jpg'/>" alt="banner" class="img-fluid" />
						<div class="banner-content">
							<div class="badge badge-danger fs-12 font-weight-bold mb-3">
								global news</div>
							<h1 class="mb-2">Coronavirus Outbreak LIVE Updates: ICSE,
								CBSE Exams Postponed, 168 Trains</h1>
							<div class="fs-12">
								<span class="mr-2">Photo </span>10 Minutes ago
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-4 stretch-card grid-margin">
					<div class="card bg-dark text-white">
						<div class="card-body">
							<h2>Latest news</h2>
							
							<c:forEach var="item" items="${modelNewsTop3.listResult}">
								<div
                                        class="d-flex border-bottom-blue pt-3 pb-4 align-items-center justify-content-between">
                                        <div class="pr-3 w-100">
                                            <div class="row">
                                                <div class="col-sm-7">
                                                    <h5 class="title-last-news">
                                                        <a class="text-white" href="/worldtime-1.0/home/news/${item.id}">
                                                            ${item.title}
                                                        </a>
                                                    </h5>
                                                    </a>
                                                    <div class="fs-12 d-flex flex-column">
                                                        <span class="mr-2 title-last-news">
                                                            ${item.shortDescription}
                                                        </span>10 Minutes ago
                                                    </div>
                                                </div>
                                                <div class="col-sm-5">
                                                    <div class="rotate-img w-75">
                                                        <img src="/uploads/thumbnail/${item.thumbnail}"
                                                            alt="thumb" class="img-fluid img-lg" />
                                                    </div>
                                                </div>
                                            </div>

                                        </div>

                                    </div>
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3 grid-margin">
					<div class="card">
						<div class="card-body">
							<h2>Category</h2>
							<ul class="vertical-menu">
								<li><a href="/home/policy">Politics</a></li>
								<li><a href="/home/business">Business</a></li>
								<li><a href="#">Finance</a></li>
								<li><a href="#">Health care</a></li>
								<li><a href="#">Technology</a></li>
								<li><a href="#">Jobs</a></li>
								<li><a href="#">Media</a></li>
								<li><a href="#">Administration</a></li>
								<li><a href="/home/sport">Sports</a></li>
								<li><a href="#">Game</a></li>
								<li><a href="#">Art</a></li>
								<li><a href="#">Kids</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-9 stretch-card grid-margin">
					<div class="card">
						<div class="card-body">
							<c:forEach var="item" items="${model.listResult}">
								<div class="row">							
									<div class="col-sm-4 grid-margin">
										<div class="position-relative">
											<div class="rotate-img">
												<img src="${pageContext.request.contextPath}/uploads/thumbnail/${item.thumbnail}" alt="thumb"
													class="img-fluid" />
											</div>
										</div>
									</div>
									<div class="col-sm-8  grid-margin">
										<h2 class="mb-2 font-weight-600"><a href="/worldtime-1.0/home/news/${item.id}">${item.title}</a></h2>
										<div class="fs-13 mb-2">
											<span class="mr-2">${item.createdBy	}</span>10 Minutes ago
										</div>
										<p class="mb-0">${item.shortDescription}</p>
									</div>
								</div>
							</c:forEach>
						
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>