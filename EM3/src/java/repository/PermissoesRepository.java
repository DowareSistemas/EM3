/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Permissoes;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class PermissoesRepository extends RepositoryImpl<Permissoes>
{

    public List<Permissoes> listByGrupo(int grupo_id)
    {
        Permissoes p = new Permissoes();
        
        Session session = SessionProvider.openSession();
        session.createCriteria(p, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "grupo_usuarios_id", grupo_id))
                .execute();
        session.close();

        return session.getList(p);
    }
}
