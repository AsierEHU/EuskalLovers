<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Reg�strate en EuskalLovers"/>
    <jsp:param name="include" value="registro"/>
    <jsp:param name="includeLib" value="formularios"/>
</jsp:include>


<%
    if(request.getParameter("error")!=null){
        %>
        <script>
            alert("El nombre de usuario o el correo electr�nico ya han sido usados");
        </script>
        <%
    }
%>

<div id="registro_center">
    <h1 id="registro_title"> �Reg�strate en Euskal Lovers! </h1>
    <form action="registro" id="registro_FORMULARIO" method="post">
        <!--    <div id="registro_foto">
        Foto *
    </div>-->
        <table>
            <tr>
<!--                <td rowspan="9"><input type="file" name="registro_foto" required ></td>-->
                <td>Nombre de usuario: * </td>
                <td><input type="text" name="registro_nick" id="registro_nick" required ></td>
            </tr>
            <tr>
                <td>Contrase�a: * </td>
                <td><input type="password" name="registro_password" id="registro_password" required ></td>
            </tr>
            <tr>
                <td>Email: * </td>
                <td><input type="email" id="registro_email" name="registro_email" required placeholder="ejemplo@ejemplo.com"></td>
            </tr>
            <tr>
                <td>G�nero: * </td>
                <td>
                    <input type="radio" name="registro_genero" value="Masculino" checked required > Masculino
                    <input type="radio" name="registro_genero" value="Femenino" > Femenino
                </td>
            </tr>
            <tr>
                <td>Ciudad: * </td>
                <td>        
                    <select name="registro_ciudad" id="registro_ciudad" required>
                        <option value="Vitoria-Gasteiz">Vitoria-Gasteiz</option>
                        <option value="Bilbao">Bilbao</option>
                        <option value="San Sebastian">San Sebasti�n</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>C�digo Postal: * </td>
                <td><input type="text" id="registro_cp" name="registro_cp" placeholder="00000" required></td>
            </tr>
            <tr>
                <td>Edad: * </td>
                <td><input type="number" name="registro_edad" id="registro_edad" min="18" max="120" required></td>
            </tr>
            <tr>
                <td>Altura:</td>
                <td><input type="number" name="registro_altura" id="registro_altura" step="0.01" min="1" max="3"></td>
            </tr>
            <tr>
                <td>Peso: </td>
                <td><input type="number" min="30" max="200" name="registro_peso" id="registro_peso"></td>
            </tr>
        </table>
        <br>
        <fieldset id="registro_constitucion">
            <legend><b>�Qu� aspecto tienes?</b></legend>
            <input type="radio" name="registro_const" value="Delgado" required checked> Delgado/Delgada
            <br>
            <input type="radio" name="registro_const" value="Fornido"> Fornido/Fornida
            <br>
            <input type="radio" name="registro_const" value="Musculoso"> Musculoso/Musculosa
        </fieldset>
        <br>
        <fieldset id="registro_caracteristicas">
            <legend><b>�C�mo te definir�as?</b></legend>
            <input type="checkbox" name="registro_carac" value="Simpatico"> Simp�tico/Simp�tica
            <br>
            <input type="checkbox" name="registro_carac" value="Divertido"> Divertido/Divertida
            <br>
            <input type="checkbox" name="registro_carac" value="Alegre"> Alegre
            <br>
            <input type="checkbox" name="registro_carac" value="Generoso"> Generoso/Generosa
            <br>
            <input type="checkbox" name="registro_carac" value="Atrevido"> Atrevido/Atrevida
            <br>
            <input type="checkbox" name="registro_carac" value="Romantico"> Rom�ntico/Rom�ntica
        </fieldset>
        <br>
        <fieldset id="registro_gustos">
            <legend><b>�Cu�les son tus gustos?</b></legend>
            <input type="checkbox" name="registro_gustos" value="Deportes"> Deportes
            <br>
            <input type="checkbox" name="registro_gustos" value="Lectura"> Lectura
            <br>
            <input type="checkbox" name="registro_gustos" value="Television"> Televisi�n
            <br>
            <input type="checkbox" name="registro_gustos" value="Musica"> M�sica
            <br>
            <input type="checkbox" name="registro_gustos" value="OcioNoc"> Ocio nocturno
            <br>
            <input type="checkbox" name="registro_gustos" value="Tecnologia"> Tecnolog�a
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
                    <select name="ciudad_busqueda" id="ciudad_busqueda">
                        <option value="Vitoria-Gasteiz">Vitoria-Gasteiz</option>
                        <option value="Bilbao">Bilbao</option>
                        <option value="San Sebastian">San Sebasti�n</option>
                    </select>
                </td> </tr>

            <tr>
                <td>
                    Con C�digo Postal: </td> <td> <input type="text" name="cp_busqueda" id="cp_busqueda"  placeholder="00000" minlength="5" maxlength="5"> </td></tr>

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
        <input  class="registro_btn" type="submit" value="Terminar Registro">
        <input id="registro_ENLACEVOLVER" class="registro_btn" type="button" value="Volver a inicio">
    </form>
</div>
<jsp:include page="/comun/pie.jsp"/>