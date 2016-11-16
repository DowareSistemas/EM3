

<%@attribute name="titulo" %>
<%@attribute name="id_btnConfirmar" %>
<%@attribute name="id_input" %>
<%@attribute name="type_input" %>
<%@attribute name="id" %>

<div class="modal fade bd-example-modal-sm" id="${id}" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${titulo}</h4>
            </div>
            <div class="modal-footer">
                <input type="${type_input}" id="${id_input}" class="form-control" style="margin-bottom: 10px;" />
                <button type="button" class="btn btn-default" data-dismiss="modal"> Cancelar </button>
                <button type="submit" id="${id_btnConfirmar}" class="btn btn-primary" data-dismiss="modal"> Confirmar </button>
            </div>
        </div>
    </div>
</div>