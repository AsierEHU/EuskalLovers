

window.addEventListener('load', function(){
    
    //Ejemplo para dragAndDrop
    addDragAndDropImage("ejemplos_caja");
    FV.addValidarDragAndDrop("ejemplos_caja","ejemplos_form");
    
    //Ejemplo datos en sesion
    var datosUsuario=document.getElementById("ejemplos_usuario");

    BDL.guardarUsuario("Asieres", "password", "email@email.com", 45, 1.54, 56, 0, "ciudad", 01012, "constitucion", "foto");
    var usuario=BDL.cargarUsuario("email@email.com");
    datosUsuario.innerHTML+=usuario.nick+"<br>";

    BDL.guardarAficionesUsuario("email@email.com",["asd","asv"]);
    var aficiones=BDL.cargarAficionesUsuario("email@email.com");
    datosUsuario.innerHTML+=aficiones[1].nombre+"<br>";;

    BDL.guardarCaracteresUsuario("email@email.com",["asd","asv"]);
    var caracteres=BDL.cargarCaracteresUsuario("email@email.com");
    datosUsuario.innerHTML+=caracteres[1].nombre+"<br>";;

    datosUsuario.innerHTML+=BDL.esUsuarioCorrecto("email@email.com","password")+"<br>";

    BDL.guardarInteresesUsuario("email@email.com", 45, 1.54, 56, 0, "ciudad", 01012, "constitucion");
    var intereses=BDL.cargarInteresesUsuario("email@email.com");
    datosUsuario.innerHTML+=intereses.ciudad+"<br>";;

    //Ejemplo validacion
    FV.addValidarEmail("ejemplo_Email");
    FV.addValidarDNI("ejemplo_DNI","ejemplos_form");
}, false);


