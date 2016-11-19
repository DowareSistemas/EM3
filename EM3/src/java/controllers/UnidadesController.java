/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.validation.Valid;
import model.Unidades;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.UnidadesRepository;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class UnidadesController
{

    static UnidadesRepository db = new UnidadesRepository();

    @RequestMapping(value = "und-search", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        List<Unidades> unidades;
        if (searchTerm.isEmpty())
            unidades = db.getAll();
        else
            unidades = db.search(searchTerm);

        if (unidades.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").get();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, unidades.size() + " registros encontrados.", unidades).get();
    }

    @RequestMapping(value = "und-get", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Unidades unidade = db.get(Unidades.class, id);
        db.close();

        if (unidade.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Unidade não localizada", "").get();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Unidade localizada", unidade).get();
    }

    @RequestMapping(value = "und-save", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String save(@Valid Unidades unidade, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").get();

        unidade.setSigla(unidade.getSigla().toUpperCase());
        if (db.exists(Unidades.class, "id", unidade.getId()))
            db.merge(unidade);
        else
            db.add(unidade);

        db.commit(true);

        if (unidade.saved || unidade.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Unidade salva.", "").get();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a unidade. Acione o suporte Doware.", "").get();
    }

    @RequestMapping(value = "und-del", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String delete(@RequestParam(value = "id") int id)
    {
        Unidades unidade = db.get(Unidades.class, id);

        if (unidade.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Unidade não localizada", "").get();
        
        if(db.isValidDelete(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "Esta unidade não pode ser removida. Existem um ou mais produtos relacionados a ela.", "").get();

        db.remove(unidade);
        db.commit(true);
        
        if(unidade.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Unidade removida", "").get();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao remover a unidade. Acione o suporte Doware.", "").get();
    }
}
