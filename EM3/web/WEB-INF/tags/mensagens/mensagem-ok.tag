<%@attribute name="id" %>

<div class="modal fade bd-example-modal-sm" data-backdrop="static" data-keyboard="false" id="${id}" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Mensagem</h4>
            </div>
            <div class="modal-body">
                <p class="text-left msg"> </p>
            </div>
            <div class="modal-footer">
                <button type="button" id="btnOk" class="btn btn-primary"  data-dismiss="modal"> OK </button>
            </div>
        </div>
    </div>
</div>