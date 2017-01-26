/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Produtos_precos;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Produtos_precoRepository extends RepositoryImpl<Produtos_precos>
{

    public List<Produtos_precos> list(int produto_id, int tabela_id)
    {
        Produtos_precos pp = new Produtos_precos();

        Session session = SessionProvider.openSession();
        session.createCriteria(pp, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "produto_id", produto_id))
                .add(Restrictions.eq(FILTER_TYPE.AND, "tabela_id", tabela_id))
                .execute();
        session.close();

        return session.getList(pp);
    }

    public List<Produtos_precos> listByProduto(int produto_id, int tabela_ignorar)
    {
        Produtos_precos pp = new Produtos_precos();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(pp, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.eq(FILTER_TYPE.WHERE, "produto_id", produto_id));
        if(tabela_ignorar > 0)
            c.add(Restrictions.ne(FILTER_TYPE.AND, "tabela_id", tabela_ignorar));
        c.execute();
        session.close();

        return session.getList(pp);
    }

    public List<Produtos_precos> listByTabela(int tabela_id)
    {
        Produtos_precos pp = new Produtos_precos();

        Session session = SessionProvider.openSession();
        session.createCriteria(pp, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "tabela_id", tabela_id))
                .execute();
        session.close();

        return session.getList(pp);
    }
}
