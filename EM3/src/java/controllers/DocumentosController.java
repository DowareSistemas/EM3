/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DocumentosDao;
import javax.validation.Valid;
import model.Documentos;
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
public class DocumentosController
{
    @RequestMapping(value = "doc-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Documentos documento, BindingResult result)
    {
        if(result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();
        
        DocumentosDao dd = new DocumentosDao(true);
        dd.save(documento);
        
        return (documento.saved || documento.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Documento salvo.", documento.getId()).toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problemao ao salvar o doumento. Acione o suporte Doware.", "").toJson());
    }
    
    @RequestMapping(value = "doc-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        DocumentosDao dd = new DocumentosDao(true);
        Documentos documento = dd.find(id);
        
        return (documento.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", documento).toJson());
    }
    
    @RequestMapping(value = "doc-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        DocumentosDao dd = new DocumentosDao();
        Documentos d = dd.find(id);
        
        if(d.getId() == 0)
        {
            dd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson();
        }
        
        dd.delete(d);
        dd.commit();
        
        return (d.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Documento removido", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o documento. Acione o suporte Doware.", "").toJson());
    }
}
