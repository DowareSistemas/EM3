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
import java.util.List;
import model.Caracteristicas;
import model.Produtos;
import model.Produtos_caracteristicas;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Produtos_caracteristicaRepository extends RepositoryImpl<Produtos_caracteristicas>
{

    public List<Produtos_caracteristicas> listAll(int produto_id)
    {
        Produtos_caracteristicas pc = new Produtos_caracteristicas();
        Produtos prd = new Produtos();
        Caracteristicas caract = new Caracteristicas();
        
        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(pc, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, prd, "produtos_caracteristicas.produto_id = produtos.id");
        c.add(JOIN_TYPE.INNER, caract, "produtos_caracteristicas.caracteristica_id = caracteristicas.id");
        c.add(Restrictions.eq(FILTER_TYPE.WHERE, "produtos_caracteristicas.produto_id ", produto_id));
        c.execute();
        c.loadList(pc);
        c.loadList(prd);
        c.loadList(caract);
        session.close();
        
        List<Produtos_caracteristicas> l_pc = session.getList(pc);
        List<Produtos> l_prd = session.getList(prd);
        List<Caracteristicas> l_caract = session.getList(caract);
        
        for(int i = 0; i < l_pc.size(); i++)
        {
            l_pc.get(i).setProdutos(l_prd.get(i));
            l_pc.get(i).setCaracteristicas(l_caract.get(i));
        }
        
        return l_pc;
    }
}
