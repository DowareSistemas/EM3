/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Operacoes_ClasseImpostoDao;
import java.util.List;
import javax.validation.Valid;
import model.Operacoes_classe_imposto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Operacoes_classeImpController
{

    @RequestMapping(value = "oclimp-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Operacoes_classe_imposto opClimp, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        Operacoes_ClasseImpostoDao od = new Operacoes_ClasseImpostoDao();

        if (!od.exists(opClimp.getId()))
        {
            if (od.countByUf(opClimp.getUf(), opClimp.getClasse_imposto_id(), opClimp.getTipos_movimento_id()) > 0)
            {
                od.commit();
                return new OperationResult(
                        StatusRetorno.FALHA_VALIDACAO,
                        "Não é possível adicionar a operação. Já existe um operação para a UF '" + opClimp.getUf() + "' na classe de imposto '" + opClimp.getClasse_imposto_id() + "'", "").toJson();
            }
        }

        od.save(opClimp);
        od.commit();

        return (opClimp.saved || opClimp.updated
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Operação salva.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a operação. Acione o suporte Doware.", "").toJson());
    }

    @RequestMapping(value = "oclimp-listall", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listAll(@RequestParam(value = "classe_imposto_id") int classe_imposto_id)
    {
        List<Operacoes_classe_imposto> result = new Operacoes_ClasseImpostoDao().listAll(classe_imposto_id);

        return (result.isEmpty()
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados.", result).toJson());
    }

    @RequestMapping(value = "oclimp-find", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        Operacoes_ClasseImpostoDao od = new Operacoes_ClasseImpostoDao(true);
        Operacoes_classe_imposto operacao = od.find(id);

        return (operacao.getId() == 0
                ? new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson()
                : new OperationResult(StatusRetorno.OPERACAO_OK, "", operacao).toJson());
    }

    @RequestMapping(value = "oclimp-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        Operacoes_ClasseImpostoDao od = new Operacoes_ClasseImpostoDao();
        Operacoes_classe_imposto operacao = od.find(id);
        od.delete(operacao);
        od.commit();

        return (operacao.deleted
                ? new OperationResult(StatusRetorno.OPERACAO_OK, "Operação excluida.", "").toJson()
                : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir a operação. Acione o suporte Doware.", "").toJson());
    }
}
