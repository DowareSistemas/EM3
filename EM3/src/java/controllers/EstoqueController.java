/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EstoqueDao;
import java.util.List;
import model.Estoque;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
@Scope(value = "request")
public class EstoqueController
{

    @RequestMapping(value = "/est-padrao", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String getEstoquePadrao(@RequestParam(value = "produto_id") int produto_id)
    {
        EstoqueDao ed = new EstoqueDao();
        Estoque estq = ed.getEstoquePadrao(produto_id);

        return new OperationResult(StatusRetorno.OPERACAO_OK, "", estq).toJson();
    }

    @RequestMapping(value = "/est-findbylocal", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String findByLocal(@RequestParam(value = "nome") String nome_local)
    {
        EstoqueDao ed = new EstoqueDao();
        Estoque estq = ed.findByLocal(nome_local);

        return new OperationResult(StatusRetorno.OPERACAO_OK, "", estq).toJson();
    }

    @RequestMapping(value = "/est-listbylocal", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listByLical(@RequestParam(value = "local_id") int local_id)
    {
        EstoqueDao ed = new EstoqueDao();
        List< Estoque> list = ed.listByLocal(local_id);

        return new OperationResult(StatusRetorno.OPERACAO_OK, list + " registros encontrados", list).toJson();
    }

    @RequestMapping(value = "/est-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(Estoque estoque)
    {
        EstoqueDao ed = new EstoqueDao(true);
        ed.save(estoque);

        return (estoque.saved || estoque.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Estoque salvo", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o estoque do produto. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "/est-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        EstoqueDao ed = new EstoqueDao(false);
        Estoque est = ed.find(id);
        ed.delete(est);

        return (est.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Estoque excluido", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao remover o estoque do produto. Acione o suporte Doware.", "").toJson());
    }
}
