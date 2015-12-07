<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Mensajes"/>
    <jsp:param name="include" value="mensajes"/>
    <jsp:param name="includeLib" value="ajax"/>
</jsp:include>

<p id="numMensajes"></p>
<article id="mensajesRecibidos"></article>
<article id="mensajesEnviados"></article>

<jsp:include page="/comun/logueado/pie.jsp"/>