<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Ejemplos"/>
    <jsp:param name="include" value="ejemplos"/>
    <jsp:param name="includeLib" value="webstorage"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

    <h3>Ejemplo drag and drop</h3>
    <div id="ejemplos_caja">
    </div>

    <h3>Ejemplo Datos usuario</h3>
    <div id="ejemplos_usuario">
    </div>
    
    <h3>Ejemplo validacion dinamica</h3>
    <form name="index_infoSesion" method="get">
        <p>
            <b>Correo electrónico: </b> <input id="ejemplo_Email" type="email" name="email_control" autofocus required />
            <br />
            <b>Contraseña: </b><input type="password" name="email_control" required />
            <br />
        </p>
        <input id="index_Submit" class="index_btn" type="submit" value="Iniciar sesión">
        <input id="index_ENLACEVOLVER" class="index_btn" type="button" value="Volver al menú">
    </form>
    
<jsp:include page="/comun/pie.jsp"/>