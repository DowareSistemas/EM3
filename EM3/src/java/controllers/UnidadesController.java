/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.validation.Valid;
import model.Unidades;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.UnidadesRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class UnidadesController
{

    UnidadesRepository db = new UnidadesRepository();

    @RequestMapping(value = "und-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        List<Unidades> unidades;
        if (searchTerm.isEmpty())
            unidades = db.getAll();
        else
            unidades = db.search(searchTerm);

        if (unidades.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, unidades.size() + " registros encontrados.", unidades).toJson();
    }

    @RequestMapping(value = "und-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Unidades unidade = session.onID(Unidades.class, id);
        session.close();

        if (unidade.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Unidade não localizada", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Unidade localizada", unidade).toJson();
    }

    @RequestMapping(value = "und-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Unidades unidade, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        unidade.setSigla(unidade.getSigla().toUpperCase());

        Session session = SessionProvider.openSession();

        if (Utility.exists(Unidades.class, "id", unidade.getId()))
            session.update(unidade);
        else
        {
            if (db.getBySigla(unidade.getSigla()).getId() > 0)
                return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "Já existe uma unidade com esta sigla. Escolha outra sigla e tente novamente.", "").toJson();

            session.save(unidade);
        }

        session.commit();
        session.close();

        if (unidade.saved || unidade.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Unidade salva.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a unidade. Acione o suporte Doware.", "").toJson();
    }

    @RequestMapping(value = "und-del", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String delete(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Unidades unidade = session.onID(Unidades.class, id);

        if (unidade.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Unidade não localizada", "").toJson();

        if (db.isValidDelete(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "Esta unidade não pode ser removida. Existem um ou mais produtos relacionados a ela.", "").toJson();

        session.delete(unidade);
        session.commit();
        session.close();

        if (unidade.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Unidade removida", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao remover a unidade. Acione o suporte Doware.", "").toJson();
    }
}
