<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Mensajes"/>
    <jsp:param name="include" value="mensajes"/>
    <jsp:param name="includeLib" value="ajax"/>
</jsp:include>

<article id="mensajes_nuevoMensaje">
    <form id="mensajes_form">
        <select name="usuario" id="mensajes_usuario" required>
            <option value="Prueba">Prueba</option>
            <option value="Otro">Otro</option>
        </select>
        <textarea id="mensajes_text" name="text" required ></textarea>
        <input type="submit" value="enviar"/>
    </form>
</article>
<article id="mensajes_mensajesRecibidos">
    <h2>Bandeja de entrada</h2>
    <p id="mensajes_numMensajesEntrada"></p>
    <hr><hr>
</article>
<article id="mensajes_mensajesEnviados">
    <h2>Bandeja de salida</h2>
    <p id="mensajes_numMensajesSalida"></p>
    <hr><hr>
</article>
<div id="mensajes_clear"></div>


<jsp:include page="/comun/logueado/pie.jsp"/>