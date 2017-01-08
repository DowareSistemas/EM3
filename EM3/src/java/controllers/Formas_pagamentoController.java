/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Formas_pagamentoDao;
import java.util.List;
import javax.validation.Valid;
import model.Formas_pagamento;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Formas_pagamentoController
{

    @RequestMapping(value = "fpg-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Formas_pagamento fpg, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Formas_pagamentoDao fd = new Formas_pagamentoDao(true);
        
        if(!fd.valid(fpg))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, fd.getMessage(), "").toJson();
        
        fd.save(fpg);

        return (fpg.saved || fpg.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Condição de pagamento salva.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a condição de pagamento. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "fpg-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        Formas_pagamentoDao fd = new Formas_pagamentoDao(true);
        Formas_pagamento forma = fd.find(id);

        return (forma.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", forma).toJson());
    }

    /**
     * Tipo: 0 - Somente inativos; 1 - Somente ativos; 2 - Todos;
     */
    @RequestMapping(value = "fpg-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm, @RequestParam(value = "tipo") int tipo)
    {
        List<Formas_pagamento> result = new Formas_pagamentoDao().search(searchTerm, tipo);
        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encotnrados.", result).toJson());
    }

    @RequestMapping(value = "fpg-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Formas_pagamentoDao fd = new Formas_pagamentoDao();

        if (!fd.podeExcluir(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, fd.getMessage(), "").toJson();

        Formas_pagamento fpg = fd.find(id);
        fd.delete(fpg);
        fd.commit();

        return (fpg.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Condição de pagamento excluida", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir a condição de pagamento. Acione o suporte Doware.", "").toJson());
    }
}
