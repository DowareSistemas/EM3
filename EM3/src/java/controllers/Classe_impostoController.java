/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import dao.Classe_impostoDao;
import java.util.List;
import javax.validation.Valid;
import model.Classes_imposto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.Classes_impostoRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Classe_impostoController
{

    @RequestMapping(value = "climp-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Classes_imposto classe, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Classe_impostoDao cd = new Classe_impostoDao(true);
        cd.save(classe);

        return (classe.saved || classe.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Classe de imposto salva.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a classe de imposto. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "climp-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        Classe_impostoDao cd = new Classe_impostoDao();
        List<Classes_imposto> result = cd.search(searchTerm);
        
        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados.", result).toJson());
    }
    
    @RequestMapping(value = "climp-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Classe_impostoDao cd = new Classe_impostoDao(true);
        Classes_imposto classe = cd.find(id);
        
        return (classe.getId() > 0
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "", classe).toJson()
                : new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson());
    }
    
    @RequestMapping(value = "climp-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Classe_impostoDao cd = new Classe_impostoDao();
        
        if(!cd.podeExcluir(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, cd.getMessage(), "").toJson();
        
        Classes_imposto classe = cd.find(id);
        
        if(classe.getId() == 0)
        {
            cd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }
        
        cd.delete(classe);
        cd.commit();
        
        return (classe.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Classe de imposto excluida.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir a classe de imposto. Acione o suporte Doware.", "").toJson());
    }
}
