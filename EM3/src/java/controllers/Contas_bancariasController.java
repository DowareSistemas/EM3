/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Contas_bancariasDao;
import java.util.List;
import javax.validation.Valid;
import model.Contas_bancarias;
import org.springframework.context.annotation.Scope;
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
public class Contas_bancariasController
{

    @RequestMapping(value = "cntb-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Contas_bancarias conta, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Contas_bancariasDao cd = new Contas_bancariasDao(true);
        cd.save(conta);

        return (conta.saved || conta.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Conta salva", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a conta. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "cntb-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        Contas_bancariasDao cd = new Contas_bancariasDao(true);
        Contas_bancarias conta = cd.find(id);

        return (conta.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", conta).toJson());
    }

    @RequestMapping(value = "cntb-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Contas_bancariasDao cd = new Contas_bancariasDao();
        Contas_bancarias conta = cd.find(id);

        if (conta.getId() == 0)
        {
            cd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson();
        }

        cd.delete(conta);
        cd.commit();

        return (conta.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Conta excluida", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir a conta. Acione o suporte Doware.", "").toJson());
    }
    
    @RequestMapping(value = "cntb-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(
            @RequestParam(value = "query") String searchTerm,
            @RequestParam(value = "tipo") int tipo)
    {
        Contas_bancariasDao cd = new Contas_bancariasDao();
        List<Contas_bancarias> result = cd.search(searchTerm, tipo);
        
        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontraodos", result).toJson());
    }
}
