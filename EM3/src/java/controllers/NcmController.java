/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.NcmDao;
import java.util.List;
import model.Ncm;
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
public class NcmController
{
    @RequestMapping(value = "ncm-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(
            @RequestParam(value = "query") String searchTerm,
            @RequestParam(value = "page") int page)
    {
        NcmDao nd = new NcmDao();
        List<Ncm> list = nd.search(searchTerm, page);
        
        return (list.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, list + " registros encontrados", list).toJson());
    }
    
    @RequestMapping(value = "ncm-count", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String count()
    {
        int count = new NcmDao().count();
        return new OperationResult(StatusRetorno.OPERACAO_OK, "", count).toJson();
    }
}
