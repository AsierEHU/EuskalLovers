/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function () {
//    addDragAndDropImage("registro_foto");
    FV.addValidarCP("registro_cp");
    FV.addValidarCP("cp_busqueda");
    FV.addValidarEmail("registro_email");
    FV.addValidarNick("registro_nick");
    FV.addValidarPassword("registro_password");
//    FV.addValidarDragAndDrop("registro_foto", "perfil_FORMULARIO");

    document.getElementById("registro_ENLACEVOLVER").addEventListener("click",function(){
        window.location = "index.jsp";
    },false);
    
}, false);
