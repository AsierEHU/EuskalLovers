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

<form>
    <p><b>Correo electrónico: </b> </p>
    <input id="ejemplo_Email" type="text" name="email_control" required />
    <p><b>DNI</b></p>
    <input id="ejemplo_DNI" type="text" name="dni_control" required />
</form>

<jsp:include page="/comun/pie.jsp"/>