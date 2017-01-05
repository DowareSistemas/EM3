/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import model.Enderecos;
import repository.EnderecosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class EnderecosDao
{
    private EnderecosRepository db = null;
    
    public EnderecosDao(boolean... autoCommitOrClose)
    {
        db = new EnderecosRepository();
        
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public EnderecosDao(Session session)
    {
        db = new EnderecosRepository();
        db.setSession(session);
    }
    
    public void save(Enderecos endereco)
    {
        if(db.exists(Enderecos.class, "id", endereco))
            db.update(endereco);
        else
            db.save(endereco);
    }
    
    public void delete(Enderecos endereco)
    {
        db.delete(endereco);
    }
    
    public Enderecos find(int id)
    {
        return db.find(Enderecos.class, id);
    }
    
    public void commit()
    {
        db.commit(true);
    }
}
