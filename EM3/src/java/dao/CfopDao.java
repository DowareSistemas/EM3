/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Cfop;
import repository.CFOPRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class CfopDao
{

    private CFOPRepository db = null;

    public CfopDao(boolean... autoCommitOrClose)
    {
        db = new CFOPRepository();
        if (autoCommitOrClose != null)
            if (autoCommitOrClose.length > 0)
                db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public CfopDao(Session session)
    {
        db = new CFOPRepository();
        db.setSession(session);
    }

    public void save(Cfop cfop)
    {
        if (db.exists(Cfop.class, "id", cfop.getId()))
            db.update(cfop);
        else
            db.save(cfop);
    }

    public Cfop find(int id)
    {
        return db.find(Cfop.class, id);
    }

    public void commit()
    {
        db.commit(true);
    }

    public List<Cfop> search(String searchTerm)
    {
        List<Cfop> result = (searchTerm.isEmpty()
                ? db.listAll()
                : db.search(searchTerm));

        return result;
    }
}
