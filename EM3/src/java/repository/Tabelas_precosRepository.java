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
import br.com.persistor.sessionManager.Query;
import dao.ProdutosDao;
import java.math.BigDecimal;
import java.util.List;
import model.Formas_pagamento;
import model.Produtos;
import model.Produtos_precos;
import model.Tabelas_precos;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Tabelas_precosRepository extends RepositoryImpl<Tabelas_precos>
{

    /**
     *
     * @param tipo 0 - Apenas ativos; 1 - Apenas ativos; 2 - Todos
     * @return
     */
    public List<Tabelas_precos> listAll(int tipo)
    {
        Tabelas_precos tabelas = new Tabelas_precos();
        Formas_pagamento formas = new Formas_pagamento();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(tabelas, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, formas, "tabelas_precos.forma_pagamento_id = formas_pagamento.id");

        switch (tipo)
        {
            case 0: // apenas inativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "tabelas_precos.inativo", true));
                break;
            case 1: // apenas ativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "tabelas_precos.inativo", false));
                break;
            case 2:// todos
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "tabelas_precos.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.execute();
        c.loadList(tabelas);
        c.loadList(formas);
        session.close();

        List<Tabelas_precos> l_tabs = session.getList(tabelas);
        List<Formas_pagamento> l_formas = session.getList(formas);

        for (int i = 0; i < l_tabs.size(); i++)
        {
            l_tabs.get(i).setFormas_pagamento(l_formas.get(i));
        }

        return l_tabs;
    }

    /**
     *
     * @param tipo 0 - Apenas ativos; 1 - Apenas ativos; 2 - Todos
     * @return
     */
    public List<Tabelas_precos> search(String searchTerm, int tipo)
    {
        Tabelas_precos tabelas = new Tabelas_precos();
        Formas_pagamento formas = new Formas_pagamento();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(tabelas, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, formas, "tabelas_precos.forma_pagamento_id = formas_pagamento.id");
        switch (tipo)
        {
            case 0: // apenas inativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "tabelas_precos.inativo", true));
                break;
            case 1: // apenas ativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "tabelas_precos.inativo", false));
                break;
            case 2:// todos
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "tabelas_precos.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }
        c.add(Restrictions.like(FILTER_TYPE.AND, "nome", searchTerm, MATCH_MODE.ANYWHERE));
        c.execute();
        c.loadList(tabelas);
        c.loadList(formas);
        session.close();

        List<Tabelas_precos> l_tabs = session.getList(tabelas);
        List<Formas_pagamento> l_formas = session.getList(formas);

        for (int i = 0; i < l_tabs.size(); i++)
        {
            l_tabs.get(i).setFormas_pagamento(l_formas.get(i));
        }

        return l_tabs;
    }

    public BigDecimal getPreco(int produto_id, String uf, double faixa, int unidade_id, int tabela_id)
    {
        if (tabela_id == 0)
            return new BigDecimal("0.00");

        Produtos_precos pp = new Produtos_precos();

        ProdutosDao pd = new ProdutosDao(true);
        Produtos p = pd.find(produto_id);

        if (p.getUnidade1() == unidade_id && p.getUnidade2() > 0)
            faixa = (faixa * p.getFator_conversao());

        String query = "select * from produtos_precos\n"
                + "where \n"
                + "tabela_id = ? and\n"
                + "produto_id = ? and\n"
                + "faixa >= ?\n";

        if (uf != null)
        {
            if (!uf.isEmpty())
                query += " and uf = ?";
        }

        query += "order by faixa asc";;

        Session session = SessionProvider.openSession();
        Query q = session.createQuery(pp, query);

        q.setParameter(1, tabela_id);
        q.setParameter(2, produto_id);
        q.setParameter(3, faixa);

        if (uf != null)
        {
            if (!uf.isEmpty())
                q.setParameter(4, uf);
        }

        q.setResult_type(RESULT_TYPE.UNIQUE);
        q.execute();
        session.close();

        return pp.getValor();
    }

    private String message = "";

    public String getMessage()
    {
        return message;
    }

    public boolean podeExcluir(int id)
    {
        Session session = SessionProvider.openSession();
        int countPrecos = session.count(Produtos_precos.class, "tabela_id = " + id);
        session.close();

        if (countPrecos > 0)
            message = "Não é possível excluir esta tabela de preços. Existem um ou mais produtos relacionados a ela";

        return (countPrecos == 0);
    }
}
