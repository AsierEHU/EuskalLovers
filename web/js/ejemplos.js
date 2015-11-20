

window.addEventListener('load', function(){
    
    //Ejemplo para dragAndDrop
    addDragAndDropImage("ejemplos_caja");
    FV.addValidarDragAndDrop("ejemplos_caja","ejemplos_form");
    
    //Ejemplo datos en sesion
    var datosUsuario=document.getElementById("ejemplos_usuario");

    BDS.guardarUsuario("nick", "password", "email", 45, 1.54, 56, 0, "ciudad", 01012, "constitucion", "foto");
    var usuario=BDS.cargarUsuario("nick");
    datosUsuario.innerHTML+=usuario.nick+"<br>";

    BDS.guardarAficionesUsuario("nick",["asd","asv"]);
    var aficiones=BDS.cargarAficionesUsuario("nick");
    datosUsuario.innerHTML+=aficiones[1].nombre+"<br>";;

    BDS.guardarCaracteresUsuario("nick",["asd","asv"]);
    var caracteres=BDS.cargarCaracteresUsuario("nick");
    datosUsuario.innerHTML+=caracteres[1].nombre+"<br>";;

    datosUsuario.innerHTML+=BDS.esUsuarioCorrecto("nick","password")+"<br>";;

    BDS.guardarInteresesUsuario("nick", 45, 1.54, 56, 0, "ciudad", 01012, "constitucion");
    var intereses=BDS.cargarInteresesUsuario("nick");
    datosUsuario.innerHTML+=intereses.ciudad+"<br>";;

    //Ejemplo validacion
    FV.addValidarEmail("ejemplo_Email");
    FV.addValidarDNI("ejemplo_DNI","ejemplos_form");
}, false);


