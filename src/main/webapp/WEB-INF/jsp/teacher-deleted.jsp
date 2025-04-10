<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h1>Επιτυχής Διαγραφή</h1>
    <p>Κωδικός: ${requestScope.id}</p>
</div>

<div>
    <a href="${pageContext.request.contextPath}/school-app/teachers/view">Επιστροφή</a>
</div>
</body>
</html>