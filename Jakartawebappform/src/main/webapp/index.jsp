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
</head>
<body>
    <h3>Formulari de Usuarios</h3>
    <%
    if(errores != null && errores.size()>0){
    %>
    <ul>
        <% for(String error: errores.values()){%>
        <li><%=error%></li>
        <%}%>
    </ul>

    <%}%>
    <form action="/Jakartawebappform/registro" method="post">
        <div>
            <div>
                <label for="username">Usuario</label>
                <input type="text" name="username1" id="username">
                <%
                    if(errores != null && errores.containsKey("username")){
                        out.println("<small style='color:red'>"+errores.get("username")+"</small>");
                    }
                    %>
            </div>
            <div>
                <label for="password">Contraseña</label>
                <input type="password" name="password1" id="password">
                <%
                    if(errores != null && errores.containsKey("password")){
                         out.println("<small style='color: red;'>"+ errores.get("password") + "</small>");
                    }
                    %>
            </div>
            <div>
                <label for="email">Email</label>
                <input type="password" name="email" id="email">
                <%
                        if(errores != null && errores.containsKey("email")){
                             out.println("<small style='color: red;'>"+ errores.get("email") + "</small>");
                        }
                        %>
            </div>
            <div>
                <label for="pais"></label>
                <div>
                    <select name="pais1" id="pais">
                        <option value="">-- Seleccionar --</option>
                        <option value="ES">España</option>
                        <option value="MX">Mexico</option>
                        <option value="CH">Chile</option>
                        <option value="AR">Argentina</option>
                        <option value="PE" selected>Peru</option>
                        <option value="CO">Colombia</option>
                        <option value="VE">Venezuela</option>
                    </select>
                </div>
                <%
                        if(errores != null && errores.containsKey("pais")){
                             out.println("<small style='color: red;'>"+ errores.get("pais") + "</small>");
                        }
                        %>
            </div>
            <div>
                <label for="Lenguajes">Leguajes de programacion</label>
                <div>
                    <select name="lenguajes1" id="Lenguajes" multiple>
                        <option value=java" selected>Lenguajes</option>
                        <option value="jakarta" selected>Jakarta EE</option>
                        <option value="spring">Spring Boot</option>
                        <option value="JS">Javascript</option>
                        <option value="angular">Angular</option>
                        <option value="react">React</option>
                    </select>
                </div>
                <%
                        if(errores != null && errores.containsKey("lenguajes")){
                             out.println("<small style='color: red;'>"+ errores.get("lenguajes") + "</small>");
                        }
                        %>
            </div>
            <div>
                <label>Roles</label>
                <div>
                    <input type="checkbox" name="roles" value="ROLE_ADMIN">
                    <label>Administrador</label>
                </div>
                <div>
                    <input type="checkbox" name="roles" value="ROLE_USE" checked>
                    <label>Usuario</label>
                </div>
                <div>
                    <input type="checkbox" name="roles" value="ROLE_MODERATOR">
                    <label>Moderador</label>
                </div>
                <%
                        if(errores != null && errores.containsKey("roles")){
                             out.println("<small style='color: red;'>"+ errores.get("roles") + "</small>");
                        }
                        %>
            </div>
            <div>
                <label>Idiomas</label>
                <div>
                    <input type="radio" name="idioma" value="es">
                    <label>Español</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="en">
                    <label>Ingles</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="fr">
                    <label>Frances</label>
                </div>
                <%
                        if(errores != null && errores.containsKey("idioma")){
                             out.println("<small style='color: red;'>"+ errores.get("idioma") + "</small>");
                        }
                        %>
            </div>
            <div>
                <label>Habilitar</label>
                <div>
                    <input type="checkbox" name="habilitar" checked>
                </div>
            </div>
            <div>
                <input type="hidden" name="secreto" value="2087390148">
            </div>
            <div>
                <div>
                    <input type="submit" value="Enviar">
                </div>
            </div>
        </div>
    </form>
</body>
</html>