/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload=function(){
    document.getElementById("").addEventListener("click",ActivarIniciarSesion);
}

function ActivarIniciarSesion(){
        document.getElementById("index_INICIAR").style.display = "block";
    }
 
 function DesactivarPrincipal(){
     document.getElementById('index_SECTIONID').style.display ="none";
 }
 
 function DesactivarIniciarSesion(){
     document.getElementById("index_INICIAR").style.display ="none";
 }
     
 function ActivarPrincipal(){
     document.getElementById("index_SECTIONID").style.display ="block";
 }
