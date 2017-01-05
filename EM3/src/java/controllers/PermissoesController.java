/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.PermissoesDao;
import java.util.List;
import model.Permissoes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class PermissoesController
{

    @RequestMapping(value = "perms-add", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String add(Permissoes permissao)
    {
        PermissoesDao pd = new PermissoesDao(true);
        pd.save(permissao);

        if (permissao.saved)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Permissão incluida.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao adicionar a permissão. Acione o suporte Doware", "").toJson();
    }

    @RequestMapping(value = "perms-clear", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String clear(@RequestParam(value = "grupo_id") int grupo_id)
    {
        PermissoesDao pd = new PermissoesDao(true);

        if (pd.removeAll("grupo_usuarios_id = " + grupo_id))
            return new OperationResult(StatusRetorno.OPERACAO_OK, "OK", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao limpar as permissões para este grupo. Acione o supprte Doware", "").toJson();
    }

    @RequestMapping(value = "perms-listbygrupo", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listAll(@RequestParam(value = "grupo_id") int grupo_id)
    {
        PermissoesDao pd = new PermissoesDao();
        List<Permissoes> list = pd.listByGrupo(grupo_id);
        return new OperationResult(StatusRetorno.OPERACAO_OK, "", list).toJson();
    }
}
