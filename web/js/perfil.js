/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function () {
    addDragAndDropImage("perfil_foto");
    FV.addValidarCP("perfil_cp");
    FV.addValidarCP("cp_busqueda");
    FV.addValidarEmail("perfil_email");
    FV.addValidarNick("perfil_nick");
    FV.addValidarPassword("perfil_password");
    FV.addValidarDragAndDrop("perfil_foto", "perfil_FORMULARIO");


    var emailUsuarioLoguado = BDL.getUsuarioLogueado();
    if(emailUsuarioLoguado!==null){
        var usuario = BDL.cargarUsuario(emailUsuarioLoguado);
        document.getElementById("perfil_nick").value=usuario.nick,
        document.getElementById("perfil_password").value=usuario.password,
        document.getElementById("perfil_email").value=usuario.email,
        document.getElementById("perfil_edad").value=usuario.edad,
        document.getElementById("perfil_altura").value=usuario.altura,
        document.getElementById("perfil_peso").value=usuario.peso,
        selectRadioButton("perfil_genero",usuario.genero),
        //selectListaDespegable("perfil_ciudad",usuario.ciudad),
        document.getElementById("perfil_cp").value=usuario.cp,
        selectRadioButton("perfil_const",usuario.constitucion),
        document.getElementById("perfil_foto").style.backgroundImage=usuario.foto;
    }




    var perfilUsuario = document.getElementById("perfil_FORMULARIO");

    perfilUsuario.addEventListener("submit", function () {
        BDL.guardarUsuario(document.getElementById("perfil_nick").value,
                document.getElementById("perfil_password").value,
                document.getElementById("perfil_email").value,
                document.getElementById("perfil_edad").value,
                document.getElementById("perfil_altura").value,
                document.getElementById("perfil_peso").value,
                obtenerRadioButton("perfil_genero"),
                obtenerListaDespegable("perfil_ciudad"),
                document.getElementById("perfil_cp").value,
                obtenerRadioButton("perfil_const"),
                document.getElementById("perfil_foto").style.backgroundImage);
        BDL.guardarAficionesUsuario(document.getElementById("perfil_email").value, obtenerCheckbox("perfil_gustos"));
        BDL.guardarCaracteresUsuario(document.getElementById("perfil_email").value, obtenerCheckbox("perfil_carac"));
    }, false);

    var interesesUsuario = document.getElementById("perfil_FORMULARIO");
    interesesUsuario.addEventListener("submit", function () {
        BDL.guardarInteresesUsuario(document.getElementById("perfil_email").value,
                document.getElementById("edad_busqueda").value,
                document.getElementById("altura_busqueda").value,
                document.getElementById("peso_busqueda").value,
                obtenerRadioButton("genero_busqueda"),
                obtenerListaDespegable("ciudad_busqueda"),
                document.getElementById("cp_busqueda").value,
                obtenerRadioButton("const_busqueda"));
    }, false);
    
    document.getElementById("perfil_ENLACEVOLVER").addEventListener("click",function(){
        window.location = "principal.jsp";
    },false);
    
}, false);

function obtenerRadioButton(botonesName) {
    var botones = document.getElementsByName(botonesName);
    for (i = 0; i < botones.length; i++) {
        if (botones[i].checked) {
            return botones[i].value;
        }
    }
}

function obtenerListaDespegable(listaId) {
    var lista = document.getElementById(listaId);
    var seleccionado = lista.selectedIndex;
    var opcionSelec = lista.options[seleccionado];
    return opcionSelec.value;
}

function obtenerCheckbox(checkName) {
    var checkbox = document.getElementsByName(checkName);
    var devolver = [];
    var j = 0;
    for (i = 0; i < checkbox.length; i++) {
        if (checkbox[i].checked) {
            devolver[j++] = checkbox[i].value;
        }
    }
    return devolver;
}

function selectRadioButton(botonesName, valor){
    var botones = document.getElementsByName(botonesName);
    for (i = 0; i < botones.length; i++) {
        if (botones[i].value===valor) {
            botones[i].checked=true;
            return;
        }
    }
}

function selectListaDespegable(listaId, valor) {
    var lista = document.getElementById(listaId);
   /* var seleccionado = lista.selectedIndex;
    var opcionSelec = lista.options[seleccionado];
    return opcionSelec.value;*/
}