package controllers;

import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.validation.Valid;
import model.Armazens;
import model.Locais_estoque;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.Locais_estoqueRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Locais_estoqueController
{

    Locais_estoqueRepository db = new Locais_estoqueRepository();

    @RequestMapping(value = "loest-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        List<Locais_estoque> result;
        if (searchTerm.isEmpty())
            result = db.listAll();
        else
            result = db.search(searchTerm);

        return new OperationResult(StatusRetorno.OPERACAO_OK, "", result).toJson();
    }

    @RequestMapping(value = "loest-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Locais_estoque local, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Session session = SessionProvider.openSession();
     
        Armazens armz = session.onID(Armazens.class, local.getArmazem_id());
        if(armz.getId() == 0)
        {
            session.close();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "O armazém informado não foi localizado ou não é válido", "").toJson();
        }
        
        if (Utility.exists(Locais_estoque.class, "id", local.getId()))
            session.update(local);
        else
            session.save(local);

        session.commit();
        session.close();

        if (local.saved || local.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Local de estoque salvo.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o local de estoque. Acione o suporte Doware.", "").toJson();
    }

    @RequestMapping(value = "loest-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Locais_estoque le = session.onID(Locais_estoque.class, id);
        session.close();

        if (le.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "", le).toJson();
    }

    @RequestMapping(value = "loest-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        if(!db.podeExcluir(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, db.getMessage(), "").toJson();
        
        Session session = SessionProvider.openSession();
        Locais_estoque le = session.onID(Locais_estoque.class, id);

        if (le.getId() == 0)
        {
            session.close();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }
        
        session.delete(le);
        session.commit();
        session.close();
        
        if(le.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Local de estoque removido.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Ocorreu um problema ao remover o local de estoque. Acione o suporte Doware.", "").toJson();
    }
}
