
AjaxMail = new Ajax("mail");

function Ajax(direccion) {

    //Privados

    function repetir(funcion, millis, enRespuesta) {
        funcion(enRespuesta);
        bucle();
        function bucle() {
            setTimeout(function () {
                funcion(enRespuesta);
                bucle();
            }, millis);
        }
    }

    function enviar(enRespuesta, parametros) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var respuesta = JSON.parse(xhttp.responseText);
                enRespuesta(respuesta);
            }
        };

        xhttp.open("GET", direccion+"?"+parametros, true);
        xhttp.send();
    }

    //Publicos

    this.enviarMensaje = function (destinatario, mensaje, enRespuesta) {
        enviar(enRespuesta, "peticion=0&destinatario=" + destinatario + "&mensaje=" + mensaje);
    };

    /**/
    this.recibirMensajesEnviadosTiempo = function (millis, enRespuesta) {
        repetir(this.recibirMensajesEnviados, millis, enRespuesta);
    };

    this.recibirMensajesEnviados = function (enRespuesta) {
        enviar(enRespuesta, "peticion=1");
    };
   
    /**/
    this.recibirMensajesRecibidosTiempo = function (millis, enRespuesta) {
        repetir(this.recibirMensajesRecibidos, millis, enRespuesta);
    };

    this.recibirMensajesRecibidos = function (enRespuesta) {
        enviar(enRespuesta, "peticion=2");
    };

    /**/
    this.numeroMensajesRecibidosTiempo = function (millis, enRespuesta) {
        repetir(this.numeroMensajesRecibidos, millis, enRespuesta);
    };

    this.numeroMensajesRecibidos = function (enRespuesta) {
        enviar(enRespuesta, "peticion=3");
    };
}

