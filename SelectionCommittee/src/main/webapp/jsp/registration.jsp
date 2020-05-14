<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

<link rel="stylesheet" href="../css/login.css">

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
		$(document).ready(function() {
			var selItem = localStorage.getItem("locales");
			$('#locales').val(selItem ? selItem : 'en');
			$("#locales").change(function() {
				var selectedOption = $('#locales').val();
				if (selectedOption) {
					window.location.replace('?lang=' + selectedOption);
					localStorage.setItem("locales", selectedOption);
				}
			});
		});
	</script>
	
</head>
<body>
<div class="login-page">

		<div class="form">
    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading"><spring:message code="registration.title.2" /></h2>
        
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="firstName" placeholder="First name"
                            autofocus="true"></form:input>
                <form:errors path="name"></form:errors>
            </div>
        </spring:bind>
        
          <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="surname" class="lastName" placeholder="Last name"
                            autofocus="true"></form:input>
                <form:errors path="surname"></form:errors>
            </div>
        </spring:bind>
        
        
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="email" class="email" placeholder="Email"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="password" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

   <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="password"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind> 
        <spring:bind path="role">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select type="password" path="role" class="form-control" placeholder="Role" id="exampleFormControlSelect1">
                	<form:option value="" label=""/>
                	<form:option value="User" label="User"/>  
                    <form:option value="Admin" label="Admin"/>  
                </form:select>
                <form:errors path="role"></form:errors>
            </div>
        </spring:bind>

        <button class="register" type="submit"><spring:message code="registration.create_account" /></button>
        <p class="message"><a href="${contextPath}/login">Log In</a></p>
        	<div class="text-center p-t-12">
						<fieldset>
							<label><spring:message code="registration.choose_language" /></label> <select
								class="text-center p-t-12" id="locales">
								<option value="en"><spring:message code='registration.english' /></option>
								<option value="uk"><spring:message code='registration.ukrainian' /></option>
							</select>
						</fieldset>
					</div>
    </form:form>

</div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>