BDL.guardarUsuario("nick", "password", "email", 45, 1.54, 56, 0, "ciudad", 01012, "constitucion", "foto");
var usuario=BDL.cargarUsuario("nick");
console.log(usuario.nick);

BDL.guardarAficionesUsuario("nick",["asd","asv"]);
var aficiones=BDL.cargarAficionesUsuario("nick");
console.log(aficiones[1].nombre);

BDL.guardarCaracteresUsuario("nick",["asd","asv"]);
var caracteres=BDL.cargarCaracteresUsuario("nick");
console.log(caracteres[1].nombre);

console.log(BDL.esUsuarioCorrecto("nick","password"));

BDL.guardarInteresesUsuario("nick", 45, 1.54, 56, 0, "ciudad", 01012, "constitucion");
var intereses=BDL.cargarInteresesUsuario("nick");
console.log(intereses.ciudad);