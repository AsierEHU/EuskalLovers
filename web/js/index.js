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
};

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
 
window.addEventListener("load", addValidacionCampoFuncionTR, false);

function addValidacionCampoFuncionTR(id, funcionValidadora, funcionCorrecta, funcionIncorrecta) {
    var campo = document.getElementById(id);
    campo.addEventListener("keyup", function () {
        if (funcionValidadora()) {
            funcionCorrecta();
        } else {
            funcionIncorrecta();
        }
    });
    
 function funcionCorrecta(){
     
 }   
}
