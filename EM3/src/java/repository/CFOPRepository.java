/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.ORDER_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import controllers.Utility;
import interfaces.IRepository;
import java.util.List;
import model.Cfop;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class CFOPRepository extends RepositoryImpl<Cfop>
{

    public List<Cfop> listAll()
    {
        Cfop cfop = new Cfop();

        Session session = SessionProvider.openSession();
        session.createCriteria(cfop, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.OrderBy("id", ORDER_MODE.ASC))
                .execute();
        session.close();

        return session.getList(cfop);
    }

    public List<Cfop> search(String searchTerm)
    {
        Cfop cfop = new Cfop();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(cfop, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "descricao", searchTerm, MATCH_MODE.ANYWHERE));

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "id", Utility.tryParse(searchTerm)));
        c.add(Restrictions.OrderBy("id", ORDER_MODE.ASC));
        c.execute();
        session.close();
        
        return session.getList(cfop);
    }
}
