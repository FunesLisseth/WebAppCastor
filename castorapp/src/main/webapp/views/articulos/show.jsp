<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-title">
    <h3 class="main-title">Mantenimiento de Art&iacute;culos</h3>
</div>
<div class="inner-content">
    <div class="panel theme-panel">
        <div class="panel-heading" id="titulo">
            <span class="panel-title">
                Listado de Registros
            </span>
            <div class="center-block" style="float:right;" >
                <button id="btnAbrirModalNuevo" type="button" class="btn btn-primary btn-sm"
                        data-toggle="modal" data-target="#formModal"
                        style="margin-top: -5px;display: initial;"
                        data-whatever="@getbootstrap">
                    Nuevo
                </button>
            </div>
        </div>
        <div class="panel-body">
            <div class="clearfix">
                <div id="result" class="table-responsive">
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="formModal" tabindex="-1" role="dialog"
     aria-labelledby="formModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="formModalLabel">Title</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" id="idArticulo" />
                    <div class="row">
                        <fieldset class="form-group col-xs-6">
                            <label for="categoria">Categoria</label>
                            <select class="form-control c-select" id="categoria"></select>
                        </fieldset>
                        <fieldset class="form-group col-xs-6">
                            <label for="descripcion">Descripcion</label>
                            <input type="text" class="form-control" id="descripcion" maxlength="254">
                        </fieldset>
                    </div>
                    <div class="row">
                        <fieldset class="form-group col-xs-3">
                            <label for="pesoNeto">Peso Neto</label>
                            <input type="text" class="form-control" id="pesoNeto" maxlength="5">
                        </fieldset>
                        <fieldset class="form-group col-xs-3">
                            <label for="pesoBruto">Peso Bruto</label>
                            <input type="text" class="form-control" id="pesoBruto" maxlength="5">
                        </fieldset>
                        <fieldset class="form-group col-xs-3">
                            <label for="volumen">Numero Volumen</label>
                            <input type="text" class="form-control" id="volumen" maxlength="5">
                        </fieldset>
                        <fieldset class="form-group col-xs-3">
                            <label for="unidadMedida">Unidad Medida</label>
                            <input type="text" class="form-control" id="unidadMedida" maxlength="6">
                        </fieldset>
                    </div>
                    <div class="row">
                        <fieldset class="form-group col-xs-3">
                            <label for="costoPromedioLocal">Costo Promedio Local</label>
                            <input type="text" class="form-control" id="costoPromedioLocal" maxlength="5">
                        </fieldset>
                        <fieldset class="form-group col-xs-3">
                            <label for="costoPromedioDolar">Costo Promedio Dolar</label>
                            <input type="text" class="form-control" id="costoPromedioDolar" maxlength="5">
                        </fieldset>
                        <fieldset class="form-group col-xs-3">
                            <label for="precioBaseLocal">Precio Base Local</label>
                            <input type="text" class="form-control" id="precioBaseLocal" maxlength="5">
                        </fieldset>
                        <fieldset class="form-group col-xs-3">
                            <label for="precioBaseDolar">Precio Base Dolar</label>
                            <input type="text" class="form-control" id="precioBaseDolar" maxlength="5">
                        </fieldset>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="btnGrabar" type="button" class="btn btn-primary">Grabar</button>
                <button id="btnCancelar" type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/js/jquery/jquery.min.js"/>"></script>
