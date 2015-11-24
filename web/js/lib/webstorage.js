
//Mejor usar BDS, puntuará más
BDL = new BD(0);
BDS = new BD(1);

/**
 * Clase que maneja el guardado de datos en local
 * @param {boolean} storageSelection 0=localStorage, 1=sessionStorage
 * @returns {BD}
 */
function BD(storageSelection) {

    var tipoStorage = ["localStorage", "sessionStorage"];
    var storage = eval(tipoStorage[storageSelection]);

    //privados

    /**
     * Guarda en el storage seleccionado
     * @param {String} prefijo
     * @param {String} id
     * @param {String} cadena
     * @returns {undefined}
     */

    function guardarEnBD(prefijo, id, cadena) {
        storage.setItem(prefijo + "_" + id, cadena);
    }

    /**
     * Carga en forma JSON del storage seleccionado
     * @param {String} prefijo
     * @param {String} id
     * @returns {JSON}
     */
    function cargarDeBD(prefijo, id) {
        return JSON.parse(storage.getItem(prefijo + "_" + id));
    }

    /**
     * Elimina el objeto seleccionado del storage seleccionado
     * @param {String} prefijo
     * @param {String} id
     * @returns {undefined}
     */
    function eliminarDeBD(prefijo, id) {
        storage.removeItem(prefijo + "_" + id);
    }

    /**
     * Convierte un array de strings a formato String JSON
     * @param {array String} arrayString
     * @returns {String}
     */
    function convertirArrayEnStringJSON(arrayString) {
        var arrayJSON = '[';
        for (var i = 0; i < arrayString.length; i++) {
            arrayJSON += '{"nombre":"' + arrayString[i] + '"}';
            if (i !== (arrayString.length - 1)) {
                arrayJSON += ',';
            }
        }
        arrayJSON += ']';
        return arrayJSON;
    }

    //publicos

    //funciones usuario

    /**
     * Guarda un usuario en local en formato JSON
     * @param {String} nick  
     * @param {String} password 
     * @param {String} email 
     * @param {int} edad 
     * @param {float} altura 
     * @param {int} peso 
     * @param {boolean} genero 
     * @param {String} ciudad 
     * @param {int} cp 
     * @param {String} constitucion 
     * @param {String} foto en base 64
     * @returns {undefined}
     */
    this.guardarUsuario = function (nick, password, email, edad, altura, peso, genero, ciudad, cp, constitucion, foto) {
        var usuarioStringJSON = '{' + '"nick":"' + nick + '","password":"' + password + '","email":"' + email + '","edad":"' + edad + '","altura":"' + altura + '","peso":"' + peso + '","genero":"' + genero + '","ciudad":"' + ciudad + '","cp":"' + cp + '","constitucion":"' + constitucion + '","foto":"' + foto + '"' + '}';
        guardarEnBD("usuario", email, usuarioStringJSON);
    };

    /**
     * Carga un usuario en formato JSON
     * @param {String} email
     * @returns {UsuarioJSON}
     */
    this.cargarUsuario = function (email) {
        return cargarDeBD("usuario", email);
    };

    /**
     * Elimina un usuario y todo lo asociado con él
     * @param {String} email
     * @returns {undefined}
     */
    this.eliminarUsuario = function (email) {
        eliminarDeBD("usuario", email);
        eliminarDeBD("aficiones", email);
        eliminarDeBD("caracteres", email);
        eliminarDeBD("intereses", email);
    };

    //funciones aficiones de usuario

    /**
     * Guarda el array de aficiones asociado al usuario
     * @param {String} email
     * @param {array Strings} aficiones
     * @returns {undefined}
     */
    this.guardarAficionesUsuario = function (email, aficiones) {
        var aficionesStringJSON = convertirArrayEnStringJSON(aficiones);
        guardarEnBD("aficiones", email, aficionesStringJSON);
    };

    /**
     * Carga las aficiones de un usuario
     * @param {String} email
     * @returns {AficionesJSON}
     */
    this.cargarAficionesUsuario = function (email) {
        return cargarDeBD("aficiones", email);
    };

    //funciones carácteres de usuario

    /**
     * Guarda los carácteres de un usuario
     * @param {String} email
     * @param {array Strings} caracteres
     * @returns {undefined}
     */
    this.guardarCaracteresUsuario = function (email, caracteres) {
        var caracteresStringJSON = convertirArrayEnStringJSON(caracteres);
        guardarEnBD("caracteres", email, caracteresStringJSON);
    };

    /**
     * Carga los carácteres de un usuario
     * @param {String} email
     * @returns {CaracteresJSON}
     */
    this.cargarCaracteresUsuario = function (email) {
        return cargarDeBD("caracteres", email);
    };

    //funciones intereses usuario

    /**
     * Guarda las aficiones en local en formato JSON
     * @param {String} email 
     * @param {int} edad 
     * @param {float} altura 
     * @param {int} peso 
     * @param {boolean} genero 
     * @param {String} ciudad 
     * @param {int} cp 
     * @param {String} constitucion 
     * @returns {undefined}
     */
    this.guardarInteresesUsuario = function (email, edad, altura, peso, genero, ciudad, cp, constitucion) {
        var aficionStringJSON = '{' + '"edad":"' + edad + '","altura":"' + altura + '","peso":"' + peso + '","genero":"' + genero + '","ciudad":"' + ciudad + '","cp":"' + cp + '","constitucion":"' + constitucion + '"' + '}';
        guardarEnBD("intereses", email, aficionStringJSON);
    };

    /**
     * 
     * @param {String} email
     * @returns {InteresesJSON}
     */
    this.cargarInteresesUsuario = function (email) {
        return cargarDeBD("intereses", email);
    };

    //funciones de login

    /**
     * Comprueba si un usuario es correcto y si es correcto lo loguea
     * @param {String} email
     * @param {String} password
     * @returns {Boolean}
     */
    this.esUsuarioCorrecto = function (email, password) {
        var usuarioJSON = cargarDeBD("usuario", email);
        if (usuarioJSON !== null && usuarioJSON.password === password) {
            guardarEnBD("login", "usuario", '{' + '"email":"' + email + '"' + '}');
            return true;
        } else {
            return false;
        }
    };
    
    /**
     * Devuelve el usuario que se ha autentificado por ultima vez con la funcion
     * esUsuarioCorrecto();
     * @returns {String}
     */
    this.getUsuarioLogueado = function(){
        var usuarioLogueado=cargarDeBD("login","usuario");
        if(usuarioLogueado!==null){
            return usuarioLogueado.email;
        }else{
            return null;
        }
        
    };
}

