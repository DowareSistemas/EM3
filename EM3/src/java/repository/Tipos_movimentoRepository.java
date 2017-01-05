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
import model.Movimentos;
import model.Operacoes_classe_imposto;
import model.Tipos_movimento;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Tipos_movimentoRepository extends RepositoryImpl<Tipos_movimento>
{

    private String message = "";

    public String getMessage()
    {
        return this.message;
    }

    public boolean podeExcluir(int id)
    {
        Session session = SessionProvider.openSession();
        int countMov = session.count(Movimentos.class, "tipo_movimento_id = " + id);
        int countOperacoesClasseImp = session.count(Operacoes_classe_imposto.class, "tipos_movimento_id = " + id);
        session.close();
        
        if (countMov > 0)
        {
            message = "Não é possível excluir este tipo de movimento. Existem um ou mais movimentos relacionados a ele.";
            return false;
        }
        
        if(countOperacoesClasseImp > 0)
        {
            message = "Não é possível excluir este tipo de movimento. Existem uma ou mais operacoes de classe de imposto relacionadas e ele.";
            return false;
        }
        
        return true;
    }

    public List<Tipos_movimento> listAll(int tipo)
    {
        Tipos_movimento tmv = new Tipos_movimento();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(tmv, RESULT_TYPE.MULTIPLE);

        /**
         * Tipo 0 - somente inativos; Tipo 1 - somente ativos; Tipo 2 - ativos e
         * inativos;
         */
        switch (tipo)
        {
            case 0:
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "inativo", 1));
                break;

            case 1:
                c.add(Restrictions.eq(FILTER_TYPE.WHERE, "inativo", 0));
                break;

            case 2:
                c.add(Restrictions.in(FILTER_TYPE.WHERE, "inativo", new String[]
                {
                    "0", "1"
                }));
                break;

        }

        c.execute();
        session.close();

        return session.getList(tmv);
    }

    public List<Tipos_movimento> search(String searchTerm, int tipo)
    {
        Tipos_movimento tmv = new Tipos_movimento();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(tmv, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "descricao", searchTerm, MATCH_MODE.ANYWHERE));

        /**
         * Tipo 0 - somente inativos; Tipo 1 - somente ativos; Tipo 2 - ativos e
         * inativos;
         */
        switch (tipo)
        {
            case 0:
                c.add(Restrictions.eq(FILTER_TYPE.AND, "inativo", 1));
                break;

            case 1:
                c.add(Restrictions.eq(FILTER_TYPE.AND, "inativo", 0));
                break;

            case 2:
                c.add(Restrictions.in(FILTER_TYPE.AND, "inativo", new String[]
                {
                    "0", "1"
                }));
                break;

        }

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "id", Utility.tryParse(searchTerm)));
        
        c.execute();
        session.close();

        return session.getList(tmv);
    }
}
