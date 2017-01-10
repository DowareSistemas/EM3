/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Operadoras_cartaoDao;
import java.util.List;
import javax.validation.Valid;
import model.Operadoras_cartao;
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
public class Operadoras_cartaoController
{
    @RequestMapping(value = "opct-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Operadoras_cartao operadora, BindingResult result)
    {
        if(result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();
        
        Operadoras_cartaoDao od = new Operadoras_cartaoDao(true);
        od.save(operadora);
        
        return (operadora.saved || operadora.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Operadora salva", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a operadora. Acione o suporte Doware.", "").toJson());
    }
    
    @RequestMapping(value = "opct-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Operadoras_cartaoDao od = new Operadoras_cartaoDao();
        Operadoras_cartao operadora = od.find(id);
        
        if(operadora.getId() == 0)
        {
            od.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }
        
        od.delete(operadora);
        od.commit();
        
        return (operadora.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Operadora removida", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir a operadora. Acione o suporte Doware.", "").toJson());
    }
    
    @RequestMapping(value = "opct-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        Operadoras_cartaoDao od = new Operadoras_cartaoDao(true);
        Operadoras_cartao operadora = od.find(id);
        
        return (operadora.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", operadora).toJson());
    }
    
    @RequestMapping(value = "opct-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query")String searchTerm)
    {
        List<Operadoras_cartao> result = new Operadoras_cartaoDao().search(searchTerm);
        
        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados", result).toJson());
    }
}