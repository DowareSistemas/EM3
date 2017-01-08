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
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "list-ufs", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String getListUfs()
    {
        List<String> ufs = new ArrayList<String>();

        ufs.add("AC");
        ufs.add("AL");
        ufs.add("AP");
        ufs.add("AM");
        ufs.add("BA");
        ufs.add("CE");
        ufs.add("DF");
        ufs.add("ES");
        ufs.add("GO");
        ufs.add("MA");
        ufs.add("MT");
        ufs.add("MS");
        ufs.add("MG");
        ufs.add("PR");
        ufs.add("PB");
        ufs.add("PA");
        ufs.add("PE");
        ufs.add("PI");
        ufs.add("RJ");
        ufs.add("RN");
        ufs.add("RS");
        ufs.add("RO");
        ufs.add("RR");
        ufs.add("SC");
        ufs.add("SE");
        ufs.add("SP");
        ufs.add("TO");
        
        return new OperationResult(StatusRetorno.OPERACAO_OK, "", ufs).toJson();
    }
}
