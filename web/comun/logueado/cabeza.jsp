<%@page import="daos.VisitaDAO"%>
<%@page import="daos.PremiumDAO"%>
<%
    String email = (String) session.getAttribute("usuario_email");
    if (email == null) {
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
            <img src="img/fotos/<%=u.getFoto()%>"/>
            <h4>Bienvenido <%=u.getNick()%></h4>
            <br/>
            <a href="index.jsp?desconectar=true">Desconectar</a>
            <%
                PremiumDAO pdao = new PremiumDAO(BD.getConexion());
                if (pdao.esPremium(u.getNick())) {
            %>
            <br>
            <h4> Premium restante: <%=pdao.tiempoQuedaPremium(u.getNick())%> dias</h4>
            <%
                }
            %>
            <p>Te visitaron : <%=new VisitaDAO(BD.getConexion()).numeroVisitantes(u.getNick())%> pers.</p>
        </div>
    </header>
    <nav id="logueado_nav">
        <ul>
            <li><a href="principal.jsp">Principal</a></li>
            <li><a href="perfil.jsp">Perfil</a></li>
            <li><a href="mensajes.jsp">Mensajes</a></li>
                <%
                    if (pdao.esPremium(u.getNick())) {
                %>

            <li> 
                <form method="post" action="noPremium" >
                    <input type="submit" value="Cancelar Premium">
                </form>
            </li>
            <%
            } else {
            %>
            <li><a href="premium.jsp">¡Hazte premium!</a></li>  
            <%
                }
            %>
            
        </ul>
            
    </nav>
    <section id="logueado_section">