/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function () {
    addDragAndDropImage("registro_foto");
    FV.addValidarCP("registro_cp");
    FV.addValidarCP("cp_busqueda");
    FV.addValidarEmail("registro_email");
    FV.addValidarNick("registro_nick");
    FV.addValidarPassword("registro_password");
    FV.addValidarDragAndDrop("registro_foto", "registro_FORMULARIO");

//    var registroUsuario = document.getElementById("registro_FORMULARIO");
//
//    registroUsuario.addEventListener("submit", function () {
//        WS.guardarUsuario(document.getElementById("registro_nick").value,
//                document.getElementById("registro_password").value,
//                document.getElementById("registro_email").value,
//                document.getElementById("registro_edad").value,
//                document.getElementById("registro_altura").value,
//                document.getElementById("registro_peso").value,
//                obtenerRadioButton("registro_genero"),
//                obtenerListaDespegable("registro_ciudad"),
//                document.getElementById("registro_cp").value,
//                obtenerRadioButton("registro_const"),
//                document.getElementById("registro_foto").style.backgroundImage);
//        WS.guardarAficionesUsuario(document.getElementById("registro_email").value, obtenerCheckbox("registro_gustos"));
//        WS.guardarCaracteresUsuario(document.getElementById("registro_email").value, obtenerCheckbox("registro_carac"));
   }, false);
//
//    var interesesUsuario = document.getElementById("registro_FORMULARIO");
//    interesesUsuario.addEventListener("submit", function () {
//        WS.guardarInteresesUsuario(document.getElementById("registro_email").value,
//                document.getElementById("edad_busqueda").value,
//                document.getElementById("altura_busqueda").value,
//                document.getElementById("peso_busqueda").value,
//                obtenerRadioButton("genero_busqueda"),
//                obtenerListaDespegable("ciudad_busqueda"),
//                document.getElementById("cp_busqueda").value,
//                obtenerRadioButton("const_busqueda"));
//    }, false);
//    
//    document.getElementById("registro_ENLACEVOLVER").addEventListener("click",function(){
//        window.location = "index.jsp";
//    },false);
//    
//}, false);
//
//function obtenerRadioButton(botonesName) {
//    var botones = document.getElementsByName(botonesName);
//    for (i = 0; i < botones.length; i++) {
//        if (botones[i].checked) {
//            return botones[i].value;
//        }
//    }
//}
//
//function obtenerListaDespegable(listaId) {
//    var lista = document.getElementById(listaId);
//    var seleccionado = lista.selectedIndex;
//    var opcionSelec = lista.options[seleccionado];
//    return opcionSelec.value;
//}
//
//function obtenerCheckbox(checkName) {
//    var checkbox = document.getElementsByName(checkName);
//    var devolver = [];
//    var j = 0;
//    for (i = 0; i < checkbox.length; i++) {
//        if (checkbox[i].checked) {
//            devolver[j++] = checkbox[i].value;
//        }
//    }
//    return devolver;
