/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Limit;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.Session;
import br.com.persistor.sessionManager.Criteria;
import java.util.List;
import model.Ncm;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class NcmRepisitory extends RepositoryImpl<Ncm>
{

    public List<Ncm> listAll(int page)
    {
        Ncm ncm = new Ncm();

        Session session = SessionProvider.openSession();
        session.createCriteria(ncm, RESULT_TYPE.MULTIPLE)
                .addLimit(Limit.paginate(page, 300, "id"))
                .execute();
        session.close();

        return session.getList(ncm);
    }

    public List<Ncm> search(String searchTerm, int page)
    {
        Ncm ncm = new Ncm();

        Session session = SessionProvider.openSession();
        session.createCriteria(ncm, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.like(FILTER_TYPE.WHERE, "cod_ncm", searchTerm, MATCH_MODE.ANYWHERE))
                .add(Restrictions.like(FILTER_TYPE.OR, "nome_ncm", searchTerm, MATCH_MODE.ANYWHERE))
                .addLimit(Limit.paginate(page, 300, "id"))
                .execute();
        session.close();

        return session.getList(ncm);
    }
}
