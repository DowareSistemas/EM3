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
import model.Grupos_produtos;
import model.Produtos;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Grupos_produtoRepository
{

    String message = "";

    public String getMessage()
    {
        return this.message;
    }

    public List<Grupos_produtos> listAll(int tipo)
    {
        Grupos_produtos grupos = new Grupos_produtos();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(grupos, RESULT_TYPE.MULTIPLE);

        switch (tipo)
        {
            case 1:
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "inativo", 0));
                break;

            case 2:
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "inativo", 1));
                break;
        }

        c.execute();
        session.close();

        return session.getList(grupos);
    }

    public List<Grupos_produtos> search(String searchTerm, int tipo)
    {
        searchTerm = searchTerm.replace("'", "");
        Grupos_produtos grupos = new Grupos_produtos();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(grupos, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "descricao", searchTerm, MATCH_MODE.ANYWHERE));

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "id", Utility.tryParse(searchTerm)));

        switch (tipo)
        {
            case 1:
                c.add(Restrictions.eq(FILTER_TYPE.AND, "inativo", 0));
                break;

            case 2:
                c.add(Restrictions.eq(FILTER_TYPE.AND, "inativo", 1));
                break;
        }

        c.execute();
        session.close();

        return session.getList(grupos);
    }

    public boolean podeExcluir(int id)
    {
        Produtos produtos = new Produtos();

        Session session = SessionProvider.openSession();
        session.createCriteria(produtos, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "grupo_produtos_id", id))
                .execute();
        session.close();

        if (!session.getList(produtos).isEmpty())
        {
            message = "Não é possível excluir este grupo. Existem um ou mais produtos relacionados a ele.";
            return false;
        }
        return true;
    }
}
