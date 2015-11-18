
FV=new formValidator(
        function(campo){
            campo.style.borderColor = "green";
        },
        function(campo){
            campo.style.borderColor = "red";
        }
);

/**
 * Clase con distintos metodos de ayuda de validación de formularios
 * @param {function(campo)} funcionCorrecta
 * @param {function(campo)} funcionIncorrecta
 * @returns {formValidator}
 */
function formValidator(funcionCorrecta, funcionIncorrecta) {

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

    //publicos

    /**
     * Añade una validacion en linea a un campo de tipo email
     * @param {type} id Id del imput Email
     * @returns {undefined}
     */
    this.addValidarEmail = function (id) {
        addValidacionTR(id, /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/);
    };
}

/**
 * Añade la función drag and drop a un div para una imagen
 * @param {String} id El identificador de un DIV
 * @returns {undefined}
 */
function addDragAndDropImage (id) {
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
