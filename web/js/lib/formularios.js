
FV = new formValidator();

/**
 * Clase con distintos metodos de ayuda de validación de formularios
 * Solo aplica los patrones y funciones, no aplica el estilo.
 * El estilo se aplica en CSS3 (Ej: input:valid{})
 * @returns {formValidator}
 */
function formValidator() {

    //privados

    /**
     * A través del patron ya nos encargamos que HTML5 lo valide automaticamente
     * @param {String} id 
     * @param {String} expresion 
     * @returns {undefined}
     */
    function addValidacionExpress(id, expresion) {
        var campo = document.getElementById(id);
        campo.pattern = expresion;
    }

    /**
     * No funciona correctamente
     * Para campos que no tienen patrones 
     * @param {String} idCampo
     * @param {String} idForm
     * @param {function (Input)} funcion Function que devulve true
     * en caso de estar correcto el campo y false en caso contrario
     * @returns {undefined}
     */
    function addValidacionFuncion(idCampo, idForm, funcion) {
        var campo = document.getElementById(idCampo);
        campo.addEventListener("input", function () {
            if(campo.value===""){
                campo.style.borderColor = "inherit";
                campo.style.backgroundColor = "inherit";
            }else{
                if (funcion(campo)) {
                    campo.style.borderColor = "green";
                    campo.style.backgroundColor = "inherit";
                } else {
                    campo.style.borderColor = "red";
                    campo.style.backgroundColor = "coral";
                }
            }
        });
        var form = document.getElementById(idForm);
        form.addEventListener("submit", function (ev) {
            if (!funcion(campo)) {
                ev.preventDefault();
                alert("no se puede enviar");
            }
        });
    }

    //publicos

    /**
     * Añade una validacion en linea a un campo de tipo email
     * @param {String} id Id del imput Email
     * @returns {undefined}
     */
    this.addValidarEmail = function (id) {
        addValidacionExpress(id, "^\\w+([/\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,4})+$");
    };

    /**
     * Añade una validacion en linea a un campo de Codigo Postal
     * @param {String} id
     * @returns {undefined}
     */
    this.addValidarCP = function (id) {
        addValidacionExpress(id, "^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$");
    };

    /**
     * Añade una validacion en linea a un campo de teléfono
     * @param {String} id
     * @returns {undefined}
     */
    this.addValidarTelf = function (id) {
        addValidacionExpress(id, "^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$");
    };

    /**
     * Añade una validacion en linea a un campo de Tarjeta de crédito
     * @param {String} id
     * @returns {undefined}
     */
    this.addValidarCreditCard = function (id) {
        addValidacionExpress(id, "^((67\\d{2})|(4\\d{3})|(5[1-5]\\d{2})|(6011))(-?\\s?\\d{4}){3}|(3[4,7])\\ d{2}-?\\s?\\d{6}-?\\s?\\d{5}$");
    };

    /**
     * Añade una validacion en linea a un campo de URL
     * @param {String} id
     * @returns {undefined}
     */
    this.addValidarUrl = function (id) {
        addValidacionExpress(id, "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\?=.-]*)*\\/?$");
    };

    /**
     * Añade una validacion en linea a un campo de password para
     * verificar su fortaleza
     * @param {String} id
     * @returns {undefined}
     */
    this.addValidarPassword = function (id) {
        addValidacionExpress(id, "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
    };

    /**
     * Añade una validacion en linea a un campo de nombre de usuario
     * @param {String} id
     * @returns {undefined}
     */
    this.addValidarNick = function (id) {
        addValidacionExpress(id, "^[a-z\\d_]{4,15}$");
    };

    /**
     * No funciona correctamente
     * Añade una validacion a un campo de tipo dni 
     * @param {String} idCampo
     * @param {String} idForm
     * @returns {undefined}
     */
    this.addValidarDNI = function (idCampo, idForm) {
        addValidacionFuncion(idCampo, idForm, function (campo) {
            var dni = campo.value;
            var numero = dni.substr(0, dni.length - 1);
            var let = dni.substr(dni.length - 1, 1);
            numero = numero % 23;
            var letra = 'TRWAGMYFPDXBNJZSQVHLCKET';
            letra = letra.substring(numero, numero + 1);
            if (letra !== let) {
                return false;
            } else {
                return true;
            }
        });
        //addValidacionExpress(id,"(\d{8})([-]?)([A-Z]{1})");
    };
    
    /**
     * No funciona correctamente
     * Añade una validacion a un campo div con drag and drop
     * @param {type} idCampo
     * @param {type} idForm
     * @returns {undefined}
     */
    this.addValidarDragAndDrop = function (idCampo, idForm) {
        addValidacionFuncion(idCampo, idForm, function (campo) {
            var backg = campo.style.backgroundImage;
            if (backg === "") {
                return false;
            } else {
                return true;
            }
        });
    };
}

/**
 * Añade la función drag and drop a un div para una imagen
 * @param {String} id El identificador de un DIV
 * @returns {undefined}
 */
function addDragAndDropImage(id) {
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
}
;
