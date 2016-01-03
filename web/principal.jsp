<%@page import="beans.Usuario"%>
<%@page import="daos.UsuarioDAO"%>
<%@page import="daos.InteresDAO"%>
<%@page import="utils.BD"%>
<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Página principal"/>
    <jsp:param name="include" value="principal"/>
</jsp:include>

        <%String email = (String) session.getAttribute("usuario_email");
            UsuarioDAO udao = new UsuarioDAO(BD.getConexion());
            Usuario u = udao.cogerUsuario(email);
            %>         
            
        Busqueda básica:
        <br>
        <form>
            
        Nick:<input type="text">
        <br>
        <br>
        <input type="submit" value="Buscar">

        </form>
        <br>
        Busqueda avanzada (Rellene todos los campos por favor):
        <form>
        <%InteresDAO iDAO = new InteresDAO(BD.getConexion()); %>

        <table>
        <tr>
            <td> Genero: </td> <br /> <td><input type="radio" name="genero_busq" value="Hombres" required  <%
                if (iDAO.getGeneroInteres(u.getNick()).equals("Masculino")) {
                    out.print("checked");
                }

                                                  %>> Hombres
            <input type="radio" name="genero_busq" value="Mujeres" <% if (iDAO.getGeneroInteres(u.getNick()).equals("Femenino")) {
                    out.print("checked");
                }

                   %>> Mujeres
        </td> </tr>

        <tr>
            <td>
                Edad: *</td><td><input type="number" name="edad_busq" id="edad_busq" min="18" max="120" required value="<%=iDAO.getEdadInteres(u.getNick())%>" > </td> </tr>

        <tr>
            <td> Altura: </td> <td> <input type="number" name="altura_busq" id="altura_busq" step="0.01" min="1" max="3" value="<%=iDAO.getAlturaInteres(u.getNick())%>"> </td> </tr>

        <tr>
            <td>
                Peso: </td> <td> <input type="number" min="30" max="200" name="peso_busq" id="peso_busq" value="<%=iDAO.getPesoInteres(u.getNick())%>"> </td></tr>

        <tr>
            <td>Lugar de residencia:  </td>
            <td>        
                <select name="ciudad_busq" id="ciudad_busqueda">
                    <option value="Vitoria-Gasteiz" <% if (iDAO.getCiudadInteres(u.getNick()).equals("Vitoria-Gasteiz")) {
                            out.print("selected");
                        }
                            %>>Vitoria-Gasteiz</option>
                    <option value="Bilbao"<% if (iDAO.getCiudadInteres(u.getNick()).equals("Bilbao")) {
                            out.print("selected");
                        }
                            %>>Bilbao</option>
                    <option value="San Sebastian" <% if (iDAO.getCiudadInteres(u.getNick()).equals("San Sebastian")) {
                            out.print("selected");
                        }
                            %>>San Sebastián</option>
                </select>
            </td> </tr>

        <tr>
            <td>
                Código Postal: </td> <td> <input type="text" id="cp_busq" name="cp_busq" placeholder="00000" minlength="5" maxlength="5" value="<%=iDAO.getCPInteres(u.getNick())%>"> </td></tr>

    </table>
    <fieldset id="const_busqueda">
        <legend><b>Aspecto: </b></legend>
        <input type="radio" name="const_busq" value="Delgado" <%
            if (iDAO.getConstitucionInteres(u.getNick()).equals("Delgado")) {
                out.print("checked");
            }

               %>> Delgado/Delgada
        <br>
        <input type="radio" name="const_busq" value="Fornido"
               <%                   if (iDAO.getConstitucionInteres(u.getNick()).equals("Fornido")) {
                       out.print("checked");
                   }

               %>> Fornido/Fornida
        <br>
        <input type="radio" name="const_busq" value="Musculoso"
               <%                   if (iDAO.getConstitucionInteres(u.getNick()).equals("Musculoso")) {
                       out.print("checked");
                   }

               %>> Musculoso/Musculosa
    </fieldset>
    <input type="submit" value="Buscar">
        </form>
<jsp:include page="/comun/logueado/pie.jsp"/>