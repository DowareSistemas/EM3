/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import model.Fornecedores;
import org.springframework.stereotype.Controller;
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
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").get();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, fornecedores.size() + " registros encontrados.", fornecedores).get();
    }

}
