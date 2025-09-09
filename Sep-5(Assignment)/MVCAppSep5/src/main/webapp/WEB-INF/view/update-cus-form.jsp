<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Update Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
<form:form action="${pageContext.request.contextPath}/customer/updateCusResp" modelAttribute="cus" method="POST"
		class="w-25 mx-auto mt-5 border p-3">
		<div class="mb-3">
			<form:input path="cusId" name="cusId" readonly="true"
				class="form-control" />
		</div>
		<div class="mb-3">
			<form:input path="cusName" name="cusName"
				placeholder="Enter your name" class="form-control" />
		</div>
		<div class="mb-3">
			<form:input path="contactNo" name="contactNo"
				placeholder="Enter contact number" class="form-control" />
		</div>
		
		<input type="submit" value="Update" class="btn btn-primary" />
	</form:form>

</body>
</html>