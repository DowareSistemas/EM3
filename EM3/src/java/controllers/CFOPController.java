/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CfopDao;
import java.util.List;
import model.Cfop;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.CFOPRepository;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
@Scope(value = "request")
public class CFOPController
{
    CFOPRepository db = new CFOPRepository();
    
    @RequestMapping(value = "cfop-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        CfopDao cd = new CfopDao();
        List<Cfop> result = cd.search(searchTerm);
        
        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados.", result).toJson());
    }
}
