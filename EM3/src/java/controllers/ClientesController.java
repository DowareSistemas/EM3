/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ClientesDao;
import java.util.List;
import javax.validation.Valid;
import model.Clientes;
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
@Scope(value = "request")
@Controller
public class ClientesController
{

    @RequestMapping(value = "cli-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Clientes cliente, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        ClientesDao cd = new ClientesDao(true);
        cd.save(cliente);

        return (cliente.saved || cliente.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Cliente salvo.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o cliente. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "cli-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        ClientesDao cd = new ClientesDao(true);
        Clientes cli = cd.find(id);
        
        return (cli.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", cli).toJson());
    }
    
    @RequestMapping(value = "cli-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(
    @RequestParam(value = "query") String searchTerm,
            @RequestParam(value = "tipo") int tipo,
            @RequestParam(value = "loja_id") int loja_id)
    {
        List<Clientes> list = new ClientesDao().search(searchTerm, tipo, loja_id);
        return new OperationResult(StatusRetorno.OPERACAO_OK, list.size() + " registros encontrados.", list).toJson();
    }
    
    @RequestMapping(value = "cli-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        ClientesDao cd = new ClientesDao();
        if(!cd.podeExcluir(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, cd.getMessage(), "").toJson();
        
        Clientes cli = cd.find(id);
        
        if(cli.getId() == 0)
        {
            cd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }
        
        cd.delete(cli);
        cd.commit();
        
        return (cli.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Cliente excluido", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o cliente. Acione o suporte Doware.", "").toJson());
    }
}
