/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.Usuarios;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.UsuariosRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class UsuariosController
{

    UsuariosRepository db = new UsuariosRepository();

    @RequestMapping(value = "/usr-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Usuarios usuario, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Session session = SessionProvider.openSession();

        if (Utility.exists(Usuarios.class, "id", usuario.getId()))
            session.update(usuario);
        else
            session.save(usuario);

        session.commit();
        session.close();

        if (usuario.saved || usuario.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Usuário salvo", usuario).toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o usuário", "").toJson();
    }

    @RequestMapping(value = "/usr-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Usuarios u = session.onID(Usuarios.class, id);
        session.close();

        if (u.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Usuário não localizado", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "", u).toJson();
    }

    @RequestMapping(value = "/usr-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Usuarios u = session.onID(Usuarios.class, id);

        if (u.getId() == 0)
        {
            session.close();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Usuário não localizado", "").toJson();
        }

        if (u.getId() == 1)
        {
            session.close();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "O usuário 1 não pode ser excluído.", "").toJson();
        }

        if (!db.podeExcluir(id))
        {
            session.close();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, db.getMessage(), "").toJson();
        }

        session.delete(u);
        session.commit();
        session.close();

        if (u.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Usuário excluido", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o usuário", "").toJson();
    }

    @RequestMapping(value = "/usr-login", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String login(Usuarios usuario, HttpServletRequest request)
    {
        SessionProvider.setConfig(request);
        
        if(!SessionProvider.databaseHasConfigured())
            return new OperationResult(StatusRetorno.OPERACAO_OK, "no_tables", "0").toJson();
        
        usuario = db.efetuaLogin(usuario);

        if (usuario.getId() > 0)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "1", usuario).toJson();
        else
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Usuário ou senha incorretos", null).toJson();
    }

    /**
     *
     * @param tipo 0 - Todos; 1 - Somente Ativos; 2 - Somente inativos;
     * @return
     */
    @RequestMapping(value = "/usr-count", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String count(@RequestParam(value = "tipo") int tipo)
    {
        Session session = SessionProvider.openSession();
        
        int count = 0;
        switch (tipo)
        {
            case 0:

                count = session.count(Usuarios.class, "ativo in (0, 1)");
                break;
            case 1:

                count = session.count(Usuarios.class, "ativo = 1");
                break;

            case 2:

                count = session.count(Usuarios.class, "ativo = 0");
                break;
        }

        session.close();
        return new OperationResult(StatusRetorno.OPERACAO_OK, "", count).toJson();
    }

    /**
     *
     * @param searchTerm
     * @param tipo 0 - Todos; 1 - Somente Ativos; 2 - Somente inativos;
     * @return
     */
    @RequestMapping(value = "/usr-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm, @RequestParam(value = "tipo") int tipo)
    {
        List<Usuarios> result;

        if (searchTerm.isEmpty())
            result = db.getAll();
        else
            result = db.search(searchTerm, tipo);

        if (result.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson();
        else
            return new OperationResult((StatusRetorno.OPERACAO_OK), result.size() + " registros encontrados.", result).toJson();
    }

    @RequestMapping(value = "/usr-validperm", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String validaPermissao(
            @RequestParam(value = "tela") String tela,
            @RequestParam(value = "usuario") int usuario,
            @RequestParam(value = "tipo_permissao") int tipo_permissao)
    {
        boolean valido = db.validaPermissao(tela, usuario, tipo_permissao);

        if (valido)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Acesso autorizado.", 1).toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Acesso negado.", 0).toJson();
    }
}
