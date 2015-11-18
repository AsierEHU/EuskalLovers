<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Reg�strate en EuskalLovers"/>
    <jsp:param name="include" value="registro"/>
</jsp:include>
 <h1> �Reg�strate en Euskal Lovers! </h1>
 <form class="registro_FORMULARIO" action="principal.jsp">
     <br>
     <h3>Pon tu foto de perfil aqu�</h3>
     <div id="caja_foto">
     </div>
    
    Nombre de usuario: * <input type="text" name="registro_nick" required autofocus >
    <br>
    Contrase�a: * <input type="password" name="registro_password" required >
    <br>
    Email: * <input type="email" name="registro_email" required placeholder="ejemplo@ejemplo.com" required>
    <br>
    G�nero: * <br> <input type="radio" name="registro_genero" value="Masculino" checked required > Masculino
                 <input type="radio" name="registro_genero" value="Femenino" > Femenino
    <br>
    Ciudad: * 
     <select name="registro_ciudad" required>
         <option value="Vitoria-Gasteiz">Vitoria-Gasteiz</option>
         <option value="Bilbao">Bilbao</option>
         <option value="San Sebastian">San Sebastian</option>
     </select>
     <br>
     C�digo Postal: * <input type="number" name="registro_cp" placeholder="00000" required>
     <br>
     Edad: * <input type="number" name="registro_edad" min="18" max="100" required>
     <br>
     Altura: <input type="number" name="registro_altura" step="0.01">
     <br>
     Peso: <input type="number" max="100" name="registro_peso">
     <br>
     <fieldset id="registro_constitucion">
         <legend>�Qu� aspecto tienes?</legend>
         <input type="radio" name="registro_const" value="Delgado" required checked> Delgad@
         <input type="radio" name="registro_const" value="Fornido"> Fornid@
         <br>
         <input type="radio" name="registro_const" value="Musculoso"> Musculos@
         <input type="radio" name="registro_const" value="">
     </fieldset>
     <br>
     <fieldset id="registro_caracteristicas">
         <legend>�C�mo eres?</legend>
        <input type="checkbox" name="registro_carac" value="Simpatico"> Simp�tic@
        <input type="checkbox" name="registro_carac" value="Divertido"> Divertid@
        <br>
        <input type="checkbox" name="registro_carac" value="Alegre"> Alegre
        <input type="checkbox" name="registro_carac" value="Generoso"> Generos@
        <br>
        <input type="checkbox" name="registro_carac" value="Atrevido"> Atrevid@
        <input type="checkbox" name="registro_carac" value="Romantico"> Rom�ntic@
     </fieldset>
     <br>
     <fieldset id="registro_gustos">
         <legend>�Cu�les son tus gustos?</legend>
        <input type="checkbox" name="registro_gustos" value="Deportes"> Deportes
        <input type="checkbox" name="registro_gustos" value="Lectura"> Lectura
        <br>
        <input type="checkbox" name="registro_gustos" value="Television"> Televisi�n
        <input type="checkbox" name="registro_gustos" value="Musica"> M�sica
        <br>
        <input type="checkbox" name="registro_gustos" value="OcioNoc"> Ocio nocturno
        <input type="checkbox" name="registro_gustos" value="Tecnologia"> Tecnolog�a
     </fieldset>
     <br>
     <h2>Indica tus preferencias de b�squeda b�sicas: * </h2>
     <br>
     Busco: <br> <input type="radio" name="registro_genero_busqueda" value="Hombre" checked required > Hombres
                 <input type="radio" name="registro_genero_busqueda" value="Mujeres" > Mujeres
     <br>
     Con una edad m�nima de: <input type="number" name="registro_edad_busqueda" min="18" max="100" required>
     <br>
     <br>
     <h5>Los campos marcados con * son obligatorios</h5>
     <br>
     <input type="submit" value="Terminar Registro">
     
</form>

<jsp:include page="/comun/pie.jsp"/>