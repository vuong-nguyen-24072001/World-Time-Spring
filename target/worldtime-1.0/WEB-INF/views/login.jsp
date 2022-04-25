<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="content-login-signup">
	<div class="container mb-5">
		<c:if test="${param.incorrectAccount != null}">
			<div class="alert alert-danger">Username or password incorrect
			</div>
		</c:if>
		<c:if test="${param.accessDenied != null}">
			<div class="alert alert-danger">You not permission</div>
		</c:if>
		<div class="row">
			<div class="col-md-6">
				<img
					src="<c:url value = '/template/web/images/undraw_remotely_2j6y.svg'/>"
					alt="Image" class="img-fluid">
			</div>
			<div class="col-md-6 contents">
				<div class="row justify-content-center">
					<div class="col-md-8">
						<div class="mb-4">
							<h3>Sign In</h3>
							<p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit
								aut eos consectetur adipisicing.</p>
						</div>
						<form action="j_spring_security_check" method="post">
							<div class="form-group first">
								<label for="username">Username</label> <input type="text"
									class="form-control" placeholder="username" id="username"
									name="j_username">

							</div>
							<div class="form-group last mb-4">
								<label for="password">Password</label> <input type="password"
									class="form-control" placeholder="password" id="password"
									name="j_password">

							</div>

							<div class="d-flex mb-5 align-items-center">
								<label class="control control--checkbox mb-0"><span
									class="caption"><a href="<c:url value='signup'/>">Create an
											Account</a></span> </label> <span class="ml-auto"><a href="#"
									class="forgot-pass">Forgot Password</a></span>
							</div>

							<input type="submit" value="Log In"
								class="btn btn-block btn-primary"> <span
								class="d-block text-left my-4 text-muted">&mdash; or
								login with &mdash;</span>

							<div class="social-login">
								<a href="#" class="facebook"> <i
									class="fa-brands fa-facebook mr-3"></i>
								</a> <a href="#" class="twitter"> <i
									class="fa-brands fa-twitter mr-3"></i>
								</a> <a href="#" class="google"> <i
									class="fa-brands fa-google mr-3"></i>
								</a>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>
	</div>
</div>