<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Bienvenido a EuskalLovers"/>
    <jsp:param name="include" value="index"/>
    <jsp:param name="includeLib" value="webstorage"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

<div id="index_SECTIONID">
    <img id="index_Logo" src="img/logo.png"  alt="logo" />
    <table id="index_TABLA" >
        <caption id="index_CAPTION">�NETE A #EUSKALLOVERS</caption>
        <tr>
            <td> <a class="index_ENLACES" href="registro.jsp">Crear mi perfil</a> </td>
        </tr>
        <tr>
            <td><a href="#" id="index_ENLACEINICIAR" class="index_ENLACES">�Ya est�s registrado? <b>�Inicia sesi�n!</b></a></td>
        </tr>
    </table>
    
    <form name="index_infoSesion" id="index_infoSesion" method="post" action="principal.jsp">
        <table>
            <tr>
                <td> <b class="index_cajasForm">Email: </b> </td> <td><input  id="index_Email" type="text" name="email_control" autofocus required /></td>
            </tr>
            <tr>
                <td>
                    <b class="index_cajasForm">Contrase�a: </b></td><td><input  type="password" name="email_control" required /></td>
            </tr>
        </table>
        <br />
        <input id="index_Submit" class="index_btn" type="submit" value="Iniciar sesi�n"> <n/>
        <input id="index_ENLACEVOLVER" class="index_btn" type="button" value="Volver al men�">
    </form>
</div>

<jsp:include page="/comun/pie.jsp"/>