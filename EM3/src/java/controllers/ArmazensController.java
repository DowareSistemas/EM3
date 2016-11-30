/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.validation.Valid;
import model.Armazens;
import model.Empresa;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.ArmazensRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class ArmazensController
{
    ArmazensRepository db = new ArmazensRepository();

    @RequestMapping(value = "armz-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        List<Armazens> result;
        if (searchTerm.isEmpty())
            result = db.listAll();
        else
            result = db.search(searchTerm);

        if (result.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados.", result).toJson();
    }

    @RequestMapping(value = "armz-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Armazens armazem = session.onID(Armazens.class, id);
        session.close();
        
        if(armazem.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "", armazem).toJson();
    }
    
    @RequestMapping(value = "armz-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Armazens armazem, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Session session = SessionProvider.openSession();

        if (armazem.getEmpresa_id() > 0)
            if (((Empresa) session.onID(Empresa.class, armazem.getEmpresa_id())).getId() == 0)
            {
                session.close();
                return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "A empresa informada não foi localizada", "").toJson();
            }

        if (Utility.exists(Armazens.class, "id", armazem.getId()))
            session.update(armazem);
        else
            session.save(armazem);
        session.commit();
        session.close();

        if (armazem.saved || armazem.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Armazém salvo.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o armazém. Acione o suporte Doware", "").toJson();
    }

    @RequestMapping(value = "armz-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Armazens armz = session.onID(Armazens.class, id);
        
        if(armz.getId() == 0)
        {
            session.close();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "Registro não encontrado.", "").toJson();
        }
        
        if(!db.podeExcluir(id))
        {
            session.close();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, db.getMessage(), "").toJson();
        }
        
        session.delete(armz);
        session.commit();
        session.close();
        
        if(armz.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Armazém removido.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o armazém. Acione o suporte Doware.", "").toJson();
    }
}
