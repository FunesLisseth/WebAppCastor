<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-title">
    <h3 class="main-title">Mantenimiento de Categor&iacute;as</h3>
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
                    <input type="hidden" id="idCategoria" />
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" maxlength="20">
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" class="form-control" id="descripcion" maxlength="150">
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

        $('#nombre, #descripcion').keypress(function (event) {
            return soloTextoEspacio(event);
        });

        fn_cargar_lista();

        $('#btnAbrirModalNuevo').on('click',function(){
            $('#formModalLabel').html('Registrar Categoria');
            $('#idCategoria').val('');
            $('#nombre').val('');
            $('#descripcion').val('');
        });

        $('#result').on('click','#btnAbrirModalEditar',function(){
            $('#formModalLabel').html('Modificar Categoria');
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

        function fn_cargar_datos(registro) {
            $.ajax({
                type: "get",
                url: "/castorapp/categorias/edit",
                cache: false,
                data: 'idCategoria='+registro,
                beforeSend: function() {
                    $('#idCategoria').val('');
                    $('#nombre').val('');
                    $('#descripcion').val('');
                },
                success: function (data) {
                    if (data!=null) {
                        $('#idCategoria').val(data.id);
                        $('#nombre').val(data.nombre);
                        $('#descripcion').val(data.descripcion);
                    }else{
                        $('#titulo').after(mensajeInformacion('La categoria seleccionada no existe.'));
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

        function fn_cargar_lista(){
            $.ajax({
                type: "get",
                url: "/castorapp/categorias/list",
                cache: false,
                beforeSend: function() {
                    $('#result').html('');
                },
                success: function (data) {
                    if (data.length > 0) {
                        $htmlCustom = '<table class="table table-hover table-condensed"><thead><tr>';
                        $htmlCustom += '<th>NOMBRE</th><th>DESCRIPCION</th><th></th>';
                        $htmlCustom += '</tr></thead><tbody>';
                        $.each(data, function (index) {
                            $htmlCustom += '<tr><td>' + data[index].nombre + '</td><td>' + data[index].descripcion + '</td><td>';
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
        };

        function fn_grabar_registro() {

            if( $('#idCategoria').val()=='' ){
                $parametros = 'nombre='+$('#nombre').val()+'&descripcion='+$('#descripcion').val();
                $url = '/castorapp/categorias/register';
                $successMessage = 'Se registró la categoría correctamente.';
            }else if( $('#idCategoria').val()!='' ){
                $parametros = 'idCategoria='+$('#idCategoria').val()+'&nombre='+$('#nombre').val()+'&descripcion='+$('#descripcion').val();
                $url = '/castorapp/categorias/update';
                $successMessage = 'Se actualizó la categoría correctamente.';
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
            $parametros = 'idCategoria='+registro+'&estado='+estado;
            $.ajax({
                type: "post",
                url: "/castorapp/categorias/state",
                cache: false,
                data: $parametros,
                success: function (data) {
                    if (data=='success') {
                        $('#titulo').after(mensajeExito("Se actualizó el estado de la categoría correctamente."));
                    }else{
                        $('#titulo').after(mensajeInformacion('La categoria seleccionada no existe.'));
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