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
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import controllers.Utility;
import java.util.List;
import model.Bancos;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class BancosRepository extends RepositoryImpl<Bancos>
{

    public List<Bancos> listAll()
    {
        Bancos bancos = new Bancos();
        Session session = SessionProvider.openSession();
        session.createCriteria(bancos, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();

        return session.getList(bancos);
    }

    public List<Bancos> search(String searchTerm)
    {
        Bancos bancos = new Bancos();
        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(bancos, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "nome", searchTerm, MATCH_MODE.ANYWHERE));
        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "numero", Utility.tryParse(searchTerm)));
        c.execute();
        session.close();

        return session.getList(bancos);
    }
}
