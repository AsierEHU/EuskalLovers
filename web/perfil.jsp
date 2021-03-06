<%@page import="daos.InteresDAO"%>
<%@page import="daos.AficionDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Personalidad"%>
<%@page import="daos.PersonalidadDAO"%>
<%@page import="utils.BD"%>
<%@page import="beans.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="daos.UsuarioDAO"%>
<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Perfil"/>
    <jsp:param name="include" value="perfil"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

<form action="Perfil" id="perfil_FORMULARIO" method="POST" enctype="multipart/form-data">
    <table>

        <%
            String nick = (String) session.getAttribute("usuario_nick");
            UsuarioDAO udao = new UsuarioDAO(BD.getConexion());
            Usuario u = udao.cogerUsuario(nick);
        %>
        <tr>
            <td>Foto:</td>
            <td><input type="file" name="perfil_foto" accept="image/*"></td>
        </tr>
        <tr>
            <td>Nombre de usuario: * </td>
            <td><input type="text" name="perfil_nick" id="perfil_nick" minlenght="3" maxlenght="15" required value="<%=u.getNick()%>" ></td>
        </tr>
        <tr>
            <td>Contrase�a: * </td>
            <td><input type="password" name="perfil_password" id="perfil_password" minlenght="5" manxlenght="15" value="<%=u.getContrase�a()%>" required ></td>
        </tr>
        <tr>
            <td>Email: * </td>
            <td><input type="email" id="perfil_email" name="perfil_email" value="<%=u.getEmail()%>" required  disabled></td>
        </tr>
        <tr>
            <td>G�nero: * </td>
            <td>
                <input type="radio" name="perfil_genero" value="Masculino"  required <% if (!u.isFemenino()) {
                        out.print("checked");
                    }
                       %> > Masculino
                <input type="radio" name="perfil_genero" value="Femenino" <% if (u.isFemenino()) {
                        out.print("checked");
                    }
                       %> > Femenino
            </td>
        </tr>
        <tr>
            <td>Ciudad: * </td>
            <td>        
                <select name="perfil_ciudad" id="perfil_ciudad" required>
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
                            %>>San Sebasti�n
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>C�digo Postal: * </td>
            <td><input type="text" id="perfil_cp" name="perfil_cp" placeholder="00000" minlength="5" maxlength="5" value="<%=u.getCp()%>" required></td>
        </tr>
        <tr>
            <td>Edad: * </td>
            <td><input type="number" name="perfil_edad" id="perfil_edad" min="18" max="120" value="<%=u.getEdad()%>" required></td>
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
            <td><input type="number" name="perfil_altura" id="perfil_altura" step="0.01" value="<%=altura%>" min="1" max="3"></td>
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
            <td><input type="number" min="30" max="200" name="perfil_peso" value="<%=peso%>" id="perfil_peso"></td>
        </tr>
    </table>
    <br>
    <fieldset id="perfil_constitucion">
        <legend><b>�Qu� aspecto tienes?</b></legend>
        <input type="radio" name="perfil_const" value="Delgado" required <% if (u.getConstitucion().equals("Delgado")) {
                out.print("checked");
            }
               %> > Delgado/Delgada
        <br>
        <input type="radio" name="perfil_const" value="Fornido" <% if (u.getConstitucion().equals("Fornido")) {
                out.print("checked");
            }
               %> > Fornido/Fornida
        <br>
        <input type="radio" name="perfil_const" value="Musculoso" <% if (u.getConstitucion().equals("Musculoso")) {
                out.print("checked");
            }
               %>> Musculoso/Musculosa
    </fieldset>
    <br>

    <%
        PersonalidadDAO pdao = new PersonalidadDAO(BD.getConexion());
    %>


    <fieldset id="perfil_caracteristicas">
        <legend><b>�C�mo te definir�as?</b></legend>
        <input type="checkbox" name="perfil_carac" value="Simpatico"
               <%
                   if (pdao.estaPersonalidad("Simpatico", u.getNick())) {
                       out.print("checked");
                   }
               %>
               > Simp�tico/Simp�tica
        <br>
        <input type="checkbox" name="perfil_carac" value="Divertido"
               <%
                   if (pdao.estaPersonalidad("Divertido", u.getNick())) {
                       out.print("checked");
                   }
               %>> Divertido/Divertida
        <br>
        <input type="checkbox" name="perfil_carac" value="Alegre"
               <%
                   if (pdao.estaPersonalidad("Alegre", u.getNick())) {
                       out.print("checked");
                   }
               %>> Alegre
        <br>
        <input type="checkbox" name="perfil_carac" value="Generoso"
               <%
                   if (pdao.estaPersonalidad("Generoso", u.getNick())) {
                       out.print("checked");
                   }
               %>> Generoso/Generosa
        <br>
        <input type="checkbox" name="perfil_carac" value="Atrevido"
               <%
                   if (pdao.estaPersonalidad("Atrevido", u.getNick())) {
                       out.print("checked");
                   }
               %>> Atrevido/Atrevida
        <br>
        <input type="checkbox" name="perfil_carac" value="Romantico"
               <%
                   if (pdao.estaPersonalidad("Romantico", u.getNick())) {
                       out.print("checked");
                   }
               %>> Rom�ntico/Rom�ntica
    </fieldset>
    <br>
    <%
        AficionDAO adao = new AficionDAO(BD.getConexion());
    %>
    <fieldset id="perfil_gustos">
        <legend><b>�Cu�les son tus gustos?</b></legend>
        <input type="checkbox" name="perfil_gustos" value="Deportes"
               <%
                   if (adao.estaAficion("Deportes", u.getNick())) {
                       out.print("checked");
                   }
               %>> Deportes
        <br>
        <input type="checkbox" name="perfil_gustos" value="Lectura"
               <%
                   if (adao.estaAficion("Lectura", u.getNick())) {
                       out.print("checked");
                   }
               %>> Lectura
        <br>
        <input type="checkbox" name="perfil_gustos" value="Television"
               <%
                   if (adao.estaAficion("Television", u.getNick())) {
                       out.print("checked");
                   }
               %>> Televisi�n
        <br>
        <input type="checkbox" name="perfil_gustos" value="Musica"
               <%
                   if (adao.estaAficion("Musica", u.getNick())) {
                       out.print("checked");
                   }
               %>> M�sica
        <br>
        <input type="checkbox" name="perfil_gustos" value="OcioNoc"
               <%
                   if (adao.estaAficion("OcioNoc", u.getNick())) {
                       out.print("checked");
                   }
               %>> Ocio nocturno
        <br>
        <input type="checkbox" name="perfil_gustos" value="Tecnologia"
               <%
                   if (adao.estaAficion("Tecnologia", u.getNick())) {
                       out.print("checked");
                   }
               %>> Tecnolog�a
    </fieldset>
    <br>
    <h2>Indica tus preferencias de b�squeda:  </h2>
    <%
        InteresDAO idao = new InteresDAO(BD.getConexion());
    %>
    <table>
        <tr>
            <td> Busco: * </td> <br /> <td><input type="radio" name="genero_busqueda" id="genero_busqueda" value="Hombres" required  <%
                if (idao.getGeneroInteres(u.getNick()).equals("Masculino")) {
                    out.print("checked");
                }

                                                  %>> Hombres
            <input type="radio" name="genero_busqueda" id="genero_busqueda" value="Mujeres" <%                if (idao.getGeneroInteres(u.getNick()).equals("Femenino")) {
                    out.print("checked");
                }

                   %>> Mujeres
        </td> </tr>

        <tr>
            <td>
                Con una edad m�nima de: *</td><td><input type="number" name="edad_busqueda" id="edad_busqueda" min="18" max="120" required value="<%=idao.getEdadInteres(u.getNick())%>" > </td> </tr>

        <tr>
            <%
                String altura2;
                if(idao.getAlturaInteres(u.getNick())==0f){
                    altura2="";
                }else{
                    altura2=String.valueOf(idao.getAlturaInteres(u.getNick()));
                }
            %>
            <td> Con altura de: </td> <td> <input type="number" name="altura_busqueda" id="altura_busqueda" step="0.01" min="1" max="3" value="<%=altura2%>"> </td> </tr>

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
                Con un peso de: </td> <td> <input type="number" min="30" max="200" name="peso_busqueda" id="peso_busqueda" value="<%=peso2%>"> </td></tr>

        <tr>
            <td>Que viva en:  </td>
            <td>        
                <select name="ciudad_busqueda" id="ciudad_busqueda">
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
                            %>>San Sebasti�n</option>
                </select>
            </td> </tr>

        <tr>
            <td>
                Con C�digo Postal: </td> <td> <input type="text" id="cp_busqueda" name="cp_busqueda" placeholder="00000" minlength="5" maxlength="5" value="<%=idao.getCPInteres(u.getNick())%>"> </td></tr>

    </table>
    <br>
    <fieldset id="const_busqueda">
        <legend><b>Con aspecto: </b></legend>
        <input type="radio" name="const_busqueda" value="Delgado" <%
            if (idao.getConstitucionInteres(u.getNick()).equals("Delgado")) {
                out.print("checked");
            }

               %>> Delgado/Delgada
        <br>
        <input type="radio" name="const_busqueda" value="Fornido"
               <%                   if (idao.getConstitucionInteres(u.getNick()).equals("Fornido")) {
                       out.print("checked");
                   }

               %>> Fornido/Fornida
        <br>
        <input type="radio" name="const_busqueda" value="Musculoso"
               <%                   if (idao.getConstitucionInteres(u.getNick()).equals("Musculoso")) {
                       out.print("checked");
                   }

               %>> Musculoso/Musculosa
    </fieldset>
    <br>
    <br>
    <h5>Los campos marcados con * son obligatorios</h5>
    <br>
    <input class="perfil_btn" type="submit" value="Editar perfil">
    <input id="perfil_ENLACEVOLVER" class="perfil_btn" type="button" value="Volver a principal">
</form>
<form method="post" action="Delete" >
    <input type="submit" class="perfil_btn" value="Eliminar mi perfil">
</form>
<jsp:include page="/comun/logueado/pie.jsp"/>