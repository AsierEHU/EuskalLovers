function addValidacionCampoExpresionTR(id, expresion, funcionCorrecta, funcionIncorrecta) {
    var campo = document.getElementById(id);
    campo.addEventListener("keydown", function () {
        if (expresion.test(campo.value)) {
            funcionCorrecta();
        } else {
            funcionIncorrecta();
        }
    });
}

function addValidacionCampoFuncionTR(id, funcionValidadora, funcionCorrecta, funcionIncorrecta) {
    var campo = document.getElementById(id);
    campo.addEventListener("keydown", function () {
        if (funcionValidadora()) {
            funcionCorrecta();
        } else {
            funcionIncorrecta();
        }
    });
}

function addDragAndDrop(id) {
    var caja = document.getElementById(id);
    caja.addEventListener('dragover', permitirDrop, false);
    caja.addEventListener('drop', drop, false);

    function drop(ev){
        ev.preventDefault();
        var arch = new FileReader();
        arch.addEventListener('load', leer, false);
        arch.readAsDataURL(ev.dataTransfer.files[0]);
    }

    function permitirDrop(ev){
        ev.preventDefault();
    }

    function leer(ev) {
        caja.style.backgroundImage = "url('" + ev.target.result + "')";
    }
}