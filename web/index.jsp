<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Bienvenido a EuskalLovers"/>
    <jsp:param name="include" value="index"/>
</jsp:include>

<!--
    <div>
        <img id="index_Logo" src="img/logo.png"  alt="logo" />
    </div>-->



<div id="layer" style="display:none;">Contenido oculto</div>

    <section class="index_SECTION">
        <table class="index_TABLA">
             <caption id="index_CAPTION">ÚNETE A #EUSKALLOVERS</caption>
          <tr>
        <td colspan="1"> <a class="index_ENLACES" href="registro.jsp">Crear mi perfil</a> </td>
    </tr>
    <tr>
        <td><a class="index_ENLACES" href="javascript:ActivarIniciarSesion();">¿Ya estás registrado? <b>Inicia sesión!</b></a></td>
       
    </tr>
        </table>
    </section>

<div id="index_INICIAR" style="display:none;">
    <form>
        <p>
Correo Electrónico: <input type="email" name="email_control" autofocus required />
<br />
Contraseña: <input type="password" name="email_control" required />
<br />
        </p>
    </form>
</div>
                
<jsp:include page="/comun/pie.jsp"/>