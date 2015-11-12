<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Bienvenido a EuskalLovers"/>
    <jsp:param name="include" value="index"/>
</jsp:include>

<!--
    <div>
        <img id="index_Logo" src="img/logo.png"  alt="logo" />
    </div>-->

<div> 
    <section id="index_CajaPrincipal">
        <table border="2">
             <caption>ÚNETE A EUSKALRENT</caption>
          <tr>
        <td colspan="1"><a class="index.Clase" href="registro.jsp">CREAR MI PERFIL</a></td>
    </tr>
    <tr>
        <td><a class="index.Clase" href="principal.jsp">¿Ya estás registrado? <b>Inicia sesión!</b></a></td>
    </tr>

<!--       -->
        </table>
    </section>
</div>
                
<jsp:include page="/comun/pie.jsp"/>