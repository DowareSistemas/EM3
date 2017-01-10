/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.TelasRepository;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
@Scope(value = "request")
public class TelasController
{

    TelasRepository db = new TelasRepository();

    @RequestMapping(value = "telas-list", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String listAll()
    {
        return new OperationResult(StatusRetorno.OPERACAO_OK, "", db.listAll()).toJson();
    }
}
