
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

    function guardarEnBD(prefijo, id, cadena) {
        storage.setItem(prefijo + "_" + id, cadena);
    }

    function cargarDeBD(prefijo, id) {
        return JSON.parse(storage.getItem(prefijo + "_" + id));
    }

    function eliminarDeBD(prefijo, id) {
        storage.removeItem(prefijo + "_" + id);
    }

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
        var usuarioStringJSON = '{' + '"nick":"' + nick + '","password":"' + password + '","email":"' + email + '","edad":' + edad + ',"altura":' + altura + ',"peso":' + peso + ',"genero":' + genero + ',"ciudad":"' + ciudad + '","cp":' + cp + ',"constitucion":"' + constitucion + '","foto":"' + foto + '"' + '}';
        guardarEnBD("usuario", nick, usuarioStringJSON);
    };

    /**
     * Carga un usuario en formato JSON
     * @param {String} nick
     * @returns {UsuarioJSON}
     */
    this.cargarUsuario = function (nick) {
        return cargarDeBD("usuario", nick);
    };

    /**
     * Elimina un usuario y todo lo asociado con él
     * @param {String} nick
     * @returns {undefined}
     */
    this.eliminarUsuario = function (nick) {
        eliminarDeBD("usuario", nick);
        eliminarDeBD("aficiones", nick);
        eliminarDeBD("caracteres", nick);
        eliminarDeBD("intereses", nick);
    };

    //funciones aficiones de usuario

    /**
     * Guarda el array de aficiones asociado al usuario
     * @param {String} nick
     * @param {array Strings} aficiones
     * @returns {undefined}
     */
    this.guardarAficionesUsuario = function (nick, aficiones) {
        var aficionesStringJSON = convertirArrayEnStringJSON(aficiones);
        guardarEnBD("aficiones", nick, aficionesStringJSON);
    };

    /**
     * Carga las aficiones de un usuario
     * @param {String} nick
     * @returns {AficionesJSON}
     */
    this.cargarAficionesUsuario = function (nick) {
        return cargarDeBD("aficiones", nick);
    };

    //funciones carácteres de usuario

    /**
     * Guarda los carácteres de un usuario
     * @param {String} nick
     * @param {array Strings} caracteres
     * @returns {undefined}
     */
    this.guardarCaracteresUsuario = function (nick, caracteres) {
        var caracteresStringJSON = convertirArrayEnStringJSON(caracteres);
        guardarEnBD("caracteres", nick, caracteresStringJSON);
    };

    /**
     * Carga los carácteres de un usuario
     * @param {String} nick
     * @returns {CaracteresJSON}
     */
    this.cargarCaracteresUsuario = function (nick) {
        return cargarDeBD("caracteres", nick);
    };

    //funciones intereses usuario
    
    /**
     * Guarda las aficiones en local en formato JSON
     * @param {String} nick 
     * @param {int} edad 
     * @param {float} altura 
     * @param {int} peso 
     * @param {boolean} genero 
     * @param {String} ciudad 
     * @param {int} cp 
     * @param {String} constitucion 
     * @returns {undefined}
     */
    this.guardarInteresesUsuario = function (nick, edad, altura, peso, genero, ciudad, cp, constitucion) {
        var aficionStringJSON = '{' + '"edad":' + edad + ',"altura":' + altura + ',"peso":' + peso + ',"genero":' + genero + ',"ciudad":"' + ciudad + '","cp":' + cp + ',"constitucion":"' + constitucion + '"' + '}';
        guardarEnBD("intereses", nick, aficionStringJSON);
    };
    
    /**
     * 
     * @param {String} nick
     * @returns {InteresesJSON}
     */
    this.cargarInteresesUsuario = function (nick) {
        return cargarDeBD("intereses", nick);
    };

    //funciones de login

    /**
     * Comprueba si un usuario es correcto
     * @param {String} nick
     * @param {String} password
     * @returns {Boolean}
     */
    this.esUsuarioCorrecto = function (nick, password) {
        var usuarioJSON = cargarDeBD("usuario", nick);
        if (usuarioJSON.password === password) {
            return true;
        } else {
            return false;
        }
    };
}

