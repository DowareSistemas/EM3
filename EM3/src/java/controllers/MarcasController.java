/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.MarcasDao;
import java.util.List;
import javax.validation.Valid;
import model.Marcas;
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
public class MarcasController
{

    @RequestMapping(value = "mrc-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        List<Marcas> result = new MarcasDao().search(searchTerm);

        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados", result).toJson());
    }

    @RequestMapping(value = "mrc-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Marcas marca, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        MarcasDao md = new MarcasDao(true);
        md.save(marca);

        return (marca.saved || marca.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Marca salva", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a marca. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "mrc-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        MarcasDao md = new MarcasDao(false);
        Marcas marca = md.find(id);

        if (marca.getId() == 0)
        {
            md.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson();
        }

        md.delete(marca);
        md.commit();

        return (marca.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Marca removida", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir a marca. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "mrc-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        MarcasDao md = new MarcasDao(true);
        Marcas marca = md.find(id);

        return (marca.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", marca).toJson());
    }
}
