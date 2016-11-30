/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import controllers.Utility;
import java.util.List;
import model.Armazens;
import model.Estoque;
import model.Locais_estoque;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Locais_estoqueRepository
{

    String message = "";

    public List<Locais_estoque> listAll()
    {
        Locais_estoque le = new Locais_estoque();
        Armazens armz = new Armazens();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(le, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, armz, "locais_estoque.armazem_id = armazens.id");
        c.execute();
        c.loadList(armz);
        c.loadList(le);
        session.close();

        List<Armazens> armazens = session.getList(armz);
        List<Locais_estoque> locais = session.getList(le);

        for (int i = 0; i < locais.size(); i++)
        {
            locais.get(i).setArmazens(armazens.get(i));
        }

        return locais;
    }

    public List<Locais_estoque> search(String searchTerm)
    {
        searchTerm = searchTerm.replace("'", "");
        Locais_estoque le = new Locais_estoque();
        Armazens armz = new Armazens();

        Session session = SessionProvider.openSession();

        ICriteria c = session.createCriteria(le, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, armz, "locais_estoque.armazem_id = armazens.id");
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "locais_estoque.nome", searchTerm, MATCH_MODE.ANYWHERE));

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "locais_estoque.id", Utility.tryParse(searchTerm)));

        c.execute();
        c.loadList(armz);
        c.loadList(le);

        session.close();

        List<Armazens> armazens = session.getList(armz);
        List<Locais_estoque> locais = session.getList(le);

        for (int i = 0; i < locais.size(); i++)
        {
            locais.get(i).setArmazens(armazens.get(i));
        }

        return locais;
    }

    public String getMessage()
    {
        return message;
    }

    public boolean podeExcluir(int local_estoque_id)
    {
        Estoque est = new Estoque();

        Session session = SessionProvider.openSession();
        session.createCriteria(est, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "local_estoque_id", local_estoque_id))
                .execute();
        session.close();

        if (!(session.getList(est).isEmpty()))
        {
            message = "Não é possível excluir este local de estoque. Existem um ou mais produtos relacionados a ele.";
            return false;
        }
        return true;
    }
}
