<%-- 
    Document   : interrogacao
    Created on : 09/08/2016, 21:06:40
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>
<%@attribute name="texto_corpo" %>
<%@attribute name="texto_btnSIM" %>
<%@attribute name="texto_btnNAO" %>
<%@attribute name="classe_btnSIM" %>
<%@attribute name="classe_btnNAO" %>
<%@attribute name="id_btnSIM" required="false" %>
<%@attribute name="value_btnSIM" required="false" %>
<%-- The list of normal or fragment attributes can be specified here: --%>

<div class="modal fade bd-example-modal-sm" id="mensagem-sn" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Atenção</h4>
            </div>
            <div class="modal-body">
                <p> ${texto_corpo} </p>
            </div>
            <div class="modal-footer">
                <button type="button" id="msg-sn-btnNAO" class="${classe_btnNAO}" data-dismiss="modal"> ${texto_btnNAO} </button>
                <button type="button" value="${value_btnSIM}" id="${id_btnSIM}" class="${classe_btnSIM}" data-dismiss="modal"> ${texto_btnSIM} </button>
            </div>
        </div>
    </div>
</div>