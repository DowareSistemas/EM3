/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Tabelas_precosDao;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import model.Tabelas_precos;
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
@Scope(value = "request")
public class Tabelas_precosController
{

    @RequestMapping(value = "/tprc-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(
            @RequestParam(value = "query") String searchTerm,
            @RequestParam(value = "tipo") int tipo)
    {
        Tabelas_precosDao tpd = new Tabelas_precosDao();
        List<Tabelas_precos> list = tpd.search(searchTerm, tipo);

        return (list.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, list.size() + " registros encontrados", list).toJson());
    }

    @RequestMapping(value = "/tprc-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Tabelas_precos tabela, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Tabelas_precosDao tpd = new Tabelas_precosDao(false);
        tpd.save(tabela);

        if (tabela.saved || tabela.updated)
        {
            tpd.commit();
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Tabela salva", tabela.getId()).toJson();
        }
        else
        {
            tpd.commit();
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a tabela de preços. Acione o suporte Doware.", "").toJson();
        }
    }

    @RequestMapping(value = "/tprc-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        Tabelas_precosDao tpd = new Tabelas_precosDao(true);
        Tabelas_precos tabela = tpd.find(id);

        return (tabela.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", tabela).toJson());
    }

    @RequestMapping(value = "/tprc-getpreco", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String getPreco(
    @RequestParam(value = "produto_id") int produto_id,
            @RequestParam(value = "uf") String uf,
            @RequestParam(value = "quant") double faixa,
            @RequestParam(value = "unidade_id") int unidade_id,
            @RequestParam(value = "tabela_id") int tabela_id)
    {
        Tabelas_precosDao tpd = new Tabelas_precosDao();
        BigDecimal preco = tpd.getPreco(produto_id, uf, faixa, unidade_id, tabela_id);
        if(preco == null)
            preco = new BigDecimal("0.00");
        return new OperationResult(StatusRetorno.OPERACAO_OK, "", preco.toString()).toJson();
    }
    
    @RequestMapping(value = "/tprc-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Tabelas_precosDao tpd = new Tabelas_precosDao();
        if(!tpd.podeExcluir(id))
        { 
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, tpd.getMessage(), "").toJson();
        }
        
        Tabelas_precos tabela = tpd.find(id);

        if (tabela.getId() == 0)
        {
            tpd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson();
        }

        tpd.delete(tabela);
        tpd.commit();

        return (tabela.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Tabela excluida", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao remover a tabela. Acione o suporte Doware.", "").toJson());
    }

}
