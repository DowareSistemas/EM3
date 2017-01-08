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
import model.Cfop;
import model.Classes_imposto;
import model.Operacoes_classe_imposto;
import model.Tipos_movimento;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Operacoes_ClasseImpostoRepository extends RepositoryImpl<Operacoes_classe_imposto>
{

    public List<Operacoes_classe_imposto> listAll(int classe_imposto_id)
    {
        Operacoes_classe_imposto operacoes = new Operacoes_classe_imposto();
        Tipos_movimento tmvs = new Tipos_movimento();
        Classes_imposto classes = new Classes_imposto();
        Cfop cfop = new Cfop();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(operacoes, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, tmvs, "operacoes_classe_imposto.tipos_movimento_id = tipos_movimento.id");
        c.add(JOIN_TYPE.INNER, classes, "operacoes_classe_imposto.classe_imposto_id  = classes_imposto.id");
        c.add(JOIN_TYPE.INNER, cfop, "operacoes_classe_imposto.cfop_id = cfop.id");
        c.add(Restrictions.eq(FILTER_TYPE.WHERE, "classe_imposto_id", classe_imposto_id));
        c.execute();
        c.loadList(operacoes);
        c.loadList(tmvs);
        c.loadList(classes);
        c.loadList(cfop);
        session.close();
        
        List<Operacoes_classe_imposto> list_operacoes = session.getList(operacoes);
        List<Tipos_movimento> list_tmv = session.getList(tmvs);
        List<Classes_imposto> list_classes = session.getList(classes);
        List<Cfop> list_cfop = session.getList(cfop);
        
        for(int i = 0; i < list_operacoes.size(); i++)
        {
            list_operacoes.get(i).setTipos_movimento(list_tmv.get(i));
            list_operacoes.get(i).setClasses_imposto(list_classes.get(i));
            list_operacoes.get(i).setCfop(list_cfop.get(i));
        }
        
        return list_operacoes;
    }
}
