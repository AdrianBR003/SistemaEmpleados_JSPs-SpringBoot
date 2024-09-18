<%@ include file="comunes/cabecero.jsp" %>
<%@ include file="comunes/navegacion.jsp"%>


<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Sistema de Empleados</h3>
    </div>
    <!-- Tabla -->
    <div class="container">
        <table class="table table-striped table-bordered align-middle"> <!-- table-striped -> Cambia los colores por registros -->
            <thead class="table-dark text-center">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Departamento</th>
                <th scope="col">Sueldo</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="empleado" items="${empleados}">
                <tr>
                    <th scope="row">${empleado.idEmpleado}</th>
                    <td>${empleado.nombreEmpleado}</td>
                    <td>${empleado.departamento}</td>
                    <td>
                        <fmt:setLocale value="en_ES"/>
                        <fmt:formatNumber type="currency" value="${empleado.sueldo}"/>
                    </td>
                    <td class="text-center">
                        <c:set var="urlEditar">
                            <c:url value="${application.contextPath}/editar">
                                <c:param name="idEmpleado" value="${empleado.idEmpleado}"/>
                            </c:url>
                        </c:set>
                        <!-- Botones Editar -->
                        <a href="${urlEditar}" class="btn btn-warning btn-sm me-3">Editar</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    <%@ include file="comunes/pie_pagina.jsp"%>