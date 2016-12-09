/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.validation.Valid;
import model.Tipos_movimento;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.Tipos_movimentoRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Tipos_movimentoController
{
    Tipos_movimentoRepository db = new Tipos_movimentoRepository();

    /**
     * 
     * @param searchTerm termo de busca
     * @param tipo 0 - somente inativos; 1 - somente ativos; 2 - todos
     * @return 
     */
    @RequestMapping(value = "tmv-search", produces="application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm, @RequestParam(value = "tipo") int tipo)
    {
        List<Tipos_movimento> result;
        
        if(searchTerm.isEmpty())
            result = db.listAll(tipo);
        else
            result = db.search(searchTerm, tipo);
        
        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados.", result).toJson());
    }
    
    @RequestMapping(value = "tmv-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Tipos_movimento tmv, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Session session = SessionProvider.openSession();
        if (Utility.exists(Tipos_movimento.class, "id", tmv.getId()))
            session.update(tmv);
        else
            session.save(tmv);
        session.commit();
        session.close();
        
        return (tmv.saved || tmv.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Tipo de movimento salvo.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o tipo de movimento. Acione o suporte Doware.", "").toJson());
    }
    
    @RequestMapping(value = "tmv-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        if(!db.podeExcluir(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, db.getMessage(), "").toJson();
        
        Session session = SessionProvider.openSession();
        Tipos_movimento tmv = session.onID(Tipos_movimento.class, id);
        
        if(tmv.getId() == 0)
        {
            session.close();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado", "").toJson();
        }
        
        session.delete(tmv);
        session.commit();
        session.close();
        
        return (tmv.saved || tmv.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Tipo de movimento excluido", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o tipo de movimento. Acione o suporte Doware", "").toJson());
    }
    
    @RequestMapping(value = "tmv-get", produces="application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Tipos_movimento tmv = session.onID(Tipos_movimento.class, id);
        session.close();
        
        return (tmv.getId() > 0
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "", tmv).toJson()
                : new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson());
    }
}
