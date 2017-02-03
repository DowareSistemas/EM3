/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Itens_pedidoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.Itens_pedido;
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
public class Itens_pedidoController
{

    @RequestMapping(value = "iped-listbypedido", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listByPedido(@RequestParam(value = "pedido_id") int pedido_id)
    {
        Itens_pedidoDao id = new Itens_pedidoDao();
        List<Itens_pedido> list = id.listByPedido(pedido_id);

        return new OperationResult(StatusRetorno.OPERACAO_OK, list.size() + " registros encontrados.", list).toJson();
    }

    @RequestMapping(value = "iped-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Itens_pedido ip, BindingResult result, HttpServletRequest request)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Itens_pedidoDao id = new Itens_pedidoDao(true);
        id.save(ip);

        return (ip.saved || ip.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Item salvo", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar um item do pedido. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "iped-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Itens_pedidoDao ipd = new Itens_pedidoDao();
        Itens_pedido ip = ipd.find(id);
        ipd.delete(ip);
        ipd.commit();
        
        return (ip.deleted 
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Item removido do pedido", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao remover o item do pedido. Acione o suporte Doware.", "").toJson());
    }
    
    @RequestMapping(value = "iped-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int item_id, HttpServletRequest request)
    {
        Itens_pedidoDao id = new Itens_pedidoDao(true);
        Itens_pedido item = id.find(item_id);

        return (item.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "Item removido", "").toJson());
    }
}
