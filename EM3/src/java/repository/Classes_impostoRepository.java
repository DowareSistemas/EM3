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
import model.Classes_imposto;
import model.Operacoes_classe_imposto;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Classes_impostoRepository
{

    private String message = "";

    public String getMessage()
    {
        return this.message;
    }

    public List<Classes_imposto> listAll()
    {
        Classes_imposto classes_imposto = new Classes_imposto();

        Session session = SessionProvider.openSession();
        session.createCriteria(classes_imposto, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();

        return session.getList(classes_imposto);
    }

    public List<Classes_imposto> search(String searchTerm)
    {
        Classes_imposto classes_imposto = new Classes_imposto();
        Session session = SessionProvider.openSession();

        ICriteria c = session.createCriteria(classes_imposto, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "nome", searchTerm, MATCH_MODE.ANYWHERE));

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "id", Utility.tryParse(searchTerm)));

        c.execute();
        session.close();

        return session.getList(classes_imposto);
    }

    public boolean podeExcluir(int classe_imp_id)
    {
        Session session = SessionProvider.openSession();
        int countOpClImp = session.count(Operacoes_classe_imposto.class, "classe_imposto_id = " + classe_imp_id);
        session.close();

        if(countOpClImp > 0)
        {
            message = "Não é possível excluir esta classe de imposto. Existem uma ou mais operacoes relacionadas a ela.";
            return false;
        }
        
        return true;
    }
}
