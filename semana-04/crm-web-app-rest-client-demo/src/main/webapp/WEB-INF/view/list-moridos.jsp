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
                       onclick="window.location.href = 'showFormForAdd'; return false;"
                       class="add-button" />
                <!--  add our html table here -->
                <table>
                    <tr>
                        <th>Nombre del difunto</th>
                        <th>Apellidos</th>
                        <th>Edad</th>
                        <th>Fecha de defuncion</th>
                        <th>Hora de la Muerte</th>
                        <th>Lugar de la Muerte</th>
                        <th>Causa de la Muerte</th>
                        <th>Action</th>
                    </tr>
                    <!-- loop over and print our customers -->
                    <c:forEach var="tempMoridos" items="${moridos}">
                        <!-- construct an "update" link with customer id -->
                        <c:url var="updateLink" value="/moridos/showFormForUpdate">
                            <c:param name="moridosId" value="${tempMoridos.id}" />
                        </c:url>
                        <!-- construct an "delete" link with customer id -->
                        <c:url var="deleteLink" value="/moridos/delete">
                            <c:param name="moridosId" value="${tempMoridos.id}" />
                        </c:url>
                        <tr>
                            <td>${tempMoridos.nombre}</td>
                            <td>${tempMoridos.apellidos}</td>
                            <td>${tempMoridos.edad}</td>
                            <td>${tempMoridos.fechaMoricion}</td>
                            <td>${tempMoridos.horaMoricion}</td>
                            <td>${tempMoridos.lugarMoricion}</td>
                            <td>${tempMoridos.causaMoricion}</td>
                            <td>
                                <!-- display the update link --> <a class="btn-update" href="${updateLink}">Update</a>
                                | <a class="btn-delete" href="${deleteLink}"
                                     onclick="if (!(confirm('Estas seguro que deseas eliminar a este muerto?')))
                                                                    return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </body>

</html>









