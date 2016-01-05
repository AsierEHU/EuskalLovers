<%@page import="beans.Visita"%>
<%@page import="daos.VisitaDAO"%>
<%@page import="daos.InteresDAO"%>
<%@page import="daos.AficionDAO"%>
<%@page import="daos.PersonalidadDAO"%>
<%@page import="utils.BD"%>
<%@page import="beans.Usuario"%>
<%@page import="daos.UsuarioDAO"%>
<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="PerfilBusqueda"/>
    <jsp:param name="include" value="perfilBusqueda"/>
</jsp:include>

    

        <% if (request.getParameterValues("nicks") != null) {
                String[] nicks = request.getParameterValues("nicks");
                for (int i = 0; i < nicks.length; i++) {
        %>
        <a class="perfilBusqueda_buscados" href="perfilBusqueda.jsp?nick=<%=nicks[i]%>"> Perfil de <%=nicks[i]%> </a>
        <br>
        <%
            }
        } else if (request.getParameter("nick") != null) {
            String nickBuscador = (String) session.getAttribute("usuario_nick");
            String nick = request.getParameter("nick");
            UsuarioDAO udao = new UsuarioDAO(BD.getConexion());
            Usuario u1 = udao.cogerUsuario(nickBuscador);
            Usuario u = udao.cogerUsuario(nick);
            PersonalidadDAO pdao = new PersonalidadDAO(BD.getConexion());
            AficionDAO adao = new AficionDAO(BD.getConexion());
            VisitaDAO vdao = new VisitaDAO(BD.getConexion());
            vdao.insertarVisita(new Visita(nickBuscador, nick));

        %>
        <table>
        <div id="busqueda_foto">
            <img src="img/fotos/<%=u.getFoto()%>"/>
        </div>
        <tr>
            <td><b>Nombre de usuario:</b> <%=u.getNick()%> </td>
        </tr>
        <tr>
            
            <td><i>Email:</i> <%=u.getEmail()%></td>
        </tr>
        <tr>
            <td><b>Género:</b> <% if (!u.isFemenino()) {
                    out.print("Masculino");
                } else {
                    out.print("Femenino");
                }
                %>
            </td>           
        </tr>
        <tr>
            <td><b>Ciudad: </b><% if (u.getCiudad().equals("Vitoria-Gasteiz")) {
                    out.print("Vitoria-Gasteiz");
                } else if (u.getCiudad().equals("Bilbao")) {
                    out.print("Bilbao");
                } else if (u.getCiudad().equals("San Sebastián")) {
                    out.print("San Sebastián");
                }
                %> </td>
        </tr>
        <tr>
            <td><b>Código Postal:</b> <%=u.getCp()%></td>
        </tr>
        <tr>
            <td><b>Edad: </b><%=u.getEdad()%> </td>
        </tr>
        <tr>
            <td><b>Altura:</b> <%if (u.getAltura() == 0.0) {
                    out.print("N/D");
                } else {
                    out.print(u.getAltura());
                }%></td>
        </tr>
        <tr>
            <td><b>Peso:</b> <%if (u.getPeso() == 0) {
                    out.print("N/D");
                } else {
                    out.print(u.getPeso());
                }%></td>
        </tr>
        <tr>
            <td><b>Aspecto:</b> <% if (u.getConstitucion().equals("Delgado")) {
                    out.print("Delgada/o");
                } else if (u.getConstitucion().equals("Fornido")) {
                    out.print("Fornida/o");
                } else if (u.getConstitucion().equals("Musculoso")) {
                    out.print("Musculosa/o");
                }
                %> </td>
        </tr>
        <tr>
            <td><b>Personalidad:</b> <%
                if (pdao.estaPersonalidad("Simpatico", u.getNick())) {
                    out.println("Simpatica/o");
                }
                if (pdao.estaPersonalidad("Divertido", u.getNick())) {
                    out.println("Divertida/o");
                }
                if (pdao.estaPersonalidad("Alegre", u.getNick())) {
                    out.println("Alegre");
                }
                if (pdao.estaPersonalidad("Generoso", u.getNick())) {
                    out.println("Generosa/o");
                }
                if (pdao.estaPersonalidad("Atrevido", u.getNick())) {
                    out.println("Atrevida/o");
                }
                if (pdao.estaPersonalidad("Romantico", u.getNick())) {
                    out.print("Romántica/o");
                }
                %></td>
        </tr>
        <tr>
            <td><b>Aficiones:</b> <%
                if (adao.estaAficion("Deportes", u.getNick())) {
                    out.println("Deportes");
                }
                if (adao.estaAficion("Lectura", u.getNick())) {
                    out.println("Lectura");
                }
                if (adao.estaAficion("Television", u.getNick())) {
                    out.print("Televisión");
                }
                if (adao.estaAficion("Musica", u.getNick())) {
                    out.print("Música");
                }
                if (adao.estaAficion("OcioNoc", u.getNick())) {
                    out.print("Ocio Nocturno");
                }
                if (adao.estaAficion("Tecnologia", u.getNick())) {
                    out.print("Tecnología");
                }
                %></td>
        </tr>
    </table>
    <br>
    <b>Numero de personalidades en comun: </b><%=pdao.numPersonalidadesComun(u.getNick(), u1.getNick())%>
    <br>
    <b>Numero de aficiones en comun:</b> <%=adao.numAficionesComun(u.getNick(), u1.getNick())%>
    <br>
<%
    }else{
            response.sendRedirect("principal.jsp");
        }
%>
<br>
<br>
<input id="perfil_ENLACEVOLVER" class="perfil_btn" type="button" value="Volver a principal">
<jsp:include page="/comun/logueado/pie.jsp"/>
