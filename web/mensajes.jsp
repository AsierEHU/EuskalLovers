<%@page import="daos.PremiumDAO"%>
<%@page import="utils.BD"%>
<%@page import="beans.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="daos.UsuarioDAO"%>

<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Mensajes"/>
    <jsp:param name="include" value="mensajes"/>
    <jsp:param name="includeLib" value="ajax"/>
</jsp:include>

<article id="mensajes_nuevoMensaje">
    <form id="mensajes_form">
        <select name="usuario" id="mensajes_usuario" required>
            <%
                UsuarioDAO udao = new UsuarioDAO(BD.getConexion());
                Iterator<Usuario> usuarios = udao.recuperarUsuarios();
                while (usuarios.hasNext()) {
                    Usuario u = usuarios.next();
                    String usuario_nick = u.getNick();
            %>
            <option value="<%=usuario_nick%>"><%=usuario_nick%></option>
            <%
                }
            %>
        </select>
        <%
            String nick = (String) session.getAttribute("usuario_nick");
            Usuario u = udao.cogerUsuario(nick);
            PremiumDAO pdao = new PremiumDAO(BD.getConexion());
            String disabled = "";
            if(!pdao.esPremium(u.getNick())){
                disabled="disabled";
            }
        %>
        <textarea id="mensajes_text" name="text" required <%=disabled%>><%if(!disabled.equals("")){out.print("Hazte premium para poder mandar mensajes.");}%></textarea>
        <input type="submit" value="enviar" <%=disabled%>/>
    </form>
</article>
<article id="mensajes_mensajesRecibidos">
    <h2>Bandeja de entrada</h2>
    <p id="mensajes_numMensajesEntrada">(0)</p>
    <hr><hr>
</article>
<article id="mensajes_mensajesEnviados">
    <h2>Bandeja de salida</h2>
    <p id="mensajes_numMensajesSalida">(0)</p>
    <hr><hr>
</article>

<jsp:include page="/comun/logueado/pie.jsp"/>