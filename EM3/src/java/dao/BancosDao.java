/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Bancos;
import repository.BancosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class BancosDao
{
    private BancosRepository db = null;
    
    public BancosDao(boolean... autoCommitOrClose)
    {
       db = new BancosRepository();
       if(autoCommitOrClose.length > 0)
           db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public BancosDao(Session session)
    {
        db = new BancosRepository();
        db.setSession(session);
    }
    
    public Session getSession()
    {
        return db.getSession();
    }
    
    public void commit()
    {
        db.commit(true);
    }
    
    public List<Bancos> search(String searchTerm)
    {
        return (searchTerm.isEmpty()
                ? db.listAll()
                : db.search(searchTerm));
    }
}
