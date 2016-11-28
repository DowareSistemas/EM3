/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import model.Permissoes;
import org.springframework.stereotype.Controller;
import repository.PermissoesRepository;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class PermissoesController
{

    static PermissoesRepository db = new PermissoesRepository();

    public static boolean removeAll(Session session, String whereCondition)
    {
        Permissoes permissoes = new Permissoes();
        db.remove(permissoes, session, whereCondition);

        return (permissoes.deleted);
    }
}
