/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.validation.Valid;
import model.Fornecedores;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.FornecedoresRepository;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class FornecedoresController
{

    static FornecedoresRepository db = new FornecedoresRepository();

    @RequestMapping(value = "forn-search")
    public static @ResponseBody
    String search(@RequestParam(value = "query") String query)
    {
        List<Fornecedores> fornecedores;

        if (query.isEmpty())
            fornecedores = db.getAll();
        else
            fornecedores = db.search(query);

        if (fornecedores.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").getJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, fornecedores.size() + " registros encontrados.", fornecedores).getJson();
    }
    
    @RequestMapping(value = "forn-del")
    public static @ResponseBody
    String delete(@RequestParam(value = "id") int id)
    {
        Fornecedores forn = db.get(Fornecedores.class, id);
        if(forn.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Fornecedor não localizado.", "").getJson();
        
        DocumentosController.delete(forn.getDocumentos(), db.getCurrentSession());
        EnderecosController.delete(forn.getEnderecos(), db.getCurrentSession());
        db.remove(forn);
        db.commit(true);
        
        if(forn.deleted)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Fornecedor excluído.", "").getJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao excluir o fornecedor. Acione o suporte Doware", "").getJson();
    }

    @RequestMapping(value = "forn-save")
    public static @ResponseBody
    String save(@Valid Fornecedores fornecedor, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").getJson();

        if (db.exists(Fornecedores.class, "id", fornecedor.getId()))
            db.merge(fornecedor);
        else
            db.add(fornecedor);

        db.commit(true);

        if (fornecedor.saved || fornecedor.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Fornecedor salvo.", "").getJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar o fornecedor. Acione o suporte Doware", "").getJson();
    }

}
