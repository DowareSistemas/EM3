/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Permissoes;
import repository.PermissoesRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class PermissoesDao
{
    private PermissoesRepository db = null;
    
    public PermissoesDao (boolean... autoCommitOrClose)
    {
        db = new PermissoesRepository();
        
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public PermissoesDao(Session session)
    {
        db = new PermissoesRepository();
        db.setSession(session);
    }
    
    public void save(Permissoes permissao)
    {
        db.save(permissao);
    }
    
    public boolean removeAll(String whereCondition)
    {
        Permissoes p  = new Permissoes();
        db.delete(p, whereCondition);
        return p.deleted;
    }
    
    public void commit()
    {
        db.commit(true);
    }

    public List<Permissoes> listByGrupo(int grupo_id)
    {
        return db.listByGrupo(grupo_id);
    }
}
