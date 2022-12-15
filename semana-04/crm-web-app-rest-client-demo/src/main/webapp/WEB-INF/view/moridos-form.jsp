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
			<h2 class="title-page">Funeraria Bellakoza</h2>
		</div>
		<form:form class="form center" action="saveMorido"
			modelAttribute="moridos" method="POST">
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
			<h3 class="title-form">Datos del difunto</h3>
			<form:input path="nombre" placeholder="nombre" />
			<form:input path="apellidos" placeholder="apellidos" />
			<form:input path="edad" placeholder="edad" />
			<form:input path="fechaMoricion" placeholder="Fecha de la defuncion" />
			<form:input path="horaMoricion" placeholder="Hora en la que se quedo tiezo" />
			<form:input path="lugarMoricion" placeholder="Lugar del desceso" />
                        <form:input path="causaMoricion" placeholder="Causa de muerte" />
			<input type="submit" value="Save" class="save" />
			<div class="container-back center">
				<a class="btn-back"
					href="${pageContext.request.contextPath}/moridos/list">Back to
					List</a>
			</div>
		</form:form>
	</div>
</body>
</html>










