<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page import="com.nguyenvuong.util.SecurityUtil" %>

<header id="header">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="navbar-top">
				<div class="d-flex justify-content-between align-items-center">
					<ul class="navbar-top-left-menu">
						<li class="nav-item"><a href="#" class="nav-link">Advertise</a>
						</li>
						<li class="nav-item"><a href="#" class="nav-link">About</a></li>
						<li class="nav-item"><a href="#" class="nav-link">Events</a>
						</li>
						<li class="nav-item"><a href="#" class="nav-link">Write
							for Us</a></li>
						<li class="nav-item"><a href="#" class="nav-link">In the
							Press</a></li>
					</ul>
					<ul class="navbar-top-right-menu">
						<li class="nav-item"><a href="#" class="nav-link"><i
								class="mdi mdi-magnify"></i></a></li>

						<security:authorize access="isAnonymous()">
							<li class="nav-item"><a href="<c:url value='login'/>" class="nav-link">Login</a>
							</li>
							<li class="nav-item"><a href="<c:url value='signup'/>"
													class="nav-link">Sign Up</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class="nav-item"><a href="#" class="nav-link"><%=SecurityUtil.getPrincipal().getFullName()%></a>
							</li>
							<li class="nav-item"><a href="<c:url value='logout'/>"
													class="nav-link">Log out</a></li>
						</security:authorize>
					</ul>
				</div>
			</div>
			<div class="navbar-bottom">
				<div class="d-flex justify-content-between align-items-center">
					<div>
						<a class="navbar-brand" href="/home?page=1"><img
								src="<c:url value='/template/web/images/logo.svg'/>"> </a>
					</div>
					<div>
						<button class="navbar-toggler" type="button"
								data-target="#navbarSupportedContent"
								aria-controls="navbarSupportedContent" aria-expanded="false"
								aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="navbar-collapse justify-content-center collapse"
							 id="navbarSupportedContent">
							<ul
									class="navbar-nav d-lg-flex justify-content-between align-items-center">
								<li>
									<button class="navbar-close">
										<i class="mdi mdi-close"></i>
									</button>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">MAGAZINE</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="/home/business?page=1">Business</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="/home/sport?page=1">Sports</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">Art</a></li>
								<li class="nav-item"><a class="nav-link" href="/home/policy?page=1">POLITICS</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">Travel</a>
								</li>

								<li class="nav-item"><a class="nav-link" href="#">Contact</a>
								</li>
							</ul>
						</div>
					</div>
					<ul class="social-media">

					</ul>
				</div>
			</div>
		</nav>
	</div>
</header>