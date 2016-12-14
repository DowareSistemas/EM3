/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.validation.Valid;
import model.Operacoes_classe_imposto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "";
    }
    
}
