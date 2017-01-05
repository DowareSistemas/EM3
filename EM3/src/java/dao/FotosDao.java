/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import model.Fotos;
import repository.FotosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class FotosDao
{
    private FotosRepository db = null;
    
    public FotosDao(boolean... autoCommitOrClose)
    {
        db = new FotosRepository();
        
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public FotosDao(Session session)
    {
        db = new FotosRepository();
        db.setSession(session);
    }
    
    public void save(Fotos foto)
    {
        if(db.exists(Fotos.class, "id", foto.getId()))
            db.update(foto);
        else
            db.save(foto);
    }
    
    public Fotos find(int id)
    {
        return db.find(Fotos.class, id);
    }
    
    public void delete(Fotos foto)
    {
        db.delete(foto);
    }
    
    public void commit()
    {
        db.commit(true);
    }
}
