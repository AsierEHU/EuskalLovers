
//Estructura de almacenaje

BDL = new BD(0);
BDS = new BD(1);

function BD(storageSelection) {

    var tipoStorage = ["localStorage", "sessionStorage"];

    this.storage = eval(tipoStorage[storageSelection]);

    //privados
    this.guardarEnJSON = function (prefijo, id, cadena) {
        this.storage.setItem(prefijo + "_" + id, JSON.parse(cadena));
    };

    this.cargarEnJSON = function (prefijo, id) {
        return this.storage.getItem(prefijo + "_" + id);
    };

    this.eliminarEnJSON = function (prefijo, id) {
        this.storage.removeItem(prefijo + "_" + id);
    };

    //publicos
    //funciones usuario
    this.guardarUsuario = function (nick, password, email, edad, altura, peso, genero, ciudad, cp, constitucion, foto) {
        var usuarioJSON = '{' + '"nick":"' + nick + '", "password":"' + password + '", "email":"' + email + '", "edad":"' + edad + '", altura":"' + altura + '", "peso":"' + peso + '", "genero":"' + genero + '", "ciudad":"' + ciudad + '", ' + '"cp":"' + cp + '", "constitucion":"' + constitucion + '", "foto":"' + foto + '"' + '}';
        this.guardarEnJSON("usuario", nick, usuarioJSON);
    };

    this.cargarUsuario = function (nick) {
        return this.cargarEnJSON("usuario", nick);
    };

    this.eliminarUsuariofunction = function (nick) {
        this.eliminarEnJSON("usuario", nick);
        this.eliminarEnJSON("aficiones", nick);
        this.eliminarEnJSON("caracteres", nick);
    };

    //funciones aficiones de usuario
    this.guardarAficionesUsuario = function (nick, aficiones) {
        var aficionesJSON = '[';
        for (var i = 0; i < aficiones.length; i++) {
            aficionesJSON += '{"nombre":"' + aficiones[i] + '"}';
            if (i !== aficiones.length - 1) {
                aficiones += ',';
            }
        }
        aficionesJSON += ']';
        this.guardarEnJSON("aficiones", nick, aficionesJSON);
    };

    this.cargarAficionesUsuario = function (nick) {
        return this.cargarEnJSON("aficiones", nick);
    };

    //funciones carácteres de usuario
    this.guardarCaracteresUsuario = function (nick, caracteres) {
        var caracteresJSON = '[';
        for (var i = 0; i < caracteres.length; i++) {
            caracteresJSON += '{"nombre":"' + caracteres[i] + '"}';
            if (i !== caracteres.length - 1) {
                caracteres += ',';
            }
        }
        caracteresJSON += ']';
        this.guardarEnJSON("caracteres", nick, caracteresJSON);
    };

    this.cargarCaracteresUsuario = function (nick) {
        return this.cargarEnJSON("caracteres", nick);
    };

    //funciones de login
    this.esUsuarioCorrecto = function (nick, password) {
        var usuarioJSON = cargarEnJSON("usuario", nick);
        if (usuarioJSON.password === password) {
            return true;
        } else {
            return false;
        }
    };
}

