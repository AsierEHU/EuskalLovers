<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Reg�strate en EuskalLovers"/>
    <jsp:param name="include" value="registro"/>
</jsp:include>
<h1> �Reg�strate en Euskal Lovers! </h1>
<form class="registro_FORMULARIO">
    
     Nombre de usuario: <input type="text" name="registro_nick" required autofocus >
    <br />
    Contrase�a:  <input type="password" name="registro_password" required >
     <br />
     Email: <input type="email" name="registro_email" required placeholder="ejemplo@ejemplo.com" required>
    <br />
     <form>
         G�nero: <br> <input type="radio" name="registro_genero" value="Masculino" checked required > Masculino
                  <input type="radio" name="registro_genero" value="Femenino" > Femenino
     </form>
     Ciudad
     <select name="registro_ciudad" required>
         <option value="Vitoria-Gasteiz">Vitoria-Gasteiz</option>
         <option value="Bilbao">Bilbao</option>
         <option value="San Sebastian">San Sebastian</option>
     </select>
     <br />
     Edad:  <input type="number" name="registro_edad" min="18" max="100" required="">
     <br />
     <fieldset id="registro_caracteristicas">
         <legend>�C�mo eres?</legend>
         <form>
        <input type="checkbox" name="registro_carac" value="Simpatico"> Simp�tico
        <input type="checkbox" name="registro_carac" value="Divertido"> Divertido
        <br>
        <input type="checkbox" name="registro_carac" value="Generoso"> Alegre
        <input type="checkbox" name="registro_carac" value="Alegre"> Generoso
        <br>
        <input type="checkbox" name="registro_carac" value="Atrevido"> Atrevido
        <input type="checkbox" name="registro_carac" value="Romantico"> Romantico
</form>
     </fieldset>
     <br />
     <fieldset id="registro_gustos">
         <legend>�Cu�les son tus gustos?</legend>
         <form>
        <input type="checkbox" name="registro_gustos" value="Deportes"> Deportes
        <input type="checkbox" name="registro_gustos" value="Lectura"> Lectura
        <br>
        <input type="checkbox" name="registro_gustos" value="Cine"> Televisi�n
        <input type="checkbox" name="registro_gustos" value="Musica"> M�sica
        <br>
        <input type="checkbox" name="registro_gustos" value="OcioNoc"> Ocio nocturno
        <input type="checkbox" name="registro_gustos" value="Romantico"> Tecnolog�a
</form>
     </fieldset>
     
     Faltan CP, Constituci�n, altura peso y foto
</form>

<jsp:include page="/comun/pie.jsp"/>