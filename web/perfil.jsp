<jsp:include page="/comun/logueado/cabeza.jsp">
    <jsp:param name="title" value="Perfil"/>
    <jsp:param name="include" value="perfil"/>
</jsp:include>

<form action="principal.jsp" id="registro_FORMULARIO">
        <div id="registro_foto">
            Foto *
        </div>
        <table>
            <tr>
                <td>Nombre de usuario: * </td>
                <td><input type="text" name="registro_nick" id="registro_nick" minlenght="3" maxlenght="15" required ></td>
            </tr>
            <tr>
                <td>Contraseña: * </td>
                <td><input type="password" name="registro_password" id="registro_password" minlenght="5" manxlenght="15" required ></td>
            </tr>
            <tr>
                <td>Email: * </td>
                <td><input type="email" id="registro_email" name="registro_email" required placeholder="ejemplo@ejemplo.com" required></td>
            </tr>
            <tr>
                <td>Género: * </td>
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
                        <option value="San Sebastian">San Sebastián</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Código Postal: * </td>
                <td><input type="text" id="registro_cp" name="registro_cp" placeholder="00000" minlength="5" maxlength="5" required></td>
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
            <legend><b>¿Qué aspecto tienes?</b></legend>
            <input type="radio" name="registro_const" value="Delgado" required checked> Delgado/Delgada
            <br>
            <input type="radio" name="registro_const" value="Fornido"> Fornido/Fornida
            <br>
            <input type="radio" name="registro_const" value="Musculoso"> Musculoso/Musculosa
        </fieldset>
        <br>
        <fieldset id="registro_caracteristicas">
            <legend><b>¿Cómo te definirías?</b></legend>
            <input type="checkbox" name="registro_carac" value="Simpatico"> Simpático/Simpática
            <br>
            <input type="checkbox" name="registro_carac" value="Divertido"> Divertido/Divertida
            <br>
            <input type="checkbox" name="registro_carac" value="Alegre"> Alegre
            <br>
            <input type="checkbox" name="registro_carac" value="Generoso"> Generoso/Generosa
            <br>
            <input type="checkbox" name="registro_carac" value="Atrevido"> Atrevido/Atrevida
            <br>
            <input type="checkbox" name="registro_carac" value="Romantico"> Romántico/Romántica
        </fieldset>
        <br>
        <fieldset id="registro_gustos">
            <legend><b>¿Cuáles son tus gustos?</b></legend>
            <input type="checkbox" name="registro_gustos" value="Deportes"> Deportes
            <br>
            <input type="checkbox" name="registro_gustos" value="Lectura"> Lectura
            <br>
            <input type="checkbox" name="registro_gustos" value="Television"> Televisión
            <br>
            <input type="checkbox" name="registro_gustos" value="Musica"> Música
            <br>
            <input type="checkbox" name="registro_gustos" value="OcioNoc"> Ocio nocturno
            <br>
            <input type="checkbox" name="registro_gustos" value="Tecnologia"> Tecnología
        </fieldset>
        <br>
        <h2>Indica tus preferencias de búsqueda:  </h2>
        <table>
            <tr>
                <td> Busco: * </td> <br /> <td><input type="radio" name="genero_busqueda" id="genero_busqueda" value="Hombres" checked required > Hombres
                <input type="radio" name="genero_busqueda" id="genero_busqueda" value="Mujeres" > Mujeres
            </td> </tr>

            <tr>
                <td>
                    Con una edad mínima de: *</td><td><input type="number" name="edad_busqueda" id="edad_busqueda" min="18" max="120" required> </td> </tr>

            <tr>
                <td> Con altura de: </td> <td> <input type="number" name="altura_busqueda" id="altura_busqueda" step="0.01" min="1" max="3"> </td> </tr>

            <tr>
                <td>
                    Con un peso de: </td> <td> <input type="number" min="30" max="200" name="peso_busqueda" id="peso_busqueda"> </td></tr>

            <tr>
                <td>Que viva en:  </td>
                <td>        
                    <select name="registro_ciudad" id="ciudad_busqueda">
                        <option value="Vitoria-Gasteiz">Vitoria-Gasteiz</option>
                        <option value="Bilbao">Bilbao</option>
                        <option value="San Sebastian">San Sebastián</option>
                    </select>
                </td> </tr>

            <tr>
                <td>
                    Con Código Postal: </td> <td> <input type="text" id="cp_busqueda" name="cp_busqueda" placeholder="00000" minlength="5" maxlength="5"> </td></tr>

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
        <input class="registro_btn" type="submit" value="Editar perfil">
    </form>
<jsp:include page="/comun/logueado/pie.jsp"/>