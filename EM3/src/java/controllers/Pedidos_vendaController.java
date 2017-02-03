/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Pedidos_vendaDao;
import java.util.List;
import javax.validation.Valid;
import model.Pedidos_venda;
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
public class Pedidos_vendaController
{
    @RequestMapping(value = "pdvnd-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Pedidos_venda pv, BindingResult result)
    {
        if(result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();
        
        Pedidos_vendaDao pd = new Pedidos_vendaDao(true);
        pd.save(pv);
        
        return (pv.saved || pv.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Pedido salvo", pv).toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o pedido de venda. Acione o suporte Doware.", "").toJson());
    }
    
    @RequestMapping(value = "pdvnd-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        Pedidos_vendaDao pd = new Pedidos_vendaDao(true);
        Pedidos_venda pv = pd.find(id);
        
        return (pv.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", pv).toJson());
    }
    
    @RequestMapping(value = "pdvnd-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(
            @RequestParam(value = "query") String searchTerm,
            @RequestParam(value = "data_inicio") String data_inicio,
            @RequestParam(value = "data_fim") String data_fim)
    {
        Pedidos_vendaDao pd = new Pedidos_vendaDao();
        List<Pedidos_venda> list = pd.search(searchTerm, data_inicio, data_fim);
        
        return new OperationResult(StatusRetorno.OPERACAO_OK, list.size() + " registros encontrados.", list).toJson();
    }
    
    @RequestMapping(value = "pdvnd-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Pedidos_vendaDao pd = new Pedidos_vendaDao();
        Pedidos_venda pv = pd.find(id);
        
        if(pv.getId() == 0)
        {
            pd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson();
        }
        
        pd.remove(pv);
        pd.commit();
        
        return (pv.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Pedido removido", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o pedido de venda. Acione o suporte Doware","").toJson());
    }
}
