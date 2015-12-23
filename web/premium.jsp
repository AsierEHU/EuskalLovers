<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Premium"/>
    <jsp:param name="include" value="premium"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

        <form action="/Premium" method="get" id="premiumTabla">
            <table>
                <tr>
                    <td>N�mero de tarjeta:  </td>
                    <td><input type="text" name="premium_tarjeta" id="premium_tarjeta" minlenght="16" maxlenght="16" required autofocus></td>
                </tr>
                <tr>
                    <td>Saldo disponible(?):  </td>
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
        </form>

<jsp:include page="/comun/logueado/pie.jsp"/>