/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.validation.Valid;
import model.Grupos_usuarios;
import model.Permissoes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.Grupos_usuariosRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Grupos_usuariosController
{

    Grupos_usuariosRepository db = new Grupos_usuariosRepository();

    public Grupos_usuarios findByUsuario(int usuario_id)
    {
        return db.findByUsuario(usuario_id);
    }

    @RequestMapping(value = "/gusr-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        List<Grupos_usuarios> result;

        if (searchTerm.isEmpty())
            result = db.listAll();
        else
            result = db.search(searchTerm);

        if (result.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados", result).toJson();
    }

    @RequestMapping(value = "/gusr-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Grupos_usuarios gu = session.onID(Grupos_usuarios.class, id);
        session.close();

        if (gu.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Grupo não encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo encontrado.", gu).toJson();
    }

    @RequestMapping(value = "/gusr-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Grupos_usuarios grupo, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Session session  = SessionProvider.openSession();
        
        if (Utility.exists(Grupos_usuarios.class, "id", grupo.getId()))
            session.update(grupo);
        else
            session.save(grupo);

        session.commit();
        session.close();

        if (grupo.saved || grupo.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo salvo com sucesso.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o grupo. Acione o suporte Doware", "").toJson();
    }

    @RequestMapping(value = "/gusr-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String delete(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        Grupos_usuarios grupo = session.onID(Grupos_usuarios.class, id);

        if (grupo.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Grupo de usuários não localizado.", "").toJson();

        if (!db.podeExcluir(grupo.getId()))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, db.getMessage(), "").toJson();

        if (new PermissoesController().removeAll(session, "grupo_usuarios_id = " + id))
        {
            session.delete(grupo);
            session.commit();
            session.close();
        }

        if (grupo.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo de usuários excluído", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluír o grupo de usuários. Acione o suporte Doware", "").toJson();
    }
}
