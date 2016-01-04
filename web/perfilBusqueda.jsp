<%@page import="daos.InteresDAO"%>
<%@page import="daos.AficionDAO"%>
<%@page import="daos.PersonalidadDAO"%>
<%@page import="utils.BD"%>
<%@page import="beans.Usuario"%>
<%@page import="daos.UsuarioDAO"%>
<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Perfil"/>
    <jsp:param name="include" value="perfil"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

<form id="perfil_busqueda" method="POST" enctype="multipart/form-data">
    <table>

        <%
            String emailBuscador = (String)session.getAttribute("usuario_email");
            String email = (String) session.getAttribute("email_perfil_busq");
            UsuarioDAO udao = new UsuarioDAO(BD.getConexion());
            Usuario u1 = udao.cogerUsuario(emailBuscador);
            Usuario u = udao.cogerUsuario(email);
        %>
        
        <tr>
            <td>Nombre de usuario: <%=u.getNick()%> </td>
        </tr>
        <tr>
            <td>Email: <%=u.getEmail()%></td>
        </tr>
        <tr>
            <td>Género: <% if (!u.isFemenino()) {
                        out.print("Masculino");
                    }else{
                out.print("Femenino");
            }
                       %>
            </td>           
        </tr>
        <tr>
            <td>Ciudad: * </td>
            <td>        
                <select name="perfil_ciudad" id="perfil_ciudad" disabled>
                    <option value="Vitoria-Gasteiz" <% if (u.getCiudad().equals("Vitoria-Gasteiz")) {
                            out.print("selected");
                        }
                            %> >Vitoria-Gasteiz
                    </option>
                    <option value="Bilbao" <% if (u.getCiudad().equals("Bilbao")) {
                            out.print("selected");
                        }
                            %> >Bilbao

                    </option>
                    <option value="San Sebastian" <% if (u.getCiudad().equals("San Sebastian")) {
                            out.print("selected");
                        }
                            %>>San Sebastián
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Código Postal: <%=u.getCp()%></td>
        </tr>
        <tr>
            <td>Edad: <%=u.getEdad()%> </td>
        </tr>
        <tr>
            <td>Altura: <%=u.getAltura()%></td>
        </tr>
        <tr>
            <td>Peso: <%=u.getPeso()%></td>
        </tr>
    </table>
    <br>
    <fieldset id="perfil_constitucion">
        <legend><b>¿Qué aspecto tienes?</b></legend>
        <input type="radio" name="perfil_const" value="Delgado" disabled <% if (u.getConstitucion().equals("Delgado")) {
                out.print("checked");
            }
               %> > Delgado/Delgada
        <br>
        <input type="radio" name="perfil_const" value="Fornido" disabled<% if (u.getConstitucion().equals("Fornido")) {
                out.print("checked");
            }
               %> > Fornido/Fornida
        <br>
        <input type="radio" name="perfil_const" value="Musculoso" disabled<% if (u.getConstitucion().equals("Musculoso")) {
                out.print("checked");
            }
               %>> Musculoso/Musculosa
    </fieldset>
    <br>

    <%
        PersonalidadDAO pdao = new PersonalidadDAO(BD.getConexion());
    %>


    <fieldset id="perfil_caracteristicas" disabled>
        <legend><b>¿Cómo te definirías?</b></legend>
        <input type="checkbox" name="perfil_carac" value="Simpatico" disabled
               <%
                   if (pdao.estaPersonalidad("Simpatico", u.getNick())) {
                       out.print("checked");
                   }
               %>
               > Simpático/Simpática
        <br>
        <input type="checkbox" name="perfil_carac" value="Divertido" disabled
               <%
                   if (pdao.estaPersonalidad("Divertido", u.getNick())) {
                       out.print("checked");
                   }
               %>> Divertido/Divertida
        <br>
        <input type="checkbox" name="perfil_carac" value="Alegre" disabled
               <%
                   if (pdao.estaPersonalidad("Alegre", u.getNick())) {
                       out.print("checked");
                   }
               %>> Alegre
        <br>
        <input type="checkbox" name="perfil_carac" value="Generoso" disabled
               <%
                   if (pdao.estaPersonalidad("Generoso", u.getNick())) {
                       out.print("checked");
                   }
               %>> Generoso/Generosa
        <br>
        <input type="checkbox" name="perfil_carac" value="Atrevido" disabled
               <%
                   if (pdao.estaPersonalidad("Atrevido", u.getNick())) {
                       out.print("checked");
                   }
               %>> Atrevido/Atrevida
        <br>
        <input type="checkbox" name="perfil_carac" value="Romantico" disabled
               <%
                   if (pdao.estaPersonalidad("Romantico", u.getNick())) {
                       out.print("checked");
                   }
               %>> Romántico/Romántica
    </fieldset>
    <br>
    <%
        AficionDAO adao = new AficionDAO(BD.getConexion());
    %>
    <fieldset id="perfil_gustos">
        <legend><b>¿Cuáles son tus gustos?</b></legend>
        <input type="checkbox" name="perfil_gustos" value="Deportes" disabled
               <%
                   if (adao.estaAficion("Deportes", u.getNick())) {
                       out.print("checked");
                   }
               %>> Deportes
        <br>
        <input type="checkbox" name="perfil_gustos" value="Lectura" disabled
               <%
                   if (adao.estaAficion("Lectura", u.getNick())) {
                       out.print("checked");
                   }
               %>> Lectura
        <br>
        <input type="checkbox" name="perfil_gustos" value="Television" disabled
               <%
                   if (adao.estaAficion("Television", u.getNick())) {
                       out.print("checked");
                   }
               %>> Televisión
        <br>
        <input type="checkbox" name="perfil_gustos" value="Musica" disabled
               <%
                   if (adao.estaAficion("Musica", u.getNick())) {
                       out.print("checked");
                   }
               %>> Música
        <br>
        <input type="checkbox" name="perfil_gustos" value="OcioNoc" disabled
               <%
                   if (adao.estaAficion("OcioNoc", u.getNick())) {
                       out.print("checked");
                   }
               %>> Ocio nocturno
        <br>
        <input type="checkbox" name="perfil_gustos" value="Tecnologia" disabled
               <%
                   if (adao.estaAficion("Tecnologia", u.getNick())) {
                       out.print("checked");
                   }
               %>> Tecnología
    </fieldset>
    <br>
    Numero de personalidades en comun: <%=pdao.numPersonalidadesComun(u.getNick(), u1.getNick())%>
    <br>
    Numero de aficiones en comun: <%=adao.numAficionesComun(u.getNick(), u1.getNick())%>
    <br>
    <input id="perfil_ENLACEVOLVER" class="perfil_btn" type="button" value="Volver a principal">
</form>
<jsp:include page="/comun/logueado/pie.jsp"/>
