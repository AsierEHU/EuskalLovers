/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load",function(){
    document.getElementById("index_ENLACEINICIAR").addEventListener("click",ActivarIniciarSesion);
    document.getElementById("index_ENLACEINICIAR").addEventListener("click",DesactivarPrincipal);
    document.getElementById("index_ENLACEVOLVER").addEventListener("click",DesactivarIniciarSesion);
    document.getElementById("index_ENLACEVOLVER").addEventListener("click",ActivarPrincipal);
    FV.addValidarEmail("index_Email");
    
     var datosUsuario = document.getElementById("index_infoSesion");
     datosUsuario.addEventListener("submit",function(event){
         if(!BDS.esUsuarioCorrecto(document.getElementById("index_Email").value,document.getElementById("index_Contraseña").value)){
             event.preventDefault();
             alert("Email o contraseña de inicio incorrectas");
         }
     
 }, false);
 
    
});


function ActivarIniciarSesion(){
        document.getElementById("index_infoSesion").style.display = "block";
    }
 function DesactivarPrincipal(){
     document.getElementById('index_TABLA').style.display ="none";
 }
 function DesactivarIniciarSesion(){
     document.getElementById("index_infoSesion").style.display ="none";
 }  
 function ActivarPrincipal(){
     document.getElementById("index_TABLA").style.display ="table";
 }
 

