// THE SCRIPT THAT CHECKS IF THE KEY PRESSED IS A NUMERIC OR DECIMAL VALUE.
function soloNumeroConPunto(evt, element) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if ((charCode != 46 || $(element).val().indexOf('.') != -1) &&      // “.” CHECK DOT, AND ONLY ONE.
        (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function soloTexto(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    var patron = /^[a-zñA-ZÑ]*$/;
    // En caso de querer validar cadenas con espacios usar: /^[a-zA-Z\s]*$/
    if(!tecla.search(patron))
        return true;
    else
        return false;
}

function soloTextoEspacio(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    var patron = /^[a-zñA-ZÑ\s]*$/;
    // En caso de querer validar cadenas con espacios usar: /^[a-zA-Z\s]*$/
    if(!tecla.search(patron))
        return true;
    else
        return false;
}

function mensajeExito(mensaje){
    var estructura = '<div class="alert alert-success" role="alert">'+
        '<span class="fa fa-check" aria-hidden="true"></span>'+mensaje+'</div>';
    return estructura;
}
function mensajeError(mensaje){
    var estructura = '<div class="alert alert-danger" role="alert">'+
        '<span class="fa fa-exclamation" aria-hidden="true"></span>'+mensaje+'</div>';
    return estructura;
}
function mensajeAdvertencia(mensaje){
    var estructura = '<div class="alert alert-warning" role="alert">'+
        '<span class="fa fa-warning" aria-hidden="true"></span>'+mensaje+'</div>';
    return estructura;
}
function mensajeInformacion(mensaje){
    var estructura = '<div class="alert alert-info" role="alert">'+
        '<span class="fa fa-info" aria-hidden="true"></span>'+mensaje+'</div>';
    return estructura;
}