
//Estructura de almacenaje
var tipoStorage=["localStorage","sessionStorage"];
var seleccionStorage=0;

function guardarEnJSON(prefijo,id,cadena){
    eval(tipoStorage[seleccionStorage]+'.setItem("'+prefijo+'_'+id+'", JSON.parse('+cadena+'))');
}

function cargarEnJSON(prefijo, id){
    return eval(tipoStorage[seleccionStorage]+'.getItem("'+prefijo+'_'+id+'")');
}

function eliminarEnJSON(prefijo, id){
    eval(tipoStorage[seleccionStorage]+'.removeItem("'+prefijo+'_'+id+'")');
}

//funciones usuario
function guardarUsuario(nick, password, email, edad, altura, peso, genero, ciudad, cp, constitucion, foto) {
    var usuarioJSON = '{' + '"nick":"' + nick + '", "password":"' + password + '", "email":"' + email + '", "edad":"' + edad + '", altura":"' + altura + '", "peso":"' + peso + '", "genero":"' + genero + '", "ciudad":"' + ciudad + '", ' + '"cp":"' + cp + '", "constitucion":"' + constitucion + '", "foto":"' + foto + '"' + '}';
    guardarEnJSON("usuario",nick,usuarioJSON);
}

function cargarUsuario(nick) {
    return cargarEnJSON("usuario",nick);
}

function eliminarUsuario(nick){
    eliminarEnJSON("usuario",nick);
    eliminarEnJSON("aficiones",nick);
    eliminarEnJSON("caracteres",nick);
}

//funciones aficiones de usuario
function guardarAficionesUsuario(nick, aficiones) {
    var aficionesJSON = '[';
    for (var i = 0; i < aficiones.length; i++) {
        aficionesJSON += '{"nombre":"' + aficiones[i] + '"}';
        if (i !== aficiones.length - 1) {
            aficiones += ',';
        }
    }
    aficionesJSON += ']';
    guardarEnJSON("aficiones",nick,aficionesJSON);
}

function cargarAficionesUsuario(nick) {
    return cargarEnJSON("aficiones",nick);
}

//funciones carácteres de usuario
function guardarCaracteresUsuario(nick, caracteres) {
    var caracteresJSON = '[';
    for (var i = 0; i < caracteres.length; i++) {
        caracteresJSON += '{"nombre":"' + caracteres[i] + '"}';
        if (i !== caracteres.length - 1) {
            caracteres += ',';
        }
    }
    caracteresJSON += ']';
    guardarEnJSON("caracteres",nick,caracteresJSON);
}

function cargarCaracteresUsuario(nick) {
    return cargarEnJSON("caracteres",nick);
}

//funciones de login
function esUsuarioCorrecto(nick, password) {
    var usuarioJSON = cargarEnJSON("usuario",nick);
    if(usuarioJSON.password === password){
        return true;
    }else{
        return false;
    }
}