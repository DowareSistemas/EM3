/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.enums.COMMIT_MODE;
import br.com.persistor.interfaces.Session;
import br.com.persistor.sessionManager.Query;
import java.util.List;
import model.Produtos_caracteristicas;
import repository.Produtos_caracteristicaRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Produto_caracteristicaDao
{

    private Produtos_caracteristicaRepository db = null;

    public Produto_caracteristicaDao(boolean... autoCommitOrClose)
    {
        db = new Produtos_caracteristicaRepository();
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public Produto_caracteristicaDao(Session session)
    {
        db = new Produtos_caracteristicaRepository();
        db.setSession(session);
    }
    
    public void add(Produtos_caracteristicas pc)
    {
        db.save(pc);
    }
    
    public void removeAll(int produto_id)
    {
        Produtos_caracteristicas pc = new Produtos_caracteristicas();
        Query q = db.getSession().createQuery(pc, "delete from produtos_caracteristicas where produto_id = ?");
        
        q.setParameter(1, produto_id);
        
        q.setCloseSessionAfterExecute(true);
        q.setCommit_mode(COMMIT_MODE.AUTO);
        q.execute();
    }
    
    public List<Produtos_caracteristicas> listAll(int produto_id)
    {
        return db.listAll(produto_id);
    }
}
