/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Cosas que faltan:
        En guardar usuario faltan añadir la ciudad(que hay que recoger los datos de una lista desplegable,
        miré código en internet para guiarme pero no lo entiendo)y la foto.
        Además hice una funcion para obtener el valor de un radio button. Mira a ver si esta bien
        
        En guardarAficionesUsuario y guardarCaracteresUsuario falta guardar los datos como tal 
        (no conseguí entender como usar el array).
                
        Por último queda guardar las preferencias de busqueda basicas pero no se donde hay que guardarlas.
        (Si es que hay que guardarlas).

*/

window.addEventListener('load', function(){
    addDragAndDropImage("registro_foto");
    FV.addValidarCP("registro_cp");
    FV.addValidarEmail("registro_email");
    FV.addValidarNick("registro_nick");
    FV.addValidarPassword("registro_password");
    FV.addValidarDragAndDrop("registro_foto","registro_FORMULARIO");
    
    var registroUsuario=document.getElementById("registro_FORMULARIO");
    
    registroUsuario.addEventListener("submit",function(event){
        BDL.guardarUsuario(document.getElementById("registro_nick").value,
        document.getElementById("registro_password").value,
        document.getElementById("registro_email").value,
        document.getElementById("registro_edad").value,
        document.getElementById("registro_altura").value,
        document.getElementById("registro_peso").value,
        document.obtenerRadioButton("registro_genero"),
        /*ciudad*/
        document.getElementById("registro_cp").value,
        document.obtenerRadioButton("registro_const")
        /*foto*/);
        BDL.guardarAficionesUsuario(document.getElementById("registro_email").value
                /*array aficiones*/);
        BDL.guardarCaracteresUsuario(document.getElementById("registro_email").value
                /*array caracteres*/);
                event.preventDefault();
    },false);
       
});

function obtenerRadioButton(botones){
    for(i=0;i<botones.length;i++){
        if(botones[i].checked){
            return botones[i].value;
        }
    }
}