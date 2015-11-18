<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Regístrate en EuskalLovers"/>
    <jsp:param name="include" value="registro"/>
</jsp:include>
 <h1> ¡Regístrate en Euskal Lovers! </h1>
 <form class="registro_FORMULARIO" action="principal.jsp">
     <br>
     <h3>Pon tu foto de perfil aquí</h3>
     <div id="caja_foto">
     </div>
    
    Nombre de usuario: * <input type="text" name="registro_nick" required autofocus >
    <br>
    Contraseña: * <input type="password" name="registro_password" required >
    <br>
    Email: * <input type="email" name="registro_email" required placeholder="ejemplo@ejemplo.com" required>
    <br>
    Género: * <br> <input type="radio" name="registro_genero" value="Masculino" checked required > Masculino
                 <input type="radio" name="registro_genero" value="Femenino" > Femenino
    <br>
    Ciudad: * 
     <select name="registro_ciudad" required>
         <option value="Vitoria-Gasteiz">Vitoria-Gasteiz</option>
         <option value="Bilbao">Bilbao</option>
         <option value="San Sebastian">San Sebastian</option>
     </select>
     <br>
     Código Postal: * <input type="number" name="registro_cp" placeholder="00000" required>
     <br>
     Edad: * <input type="number" name="registro_edad" min="18" max="100" required>
     <br>
     Altura: <input type="number" name="registro_peso" step="0.01">
     <br>
     Peso: <input type="number" max="100" name="registro_altura">
     <br>
     <fieldset id="registro_constitucion">
         <legend>¿Qué aspecto tienes?</legend>
         <input type="radio" name="registro_const" value="Delgado" checked> Delgad@
         <input type="radio" name="registro_const" value="Fornido"> Fornid@
         <br>
         <input type="radio" name="registro_const" value="Musculoso"> Musculos@
         <input type="radio" name="registro_const" value="">
     </fieldset>
     <br>
     <fieldset id="registro_caracteristicas">
         <legend>¿Cómo eres?</legend>
        <input type="checkbox" name="registro_carac" value="Simpatico"> Simpátic@
        <input type="checkbox" name="registro_carac" value="Divertido"> Divertid@
        <br>
        <input type="checkbox" name="registro_carac" value="Generoso"> Alegre
        <input type="checkbox" name="registro_carac" value="Alegre"> Generos@
        <br>
        <input type="checkbox" name="registro_carac" value="Atrevido"> Atrevid@
        <input type="checkbox" name="registro_carac" value="Romantico"> Romántic@
     </fieldset>
     <br>
     <fieldset id="registro_gustos">
         <legend>¿Cuáles son tus gustos?</legend>
        <input type="checkbox" name="registro_gustos" value="Deportes"> Deportes
        <input type="checkbox" name="registro_gustos" value="Lectura"> Lectura
        <br>
        <input type="checkbox" name="registro_gustos" value="Cine"> Televisión
        <input type="checkbox" name="registro_gustos" value="Musica"> Música
        <br>
        <input type="checkbox" name="registro_gustos" value="OcioNoc"> Ocio nocturno
        <input type="checkbox" name="registro_gustos" value="Romantico"> Tecnología
     </fieldset>
     <br>
     <h5>Los campos marcados con * son obligatorios</h5>
     <br>
     <input type="submit" value="Terminar Registro">
     
</form>

<jsp:include page="/comun/pie.jsp"/>