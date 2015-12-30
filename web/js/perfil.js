/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function () {
//    addDragAndDropImage("perfil_foto");
    FV.addValidarCP("perfil_cp");
    FV.addValidarCP("cp_busqueda");
    FV.addValidarNick("perfil_nick");
    FV.addValidarPassword("perfil_password");
//    FV.addValidarDragAndDrop("perfil_foto", "registro_FORMULARIO");

    document.getElementById("perfil_ENLACEVOLVER").addEventListener("click", function () {
        window.location = "principal.jsp";
    }, false);

}, false);
