
AjaxMail = new Ajax("localhost:8084/EuskalLovers/mail");

function Ajax(direccion) {

    //Privados

    function repetir(funcion, millis, enRespuesta) {
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

        xhttp.open("POST", direccion, true);
        xhttp.send(parametros);
    }

    //Publicos

    this.enviarMensaje = function (destinatario, mensaje, enRespuesta) {
        enviar(enRespuesta, "peticion=0&destinatario=" + destinatario + "&mensaje=" + mensaje);
    };

    this.recibirMensajesTiempo = function (millis, enRespuesta) {
        repetir(this.recibirMensajes, millis, enRespuesta);
    };

    this.recibirMensajes = function (enRespuesta) {
        enviar(enRespuesta, "peticion=1");
    };

    this.numeroMensajesTiempo = function (millis, enRespuesta) {
        repetir(this.numeroMensajes, millis, enRespuesta);
    };

    this.numeroMensajes = function (enRespuesta) {
        enviar(enRespuesta, "peticion=2");
    };
}

