<%-- 
    Document   : Premium
    Created on : 23-dic-2015, 17:46:17
    Author     : Asier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/Premium" method="get" id="premiumTabla">
            <table>
                <tr>
                    <td>Número de tarjeta:  </td>
                    <td><input type="text" name="premium_tarjeta" id="premium_tarjeta" minlenght="16" maxlenght="16" required autofocus></td>
                </tr>
                <tr>
                    <td>Saldo disponible:  </td>
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
    </body>
</html>
