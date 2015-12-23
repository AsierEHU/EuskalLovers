<%
    String email = (String)session.getAttribute("usuario_email");
    if(email == null){
        application.getRequestDispatcher("/index.jsp").forward(request, response);
        //esto hay que mejorar
    }
    
    UsuarioDAO udao = new UsuarioDAO(BD.getConexion());
    Usuario u = udao.cogerUsuario(email);

%>

<%@page import="beans.Usuario"%>
<%@page import="utils.BD"%>
<%@page import="daos.UsuarioDAO"%>
<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="include" value="logueado"/>
</jsp:include>


<div id="logueado_center">
    <header id="logueado_header">
        <img id="logueado_header_logo" src="img/title.png"/>
        <div id="logueado_header_user">
            <h4>Bienvenido <%=u.getNick()%></h4>
            <a href="index.jsp?desconectar=true">Desconectar</a>
        </div>
    </header>
    <nav id="logueado_nav">
        <ul>
            <li><a href="principal.jsp">Principal</a></li>
            <li><a href="perfil.jsp">Perfil</a></li>
            <li><a href="mensajes.jsp">Mensajes</a></li>
            <li><a href="premium.jsp">¡Hazte premium!</a></li>
        </ul>
    </nav>
    <section id="logueado_section">