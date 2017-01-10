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
import model.Bancos;
import model.Contas_bancarias;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Contas_bancariasRepository extends RepositoryImpl<Contas_bancarias>
{

    public List<Contas_bancarias> search(String searchTerm, int tipo)
    {
        Contas_bancarias contas = new Contas_bancarias();
        Bancos bancos = new Bancos();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(contas, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, bancos, "contas_bancarias.banco_id = bancos.id");
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "contas_bancarias.nome", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "agencia", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "conta", searchTerm, MATCH_MODE.ANYWHERE));

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "contas_bancarias.id", Utility.tryParse(searchTerm)));

        switch (tipo)
        {
            case 0: //apenas inativos
                c.add(Restrictions.eq(FILTER_TYPE.AND, "contas_bancarias.inativo", true));
                break;
            case 1: //apenas ativos
                c.add(Restrictions.eq(FILTER_TYPE.AND, "contas_bancarias.inativo", false));
                break;
            case 2: //todos
                c.add(Restrictions.in(FILTER_TYPE.AND, "contas_bancarias.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.execute();
        session.close();
        c.loadList(contas);
        c.loadList(bancos);

        List<Contas_bancarias> list_contas = session.getList(contas);
        List<Bancos> list_bancos = session.getList(bancos);

        for (int i = 0; i < list_contas.size(); i++)
        {
            list_contas.get(i).setBancos(list_bancos.get(i));
        }

        return list_contas;
    }

    public List<Contas_bancarias> listAll(int tipo)
    {
        Contas_bancarias contas = new Contas_bancarias();
        Bancos bancos = new Bancos();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(contas, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, bancos, "contas_bancarias.banco_id = bancos.id");
        switch (tipo)
        {
            case 0: //apenas inativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "contas_bancarias.inativo", true));
                break;
            case 1: //apenas ativos
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "contas_bancarias.inativo", false));
                break;
            case 2: //todos
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "contas_bancarias.inativo", new String[]
                {
                    "0", "1"
                }));
                break;
        }

        c.execute();
        session.close();
        c.loadList(contas);
        c.loadList(bancos);

        List<Contas_bancarias> list_contas = session.getList(contas);
        List<Bancos> list_bancos = session.getList(bancos);

        for (int i = 0; i < list_contas.size(); i++)
        {
            list_contas.get(i).setBancos(list_bancos.get(i));
        }

        return list_contas;
    }

}
