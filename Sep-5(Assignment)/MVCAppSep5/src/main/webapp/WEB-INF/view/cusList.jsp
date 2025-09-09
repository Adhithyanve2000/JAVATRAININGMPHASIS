<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
</head>
<body>
	<div class="mt-5 w-50 mx-auto">
		<a href="addForm1" class="btn btn-secondary mb-3 ">Add Customer</a>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>Customer Name</th>
					<th>Contact Number</th>
				
				</tr>
			</thead>
			<tbody>

				<c:forEach var="cus" items="${cusList}">
					<tr>
						<td><c:out value="${cus.cusId}" /></td>
						<td><c:out value="${cus.cusName}" /></td>
						<td><c:out value="${cus.contactNo}" /></td>
						<td><a href="updateCusForm/${cus.cusId}"><i
								class="bi bi-pen me-3"></i></a> <a href="deleteCusById/${cus.cusId}"><i
								class="bi bi-file-earmark-x-fill"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>