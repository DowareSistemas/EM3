/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.persistor.generalClasses.Util;
/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Commons
{
    @RequestMapping(value = "serverdate", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String getServerDate()
    {
        return new OperationResult(StatusRetorno.OPERACAO_OK, Util.getDateTime(), "").toJson();
    }
}
