/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Classes_imposto;
import repository.Classes_impostoRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Classe_impostoDao
{

    private Classes_impostoRepository db = null;

    public Classe_impostoDao(boolean... autoCommitOrClose)
    {
        db = new Classes_impostoRepository();
        
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public Classe_impostoDao(Session session)
    {
        db = new Classes_impostoRepository();
        db.setSession(session);
    }
    
    public void save(Classes_imposto ci)
    {
        if(db.exists(Classes_imposto.class, "id", ci.getId()))
            db.update(ci);
        else
            db.save(ci);
    }
    
    public Classes_imposto find(int id)
    {
        return db.find(Classes_imposto.class, id);
    }
    
    public void delete(Classes_imposto ci)
    {
        db.delete(ci);
    }
    
    public boolean podeExcluir(int id)
    {
        return db.podeExcluir(id);
    }
    
    public void commit()
    {
        db.commit(true);
    }
    
    public String getMessage()
    {
        return db.getMessage();
    }
    
    public List<Classes_imposto> search(String searchTerm)
    {
        List<Classes_imposto> result = (searchTerm.isEmpty()
                ? db.listAll()
                : db.search(searchTerm));
        
        return result;
    }
}
