

window.addEventListener('load', function(){
    
    //Ejemplo para dragAndDrop
    addDragAndDropImage("ejemplos_caja");
    FV.addValidarDragAndDrop("ejemplos_caja","ejemplos_form");
    
    //Ejemplo datos en sesion
    var datosUsuario=document.getElementById("ejemplos_usuario");

    BDS.guardarUsuario("Asieres", "password", "email@email.com", 45, 1.54, 56, 0, "ciudad", 01012, "constitucion", "foto");
    var usuario=BDS.cargarUsuario("email@email.com");
    datosUsuario.innerHTML+=usuario.nick+"<br>";

    BDS.guardarAficionesUsuario("email@email.com",["asd","asv"]);
    var aficiones=BDS.cargarAficionesUsuario("email@email.com");
    datosUsuario.innerHTML+=aficiones[1].nombre+"<br>";;

    BDS.guardarCaracteresUsuario("email@email.com",["asd","asv"]);
    var caracteres=BDS.cargarCaracteresUsuario("email@email.com");
    datosUsuario.innerHTML+=caracteres[1].nombre+"<br>";;

    datosUsuario.innerHTML+=BDS.esUsuarioCorrecto("email@email.com","password")+"<br>";;

    BDS.guardarInteresesUsuario("email@email.com", 45, 1.54, 56, 0, "ciudad", 01012, "constitucion");
    var intereses=BDS.cargarInteresesUsuario("email@email.com");
    datosUsuario.innerHTML+=intereses.ciudad+"<br>";;

    //Ejemplo validacion
    FV.addValidarEmail("ejemplo_Email");
    FV.addValidarDNI("ejemplo_DNI","ejemplos_form");
}, false);


