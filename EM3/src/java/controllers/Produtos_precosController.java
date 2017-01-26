/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Produtos_precosDao;
import java.util.List;
import model.Produtos_precos;
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
public class Produtos_precosController
{

    @RequestMapping(value = "prdp-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(Produtos_precos pp)
    {
        Produtos_precosDao ppd = new Produtos_precosDao(true);
        ppd.save(pp);

        return (pp.saved || pp.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Preço salvo.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o preço do produto. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "prdp-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        Produtos_precosDao ppd = new Produtos_precosDao(true);
        Produtos_precos pp = ppd.find(id);

        return (pp.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", pp).toJson());
    }

    @RequestMapping(value = "prdp-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Produtos_precosDao ppd = new Produtos_precosDao();

        if (!ppd.podeExcluir(id))
        {
            ppd.commit();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "Não é possível remover este preço. Existem um ou mais produtos cujo o preço é baseado neste item.", "").toJson();
        }

        Produtos_precos pp = ppd.find(id);
        ppd.delete(pp);
        ppd.commit();

        return (pp.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Preço removido", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao remover o preço. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "prdp-listbyproduto", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listByProduto(
            @RequestParam(value = "produto_id") int produto_id,
            @RequestParam(value = "tabela_ignorar") int tabela_ignorar)
    {
        Produtos_precosDao ppd = new Produtos_precosDao();
        List<Produtos_precos> list = ppd.listByProduto(produto_id, tabela_ignorar);

        return new OperationResult(StatusRetorno.OPERACAO_OK,
                list.size() + " registros encontrados.", list).toJson();
    }
    
    @RequestMapping(value = "prdp-listbytabela", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listByTabela(@RequestParam(value = "tabela_id") int tabela_id)
    {
        Produtos_precosDao ppd = new Produtos_precosDao();
        List<Produtos_precos> list = ppd.listByTabela(tabela_id);
        
        return new OperationResult(StatusRetorno.OPERACAO_OK,
                list.size() + " registros encontrados.", list).toJson();
    }

    @RequestMapping(value = "prdp-listbyprodutotabela", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listByProdutoTabela(
            @RequestParam(value = "produto_id") int produto_id,
            @RequestParam(value = "tabela_id") int tabela_id)
    {
        Produtos_precosDao ppd = new Produtos_precosDao();
        List<Produtos_precos> list = ppd.listByProduto_tabela(produto_id, tabela_id);
        
        return new OperationResult(StatusRetorno.OPERACAO_OK, 
                list.size() + " registros encontrados.", list).toJson();
    }
}
