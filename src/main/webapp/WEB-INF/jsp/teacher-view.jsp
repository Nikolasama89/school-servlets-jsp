<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Προβολή Καθηγητή</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/teacher-update.css">
</head>
<body>
<%@ include file="header.jsp"%>
<div class="main-content">
	<div class="m-bottom">
		<p><strong>Όνομα:</strong> ${readOnlyDTO.firstname}</p>
                <p><strong>Επώνυμο:</strong> ${readOnlyDTO.lastname}</p>
                <p><strong>ΑΦΜ:</strong> ${readOnlyDTO.vat}</p>
                <p><strong>Πατρώνυμο:</strong> ${readOnlyDTO.fatherName}</p>
                <p><strong>Τηλέφωνο:</strong> ${readOnlyDTO.phoneNum}</p>
                <p><strong>Email:</strong> ${readOnlyDTO.email}</p>
                <p><strong>Οδός:</strong> ${readOnlyDTO.street}</p>
                <p><strong>Αριθμός:</strong> ${readOnlyDTO.streetNum}</p>
                <p><strong>Τ.Κ.:</strong> ${readOnlyDTO.zipCode}</p>

                <p><strong>Πόλη:</strong>
                    <c:forEach items="${cities}" var="city">
                        <c:if test="${city.id == readOnlyDTO.cityId}">
                            ${city.name}
                        </c:if>
                    </c:forEach>
                </p>
	</div>

    <div class="m-bottom">
        <a href="${pageContext.request.contextPath}/school-app/teachers/view">Επιστροφή</a>
    </div>

    <div>
        ${requestScope.errorMessage}
    </div>
</div>
</body>
</html>