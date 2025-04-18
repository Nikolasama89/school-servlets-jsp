<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">-->
</head>
<body class="min-h-screen flex flex-col bg-gray-50 text-gray-800">
<%@ include file="header.jsp"%>


        <div class="flex-grow flex flex-col justify-center items-center text-center p-4">

            <h1 class="text-2xl sm:text-3xl font-bold mb-6 text-primary-700">Coding Factory Dashboard</h1>

            <div class="grid gap-6 sm:grid-cols-2 w-full max-w-md">
                <div class="bg-white border border-gray-300 rounded-lg p-4 shadow hover:shadow-lg transition transform hover:-translate-y-1">
                    <a href="<c:url value='${pageContext.request.contextPath}/school-app/teachers/view' />">Προβολή Καθηγητών</a>
                </div>

                <div class="bg-white border border-gray-300 rounded-lg p-4 shadow hover:shadow-lg transition transform hover:-translate-y-1">
                    <a href="<c:url value='${pageContext.request.contextPath}/school-app/teachers/view' />">Προβολή Μαθητών</a>
                </div>
            </div>
        </div>


<%@ include file="footer.jsp"%>
</body>
</html>