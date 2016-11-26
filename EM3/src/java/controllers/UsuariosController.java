/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import model.Usuarios;
import org.springframework.stereotype.Controller;
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

    static UsuariosRepository db = new UsuariosRepository();

    @RequestMapping("/usr-save")
    public @ResponseBody
    String save(Usuarios usuario)
    {
        if (db.exists(Usuarios.class, "id", usuario.getId()))
            db.merge(usuario);
        else
            db.add(usuario);
        db.commit(true);

        if (usuario.saved || usuario.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Usuário salvo", "").getJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o usuário", "").getJson();
    }

    @RequestMapping("/usr-get")
    public static @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Usuarios u = db.get(Usuarios.class, id);
        db.close();

        if (u.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Usuário não localizado", "").getJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "", u).getJson();
    }

    @RequestMapping("/usr-rem")
    public static @ResponseBody
    String remove(int id)
    {
        Usuarios u = db.get(Usuarios.class, id);
        if (u.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Usuário não localizado", "").getJson();

        db.remove(u);
        db.commit(true);

        if (u.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Usuário excluido", "").getJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o usuário", "").getJson();
    }

    @RequestMapping(value = "/usr-login", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String login(Usuarios usuario, HttpServletRequest request)
    {
        SessionProvider.setConfig(request);
        usuario = db.efetuaLogin(usuario);

        if (usuario.getId() > 0)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "1", usuario).getJson();
        else
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Usuário ou senha incorretos", null).getJson();
    }

    @RequestMapping(value = "/usr-validperm", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String validaPermissao(
            @RequestParam(value = "tela") String tela,
            @RequestParam(value = "usuario") int usuario,
            @RequestParam(value = "tipo_permisao") int tipo_permissao)
    {
        boolean valido = db.validaPermissao(tela, usuario, tipo_permissao);

        if (valido)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Acesso autorizado.", 1).getJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Acesso negado.", 0).getJson();
    }
}
