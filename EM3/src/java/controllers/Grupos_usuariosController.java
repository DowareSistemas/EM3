/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import dao.Grupos_usuariosDao;
import dao.PermissoesDao;
import java.util.List;
import javax.validation.Valid;
import model.Grupos_usuarios;
import model.Permissoes;
import org.springframework.context.annotation.Scope;
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
@Scope(value = "request")
public class Grupos_usuariosController
{

    public Grupos_usuarios findByUsuario(int usuario_id)
    {
        Grupos_usuariosDao gd = new Grupos_usuariosDao(true);
        return gd.findByUsuario(usuario_id);
    }

    @RequestMapping(value = "/gusr-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm)
    {
        Grupos_usuariosDao gd = new Grupos_usuariosDao();
        List<Grupos_usuarios> result = gd.search(searchTerm);

        if (result.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados", result).toJson();
    }

    @RequestMapping(value = "/gusr-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        Grupos_usuariosDao gd = new Grupos_usuariosDao(true);
        Grupos_usuarios gu = gd.find(id);

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

        Grupos_usuariosDao gd = new Grupos_usuariosDao(true);
        gd.save(grupo);

        if (grupo.saved || grupo.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo salvo com sucesso.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o grupo. Acione o suporte Doware", "").toJson();
    }

    @RequestMapping(value = "/gusr-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String delete(@RequestParam(value = "id") int id)
    {
        Grupos_usuariosDao gd = new Grupos_usuariosDao();
        PermissoesDao pd = new PermissoesDao(gd.getSession());

        Grupos_usuarios grupo = gd.find(id);

        if (grupo.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Grupo de usuários não localizado.", "").toJson();

        if (!gd.podeExcluir(grupo.getId()))
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, gd.getMessage(), "").toJson();

        pd.removeAll("grupo_usuarios_id = " + id);
        gd.delete(grupo);
        gd.commit();

        if (grupo.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Grupo de usuários excluído", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluír o grupo de usuários. Acione o suporte Doware", "").toJson();
    }
}
