/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import br.com.persistor.sessionManager.Query;
import controllers.Utility;
import java.util.List;
import model.Estoque;
import model.Produtos;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class EstoqueRepository extends RepositoryImpl<Estoque>
{

    public Estoque getEstoquePadrao(int produto_id)
    {
        Estoque estoque = new Estoque();

        Session session = SessionProvider.openSession();
        session.createCriteria(estoque, RESULT_TYPE.UNIQUE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "produto_id", produto_id))
                .add(Restrictions.eq(FILTER_TYPE.AND, "local_padrao", true))
                .execute();
        session.close();

        return estoque;
    }

    public List<Estoque> listAll(int produto_id)
    {
        Estoque estoque = new Estoque();

        Session session = SessionProvider.openSession();
        session.createCriteria(estoque, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();

        return session.getList(estoque);
    }

    public Estoque findByLocal(String nomeLocal)
    {
        Estoque e = new Estoque();

        String query
                = "select estoque.* from estoque "
                + "inner join locais_estoque on estoque.local_estoque_id = locais_estoque.id "
                + "where locais_estoque.nome = ?";
        if (Utility.tryParse(nomeLocal) > 0)
            query += " and or locais_estoque.id = ?";

        Session session = SessionProvider.openSession();
        Query q = session.createQuery(e, query);
        q.setParameter(1, nomeLocal);

        if (Utility.tryParse(nomeLocal) > 0)
            q.setParameter(2, (Utility.tryParse(nomeLocal)));

        q.setResult_type(RESULT_TYPE.UNIQUE);
        q.execute();
        session.close();

        return e;
    }

    public List<Estoque> listByLocal(int local_id)
    {
        Produtos produtos = new Produtos();
        Estoque estoque = new Estoque();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(estoque, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, produtos, "estoque.produto_id = produtos.id");
        c.add(Restrictions.eq(FILTER_TYPE.WHERE, "estoque.local_estoque_id", local_id));
        c.execute();
        session.close();
        c.loadList(produtos);
        c.loadList(estoque);
        
        List<Produtos> l_produtos = session.getList(produtos);
        List<Estoque> l_estoque = session.getList(estoque);
        
        for(int i = 0; i < l_estoque.size(); i++)
        {
            l_estoque.get(i).setProdutos(l_produtos.get(i));
        }
        
        return l_estoque;
    }

    public void deleteByProduto(int produto_id, Session session)
    {
        Estoque est = new Estoque();
        Query q =  session.createQuery(est, "delete from estoque where produto_id = ?");
        q.setParameter(1, produto_id);
        q.setCloseSessionAfterExecute(false);
        q.execute();
    }
}
