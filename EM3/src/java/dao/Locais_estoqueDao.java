/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Locais_estoque;
import repository.Locais_estoqueRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Locais_estoqueDao
{

    private Locais_estoqueRepository db = null;

    public Locais_estoqueDao(boolean... autoCommitOrClose)
    {
        db = new Locais_estoqueRepository();

        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public Locais_estoqueDao(Session session)
    {
        db = new Locais_estoqueRepository();
        db.setSession(session);
    }

    public Session getSession()
    {
        return db.getSession();
    }

    public void save(Locais_estoque local)
    {
        if (db.exists(Locais_estoque.class, "id", local.getId()))
            db.update(local);
        else
            db.save(local);
    }

    public void delete(Locais_estoque local)
    {
        db.delete(local);
    }

    public void commit()
    {
        db.commit(true);
    }

    public List<Locais_estoque> search(String searchTerm)
    {
        List<Locais_estoque> result;
        if (searchTerm.isEmpty())
            result = db.listAll();
        else
            result = db.search(searchTerm);

        return result;
    }

    public Locais_estoque find(int id)
    {
        return db.find(Locais_estoque.class, id);
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
