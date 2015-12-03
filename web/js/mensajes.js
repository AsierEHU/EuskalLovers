window.addEventListener('load', function () {
    AjaxMail.numeroMensajesTiempo(5000,function(respuesta){
        document.getElementById("numMensajes").innerHTML=respuesta.cantidad;
    });
});