/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import dao.CaracteristicaDao;
import java.util.List;
import javax.validation.Valid;
import model.Caracteristicas;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.CaracteristicasRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
@Scope(value = "request")
public class CaracteristicasController
{

    @RequestMapping(value = "caract-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        CaracteristicaDao cd = new CaracteristicaDao();
        List<Caracteristicas> result = cd.search(searchTerm);

        return new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados.", result).toJson();
    }

    @RequestMapping(value = "caract-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Caracteristicas caract, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        CaracteristicaDao cd = new CaracteristicaDao(true);
        cd.save(caract);

        if (caract.saved || caract.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Característica salva.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a característica. Acione o suporte Doware.", "").toJson();
    }

    @RequestMapping(value = "caract-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        CaracteristicaDao cd = new CaracteristicaDao(true);
        Caracteristicas result = cd.find(id);

        if (result.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "", result).toJson();
    }

    @RequestMapping(value = "caract-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        CaracteristicaDao cd = new CaracteristicaDao();
        Caracteristicas c = cd.find(id);

        if (c.getId() == 0)
        {
            cd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }
        
        if (!cd.podeExcluir(id))
        {
            cd.commit();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, cd.getMessage(), "").toJson();
        }
        
        cd.delete(c);
        cd.commit();

        if (c.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Registro excluido", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir a característica. Acione o suporte Doware.", "").toJson();
    }
}
