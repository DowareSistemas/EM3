/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UsuariosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.Usuarios;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
@Scope(value = "request")
public class UsuariosController
{

    @RequestMapping(value = "/usr-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Usuarios usuario, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        UsuariosDao ud = new UsuariosDao(false);
        ud.save(usuario);

        if (usuario.saved || usuario.updated)
        {
            usuario = ud.last();
            ud.commit();
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Usuário salvo", usuario).toJson();
        }
        else
        {
            ud.commit();
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o usuário", "").toJson();
        }
    }

    @RequestMapping(value = "/usr-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        UsuariosDao ud = new UsuariosDao(true);
        Usuarios u = ud.find(id);

        if (u.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Usuário não localizado", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "", u).toJson();
    }

    @RequestMapping(value = "/usr-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        UsuariosDao ud = new UsuariosDao();
        Usuarios usuario = ud.find(id);

        if (usuario.getId() == 0)
        {
            ud.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Usuário não localizado", "").toJson();
        }

        if (usuario.getId() == 1)
        {
            ud.commit();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "O usuário 1 não pode ser excluído.", "").toJson();
        }

        if (!ud.podeExcluir(id))
        {
            ud.commit();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, ud.getMessage(), "").toJson();
        }

        ud.delete(usuario);
        ud.commit();

        if (usuario.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Usuário excluido", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o usuário", "").toJson();
    }

    @RequestMapping(value = "/usr-login", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String login(Usuarios usuario, HttpServletRequest request)
    {
        SessionProvider.setConfig(request);

        if (!SessionProvider.databaseHasConfigured())
            return new OperationResult(StatusRetorno.OPERACAO_OK, "no_tables", "0").toJson();

        UsuariosDao ud = new UsuariosDao();
        usuario = ud.efetuaLogin(usuario);

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
        UsuariosDao ud = new UsuariosDao();
        int count = ud.count(tipo);
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
        UsuariosDao ud = new UsuariosDao();
        List<Usuarios> result = ud.search(searchTerm, tipo);

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
        UsuariosDao ud = new UsuariosDao();
        boolean valido = ud.validaPermissao(tela, usuario, tipo_permissao);

        if (valido)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Acesso autorizado.", 1).toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Acesso negado.", 0).toJson();
    }
}
