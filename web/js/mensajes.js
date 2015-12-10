window.addEventListener('load', function () {
    
    var nme = 0;
    var nmi = 0;
    
    AjaxMail.numeroMensajesRecibidosTiempo(5000,function(respuesta){
        if (nme<respuesta.cantidad){
            AjaxMail.recibirMensajesRecibidos(function(respuesta){
                var listaMensajes=respuesta.mensajes;
                for(;nme<listaMensajes.length;nme++){
                    nuevoMensaje(listaMensajes[nme].sender,listaMensajes[nme].mensaje,"mensajes_mensajesRecibidos");
                }
            });
            document.getElementById("mensajes_numMensajesEntrada").innerHTML="  ("+respuesta.cantidad+")";
        }
    });
    
    AjaxMail.recibirMensajesEnviados(function(respuesta){
        var listaMensajes=respuesta.mensajes;
        for(var i=0;i<listaMensajes.length;i++){
            nuevoMensaje(listaMensajes[i].receiver,listaMensajes[i].mensaje,"mensajes_mensajesEnviados");
        }
        nmi=listaMensajes.length;
        document.getElementById("mensajes_numMensajesSalida").innerHTML="  ("+nmi+")";
    });
    

    var form = document.getElementById("mensajes_form");
    form.addEventListener("submit", function (ev) {
        ev.preventDefault();
        nmi++;
        enviarMensaje(document.getElementById("mensajes_usuario").value,document.getElementById("mensajes_text").value, nmi);
    });

});

function enviarMensaje(usuario, text, nmi){
    
    AjaxMail.enviarMensaje(usuario,text,function(respuesta){});
    nuevoMensaje(usuario, text,"mensajes_mensajesEnviados");
    document.getElementById("mensajes_numMensajesSalida").innerHTML="  ("+nmi+")";
}

function nuevoMensaje(usuario, text, articuloId){
    var vis=document.getElementById(articuloId);
    var b=document.createElement("b");
    b.appendChild(document.createTextNode(usuario));
    var p=document.createElement("p");
    p.appendChild(document.createTextNode(text));
    var hr=document.createElement("hr");

    var div=document.createElement("div");
    div.className="mensajes_mensaje";
    div.appendChild(hr);
    div.appendChild(b);
    div.appendChild(p);
    vis.insertBefore(div,vis.getElementsByTagName("div")[0]);
}