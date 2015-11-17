<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Bienvenido a EuskalLovers"/>
    <jsp:param name="include" value="index"/>
    <jsp:param name="includeLib" value="webstorage"/>
</jsp:include>


    <div>
        <img id="index_Logo" src="img/logo.png"  alt="logo" />
    </div>

<section style="display:block" class="index_SECTION" id="index_SECTIONID">
        <table class="index_TABLA">
             <caption id="index_CAPTION">ÚNETE A #EUSKALLOVERS</caption>
          <tr>
        <td colspan="1"> <a class="index_ENLACES" href="registro.jsp">Crear mi perfil</a> </td>
    </tr>
    <tr>
        <td><a class="index_ENLACES" onclick="ActivarIniciarSesion();DesactivarPrincipal()">¿Ya estás registrado? <b>¡Inicia sesión!</b></a></td>
    </tr>
        </table>
    </section>

<div id="index_INICIAR" style="display:none;">
    <form>
        <p>
            <b>Correo electrónico: </b> <input type="email" name="email_control" autofocus required />
<br />
<b>Contraseña: </b><input type="password" name="email_control" required />
<br />
        </p>
        <input class="index_btn" type="submit" value="Iniciar sesión">
        <input class="index_btn" type="button" value="Volver al menú" onclick="DesactivarIniciarSesion();ActivarPrincipal()">
    </form>
</div>

<footer id="comun_AUTORES">
    © ADSI-2015/2016 Euskal Lovers | Created and developed by: Adrián Vazquez, Asier López & Asier Rodríguez. | UPV-EHU
</footer>

<jsp:include page="/comun/pie.jsp"/>