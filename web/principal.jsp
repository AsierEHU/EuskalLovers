<jsp:include page="framework/cabeza.jsp">
    <jsp:param name="title" value="P�gina principal"/>
    <jsp:param name="include" value="header"/>
    <jsp:param name="include" value="menu"/>
    <jsp:param name="include" value="principal"/>
    <jsp:param name="include" value="chat"/>
    <jsp:param name="include" value="footer"/>
</jsp:include>



<div id="principal_center">
    <jsp:include page="jsp/header.jsp"/>
    <jsp:include page="jsp/menu.jsp"/>
    <section>
        <h1>Contenido din�mico</h1>
    </section>
    <jsp:include page="jsp/footer.jsp"/>
</div>



<jsp:include page="framework/pie.jsp"/>