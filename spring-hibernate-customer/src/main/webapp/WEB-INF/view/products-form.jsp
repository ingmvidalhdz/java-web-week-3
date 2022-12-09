<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Save Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div class="container">
		<div class="container-title">
			<h2 class="title-page">Web Shop</h2>
		</div>
		<form:form class="form center" action="saveCustomer"
			modelAttribute="products" method="POST">
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
			<h3 class="title-form">Save Product</h3>
			<form:input path="name" placeholder="Name" />
			<form:input path="description" placeholder="Description" />
			<form:input path="content" placeholder="Content" />
			<form:input path="price" placeholder="Price" />
			<form:input path="dateRegister" placeholder="Date Register" />
			<form:input path="dateExpiration" placeholder="Date Caduced" />
			<input type="submit" value="Save" class="save" />
			<div class="container-back center">
				<a class="btn-back"
					href="${pageContext.request.contextPath}/products/list">Back to
					List</a>
			</div>
		</form:form>
	</div>
</body>
</html>










