<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Bienvenido a EuskalLovers"/>
    <jsp:param name="include" value="index"/>
    <jsp:param name="includeLib" value="webstorage"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

<div id="index_SECTIONID">
    <img id="index_Logo" src="img/logo.png"  alt="logo" />
    <table id="index_TABLA" >
        <caption id="index_CAPTION">ÚNETE A #EUSKALLOVERS</caption>
        <tr>
            <td> <a class="index_ENLACES" href="registro.jsp">Crear mi perfil</a> </td>
        </tr>
        <tr>
            <td><a href="#" id="index_ENLACEINICIAR" class="index_ENLACES">¿Ya estás registrado? <b>¡Inicia sesión!</b></a></td>
        </tr>
    </table> 
   
    <form name="index_infoSesion" id="index_infoSesion" method="post" action="principal.jsp">
        <table>
            <tr>
                <td> <b class="index_cajasForm">Email: </b> </td> <td><input  id="index_Email" type="email" name="email_control" autofocus required /></td>
            </tr>
            <tr>
                <td>
                    <b class="index_cajasForm">Contraseña: </b></td><td><input  id="index_Contrasena" type="password" name="email_control" required /></td>
            </tr>
        </table> 
       <input id="index_Submit" class="index_btn" type="submit" value="Iniciar sesión"> <n/>
        <input id="index_ENLACEVOLVER" class="index_btn" type="button" value="Volver al menú">
    </form>
</div>

<jsp:include page="/comun/pie.jsp"/>