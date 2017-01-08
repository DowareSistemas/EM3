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
import model.Operadoras_cartao;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Operadoras_cartaoRepository extends RepositoryImpl<Operadoras_cartao>
{
    public List<Operadoras_cartao> listAll()
    {
        Operadoras_cartao op = new Operadoras_cartao();
        
        Session session = SessionProvider.openSession();
        session.createCriteria(op, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();
        
        return session.getList(op);
    }
    
    public List<Operadoras_cartao> search(String searchTerm)
    {
        Operadoras_cartao oc = new Operadoras_cartao();
        
        Session session = SessionProvider.openSession();
        session.createCriteria(oc, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.like(FILTER_TYPE.WHERE, "nome", searchTerm, MATCH_MODE.ANYWHERE))
                .execute();
        session.close();
        
        return session.getList(oc);
    }
}
