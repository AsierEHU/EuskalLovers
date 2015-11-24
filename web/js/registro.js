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
        obtenerRadioButton("registro_genero"),
        obtenerListaDespegable("registro_ciudad"),
        document.getElementById("registro_cp").value,
        obtenerRadioButton("registro_const"),
        document.getElementById("registro_foto").style.backgroundImage);
        BDL.guardarAficionesUsuario(document.getElementById("registro_email").value,obtenerCheckbox("registro_gustos"));            
        BDL.guardarCaracteresUsuario(document.getElementById("registro_email").value,obtenerCheckbox("registro_carac"));
        event.preventDefault(); //El event.preventdefaul despues de hacer todas las pruebas eliminar
    },false);
       
});

function obtenerRadioButton(botonesName){
    var botones = document.getElementsByName(botonesName);
    for(i=0;i<botones.length;i++){
        if(botones[i].checked){
            return botones[i].value;
        }
    }
}

function obtenerListaDespegable(listaId){
    var lista= document.getElementById(listaId);
    var seleccionado = lista.selectedIndex;
    var opcionSelec = lista.options[seleccionado];
    return opcionSelec.value;
}

function obtenerCheckbox(checkName){
    var checkbox = document.getElementsByName(checkName);
    var devolver = [];
    var j=0;
    for(i=0;i<checkbox.length;i++){
        if(checkbox[i].checked){
           devolver[j]=checkbox[i].value;
           j++;
        }
        return devolver;
    }
    
}