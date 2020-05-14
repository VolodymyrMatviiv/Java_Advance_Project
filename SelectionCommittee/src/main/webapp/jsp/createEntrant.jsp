<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Entrants</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="../css/createEntrant.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- //web font -->
<title>Entrants</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/menu.css">
</head>

<body>


	<jsp:include page="menu.jsp"></jsp:include>
	<div class="main-w3layouts wrapper">
				<h1>Create new Entrant</h1>
			<div class="main-agileinfo">
					<div class="agileits-top">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				<%-- 	<h2>
						Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2> --%>
				</c:if>




				<form:form method="POST" action="${contextPath}/addEntrant" enctype="multipart/form-data">
					<table>
						<tr>
							<td>FirstName</td>
							<td><input type="text" name="firstName" /></td>
						</tr>
						<tr>
							<td>LastName</td>
							<td><input type="text" name="lastName" /></td>
						</tr>
				
						<tr>
							<td>Faculty</td>
							<td>
								<%
								    try{
								//Class.forName("com.mysql.jdbc.Driver").newInstance();
								Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/selection_committee?user=root&password=1234&serverTimezone=UTC");
								       Statement statement = connection.createStatement() ;
								       resultset = statement.executeQuery("select * from faculty") ;
								%>
								        <select name="faculty">
								        <%  while(resultset.next()){ %>    
								        <option value = <%= resultset.getInt(1) %>><%= resultset.getString(2) %></option>
								        <% } %>
								        </select>	
								<%
								//**Should I input the codes here?**
								        }
								        catch(Exception e)
								        {
								             out.println("wrong entry"+e);
								        }
								%>							</td>
						</tr>
						<tr>
							<td>First Subject</td>
							<td><input type="text" name="firstSubject" /></td>
						</tr>
						<tr>
							<td>Second Subject</td>
							<td><input type="text" name="secondSubject" /></td>
						</tr>
						<tr>
							<td>Third Subject</td>
							<td><input type="text" name="thirdSubject" /></td>
						</tr>
						<tr class = "style">
							<td>Fourth Subject</td>
							<td><input type="text" name="fourthSubject" /></td>
						</tr>
						
						
						<tr>
							<td>Select an image to upload</td>
							<td><input type="file" name="image" /></td>
						</tr>
												
						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>


			</div>

		</div>


	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="../js/menu.js"></script>

</body>
</html>