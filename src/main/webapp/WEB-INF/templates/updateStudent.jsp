<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update student</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<style>
    .form-control{
        font-size: 18px;
    }
</style>

<body>
    <div class="container"  style="margin: 5%;">
        <div class="container" style="margin: 10%;">
            <h1 style="text-align: center; margin-bottom: 5%;">UPDATE INFORMATION STUDENT</h1>
            <c:url value="/updateStudent" var="updateStudent" />
            <form:form action="${updateStudent}" method="POST" modelAttribute="student_update">
                <h5>ID Student:</h5>
                <form:input type="text" class="form-control" path="idStudent" placeholder="Id student" value="${detailStudent.idStudent}" readonly="true"/>
                <br>
                <h5>Full Name:</h5>
                <form:input type="text" class="form-control" path="fullName" placeholder="Full name" value="${detailStudent.fullName}" />
                <br>
                <button class="btn btn-primary">UPDATE INFORMATION STUDENT</button>
            </form:form>
        </div>
    </div>
</body>
</html>