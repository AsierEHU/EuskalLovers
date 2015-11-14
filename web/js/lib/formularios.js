function addValidacionCampoExpresionTR(id, expresion, funcionCorrecta, funcionIncorrecta) {
    var campo = document.getElementById(id);
    campo.addEventListener("keydown", function () {
        if (expresion.test(campo.value)) {
            funcionCorrecta();
        }else{
            funcionIncorrecta();
        }
    });
}

function addValidacionCampoFuncionTR(id, funcionValidadora, funcionCorrecta, funcionIncorrecta) {
    var campo = document.getElementById(id);
    campo.addEventListener("keydown", function () {
        if (funcionValidadora()) {
            funcionCorrecta();
        }else{
            funcionIncorrecta();
        }
    });
}