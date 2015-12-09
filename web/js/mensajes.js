window.addEventListener('load', function () {
    
    var numMensajes = 0;
    
    AjaxMail.numeroMensajesRecibidosTiempo(5000,function(respuesta){
        document.getElementById("numMensajes").innerHTML="Mensajes recibidos: "+respuesta.cantidad;
        if (numMensajes<respuesta.cantidad){
            AjaxMail.recibirMensajesRecibidos(function(respuesta){
                var listaMensajes=respuesta.mensajes;
                var vis=document.getElementById("mensajesRecibidos");
                vis.innerHTML="";
                for(var i=0;i<listaMensajes.length;i++){
                    vis.innerHTML+="<p>Enviador: "+listaMensajes[i].sender+"</p><br>";
                    vis.innerHTML+="<p>Texto: "+listaMensajes[i].mensaje+"</p><br>";
                    vis.innerHTML+="<br>";
                }
            });
        }
    });
    
    AjaxMail.recibirMensajesEnviados(function(respuesta){
        var listaMensajes=respuesta.mensajes;
        var vis=document.getElementById("mensajesEnviados");
        vis.innerHTML="";
        for(var i=0;i<listaMensajes.length;i++){
            vis.innerHTML+="<p>Destinatario: "+listaMensajes[i].receiver+"</p><br>";
            vis.innerHTML+="<p>Texto: "+listaMensajes[i].mensaje+"</p><br>";
            vis.innerHTML+="<br>";
        }
    });
    

});