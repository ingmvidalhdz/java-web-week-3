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
				onclick="window.location.href='add-candidate-form.html'; return false;" />
			<table class="table-content center">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach var="tempCandidate" items="${LISTA_CANDIDATOS}">
					<!-- set up a link for each candidate -->
					<c:url var="tempLink" value="CandidateControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="candidateId" value="${tempCandidate.id}" />
					</c:url>
					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="CandidateControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="candidateId" value="${tempCandidate.id}" />
					</c:url>
					<tr>
						<td>${tempCandidate.name}</td>
						<td>${tempCandidate.lastName}</td>
						<td>${tempCandidate.email}</td>
						<td><a class="btn-update" href="${tempLink}">Show More</a></td>
						<td><a class="btn-delete" href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this candidate?'))) return false">
								Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<script type="text/javascript" src="scripts-js/app.js"></script>
	</div>
</body>
</html>








