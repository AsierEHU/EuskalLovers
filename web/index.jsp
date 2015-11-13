<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Bienvenido a EuskalLovers"/>
    <jsp:param name="include" value="index"/>
</jsp:include>

<!--
    <div>
        <img id="index_Logo" src="img/logo.png"  alt="logo" />
    </div>-->


    <section class="index_SECTION">
        <table class="index_TABLA">
             <caption id="index_CAPTION">ÚNETE A EUSKALLOVERS</caption>
          <tr>
        <td colspan="1"> <a class="index_ENLACES" href="registro.jsp">Crear mi perfil</a> </td>
    </tr>
    <tr>
        <td><a class="index_ENLACES" href= "principal.jsp">¿Ya estás registrado? <b>Inicia sesión!</b></a></td>
    </tr>
        </table>
    </section>

                
<jsp:include page="/comun/pie.jsp"/>