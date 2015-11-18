function validaForm() {

    //privados

    function addValidacionTR(id, expresion) {
        var campo = document.getElementById(id);
        campo.addEventListener("input", function () {
            if (expresion.test(campo.value)) {
                funcionCorrecta(campo);
            } else {
                funcionIncorrecta(campo);
            }
        });
    }

    function funcionCorrecta(campo) {
        campo.style.borderColor = "green";
    }

    function funcionIncorrecta(campo) {
        campo.style.borderColor = "red";
    }

    /**
     * 
     * @param {type} id
     * @returns {undefined}
     */
    this.addValidarEmail = function (id) {
        addValidacionTR(id, /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/);
    };

    /**
     * Añade la función drag and drop a un div para una imagen
     * @param {String} id El identificador de un DIV
     * @returns {undefined}
     */
    this.addDragAndDropImage = function(id) {
        var caja = document.getElementById(id);
        caja.style.backgroundRepeat = "no-repeat";
        caja.style.backgroundSize = "cover";
        caja.style.backgroundPosition = "center";
        caja.addEventListener('dragover', permitirDrop, false);
        caja.addEventListener('drop', drop, false);

        function drop(ev) {
            ev.preventDefault();
            var arch = new FileReader();
            arch.addEventListener('load', leer, false);
            arch.readAsDataURL(ev.dataTransfer.files[0]);
        }

        function permitirDrop(ev) {
            ev.preventDefault();
        }

        function leer(ev) {
            caja.style.backgroundImage = "url('" + ev.target.result + "')";
        }
    };
}

