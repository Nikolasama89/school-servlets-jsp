<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Επιτυχής Εισαγωγή</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/success.css">
</head>
<body>

	<div class="success m-bottom">
		<h1>Επιτυχής Εγγραφή</h1>
		<p>Username: ${sessionScope.userInfo.username}</p>
	</div>	
	 	
	<div>
		<a href="${pageContext.request.contextPath}/login">Επιστροφή</a>
	</div> 	
</body>
</html>
