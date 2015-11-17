<jsp:include page="/comun/cabeza.jsp">
    <jsp:param name="title" value="Regístrate en EuskalLovers"/>
    <jsp:param name="include" value="registro"/>
</jsp:include>
<h1> ¡Regístrate en Euskal Lovers! </h1>
<form class="registro_FORMULARIO">
    
     Nombre de usuario: <input type="text" name="registro_nick" required autofocus >
    <br />
    Contraseña:  <input type="password" name="registro_password" required >
     <br />
     Email: <input type="email" name="registro_email" required placeholder="ejemplo@ejemplo.com" required>
    <br />
     <form>
         Género: <br> <input type="radio" name="registro_genero" value="Masculino" checked required > Masculino
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


<jsp:include page="/comun/pie.jsp"/>