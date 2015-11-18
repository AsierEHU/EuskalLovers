
FV=new formValidator();

/**
 * Clase con distintos metodos de ayuda de validación de formularios
 * Solo aplica los patrones y funciones, no aplica el estilo.
 * El estilo se aplica en CSS3 (Ej: input:valid{})
 * @returns {formValidator}
 */
function formValidator() {

    //privados

    /**
     * Atraves del patron ya nos encargamos que HTML5 lo valide automaticamente
     * @param {String} id 
     * @param {String} expresion 
     * @returns {undefined}
     */
    function addValidacionExpress(id, expresion) {
        var campo = document.getElementById(id);
        campo.pattern=expresion;
    }
    
    /**
     * Para campos que no tienen patrones
     * @param {String} id
     * @param {function (Input)} funcion Function que devulve true
     * en caso de estar correcto el campo y false en caso contrario
     * @returns {undefined}
     */
    function addValidacionFuncion(id,funcion){
         var campo = document.getElementById(id);
         campo.addEventListener("input",function(){
            if(funcion(campo)){
                campo.validity="true";
            }else{
                campo.validity="false";
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
        addValidacionExpress(id, "^\\w+([/\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,4})+$");
    };
    
    /**
     * Añade una validacion a un campo de tipo dni
     * @param {String} id
     * @returns {undefined}
     */
    this.addValidarDNI = function(id) {
        addValidacionFuncion(id,function(campo){
            var dni=campo.value;
            var numero = dni.substr(0,dni.length-1);
            var let = dni.substr(dni.length-1,1);
            numero = numero % 23;
            var letra='TRWAGMYFPDXBNJZSQVHLCKET';
            letra=letra.substring(numero,numero+1);
            if (letra!==let){
                return false;
            }else{
                return true;
            }
        });
        //addValidacionExpress(id,"(\d{8})([-]?)([A-Z]{1})");
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
