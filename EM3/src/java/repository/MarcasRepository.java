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
import model.Marcas;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class MarcasRepository extends RepositoryImpl<Marcas>
{

    public List<Marcas> listAll()
    {
        Marcas marcas = new Marcas();

        Session session = SessionProvider.openSession();
        session.createCriteria(marcas, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();

        return session.getList(marcas);
    }

    public List<Marcas> search(String searchTerm)
    {
        Marcas marcas = new Marcas();

        Session session = SessionProvider.openSession();
        
        ICriteria c = session.createCriteria(marcas, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "nome", searchTerm, MATCH_MODE.ANYWHERE));
        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "id", Utility.tryParse(searchTerm)));
    
        c.execute();
        session.close();

        return session.getList(marcas);
    }
}
