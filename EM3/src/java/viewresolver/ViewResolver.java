/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class ViewResolver
{
    @RequestMapping("/teste")
    public String teste()
    {
        return "forward:http://localhost:8080//mmnfretes/";
    }
    
    @RequestMapping("/inicio")
    public String inicio()
    {
        return "inicio/inicio";
    }
    
    @RequestMapping("/clientes")
    public String clientes()
    {
        return "clientes/visualizacao";
    }
    
    @RequestMapping("/dbconfig")
    public String dbConfig()
    {
        return "config/dbconfig";
    }
    
    @RequestMapping("/login")
    public String login()
    {
        return "login/login";
    }
}
