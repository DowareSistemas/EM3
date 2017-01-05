/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import model.Documentos;
import repository.DocumentosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class DocumentosDao
{
    private DocumentosRepository db = null;
    
    public DocumentosDao(boolean... autoCommitOrClose)
    {
        db = new DocumentosRepository();
        
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public DocumentosDao(Session session)
    {
        db = new DocumentosRepository();
        db.setSession(session);
    }
    
    public void save(Documentos doc)
    {
        if(db.exists(Documentos.class, "id", doc.getId()))
            db.update(doc);
        else
            db.save(doc);
    }
    
    public void commit()
    {
        db.commit(true);
    }
    
    public Documentos find(int id)
    {
        return db.find(Documentos.class, id);
    }
    
    public void delete(Documentos doc)
    {
        db.delete(doc);
    }
}
