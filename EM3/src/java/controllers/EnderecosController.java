/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EnderecosDao;
import javax.validation.Valid;
import model.Enderecos;
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
public class EnderecosController
{

    @RequestMapping(value = "end-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Enderecos endereco, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        EnderecosDao ed = new EnderecosDao(true);
        ed.save(endereco);

        return (endereco.saved || endereco.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Endereço salvo.", endereco.getId()).toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o endereço. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "end-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        EnderecosDao ed = new EnderecosDao(true);
        Enderecos e = ed.find(id);

        return (e.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", e).toJson());
    }

    @RequestMapping(value = "end-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        EnderecosDao ed = new EnderecosDao();
        Enderecos e = ed.find(id);

        if (e.getId() == 0)
        {
            ed.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }
        
        ed.delete(e);
        ed.commit();
        
        return (e.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Endereço removido.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "Ocorreu um problema ao remover o endereço. Acione o suporte Doware.", "").toJson());
    }
}
