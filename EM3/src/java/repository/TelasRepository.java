/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Telas;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class TelasRepository extends RepositoryImpl<Telas>
{
    public List<Telas> listAll()
    {
        Telas telas = new Telas();
        
        Session session = SessionProvider.openSession();
        session.createCriteria(telas, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();
        
        return session.getList(telas);
    }
}
