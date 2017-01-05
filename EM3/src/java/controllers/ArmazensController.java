/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import dao.ArmazemDao;
import dao.EmpresaDao;
import java.util.List;
import javax.validation.Valid;
import model.Armazens;
import model.Empresa;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.ArmazensRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
@Scope(value = "request")
public class ArmazensController
{
    @RequestMapping(value = "armz-search", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm, @RequestParam(value = "empresa_id") int empresa_id)
    {
        ArmazemDao dao = new ArmazemDao();
        List<Armazens> result = dao.search(searchTerm, empresa_id);

        if (result.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, result.size() + " registros encontrados.", result).toJson();
    }

    @RequestMapping(value = "armz-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id)
    {
        ArmazemDao dao = new ArmazemDao(true);
        Armazens armazem = dao.find(id);

        if (armazem.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Registro não encontrado.", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "", armazem).toJson();
    }

    @RequestMapping(value = "armz-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@Valid Armazens armazem, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        EmpresaDao ed = new EmpresaDao(true);
        ArmazemDao ad = new ArmazemDao(true);

        if (armazem.getEmpresa_id() > 0)
            if ((ed.find(armazem.getEmpresa_id())).getId() == 0)
                return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "A empresa informada não foi localizada", "").toJson();

        ad.save(armazem);

        if (armazem.saved || armazem.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Armazém salvo.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o armazém. Acione o suporte Doware", "").toJson();
    }

    @RequestMapping(value = "armz-rem", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String remove(@RequestParam(value = "id") int id)
    {
        ArmazemDao ad = new ArmazemDao();
        Armazens armz = ad.find(id);

        if (armz.getId() == 0)
        {
            ad.commit();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, "Registro não encontrado.", "").toJson();
        }
        
        if (!ad.podeExcluir(id))
        {
            ad.commit();
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, ad.getMessage(), "").toJson();
        }
        
        ad.delete(armz);
        ad.commit();

        if (armz.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Armazém removido.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o armazém. Acione o suporte Doware.", "").toJson();
    }
}
