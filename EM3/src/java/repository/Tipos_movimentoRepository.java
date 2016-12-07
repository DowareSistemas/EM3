/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Tipos_movimento;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Tipos_movimentoRepository
{

    private String message = "";

    public String getMessage()
    {
        return this.message;
    }

    public boolean podeExcluir(int id)
    {

        return true;
    }

    public List<Tipos_movimento> listAll()
    {
        Tipos_movimento tmv = new Tipos_movimento();

        Session session = SessionProvider.openSession();
        session.createCriteria(tmv, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();

        return session.getList(tmv);
    }

    public List<Tipos_movimento> search(String searchTerm)
    {
        Tipos_movimento tmv = new Tipos_movimento();

        Session session = SessionProvider.openSession();
        session.createCriteria(tmv, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.like(FILTER_TYPE.WHERE, "descricao", searchTerm, MATCH_MODE.ANYWHERE))
                .execute();
        session.close();

        return session.getList(tmv);
    }
}
