<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Validar la sesión
    String usuarioLogueado = (String) session.getAttribute("usuarioLogueado");
    
    if (usuarioLogueado == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Cliente</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>

    <div class="main-wrapper">
        
        <!-- INCLUSIÓN DEL MENÚ MODULAR -->
        <jsp:include page="menu.jsp" />

        <!-- Panel Principal -->
        <div class="content">
            <h2 class="header-title">Formulario de Cliente</h2>
            <p class="user-info">Usuario: <strong><%= usuarioLogueado %></strong></p>

            <div class="form-card">
                
                <% if (request.getAttribute("mensajeError") != null) { %>
                    <div class="msg-error"><%= request.getAttribute("mensajeError") %></div>
                <% } %>
                <% if (request.getAttribute("mensajeExito") != null) { %>
                    <div class="msg-exito"><%= request.getAttribute("mensajeExito") %></div>
                <% } %>

                <!-- FORMULARIO HTML5 -->
                <form action="ServletAgregarCliente" method="post">
                    <div class="grid-container">
                        
                        <div class="form-group">
                            <label for="dni">DNI *</label>
                            <input type="text" id="dni" name="dni" placeholder="Solo números (6 a 8 dígitos)" pattern="[0-9]{6,8}" title="DNI debe ser numérico entre 6 y 8 dígitos" required>
                        </div>

                        <div class="form-group">
                            <label for="cuil">CUIL *</label>
                            <input type="text" id="cuil" name="cuil" placeholder="Formato 11 dígitos" pattern="[0-9]{11}" title="CUIL debe ser numérico de 11 dígitos" required>
                        </div>

                        <div class="form-group">
                            <label for="nombre">Nombre *</label>
                            <input type="text" id="nombre" name="nombre" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+" title="Solo se permiten letras" required>
                        </div>

                        <div class="form-group">
                            <label for="apellido">Apellido *</label>
                            <input type="text" id="apellido" name="apellido" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+" title="Solo se permiten letras" required>
                        </div>

                        <div class="form-group">
                            <label for="sexo">Sexo *</label>
                            <select id="sexo" name="sexo" required>
                                <option value="">-- Seleccione --</option>
                                <option value="M">Masculino (M)</option>
                                <option value="F">Femenino (F)</option>
                                <option value="Otro">Otro</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="nacionalidad">Nacionalidad *</label>
                            <input type="text" id="nacionalidad" name="nacionalidad" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+" title="Solo se permiten letras" required>
                        </div>

                        <div class="form-group">
                            <label for="fechaNacimiento">Fecha de nacimiento *</label>
                            <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>
                        </div>

                        <div class="form-group">
                            <label for="direccion">Dirección *</label>
                            <input type="text" id="direccion" name="direccion" required>
                        </div>

                        <div class="form-group">
                            <label for="localidad">Localidad *</label>
                            <input type="text" id="localidad" name="localidad" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+" title="Solo se permiten letras" required>
                        </div>

                        <div class="form-group">
                            <label for="provincia">Provincia *</label>
                            <input type="text" id="provincia" name="provincia" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+" title="Solo se permiten letras" required>
                        </div>

                        <div class="form-group">
                            <label for="correo">Correo electrónico *</label>
                            <input type="email" id="correo" name="correo" placeholder="ej: nombre@dominio.com" required>
                        </div>

                        <div class="form-group">
                            <label for="telefono">Teléfono *</label>
                            <input type="text" id="telefono" name="telefono" placeholder="10 dígitos numéricos" pattern="[0-9]{10}" title="Teléfono debe ser numérico de 10 dígitos" required>
                        </div>

                    </div>

                    <button type="submit" class="btn-guardar">Guardar cliente</button>
                </form>

            </div>
        </div>
    </div>

</body>
</html>