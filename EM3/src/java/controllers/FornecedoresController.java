/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.validation.Valid;
import model.Fornecedores;
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
public class FornecedoresController
{

    FornecedoresRepository db = new FornecedoresRepository();

    @RequestMapping(value = "forn-search")
    public @ResponseBody
    String search(@RequestParam(value = "query") String query)
    {
        List<Fornecedores> fornecedores;

        if (query.isEmpty())
            fornecedores = db.getAll();
        else
            fornecedores = db.search(query);

        if (fornecedores.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").toJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, fornecedores.size() + " registros encontrados.", fornecedores).toJson();
    }

    @RequestMapping(value = "forn-del")
    public @ResponseBody
    String delete(@RequestParam(value = "id") int id)
    {
        Session session = SessionProvider.openSession();
        
        Fornecedores forn = session.onID(Fornecedores.class, id);
        if (forn.getId() == 0)
        {
            session.close();
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Fornecedor não localizado.", "").toJson();
        }
        
        new DocumentosController().delete(forn.getDocumentos(), session);
        new EnderecosController().delete(forn.getEnderecos(), session);
       
        session.delete(forn);
        session.commit();
        session.close();

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

        Session session = SessionProvider.openSession();
        
        if (Utility.exists(Fornecedores.class, "id", fornecedor.getId()))
           session.update(fornecedor);
        else
            session.save(fornecedor);

        session.commit();
        session.close();

        if (fornecedor.saved || fornecedor.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Fornecedor salvo.", "").toJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o fornecedor. Acione o suporte Doware", "").toJson();
    }

}
