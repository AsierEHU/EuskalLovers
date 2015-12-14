<%@page import="beans.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="utils.ConexionBD"%>
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
                UsuarioDAO udao = new UsuarioDAO(ConexionBD.getConexionBD().getConnection());
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
        <textarea id="mensajes_text" name="text" required ></textarea>
        <input type="submit" value="enviar"/>
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
<div id="mensajes_clear"></div>


<jsp:include page="/comun/logueado/pie.jsp"/>