<%@page import="daos.InteresDAO"%>
<%@page import="daos.AficionDAO"%>
<%@page import="daos.PersonalidadDAO"%>
<%@page import="utils.BD"%>
<%@page import="beans.Usuario"%>
<%@page import="daos.UsuarioDAO"%>
<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Perfil"/>
    <jsp:param name="include" value="perfil"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

<form id="perfil_busqueda" method="POST" enctype="multipart/form-data">
    <table>

        <%
            String email = (String) session.getAttribute("email_perfil_busq");
            UsuarioDAO udao = new UsuarioDAO(BD.getConexion());
            Usuario u = udao.cogerUsuario(email);
        %>
        <tr>
            <td>Foto:</td>
            <td><img src="img/fotos/<%=u.getFoto()%>"/>
        </tr>
        <tr>
            <td>Nombre de usuario: * </td>
            <td><input type="text" name="perfil_nick" id="perfil_nick" minlenght="3" maxlenght="15" value="<%=u.getNick()%>" disabled></td>
        </tr>
        <tr>
            <td>Email: * </td>
            <td><input type="email" id="perfil_email" name="perfil_email" value="<%=u.getEmail()%>" disabled></td>
        </tr>
        <tr>
            <td>Género: * </td>
            <td>
                <input type="radio" name="perfil_genero" value="Masculino" disabled<% if (!u.isFemenino()) {
                        out.print("checked");
                    }
                       %> > Masculino
                <input type="radio" name="perfil_genero" value="Femenino" disabled<% if (u.isFemenino()) {
                        out.print("checked");
                    }
                       %> > Femenino
            </td>
        </tr>
        <tr>
            <td>Ciudad: * </td>
            <td>        
                <select name="perfil_ciudad" id="perfil_ciudad" disabled>
                    <option value="Vitoria-Gasteiz" <% if (u.getCiudad().equals("Vitoria-Gasteiz")) {
                            out.print("selected");
                        }
                            %> >Vitoria-Gasteiz
                    </option>
                    <option value="Bilbao" <% if (u.getCiudad().equals("Bilbao")) {
                            out.print("selected");
                        }
                            %> >Bilbao

                    </option>
                    <option value="San Sebastian" <% if (u.getCiudad().equals("San Sebastian")) {
                            out.print("selected");
                        }
                            %>>San Sebastián
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Código Postal: * </td>
            <td><input type="text" id="perfil_cp" name="perfil_cp" disabled placeholder="00000" minlength="5" maxlength="5" value="<%=u.getCp()%>" disabled></td>
        </tr>
        <tr>
            <td>Edad: * </td>
            <td><input type="number" name="perfil_edad" id="perfil_edad" disabled min="18" max="120" value="<%=u.getEdad()%>" disabled></td>
        </tr>
        <tr>
            <td>Altura:</td>
            <%
                String altura;
                if(u.getAltura()==0f){
                    altura="";
                }else{
                    altura=String.valueOf(u.getAltura());
                }
            %>
            <td><input type="number" name="perfil_altura" id="perfil_altura" disabled step="0.01" value="<%=altura%>" min="1" max="3"></td>
        </tr>
        <tr>
            <td>Peso: </td>
            <%
                String peso;
                if(u.getPeso()==0){
                    peso="";
                }else{
                    peso=String.valueOf(u.getPeso());
                }
            %>
            <td><input type="number" min="30" max="200" name="perfil_peso" disabled value="<%=peso%>" id="perfil_peso"></td>
        </tr>
    </table>
    <br>
    <fieldset id="perfil_constitucion">
        <legend><b>¿Qué aspecto tienes?</b></legend>
        <input type="radio" name="perfil_const" value="Delgado" disabled <% if (u.getConstitucion().equals("Delgado")) {
                out.print("checked");
            }
               %> > Delgado/Delgada
        <br>
        <input type="radio" name="perfil_const" value="Fornido" disabled<% if (u.getConstitucion().equals("Fornido")) {
                out.print("checked");
            }
               %> > Fornido/Fornida
        <br>
        <input type="radio" name="perfil_const" value="Musculoso" disabled<% if (u.getConstitucion().equals("Musculoso")) {
                out.print("checked");
            }
               %>> Musculoso/Musculosa
    </fieldset>
    <br>

    <%
        PersonalidadDAO pdao = new PersonalidadDAO(BD.getConexion());
    %>


    <fieldset id="perfil_caracteristicas" disabled>
        <legend><b>¿Cómo te definirías?</b></legend>
        <input type="checkbox" name="perfil_carac" value="Simpatico" disabled
               <%
                   if (pdao.estaPersonalidad("Simpatico", u.getNick())) {
                       out.print("checked");
                   }
               %>
               > Simpático/Simpática
        <br>
        <input type="checkbox" name="perfil_carac" value="Divertido" disabled
               <%
                   if (pdao.estaPersonalidad("Divertido", u.getNick())) {
                       out.print("checked");
                   }
               %>> Divertido/Divertida
        <br>
        <input type="checkbox" name="perfil_carac" value="Alegre" disabled
               <%
                   if (pdao.estaPersonalidad("Alegre", u.getNick())) {
                       out.print("checked");
                   }
               %>> Alegre
        <br>
        <input type="checkbox" name="perfil_carac" value="Generoso" disabled
               <%
                   if (pdao.estaPersonalidad("Generoso", u.getNick())) {
                       out.print("checked");
                   }
               %>> Generoso/Generosa
        <br>
        <input type="checkbox" name="perfil_carac" value="Atrevido" disabled
               <%
                   if (pdao.estaPersonalidad("Atrevido", u.getNick())) {
                       out.print("checked");
                   }
               %>> Atrevido/Atrevida
        <br>
        <input type="checkbox" name="perfil_carac" value="Romantico" disabled
               <%
                   if (pdao.estaPersonalidad("Romantico", u.getNick())) {
                       out.print("checked");
                   }
               %>> Romántico/Romántica
    </fieldset>
    <br>
    <%
        AficionDAO adao = new AficionDAO(BD.getConexion());
    %>
    <fieldset id="perfil_gustos">
        <legend><b>¿Cuáles son tus gustos?</b></legend>
        <input type="checkbox" name="perfil_gustos" value="Deportes" disabled
               <%
                   if (adao.estaAficion("Deportes", u.getNick())) {
                       out.print("checked");
                   }
               %>> Deportes
        <br>
        <input type="checkbox" name="perfil_gustos" value="Lectura" disabled
               <%
                   if (adao.estaAficion("Lectura", u.getNick())) {
                       out.print("checked");
                   }
               %>> Lectura
        <br>
        <input type="checkbox" name="perfil_gustos" value="Television" disabled
               <%
                   if (adao.estaAficion("Television", u.getNick())) {
                       out.print("checked");
                   }
               %>> Televisión
        <br>
        <input type="checkbox" name="perfil_gustos" value="Musica" disabled
               <%
                   if (adao.estaAficion("Musica", u.getNick())) {
                       out.print("checked");
                   }
               %>> Música
        <br>
        <input type="checkbox" name="perfil_gustos" value="OcioNoc" disabled
               <%
                   if (adao.estaAficion("OcioNoc", u.getNick())) {
                       out.print("checked");
                   }
               %>> Ocio nocturno
        <br>
        <input type="checkbox" name="perfil_gustos" value="Tecnologia" disabled
               <%
                   if (adao.estaAficion("Tecnologia", u.getNick())) {
                       out.print("checked");
                   }
               %>> Tecnología
    </fieldset>
    <br>
    <h2>Indica tus preferencias de búsqueda:  </h2>
    <%
        InteresDAO idao = new InteresDAO(BD.getConexion());
    %>
    <table>
        <tr>
            <td> Busco: * </td> <br /> <td><input type="radio" name="genero_busqueda" id="genero_busqueda" value="Hombres" disabled <%
                if (idao.getGeneroInteres(u.getNick()).equals("Masculino")) {
                    out.print("checked");
                }

                                                  %>> Hombres
            <input type="radio" name="genero_busqueda" id="genero_busqueda" value="Mujeres" disabled<% if (idao.getGeneroInteres(u.getNick()).equals("Femenino")) {
                    out.print("checked");
                }

                   %>> Mujeres
        </td> </tr>

        <tr>
            <td>
                Con una edad mínima de: *</td><td><input type="number" disabled name="edad_busqueda" id="edad_busqueda" min="18" max="120" required value="<%=idao.getEdadInteres(u.getNick())%>" > </td> </tr>

        <tr>
            <%
                String altura2;
                if(idao.getAlturaInteres(u.getNick())==0f){
                    altura2="";
                }else{
                    altura2=String.valueOf(idao.getAlturaInteres(u.getNick()));
                }
            %>
            <td> Con altura de: </td> <td> <input type="number" disabled name="altura_busqueda" id="altura_busqueda" step="0.01" min="1" max="3" value="<%=altura2%>"> </td> </tr>

        <tr>
            <%
                String peso2;
                if(idao.getPesoInteres(u.getNick())==0){
                    peso2="";
                }else{
                    peso2=String.valueOf(idao.getPesoInteres(u.getNick()));
                }
            %>
            <td>
                Con un peso de: </td> <td> <input type="number" disabled min="30" max="200" name="peso_busqueda" id="peso_busqueda" value="<%=peso2%>"> </td></tr>

        <tr>
            <td>Que viva en:  </td>
            <td>        
                <select name="perfil_ciudad" id="ciudad_busqueda" disabled>
                    <option value="Vitoria-Gasteiz" <% if (idao.getCiudadInteres(u.getNick()).equals("Vitoria-Gasteiz")) {
                            out.print("selected");
                        }
                            %>>Vitoria-Gasteiz</option>
                    <option value="Bilbao"<% if (idao.getCiudadInteres(u.getNick()).equals("Bilbao")) {
                            out.print("selected");
                        }
                            %>>Bilbao</option>
                    <option value="San Sebastian" <% if (idao.getCiudadInteres(u.getNick()).equals("San Sebastian")) {
                            out.print("selected");
                        }
                            %>>San Sebastián</option>
                </select>
            </td> </tr>

        <tr>
            <td>
                Con Código Postal: </td> <td> <input type="text" id="cp_busqueda" disabled name="cp_busqueda" placeholder="00000" minlength="5" maxlength="5" value="<%=idao.getCPInteres(u.getNick())%>"> </td></tr>

    </table>
    <br>
    <fieldset id="const_busqueda">
        <legend><b>Con aspecto: </b></legend>
        <input type="radio" name="const_busqueda" value="Delgado" disabled<%
            if (idao.getConstitucionInteres(u.getNick()).equals("Delgado")) {
                out.print("checked");
            }

               %>> Delgado/Delgada
        <br>
        <input type="radio" name="const_busqueda" value="Fornido" disabled
               <%                   if (idao.getConstitucionInteres(u.getNick()).equals("Fornido")) {
                       out.print("checked");
                   }

               %>> Fornido/Fornida
        <br>
        <input type="radio" name="const_busqueda" value="Musculoso" disabled
               <%                   if (idao.getConstitucionInteres(u.getNick()).equals("Musculoso")) {
                       out.print("checked");
                   }

               %>> Musculoso/Musculosa
    </fieldset>
    <br>
    <br>
    <input id="perfil_ENLACEVOLVER" class="perfil_btn" type="button" value="Volver a principal">
</form>
<jsp:include page="/comun/logueado/pie.jsp"/>
