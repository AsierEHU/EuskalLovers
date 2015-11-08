<jsp:include page="framework/cabeza.jsp">
    <jsp:param name="title" value="Página principal"/>
    <jsp:param name="include" value="header"/>
    <jsp:param name="include" value="footer"/>
    <jsp:param name="include" value="menu"/>
</jsp:include>

<jsp:include page="jsp/header.jsp"/>

<jsp:include page="jsp/menu.jsp"/>

<h1>Body!</h1>

<jsp:include page="jsp/footer.jsp"/>

<jsp:include page="framework/pie.jsp"/>