/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Produto_caracteristicaDao;
import dao.ProdutosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.Produtos;
import model.Produtos_caracteristicas;
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
public class ProdutosController
{

    @RequestMapping(value = "prd-limpacaract", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String limpaCaracteristicas(@RequestParam(value = "produto_id") int produto_id)
    {
        Produto_caracteristicaDao pcd = new Produto_caracteristicaDao(true);
        pcd.removeAll(produto_id);

        return new OperationResult(StatusRetorno.OPERACAO_OK, "Caracteristicas excluidas", "").toJson();
    }

    @RequestMapping(value = "prd-listacaract", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listaCaract(@RequestParam(value = "produto_id") int produto_id)
    {
        Produto_caracteristicaDao pcd = new Produto_caracteristicaDao();
        List<Produtos_caracteristicas> list = pcd.listAll(produto_id);

        return (list.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, list.size() + " registros encontrados", list).toJson());
    }

    @RequestMapping(value = "prd-addcaract", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String addCaracteristica(Produtos_caracteristicas pc)
    {
        Produto_caracteristicaDao pcd = new Produto_caracteristicaDao(true);
        pcd.add(pc);

        return (pc.saved
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Caracteristica do produto adicionada", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao adicionar a característica ao produto. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "prd-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(
            @RequestParam(value = "query") String searchTerm,
            @RequestParam(value = "tipo") int tipo,
            @RequestParam(value = "page") int page)
    {
        ProdutosDao pd = new ProdutosDao();
        List<Produtos> result = pd.search(searchTerm, tipo, page);

        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados", result).toJson());
    }

    @RequestMapping(value = "prd-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Produtos produto, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        ProdutosDao pd = new ProdutosDao(false);
        pd.save(produto);

        if (produto.saved || produto.updated)
        {
            produto = pd.last();
            pd.commit();
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Produto salvo", produto.getId()).toJson();
        }
        else
        {
            produto = pd.last();
            pd.commit();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "Ocorreu um problema ao salvar o produto. Acione o suporte Doware.", 0).toJson();
        }
    }

    @RequestMapping(value = "prd-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
 
        Produtos produto = new ProdutosDao(true).find(id);

        return (produto.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", produto).toJson());
    }

    @RequestMapping(value = "prd-count", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String count()
    {
        int count = new ProdutosDao(true).count();
        return new OperationResult(StatusRetorno.OPERACAO_OK, "", count).toJson();
    }

    @RequestMapping(value = "prd-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        ProdutosDao pd = new ProdutosDao();

        if (!pd.podeExcluir(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, pd.getMessage(), "").toJson();

        Produtos produto = pd.find(id);

        if (produto.getId() == 0)
        {
            pd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }

        pd.delete(produto);
        pd.commit();

        return (produto.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Produto excluido", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao remover o produto. Acione o suporte Doware", "").toJson());
    }
}
