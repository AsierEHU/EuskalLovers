<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Ejemplos"/>
    <jsp:param name="include" value="ejemplos"/>
    <jsp:param name="includeLib" value="webstorage"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

<h3>Ejemplo drag and drop</h3>
<div id="ejemplos_caja">
</div>
<br>
<h3>Ejemplo Datos usuario</h3>
<div id="ejemplos_usuario">
</div>
<br>
<h3>Ejemplo validacion dinamica</h3>
<p><b>Correo electrónico: </b> </p>
<input id="ejemplo_Email" type="email" name="email_control" autofocus required />


<jsp:include page="/comun/pie.jsp"/>