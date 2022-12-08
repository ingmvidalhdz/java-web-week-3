<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Candidates Tracker App</title>
<link rel="icon" type="image/x-icon"
	href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfnBVPMPfBILqQFAmEdcAkJGWzQUFEmDxXJA&usqp=CAU">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container-title">
		<h2 class="title-app">Candidates for job</h2>
	</div>
	<div class="container">
		<div class="content center">
			<!-- put new button: Add Student -->
			<input class="btn-add" type="button" value="Add Candidate"
				onclick="window.location.href='add-student-form.html'; return false;" />
			<table class="table-content center">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Deparment</th>
					<th>Degree</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach var="tempStudent" items="${LISTA_CANDIDATOS}">
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="CandidateControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="CandidateControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					<tr>
						<td>${tempStudent.name}</td>
						<td>${tempStudent.lastName}</td>
						<td>${tempStudent.email}</td>
						<td>${tempStudent.phone}</td>
						<td>${tempStudent.department}</td>
						<td>${tempStudent.degree}</td>
						<td><a class="btn-update" href="${tempLink}">Update</a></td>
						<td><a class="btn-delete" href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<script type="text/javascript" src="scripts-js/app.js"></script>
	</div>
</body>
</html>








