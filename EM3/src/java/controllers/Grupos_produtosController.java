/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import dao.FotosDao;
import dao.Grupos_produtoDao;
import java.util.List;
import javax.validation.Valid;
import model.Fotos;
import model.Grupos_produtos;
import org.springframework.context.annotation.Scope;
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
@Scope(value = "request")
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
        Grupos_produtoDao gd = new Grupos_produtoDao();
        List<Grupos_produtos> result = gd.search(searchTerm, tipo);

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

        Grupos_produtoDao gd = new Grupos_produtoDao(true);
        gd.save(grupos_produtos);

        return ((grupos_produtos.saved || grupos_produtos.updated)
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo salvo.", grupos_produtos).toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o grupo. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "gprod-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Grupos_produtoDao gd = new Grupos_produtoDao(true);
        Grupos_produtos gp = gd.find(id);

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

        Grupos_produtoDao gd = new Grupos_produtoDao();
        Grupos_produtos gp = gd.find(id);

        if (gp.getId() == 0)
        {
            gd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        }

        gd.delete(gp);

        if (gp.getFoto_id() > 0)
        {
            FotosDao fd = new FotosDao(gd.getSession());
            Fotos foto = fd.find(gp.getFoto_id());
            fd.delete(foto);
        }

        gd.commit();

        return (gp.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo excluido.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o grupo. Acione o suporte Doware.", "").toJson());
    }
}
