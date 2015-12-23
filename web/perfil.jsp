<%@page import="utils.BD"%>
<%@page import="beans.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="daos.UsuarioDAO"%>
<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Perfil"/>
    <jsp:param name="include" value="perfil"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>

<form action="/Perfil" id="perfil_FORMULARIO">
    <div id="perfil_foto">
        Foto *
    </div>
    <table>
        
        <%
    String email = (String)session.getAttribute("usuario_email");
    if(email == null){
        application.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    UsuarioDAO udao = new UsuarioDAO(BD.getConexion());
    Usuario u = udao.cogerUsuario(email);

%>
            
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
                <input type="radio" name="perfil_genero" value="Masculino" checked required > Masculino
                <input type="radio" name="perfil_genero" value="Femenino" > Femenino
            </td>
        </tr>
        <tr>
            <td>Ciudad: * </td>
            <td>        
                <select name="perfil_ciudad" id="perfil_ciudad" required>
                    <option value="Vitoria-Gasteiz" <% if(u.getCiudad()=="Vitoria-Gasteiz"){
                            out.print("selected");
                        }
                                %> >Vitoria-Gasteiz
                        </option>
                    <option value="Bilbao" <% if(u.getCiudad()=="Bilbao"){ 
                            out.print("selected");
                        }
                                %> >Bilbao
                     
                    </option>
                    <option value="San Sebastian" <% if(u.getCiudad()=="San Sebastian"){
                            out.print("selected");
                        }
                                %>>San Sebasti�n
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>C�digo Postal: * </td>
            <td><input type="text" id="perfil_cp" name="perfil_cp" placeholder="00000" minlength="5" maxlength="5" value="<%="0" + ((Integer)u.getCp()).toString() %>" required></td>
        </tr>
        <tr>
            <td>Edad: * </td>
            <td><input type="number" name="perfil_edad" id="perfil_edad" min="18" max="120" value="<%=u.getEdad()%>" required></td>
        </tr>
        <tr>
            <td>Altura:</td>
            <td><input type="number" name="perfil_altura" id="perfil_altura" step="0.01" value="<%=u.getAltura()%>" min="1" max="3"></td>
        </tr>
        <tr>
            <td>Peso: </td>
            <td><input type="number" min="30" max="200" name="perfil_peso" value="<%=u.getPeso()%>" id="perfil_peso"></td>
        </tr>
    </table>
    <br>
    <fieldset id="perfil_constitucion">
        <legend><b>�Qu� aspecto tienes?</b></legend>
        <input type="radio" name="perfil_const" value="Delgado" required checked> Delgado/Delgada
        <br>
        <input type="radio" name="perfil_const" value="Fornido"> Fornido/Fornida
        <br>
        <input type="radio" name="perfil_const" value="Musculoso"> Musculoso/Musculosa
    </fieldset>
    <br>
    <fieldset id="perfil_caracteristicas">
        <legend><b>�C�mo te definir�as?</b></legend>
        <input type="checkbox" name="perfil_carac" value="Simpatico"> Simp�tico/Simp�tica
        <br>
        <input type="checkbox" name="perfil_carac" value="Divertido"> Divertido/Divertida
        <br>
        <input type="checkbox" name="perfil_carac" value="Alegre"> Alegre
        <br>
        <input type="checkbox" name="perfil_carac" value="Generoso"> Generoso/Generosa
        <br>
        <input type="checkbox" name="perfil_carac" value="Atrevido"> Atrevido/Atrevida
        <br>
        <input type="checkbox" name="perfil_carac" value="Romantico"> Rom�ntico/Rom�ntica
    </fieldset>
    <br>
    <fieldset id="perfil_gustos">
        <legend><b>�Cu�les son tus gustos?</b></legend>
        <input type="checkbox" name="perfil_gustos" value="Deportes"> Deportes
        <br>
        <input type="checkbox" name="perfil_gustos" value="Lectura"> Lectura
        <br>
        <input type="checkbox" name="perfil_gustos" value="Television"> Televisi�n
        <br>
        <input type="checkbox" name="perfil_gustos" value="Musica"> M�sica
        <br>
        <input type="checkbox" name="perfil_gustos" value="OcioNoc"> Ocio nocturno
        <br>
        <input type="checkbox" name="perfil_gustos" value="Tecnologia"> Tecnolog�a
    </fieldset>
    <br>
    <h2>Indica tus preferencias de b�squeda:  </h2>
    <table>
        <tr>
            <td> Busco: * </td> <br /> <td><input type="radio" name="genero_busqueda" id="genero_busqueda" value="Hombres" checked required > Hombres
            <input type="radio" name="genero_busqueda" id="genero_busqueda" value="Mujeres" > Mujeres
        </td> </tr>

        <tr>
            <td>
                Con una edad m�nima de: *</td><td><input type="number" name="edad_busqueda" id="edad_busqueda" min="18" max="120" required> </td> </tr>

        <tr>
            <td> Con altura de: </td> <td> <input type="number" name="altura_busqueda" id="altura_busqueda" step="0.01" min="1" max="3"> </td> </tr>

        <tr>
            <td>
                Con un peso de: </td> <td> <input type="number" min="30" max="200" name="peso_busqueda" id="peso_busqueda"> </td></tr>

        <tr>
            <td>Que viva en:  </td>
            <td>        
                <select name="perfil_ciudad" id="ciudad_busqueda">
                    <option value="Vitoria-Gasteiz">Vitoria-Gasteiz</option>
                    <option value="Bilbao">Bilbao</option>
                    <option value="San Sebastian">San Sebasti�n</option>
                </select>
            </td> </tr>

        <tr>
            <td>
                Con C�digo Postal: </td> <td> <input type="text" id="cp_busqueda" name="cp_busqueda" placeholder="00000" minlength="5" maxlength="5"> </td></tr>

    </table>
    <br>
    <fieldset id="const_busqueda">
        <legend><b>Con aspecto: </b></legend>
        <input type="radio" name="const_busqueda" value="Delgado" checked> Delgado/Delgada
        <br>
        <input type="radio" name="const_busqueda" value="Fornido"> Fornido/Fornida
        <br>
        <input type="radio" name="const_busqueda" value="Musculoso"> Musculoso/Musculosa
    </fieldset>
    <br>
    <br>
    <h5>Los campos marcados con * son obligatorios</h5>
    <br>
    <input class="perfil_btn" type="submit" value="Editar perfil">
    <input id="perfil_ENLACEVOLVER" class="perfil_btn" type="button" value="Volver a principal">
</form>
<jsp:include page="/comun/logueado/pie.jsp"/>