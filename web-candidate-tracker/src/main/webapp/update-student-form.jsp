<!DOCTYPE html>
<html>

<head>
	<title>Update Student</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div class="container-title">
		<h2 class="title-app">Candidates for job</h2>
	</div>
	
	<div class="container">
		<form class="form center" action="CandidateControllerServlet" method="GET">
			<h3 class="title-form">Update Candidate</h3>
			
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="studentId" value="${THE_STUDENT.id}" />
			
			<label class="label-form" style="margin-left:30px" >First Name</label>
			<input type="text" name="name" value="${THE_STUDENT.name}" />
			
			<label class="label-form" style="margin-left:30px">Last Name</label>
			<input type="text" name="lastName" value="${THE_STUDENT.lastName}" />
			
			<label class="label-form">E-mail</label>
			<input type="text" name="email" value="${THE_STUDENT.email}" />
			
			<label class="label-form">Phone</label>
			<input type="text" name="phone" value="${THE_STUDENT.phone}" />
			
			<label class="label-form" style="margin-left:35px">Department</label>
			<input type="text" name="department" value="${THE_STUDENT.department}" />
			
			<label class="label-form">Degree</label>
			<input type="text" name="degree" value="${THE_STUDENT.degree}" />
			
			<input type="submit" value="Save" class="save" />
			<a class="btn-back" href="CandidateControllerServlet">Back to List</a>
		</form>
	</div>
</body>

</html>











