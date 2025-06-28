<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
Map<String,String> errores = (Map<String,String>)request.getAttribute("errores");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulari de Usuarios</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h3>Formulari de Usuarios</h3>
    <%
    if(errores != null && errores.size()>0){
    %>
    <ul class="alert alert-danger mx-5">
        <% for(String error: errores.values()){%>
        <li><%=error%></li>
        <%}%>
    </ul>

    <%}%>
    <div class="px-5">
    <form action="/Jakartawebappform/registro" method="post">
        <div>
            <div class="row mb-3">
                <label for="username" class="col-form-label col-sm-2">Usuario</label>
                <div class="col-sm-4">
                    <input type="text" name="username1" id="username" class="form-control" value="${param.username1}">
                </div>

                <%
                    if(errores != null && errores.containsKey("username")){
                        out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color: red;'>"+ errores.get("username") + "</div>");
                    }
                    %>
            </div>
            <div class="row mb-3" class="col-form-label col-sm-2">
                <label for="password" class="col-form-label col-sm-2">Contraseña</label>
                <div class="col-sm-4">
                    <input type="password" name="password1" id="password" class="form-control">
                </div>

                <%
                    if(errores != null && errores.containsKey("password")){
                         out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+ errores.get("password") + "</small>");
                    }
                    %>
            </div>
            <div class="row mb-3">
                <label for="email" class="col-form-label col-sm-2">Email</label>
                <div class="col-sm-4">
                    <input type="text" name="email" id="email" class="form-control" value="${param.email}">
                </div>

                <%
                        if(errores != null && errores.containsKey("email")){
                             out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+ errores.get("email") + "</small>");
                        }
                        %>
            </div>
            <div class="row mb-3">
                <label for="pais" class="col-form-label col-sm-2"></label>
                <div>
                    <select name="pais1" id="pais" class="form-select">
                        <option value="">-- Seleccionar --</option>
                        <option value="ES" ${param.pais1.equals("ES")?"selected":""}>España</option>
                        <option value="MX" ${param.pais1.equals("MX")?"selected":""}>Mexico</option>
                        <option value="CH" ${param.pais1.equals("CH")?"selected":""}>Chile</option>
                        <option value="AR" ${param.pais1.equals("AR")?"selected":""}>Argentina</option>
                        <option value="PE" ${param.pais1.equals("PE")?"selected":""}>Peru</option>
                        <option value="CO" ${param.pais1.equals("CO")?"selected":""}>Colombia</option>
                        <option value="VE" ${param.pais1.equals("VE")?"selected":""}>Venezuela</option>
                    </select>
                </div>
                <%
                        if(errores != null && errores.containsKey("pais")){
                              out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+ errores.get("pais") + "</small>");
                        }
                        %>
            </div>
            <div class="row mb-3">
                <label for="Lenguajes" class="col-form-label col-sm-2">Leguajes de programacion</label>
                <div>
                    <select name="lenguajes1" id="Lenguajes"  multiple class="form-select">
                        <option value="java" ${paramValues.lenguajes1.stream().anyMatch(v->v.equals("java")).get() ? "selected":""}>Lenguajes</option>
                        <option value="jakarta" ${paramValues.lenguajes1.stream().anyMatch(v->v.equals("jakarta")).get() ? "selected":""}>Jakarta EE</option>
                        <option value="spring" ${paramValues.lenguajes1.stream().anyMatch(v->v.equals("spring")).get() ? "selected":""}>Spring Boot</option>
                        <option value="JS" ${paramValues.lenguajes1.stream().anyMatch(v->v.equals("JS")).get() ? "selected":""}>Javascript</option>
                        <option value="angular" ${paramValues.lenguajes1.stream().anyMatch(v->v.equals("angular")).get() ? "selected":""}>Angular</option>
                        <option value="react" ${paramValues.lenguajes1.stream().anyMatch(v->v.equals("react")).get() ? "selected":""}>React</option>
                    </select>
                </div>
                <%
                        if(errores != null && errores.containsKey("lenguajes")){
                            out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+ errores.get("lenguajes") + "</small>");
                        }
                        %>
            </div>
            <div class="row mb-3">
                <label  class="col-form-label col-sm-2">Roles</label>
                <div class="form-check">
                    <input type="checkbox" name="roles" value="ROLE_ADMIN"
                    ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_ADMIN")).get() ? "checked":""}
                    class="form-check-input" >
                    <label class="form-check-label">Administrador</label>
                </div>
                <div class="form-check">
                    <input type="checkbox" name="roles" value="ROLE_USE"
                     ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_USE")).get() ? "checked":""}
                     class="form-check-input">
                    <label class="form-check-label">Usuario</label>
                </div>
                <div class="form-check">
                    <input type="checkbox" name="roles" value="ROLE_MODERATOR"
                    ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_MODERATOR")).get() ? "checked":""}
                    class="form-check-input">
                    <label class="form-check-label">Moderador</label>
                </div>
                <%
                        if(errores != null && errores.containsKey("roles")){
                             out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+ errores.get("roles") + "</small>");
                        }
                        %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2">Idiomas</label>
                <div class="form-check">
                    <input type="radio" name="idioma" value="es" class="form-check-input" ${param.idioma.equals("ES")?"checked":""}>
                    <label class="form-check-label">Español</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="en" class="form-check-input" ${param.idioma.equals("en")?"checked":""}>
                    <label class="form-check-label">Ingles</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="fr" class="form-check-input" ${param.idioma.equals("fr")?"checked":""}>
                    <label class="form-check-label">Frances</label>
                </div>
                <%
                        if(errores != null && errores.containsKey("idioma")){
                             out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+ errores.get("idioma") + "</small>");
                        }
                        %>
            </div>
            <div class="row mb-3">
                <label>Habilitar</label>
                <div for="habilitar" class="col-form-label col-sm-2">
                    <input type="checkbox" name="habilitar" checked class="form-check-input">
                </div>
            </div>
            <div>
                <input type="hidden" name="secreto" value="2087390148">
            </div>
            <div class="row mb-3">
                <div>
                    <input type="submit" value="Enviar" class="btn btn-primary">
                </div>
            </div>
        </div>
    </form>
    </div>
</body>
</html>