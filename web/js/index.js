/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onclick=function(){
    document.getElementById("index_ENLACEINICIAR").addEventListener("click",ActivarIniciarSesion);
    document.getElementById("index_ENLACEINICIAR").addEventListener("click",DesactivarPrincipal);
    document.getElementById("index_ENLACEVOLVER").addEventListener("click",DesactivarIniciarSesion);
    document.getElementById("index_ENLACEVOLVER").addEventListener("click",ActivarPrincipal);
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
 
window.addEventListener("load", iniciar, false);

function iniciar() {
    document.getElementById("index_Submit").addEventListener("click",
            enviar, false);
    document.getElementById("index_infoSesion").addEventListener("input",
            controlar, false);
}

function enviar() {
    var valido = document.index_infoSesion.checkValidity();
}

function controlar(e) {
    var elemnt = document.getElementById("index_Email");
    if (e.target.validity.valid) {
        e.target.style.background = 'green';
    } else {
        e.target.style.background = 'red';
    }
}
