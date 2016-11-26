/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.Empresa;
import model.Enderecos;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.EmpresaRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class EmpresasController
{

    static EmpresaRepository db = new EmpresaRepository();

    @RequestMapping(value = "/emp-save", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String save(@Valid Empresa emp, BindingResult result)
    {
        if (result.hasErrors())
            return new OperationResult(StatusRetorno.FALHA_VALIDACAO, result.getFieldErrors().get(0).getDefaultMessage(), "").getJson();

        if (db.exists(Empresa.class, "id", emp.getId()))
            db.merge(emp);
        else
            db.add(emp);

        db.commit(true);

        if (emp.saved || emp.updated)
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Empresa salva", "").getJson();
        else
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a empresa. Acione o suporte Doware.", "").getJson();
    }

    @RequestMapping(value = "/emp-search", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String search(@RequestParam(value = "query") String searchTerm, HttpServletRequest request)
    {
        SessionProvider.setConfig(request);
        List<Empresa> empresas;

        if (searchTerm.isEmpty())
            empresas = db.getAll();
        else
            empresas = db.search(searchTerm);

        if (empresas.isEmpty())
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Nenhum registro encontrado", "").getJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, empresas.size() + " registros encontrados.", empresas).getJson();
    }

    @RequestMapping(value = "/emp-find", produces = "application/json; charset=utf-8")
    public static @ResponseBody
    String find(@RequestParam(value = "id") int id)
    {
        Empresa e = db.get(Empresa.class, id);
        db.close();

        if (e.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Empresa não localizada", "").getJson();
        else
            return new OperationResult(StatusRetorno.OPERACAO_OK, "Empresa encontrada", e).getJson();
    }
}
