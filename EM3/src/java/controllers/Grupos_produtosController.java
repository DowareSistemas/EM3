/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.validation.Valid;
import model.Grupos_produtos;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.Grupos_produtoRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Grupos_produtosController
{

    Grupos_produtoRepository db = new Grupos_produtoRepository();

    /**
     *
     * @param searchTerm
     * @param tipo 0 - Todos; 1 - Apenas ativos; 2 - Apenas inativos
     * @return
     */
    @RequestMapping(value = "gprod-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm, @RequestParam(value = "tipo") int tipo)
    {
        List<Grupos_produtos> result = (searchTerm.isEmpty()
                ? db.listAll(tipo)
                : db.search(searchTerm, tipo));

        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados.", result).toJson());
    }

    @RequestMapping(value = "gprod-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Grupos_produtos grupos_produtos, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Session session = SessionProvider.openSession();

        if (Utility.exists(Grupos_produtos.class, "id", grupos_produtos.getId()))
            session.update(grupos_produtos);
        else
            session.save(grupos_produtos);

        session.commit();
        session.close();

        return ((grupos_produtos.saved || grupos_produtos.updated)
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo salvo.", grupos_produtos).toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o grupo. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "gprod-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Grupos_produtos gp = session.onID(Grupos_produtos.class, id);
        session.close();

        return (gp.getId() > 0)
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "", gp).toJson()
                : new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
    }

    @RequestMapping(value = "gprod-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        if (!db.podeExcluir(id))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, db.getMessage(), "").toJson();

        Session session = SessionProvider.openSession();
        Grupos_produtos gp = session.onID(Grupos_produtos.class, id);

        if (gp.getId() == 0)
        {
            session.close();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }

        session.delete(gp);
        session.commit();
        session.close();

        new ImagensController().delete(gp.getFoto_id());

        return (gp.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo excluido.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o grupo. Acione o suporte Doware.", "").toJson());
    }
}
