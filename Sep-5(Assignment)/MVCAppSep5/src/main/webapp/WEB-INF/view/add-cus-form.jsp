<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<div class="w-25 mx-auto mt-5">
		<h3>Add Employee Form</h3>
		<form:form action="addcusResp" modelAttribute="cus" method="POST"
			class="border p-3">
			<div class="mb-3">
				<form:input path="cusName" name="cusName"
					placeholder="Enter your name" class="form-control" />
			</div>
			<div class="mb-3">
				<form:input type="?number?" path="contactNo" name="contactNo"
					placeholder="Enter contact number" class="form-control" />
			</div>
			
			<input type="submit" value="Add" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>