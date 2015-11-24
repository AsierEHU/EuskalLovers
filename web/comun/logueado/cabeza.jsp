<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="include" value="logueado"/>
</jsp:include>
<div id="logueado_center">
    <header id="logueado_header">
        <img id="logueado_header_logo" src="img/logo.png"/>
        <div id="logueado_header_user">
            <h4>Info usuario</h4>
        </div>
    </header>
    <nav id="logueado_nav">
        <ul>
            <li><a href="index.jsp">Inicio</a></li>
            <li><a href="registro.jsp">Registro</a></li>
            <li><a href="principal.jsp">Principal</a></li>
            <li><a href="perfil.jsp">Perfil</a></li>
        </ul>
    </nav>
    <section id="logueado_section">