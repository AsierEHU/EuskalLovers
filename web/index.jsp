<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Bienvenido a EuskalLovers"/>
    <jsp:param name="include" value="index"/>
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
        <td><a class="index_ENLACES" onclick="ActivarIniciarSesion()">�Ya est�s registrado? <b>�Inicia sesi�n!</b></a></td>
    </tr>
        </table>
    </section>

<button onclick="DesactivarPrincipal()">desactivarPRINCIPAL</button>
<button onclick="DesactivarIniciarSesion()()">desactivarIniciar</button>
<button onclick="ActivarPrincipal()">activarPRINCIPAL</button>
<button onclick="ActivarIniciarSesion()">ActivarINICIAL</button>

<div id="index_INICIAR" style="display:none;">
    <form>
        <p>
Correo Electr�nico: <input type="email" name="email_control" autofocus required />
<br />
Contrase�a: <input type="password" name="email_control" required />
<br />
        </p>
    </form>
</div>
<jsp:include page="/comun/pie.jsp"/>