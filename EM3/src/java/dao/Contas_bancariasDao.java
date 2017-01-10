/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Contas_bancarias;
import repository.Contas_bancariasRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Contas_bancariasDao
{
    private Contas_bancariasRepository db = null;
    
    public Contas_bancariasDao(boolean... autoCommitOrClose)
    {
        db = new Contas_bancariasRepository();
        if(autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public Contas_bancariasDao(Session session)
    {
        db = new Contas_bancariasRepository();
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
    
    public void save(Contas_bancarias conta)
    {
        if(db.exists(Contas_bancarias.class, "id", conta.getId()))
            db.update(conta);
        else
            db.save(conta);
    }
    
    public void delete(Contas_bancarias conta)
    {
        db.delete(conta);
    }
    
    public Contas_bancarias find(int id)
    {
        return db.find(Contas_bancarias.class, id);
    }
    
    public List<Contas_bancarias> search(String searchTerm, int tipo)
    {
        return (searchTerm.isEmpty()
                ? db.listAll(tipo)
                : db.search(searchTerm, tipo));
    }
}
