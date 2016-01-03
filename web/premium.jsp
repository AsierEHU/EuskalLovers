<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Premium"/>
    <jsp:param name="include" value="premium"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

<%
    if(request.getParameter("error")!=null){
        %>
        <script>
            alert("El saldo de la cuenta no es suficiente para esta opción");
        </script>
        <%
    }
%>

        <form action="Premium" method="post" id="premiumTabla">
            <table>
                <tr>
                    <td>Número de tarjeta:  </td>
                    <td><input type="text" name="premium_tarjeta" id="premium_tarjeta" minlenght="16" maxlenght="16" required autofocus></td>
                </tr>
                <tr>
                    <td>Saldo disponible(Euros):  </td>
                    <td><input type="number" name="premium_saldo" id="premium_saldo" required ></td>
                </tr>
                <tr>
                    <td>Pack a contratar: </td>
                    <td>        
                        <select name="premiumPack" id="premiumPack" required>
                            <option value="1">1 mes de Premium</option>
                            <option value="2">3 mes de Premium</option>
                            <option value="3">6 mes de Premium</option>
                        </select>
                    </td>
                </tr>    
            </table>
               <input type="submit" value="Convierteme en Premium">
               <img id="Premium_precios" src="img/ESTRELLA.png"/>
        </form>

<jsp:include page="/comun/logueado/pie.jsp"/>