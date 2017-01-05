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
import interfaces.IRepository;
import java.util.List;
import model.Armazens;
import model.Empresa;
import model.Locais_estoque;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class ArmazensRepository extends RepositoryImpl<Armazens>
{

    private String message = "";
    
    public List<Armazens> listAll(int empresa_id)
    {
        Empresa empr = new Empresa();
        Armazens armz = new Armazens();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(armz, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, empr, "armazens.empresa_id = empresa.id");
        
        if(empresa_id > 0)
            c.add(Restrictions.eq(FILTER_TYPE.WHERE, "empresa.id", empresa_id));
        
        c.execute();
        c.loadList(empr);
        c.loadList(armz);
        session.close();

        List<Empresa> empresas = session.getList(empr);
        List<Armazens> armazens = session.getList(armz);

        for (int i = 0; i < armazens.size(); i++)
        {
            armazens.get(i).setEmpresa(empresas.get(i));
        }

        return armazens;
    }

    public List<Armazens> search(String searchTerm, int empresa_id)
    {
        searchTerm = searchTerm.replace("'", "");

        Empresa empr = new Empresa();
        Armazens armz = new Armazens();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(armz, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.LEFT, empr, "armazens.empresa_id = empresa.id");
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "armazens.nome", searchTerm, MATCH_MODE.ANYWHERE));
        
        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "armazens.id", Utility.tryParse(searchTerm)));
        
        if(empresa_id > 0)
            c.add(Restrictions.eq(FILTER_TYPE.AND, "empresa.id", empresa_id));
        
        c.execute();
        c.loadList(empr);
        c.loadList(armz);
        session.close();

        List<Empresa> empresas = session.getList(empr);
        List<Armazens> armazens = session.getList(armz);

        for (int i = 0; i < armazens.size(); i++)
        {
            armazens.get(i).setEmpresa(empresas.get(i));
        }

        return armazens;
    }

    public boolean podeExcluir(int id)
    {
        Locais_estoque le = new Locais_estoque();
        
        Session session = SessionProvider.openSession();
        session.createCriteria(le, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "armazem_id", id))
                .execute();
        session.close();

       if (!session.getList(le).isEmpty())
       {
           message = "Não é possível excluir este armazém. Existem um ou mais locais de estoque relacionados a ele.";
           return false;
       }
       return true;
    }

    public String getMessage()
    {
        return this.message;
    }
}
