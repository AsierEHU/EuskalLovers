<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="<%=request.getParameter("title")%>"/>
    <jsp:param name="include" value="logueado"/>
    <jsp:param name="include" value="header"/>
    <jsp:param name="include" value="menu"/>
    <jsp:param name="include" value="<%=request.getParameter("page")%>"/>
    <jsp:param name="include" value="footer"/>
</jsp:include>

<div id="logueado_center">
    <jsp:include page="/jsp/header.jsp"/>
    <jsp:include page="/jsp/menu.jsp"/>
    <section>