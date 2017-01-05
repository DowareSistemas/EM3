/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Unidades;
import repository.UnidadesRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class UnidadesDao
{

    private UnidadesRepository db = null;

    public UnidadesDao(boolean... autoCommitOrClose)
    {
        db = new UnidadesRepository();
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public UnidadesDao(Session session)
    {
        db = new UnidadesRepository();
        db.setSession(session);
    }

    public Session getSession()
    {
        return db.getSession();
    }

    public void save(Unidades unidade)
    {
        if (db.exists(Unidades.class, "id", unidade.getId()))
            db.update(unidade);
        else
            db.save(unidade);
    }
    
    public boolean exists(Unidades unidade)
    {
        return db.exists(Unidades.class, "id", unidade.getId());
    }
    
    public void delete(Unidades unidade)
    {
        db.delete(unidade);
    }

    public Unidades find(int id)
    {
        return db.find(Unidades.class, id);
    }

    public void commit()
    {
        db.commit(true);
    }

    public Unidades getBySigla(String sigla)
    {
        return db.getBySigla(sigla);
    }

    public List<Unidades> search(String searchTerm)
    {
        List<Unidades> unidades;
        if (searchTerm.isEmpty())
            unidades = db.getAll();
        else
            unidades = db.search(searchTerm);

        return unidades;
    }

    public boolean isValidDelete(int id)
    {
        return  db.isValidDelete(id);
    }
}
