/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Armazens;
import repository.ArmazensRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class ArmazemDao
{

    private ArmazensRepository db = null;

    public ArmazemDao(boolean... autoCommitOrClose)
    {
        db = new ArmazensRepository();

        if (autoCommitOrClose != null)
            if (autoCommitOrClose.length > 0)
                db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public ArmazemDao(Session session)
    {
        db = new ArmazensRepository();
        db.setSession(session);
    }

    public void save(Armazens armazem)
    {
        if (db.exists(Armazens.class, "id", armazem.getId()))
            db.update(armazem);
        else
            db.save(armazem);
    }

    public void delete(Armazens armazem)
    {
        db.delete(armazem);
    }

    public Armazens find(int id)
    {
        return db.find(Armazens.class, id);
    }

    public void commit()
    {
        db.commit(true);
    }

    public List<Armazens> search(String searchTerm, int empresa_id)
    {
        List<Armazens> result;

        result = (searchTerm.isEmpty()
                ? db.listAll(empresa_id)
                : db.search(searchTerm, empresa_id));

        return result;
    }

    public boolean podeExcluir(int id)
    {
        return db.podeExcluir(id);
    }
    
    public String getMessage()
    {
        return db.getMessage();
    }
}
