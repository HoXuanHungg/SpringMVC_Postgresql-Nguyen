<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List students</title>
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
	.error{
		color: red;
	}
</style>

<body>
	<div class="container mt-3" style="margin-top: 10px">
		<form:form action="saveStudent" method="POST" modelAttribute="student_save">
			<div>
			  <div>
			  	  <h5>Id Student:</h5>
				  <form:input type="text" class="form-control" placeholder="Id student" path="idStudent" />
				  <form:errors path="idStudent" cssClass="error"></form:errors>
			  </div>
			  <br>
			  <div>
			  		<h5>Full Name:</h5>
				  <form:input type="text" class="form-control" placeholder="Full name" path="fullName" />
				  <form:errors path="fullName" cssClass="error"></form:errors>
			  </div>
			</div>  
			<br>
			<button class="btn btn-primary" type="submit">CREATE INFORMATION STUDENT</button>
			
		</form:form>

		<hr>

		<h2 style="text-align: center;">LIST STUDENTS</h2>

		<br>

		<h4 style="margin-bottom: 15px;">Number students: ${statistical}</h4>

		<table class="table table-bordered" style="margin-top: 10px">
			<tr style="text-align: center;">
				<th>Number</th>
				<th>Id student</th>
				<th>Full name</th>
				<th>Detail</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			
			<c:if test="${not empty listStudents}">
				<c:forEach var="student" items="${listStudents}" varStatus="loop">
					<tr>
						<td style="text-align: center; vertical-align: inherit;"><c:out value="${loop.count}"></c:out></td>
						<td style="text-align: center; vertical-align: inherit;">${student.idStudent}</td>
						<td style="vertical-align: inherit;">${student.fullName}</td>
						<td style="width: 80px">
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#detailStudent${student.idStudent}">Detail</button>

							<!-- The Modal Detail Student -->
							<div class="modal fade" id="detailStudent${student.idStudent}">
								<div class="modal-dialog">
									<div class="modal-content">
								
										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title">Information Student</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
								
										<!-- Modal body -->
										<div class="modal-body">
											<h4><small><b>Id Student:</b> ${student.idStudent}</small></h4>
											<br>
											<h4><small><b>Full Name:</b> ${student.fullName}</small></h4>
										</div>
								
										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
										</div>
								
									</div>
								</div>
							</div>
						</td>
						<td style="width: 80px"><a href="updateStudent/${student.idStudent}" class="btn btn-success">Update</a></td>
						<td style="width: 80px"><a href="deleteStudent/${student.idStudent}" class="btn btn-info">Delete</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>