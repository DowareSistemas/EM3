/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import dao.DocumentosDao;
import dao.EnderecosDao;
import dao.FornecedorDao;
import java.util.List;
import javax.validation.Valid;
import model.Fornecedores;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.FornecedoresRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
@Scope(value = "request")
public class FornecedoresController
{

    FornecedoresRepository db = new FornecedoresRepository();

    @RequestMapping(value = "forn-search")
    public @ResponseBody
    String search(@RequestParam(value = "query") String query)
    {
        FornecedorDao fd = new FornecedorDao();
        List<Fornecedores> fornecedores = fd.search(query);

        if (fornecedores.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, fornecedores.size() + " registros encontrados.", fornecedores).toJson();
    }

    @RequestMapping(value = "forn-del")
    public @ResponseBody
    String delete(@RequestParam(value = "id") int id)
    {
        FornecedorDao fd = new FornecedorDao();
        DocumentosDao dd = new DocumentosDao(fd.getSession());
        EnderecosDao ed = new EnderecosDao(fd.getSession());

        Fornecedores forn = fd.find(id);

        if (forn.getId() == 0)
        {
            fd.commit();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Fornecedor não localizado.", "").toJson();
        }

        dd.delete(forn.getDocumentos());
        ed.delete(forn.getEnderecos());
        fd.delete(forn);

        fd.commit();

        if (forn.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Fornecedor excluído.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o fornecedor. Acione o suporte Doware", "").toJson();
    }

    @RequestMapping(value = "forn-save")
    public @ResponseBody
    String save(@Valid Fornecedores fornecedor, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").toJson();

        FornecedorDao fd = new FornecedorDao(true);
        fd.save(fornecedor);

        if (fornecedor.saved || fornecedor.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Fornecedor salvo.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o fornecedor. Acione o suporte Doware", "").toJson();
    }

}
