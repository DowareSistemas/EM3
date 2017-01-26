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
import java.util.List;
import model.Formas_pagamento;
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
}