<script>
    $(function() {

        $('#descripcion').keypress(function (event) {
            return soloTextoEspacio(event);
        });
        $('#unidadMedida').keypress(function (event) {
            return soloTexto(event);
        });
        $('#pesoNeto, #pesoBruto, #volumen, #costoPromedioLocal, #costoPromedioDolar, #precioBaseLocal, #precioBaseDolar').keypress(function (event) {
            return soloNumeroConPunto(event, this)
        });

        fn_cargar_lista();

        $('#btnAbrirModalNuevo').on('click',function(){
            $('#formModalLabel').html('Registrar Articulo');
            $('input').val('');
            fn_cargar_categorias();
        });

        $('#result').on('click','#btnAbrirModalEditar',function(){
            $('#formModalLabel').html('Modificar Articulo');
            var registro = $(this).attr('name');
            fn_cargar_datos(registro);
        });

        $('#result').on('click','#btnActivar',function () {
            var registro = $(this).attr('name');
            fn_cambiar_estado(registro, '1');
        });

        $('#result').on('click','#btnInactivar',function () {
            var registro = $(this).attr('name');
            fn_cambiar_estado(registro, '0');
        });

        $('#btnGrabar').on('click',function(){
            fn_grabar_registro();
        });

        function fn_cargar_categorias(){
            $.ajax({
                type: "get",
                url: "/castorapp/categorias/list",
                cache: false,
                data: 'activo=1',
                beforeSend: function() {
                    $('#categoria option').remove();
                },
                success: function (data) {
                    if (data.length > 0) {
                        $.each(data, function (index) {
                            $('#categoria').append('<option value="'+data[index].id + '">' + data[index].nombre + '</option>');
                        });
                    }else{
                        var msg = 'No se encontraron categorías.';
                        $('#titulo').after(mensajeInformacion(msg));
                    }
                },
                error: function(xhr) { // if error occured
                    $('#titulo').after(mensajeError("Ocurrio un error. Por favor prueba otra vez."));
                },
                complete: function () {
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); });
                    }, 2000);
                }
            });
        }

        function fn_cargar_lista() {
            $.ajax({
                type: "get",
                url: "/castorapp/articulos/list",
                cache: false,
                beforeSend: function() {
                    $('#result').html('');
                },
                success: function (data) {
                    if (data.length > 0) {
                        $htmlCustom = '<table class="table table-hover table-condensed"><thead><tr>';
                        $htmlCustom += '<th>CATEGORIA</th><th>CODIGO ARTICULO</th><th>DESCRIPCION</th><th>PESO NETO</th><th>PESO BRUTO</th><th></th>';
                        $htmlCustom += '</tr></thead><tbody>';
                        $.each(data, function (index) {
                            $htmlCustom += '<tr><td>' + data[index].categoria.nombre + '</td>';
                            $htmlCustom += '<td>' + data[index].codigo + '</td><td>' + data[index].descripcion + '</td>';
                            $htmlCustom += '<td>' + data[index].pesoNeto + '</td><td>' + data[index].pesoBruto + '</td>';
                            $htmlCustom += '<td>';
                            $htmlCustom += '<button id="btnAbrirModalEditar" name="'+data[index].id+'" type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#formModal" data-whatever="@getbootstrap">Editar</button>&nbsp;';
                            if (data[index].activo == 1)
                                $htmlCustom += '<button id="btnInactivar" name="'+data[index].id+'" type="button" class="btn btn-default btn-sm">Inactivar</button>';
                            if (data[index].activo == 0)
                                $htmlCustom += '<button id="btnActivar" name="'+data[index].id+'" type="button" class="btn btn-default btn-sm">Activar</button>';
                            $htmlCustom += '</td></tr>';
                        });
                        $htmlCustom += '</tbody></table>';
                        $('#result').html($htmlCustom);
                    }else{
                        var msg = 'No se encontraron artículos.';
                        $('#titulo').after(mensajeInformacion(msg));
                    }
                },
                error: function(xhr) { // if error occured
                    $('#titulo').after(mensajeError("Ocurrio un error. Por favor prueba otra vez."));
                },
                complete: function () {
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); });
                    }, 2000);
                }
            });
        }

        function fn_cargar_datos(registro) {
            $.ajax({
                type: "get",
                url: "/castorapp/articulos/edit",
                cache: false,
                data: 'idArticulo='+registro,
                beforeSend: function() {
                    $('input').val('');
                    $('select option').remove();
                    fn_cargar_categorias();
                },
                success: function (data) {
                    if (data!=null) {
                        $('#idArticulo').val(data.id);
                        $('#idCategoria').val(data.idCategoria);
                        $('#descripcion').val(data.descripcion);
                        $('#pesoNeto').val(data.pesoNeto);
                        $('#pesoBruto').val(data.pesoBruto);
                        $('#volumen').val(data.volumen);
                        $('#unidadMedida').val(data.unidadMedida);
                        $('#costoPromedioLocal').val(data.costoPromedioLocal);
                        $('#costoPromedioDolar').val(data.costoPromedioDolar);
                        $('#precioBaseLocal').val(data.precioBaseLocal);
                        $('#precioBaseDolar').val(data.precioBaseDolar);
                    }else{
                        $('#titulo').after(mensajeInformacion('El artículo seleccionado no existe.'));
                    }
                },
                error: function(xhr) { // if error occured
                    $('#titulo').after(mensajeError("Ocurrio un error. Por favor prueba otra vez."));
                },
                complete: function () {
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); });
                    }, 2000);
                }
            });
        }

        function fn_grabar_registro() {

            if( $('#idArticulo').val()=='' ){
                $parametros = 'idCategoria='+$('#categoria').val()+'&descripcion='+$('#descripcion').val();
                $parametros += '&pesoNeto='+$('#pesoNeto').val()+'&pesoBruto='+$('#pesoBruto').val()+'&volumen='+$('#volumen').val()+'&unidadMedida='+$('#unidadMedida').val();
                $parametros += '&costoPromedioLocal='+$('#costoPromedioLocal').val()+'&costoPromedioDolar='+$('#costoPromedioDolar').val()+'&precioBaseLocal='+$('#precioBaseLocal').val()+'&precioBaseDolar='+$('#precioBaseDolar').val();
                $url = '/castorapp/articulos/register';
                $successMessage = 'Se registró el artículo correctamente.';
            }else if( $('#idArticulo').val()!='' ){
                $parametros = 'idArticulo='+$('#idArticulo').val()+'&idCategoria='+$('#categoria').val()+'&descripcion='+$('#descripcion').val();
                $parametros += '&pesoNeto='+$('#pesoNeto').val()+'&pesoBruto='+$('#pesoBruto').val()+'&volumen='+$('#volumen').val()+'&unidadMedida='+$('#unidadMedida').val();
                $parametros += '&costoPromedioLocal='+$('#costoPromedioLocal').val()+'&costoPromedioDolar='+$('#costoPromedioDolar').val()+'&precioBaseLocal='+$('#precioBaseLocal').val()+'&precioBaseDolar='+$('#precioBaseDolar').val();
                $url = '/castorapp/articulos/update';
                $successMessage = 'Se actualizó el artículo correctamente.';
            }

            $.ajax({
                type: "post",
                url: $url,
                cache: false,
                data: $parametros,
                beforeSend: function() {
                    $('#btnGrabar').attr('disabled','disabled');
                    $('#btnCancelar').attr('disabled','disabled');
                },
                success: function (data) {
                    if( data=='success' ) {
                        $('#titulo').after(mensajeExito($successMessage));
                    }else{
                        $('#titulo').after(mensajeError("Ocurrio un error. Por favor prueba otra vez."));
                    }
                },
                error: function(xhr) { // if error occured
                    $('#titulo').after(mensajeError("Ocurrio un error. Por favor prueba otra vez."));
                },
                complete: function () {
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); });
                    }, 2000);
                    $('#btnGrabar').removeAttr('disabled');
                    $('#btnCancelar').removeAttr('disabled').click();
                    fn_cargar_lista();
                }
            });
        };

        function fn_cambiar_estado(registro, estado) {
            $parametros = 'idArticulo='+registro+'&estado='+estado;
            $.ajax({
                type: "post",
                url: "/castorapp/articulos/state",
                cache: false,
                data: $parametros,
                success: function (data) {
                    if (data=='success') {
                        $('#titulo').after(mensajeExito("Se actualizó el estado del artículo correctamente."));
                    }else{
                        $('#titulo').after(mensajeInformacion('El artículo seleccionado no existe.'));
                    }
                },
                error: function(xhr) { // if error occured
                    $('#titulo').after(mensajeError("Ocurrio un error. Por favor prueba otra vez."));
                },
                complete: function () {
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); });
                    }, 2000);
                    fn_cargar_lista();
                }
            });
        };

    });
</script>