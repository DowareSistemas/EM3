/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Marcas;
import repository.MarcasRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class MarcasDao
{

    private MarcasRepository db = null;

    public MarcasDao(boolean... autoCommitOrClose)
    {
        db = new MarcasRepository();
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public MarcasDao(Session session)
    {
        db = new MarcasRepository();
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

    public void save(Marcas marca)
    {
        if (db.exists(Marcas.class, "id", marca.getId()))
            db.update(marca);
        else
            db.save(marca);
    }

    public void delete(Marcas marca)
    {
        db.delete(marca);
    }

    public List<Marcas> search(String searchTerm)
    {
        return (searchTerm.isEmpty()
                ? db.listAll()
                : db.search(searchTerm));
    }

    public Marcas find(int id)
    {
        return db.find(Marcas.class, id);
    }
}
