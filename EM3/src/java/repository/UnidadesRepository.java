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
import interfaces.IUnidades;
import java.util.List;
import model.Produtos;
import model.Unidades;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class UnidadesRepository extends Repository<Unidades> implements IUnidades
{

    public List<Unidades> getAll()
    {
        Unidades unidades = new Unidades();

        Session session = SessionProvider.openSession();
        session.createCriteria(unidades, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();
        return session.getList(unidades);
    }

    public List<Unidades> search(String searchTerm)
    {
        searchTerm = searchTerm.replace("'", "");
        Unidades unidades = new Unidades();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(unidades, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "sigla", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "descricao", searchTerm, MATCH_MODE.ANYWHERE));
        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "id", Utility.tryParse(searchTerm)));
        c.execute();
        session.close();
        
        return session.getList(unidades);
    }

    public boolean isValidDelete(int id)
    {
        Produtos p = new Produtos();
        Session session = SessionProvider.openSession();
        session.createCriteria(p, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "unidade1", id))
                .add(Restrictions.eq(FILTER_TYPE.OR, "unidade2", id))
                .execute();
        session.close();
        
        return (!session.getList(p).isEmpty());
    }
}
