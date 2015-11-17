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
             <caption id="index_CAPTION">�NETE A #EUSKALLOVERS</caption>
          <tr>
        <td colspan="1"> <a class="index_ENLACES" href="registro.jsp">Crear mi perfil</a> </td>
    </tr>
    <tr>
        <td><a class="index_ENLACES" onclick="ActivarIniciarSesion();DesactivarPrincipal()">�Ya est�s registrado? <b>�Inicia sesi�n!</b></a></td>
    </tr>
        </table>
    </section>

<div id="index_INICIAR" style="display:none;">
    <form>
        <p>
            <b>Correo electr�nico: </b> <input type="email" name="email_control" autofocus required />
<br />
<b>Contrase�a: </b><input type="password" name="email_control" required />
<br />
        </p>
        <input class="index_btn" type="submit" value="Iniciar sesi�n">
        <input class="index_btn" type="button" value="Volver al men�" onclick="DesactivarIniciarSesion();ActivarPrincipal()">
    </form>
</div>

<footer id="comun_AUTORES">
    � ADSI-2015/2016 Euskal Lovers | Created and developed by: Adri�n Vazquez, Asier L�pez & Asier Rodr�guez. | UPV-EHU
</footer>

<jsp:include page="/comun/pie.jsp"/>