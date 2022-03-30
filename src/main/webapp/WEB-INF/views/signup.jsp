<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.nguyenvuong.util.SecurityUtil" %>
<c:url var="userAPI" value="/api/user" />
<div class="content-login-signup">
    <div class="container">
    	<c:if test="${param.userExist != null}">
			<div class="alert alert-danger">Username Exist, please use another Username
			</div>
		</c:if>
		<c:if test="${param.passwordNotMatch != null}">
			<div class="alert alert-danger">Check your password</div>
		</c:if>
        <div class="row">
            <div class="col-md-6">
                <img src="<c:url value = '/template/web/images/undraw_remotely_2j6y.svg'/>" alt="Image" class="img-fluid">
            </div>
            <div class="col-md-6 contents">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="mb-4">
                            <h3>Sign Up</h3>
                            <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur
                                adipisicing.</p>
                        </div>
                        <form id="formSignUp">
                            <div class="form-group first">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" placeholder="username" id="userName"
                                    name="userName" required>

                            </div>
                            <div class="form-group last mb-4">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" placeholder="password" id="password"
                                    name="password" required>

                            </div>
                           
                            <div class="form-group last mb-4">
                                <label for="repeatPassword">Confirm Password</label>
                                <input type="password" class="form-control" placeholder="confirm password"
                                    id="confirmPassword" required>

                            </div>
                            
                            <div class="form-group last mb-4">
                                <label for="fullName">Fullname</label>
                                <input type="fullName" class="form-control" placeholder="full name" id="fullName"
                                    name="fullName" required>

                            </div>

                            <div class="d-flex mb-5 align-items-center">
                                <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                                    <input type="checkbox" checked="checked" />
                                    <div class="control__indicator"></div>
                                </label>
                                <span class="ml-auto">You have an <a href="#" class="forgot-pass">Account</a> ?</span>
                            </div>

                            <button type="button" value="Sign Up" id="btnSignUp" class="btn btn-block btn-primary">Sign Up</button>

                            <span class="d-block text-left my-4 text-muted">&mdash; or Sign Up with &mdash;</span>

                            <div class="social-login">
                                <a href="#" class="facebook">
                                    <i class="fa-brands fa-facebook mr-3"></i>
                                </a>
                                <a href="#" class="twitter">
                                    <i class="fa-brands fa-twitter mr-3"></i>
                                </a>
                                <a href="#" class="google">
                                    <i class="fa-brands fa-google mr-3"></i>
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

	$('#btnSignUp').click(function(e) {
		e.preventDefault();
		var data = {};
		var password = $('#password').val();
		var confirmPassword = $('#confirmPassword').val();
		if (password != confirmPassword) {
			window.location.href = "/signup?passwordNotMatch";
		}
		var formData = $('#formSignUp').serializeArray();
		$.each(formData, function(i,v) {
			data["" + v.name + ""] = v.value;
		})
		isUserExist(data);
	})
	
	function createUser(data){
	        	$.ajax({
	                url: '${userAPI}',
	                type: 'POST',
	                contentType: 'application/json',
	                data: JSON.stringify(data),
	                dataType: 'json',
	                success: function (result) {
	                	window.location.href = "/login";
	                },
	                error: function (error) {
	                	window.location.href = "/signup";
	                }
	            });
	        }
	function isUserExist(data) {
		var url = '${userAPI}?username=' + data.userName;
		$.ajax({
            url: url,
            type: 'GET',
            success: function (result) {
            	if (result.userName){
            		console.log("duplicate user");
            	} else {
            		createUser(data);            		
            	}
            },
            error: function (error) {
            	console.log(error);
            }
        });
	} 

</script>