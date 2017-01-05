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
import model.Empresa;
import model.Enderecos;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class EmpresaRepository extends RepositoryImpl<Empresa>
{
    public List<Empresa> getAll()
    {
        Empresa empresa = new Empresa();
        Enderecos endereco = new Enderecos();
        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(empresa, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, endereco, "empresa.endereco_id = enderecos.id");
        c.execute();
        c.loadList(empresa);
        c.loadList(endereco);

        session.close();

        List<Empresa> empresas = session.getList(empresa);
        List<Enderecos> enderecos = session.getList(endereco);

        for (int i = 0; i < empresas.size(); i++)
        {
            empresas.get(i).setEnderecos(enderecos.get(i));
        }

        return empresas;
    }

    public List<Empresa> search(String searchTerm)
    {
        searchTerm = searchTerm.replace("'", "");
        Empresa empresa = new Empresa();
        Enderecos endereco = new Enderecos();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(empresa, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, endereco, "empresa.endereco_id = enderecos.id");
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "razao_social", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "nome_fantasia", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "telefone1", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "telefone2", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "email", searchTerm, MATCH_MODE.ANYWHERE));
        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "empresa.id", Utility.tryParse(searchTerm)));
        c.execute();
        c.loadList(empresa);
        c.loadList(endereco);
        session.close();

        List<Empresa> empresas = session.getList(empresa);
        List<Enderecos> enderecos = session.getList(endereco);

        for (int i = 0; i < empresas.size(); i++)
        {
            empresas.get(i).setEnderecos(enderecos.get(i));
        }

        return empresas;
    }


}
