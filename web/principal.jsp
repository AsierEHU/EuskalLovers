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
        <%InteresDAO iDAO = new InteresDAO(BD.getConexion()); %>   
        Busqueda básica:
        <br>
        <form action="buscar">           
        <table>
        <tr>
            <td> Genero: </td> <br /> <td><input type="radio" name="genero_busq" value="Hombres" disabled <%
                if (iDAO.getGeneroInteres(u.getNick()).equals("Masculino")) {
                    out.print("checked");
                }

                                                  %>> Hombres
            <input type="radio" name="genero_busq" value="Mujeres" disabled <% if (iDAO.getGeneroInteres(u.getNick()).equals("Femenino")) {
                    out.print("checked");
                }

                   %>> Mujeres
        </td> </tr>

        <tr>
            <td>
                Edad: </td><td><input type="number" name="edad_busq" min="18" max="120" required disabled value="<%=iDAO.getEdadInteres(u.getNick())%>" > </td> </tr>

        <tr>
            <td> Altura: </td> <td> <input type="number" name="altura_busq" step="0.01" min="1" max="3" disabled value="<%=iDAO.getAlturaInteres(u.getNick())%>"> </td> </tr>

        <tr>
            <td>
                Peso: </td> <td> <input type="number" min="30" max="200" name="peso_busq" disabled value="<%=iDAO.getPesoInteres(u.getNick())%>"> </td></tr>

        <tr>
            <td>Lugar de residencia:  </td>
            <td>        
                <select name="ciudad_busq" disabled>
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
                Código Postal: </td> <td> <input type="text" name="cp_busq" disabled placeholder="00000" minlength="5" maxlength="5" value="<%=iDAO.getCPInteres(u.getNick())%>"> </td></tr>

    </table>
    <fieldset id="const_busq" disabled>
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
        <br>
        <input type="submit" class="busqueda_btn" value="Buscar">

        </form>
        <br>
        Busqueda avanzada (Rellene todos los campos por favor):
        <form>
        

        <table>
        <tr>
            <td> Genero: </td> <br /> <td><input type="radio" name="genero_busq1" value="Hombres" required  <%
                if (iDAO.getGeneroInteres(u.getNick()).equals("Masculino")) {
                    out.print("checked");
                }

                                                  %>> Hombres
            <input type="radio" name="genero_busq1" value="Mujeres" <% if (iDAO.getGeneroInteres(u.getNick()).equals("Femenino")) {
                    out.print("checked");
                }

                   %>> Mujeres
        </td> </tr>

        <tr>
            <td>
                Edad: </td><td><input type="number" name="edad_busq1" id="edad_busq" min="18" max="120" required value="<%=iDAO.getEdadInteres(u.getNick())%>" > </td> </tr>

        <tr>
            <td> Altura: </td> <td> <input type="number" name="altura_busq1" id="altura_busq" step="0.01" min="1" max="3" value="<%=iDAO.getAlturaInteres(u.getNick())%>"> </td> </tr>

        <tr>
            <td>
                Peso: </td> <td> <input type="number" min="30" max="200" name="peso_busq1" id="peso_busq" value="<%=iDAO.getPesoInteres(u.getNick())%>"> </td></tr>

        <tr>
            <td>Lugar de residencia:  </td>
            <td>        
                <select name="ciudad_busq1" id="ciudad_busqueda">
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
                Código Postal: </td> <td> <input type="text" name="cp_busq1" placeholder="00000" minlength="5" maxlength="5" value="<%=iDAO.getCPInteres(u.getNick())%>"> </td></tr>

    </table>
    <fieldset id="const_busq1">
        <legend><b>Aspecto: </b></legend>
        <input type="radio" name="const_busq1" value="Delgado" <%
            if (iDAO.getConstitucionInteres(u.getNick()).equals("Delgado")) {
                out.print("checked");
            }

               %>> Delgado/Delgada
        <br>
        <input type="radio" name="const_busq1" value="Fornido"
               <%                   if (iDAO.getConstitucionInteres(u.getNick()).equals("Fornido")) {
                       out.print("checked");
                   }

               %>> Fornido/Fornida
        <br>
        <input type="radio" name="const_busq1" value="Musculoso"
               <%                   if (iDAO.getConstitucionInteres(u.getNick()).equals("Musculoso")) {
                       out.print("checked");
                   }

               %>> Musculoso/Musculosa
    </fieldset>
    <br>
    <input type="submit" class="busqueda_btn" value="Buscar">
        </form>
<jsp:include page="/comun/logueado/pie.jsp"/>