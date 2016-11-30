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
import model.Caracteristicas;
import model.Produtos;
import model.Produtos_caractetisticas;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class CaracteristicasRepository
{
    private String message = "";

    public List<Caracteristicas> getAll()
    {
        Caracteristicas carac = new Caracteristicas();

        Session session = SessionProvider.openSession();
        session.createCriteria(carac, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();

        return session.getList(carac);
    }

    public List<Caracteristicas> search(String searchTerm)
    {
        searchTerm = searchTerm.replace("'", "");
        
        Caracteristicas carac = new Caracteristicas();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(carac, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "atributo", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "valor", searchTerm, MATCH_MODE.ANYWHERE));
        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "id", Utility.tryParse(searchTerm)));
        c.execute();
        session.close();
        
        return session.getList(carac);
    }

    public boolean podeExcluir(int id)
    {
        Produtos_caractetisticas pc = new Produtos_caractetisticas();
        
        Session session = SessionProvider.openSession();
        session.createCriteria(pc, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "caracteristica_id", id))
                .execute();
        session.close();
        
        if(!pc.ResultList.isEmpty())
        {
            message = "Não é possível excluir esta característica. Existem um ou mais produtos relacionados a ela.";
            return false;
        }
        
        return true;
    }

    public String getMessage()
    {
      return message;
    }
}
