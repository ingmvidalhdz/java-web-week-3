<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="container-title center">
			<h2 class="title-page">Web Shop</h2>
		</div>
		<div class="container-content center">
			<!-- put new button: Add Customer -->
			<input class="btn-add" type="button" value="Add Product"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Content</th>
					<th>Price</th>
					<th>Date Register</th>
					<th>Date Caduced</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempProducts" items="${products}">
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/products/showFormForUpdate">
						<c:param name="productsId" value="${tempProducts.id}" />
					</c:url>
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/products/delete">
						<c:param name="productsId" value="${tempProducts.id}" />
					</c:url>
					<tr>
						<td>${tempProducts.name}</td>
						<td>${tempProducts.description}</td>
						<td>${tempProducts.content}</td>
						<td>${tempProducts.price}</td>
						<td>${tempProducts.dateRegister}</td>
						<td>${tempProducts.dateExpiration}</td>
						<td>
							<!-- display the update link --> <a class="btn-update" href="${updateLink}">Update</a>
							| <a class="btn-delete" href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>









