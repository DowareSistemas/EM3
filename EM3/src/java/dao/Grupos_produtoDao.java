/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Grupos_produtos;
import repository.Grupos_produtoRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Grupos_produtoDao
{

    private Grupos_produtoRepository db = null;

    public Grupos_produtoDao(boolean... autoCommitOrClose)
    {
        db = new Grupos_produtoRepository();

        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public Grupos_produtoDao(Session session)
    {
        db = new Grupos_produtoRepository();
        db.setSession(session);
    }

    public void save(Grupos_produtos grupo)
    {
        if (db.exists(Grupos_produtos.class, "id", grupo.getId()))
            db.update(grupo);
        else
            db.save(grupo);
    }

    public void delete(Grupos_produtos grupo)
    {
        db.delete(grupo);
    }

    public void commit()
    {
        db.commit(true);
    }

    public List<Grupos_produtos> search(String searchTerm, int tipo)
    {
        List<Grupos_produtos> result = (searchTerm.isEmpty()
                ? db.listAll(tipo)
                : db.search(searchTerm, tipo));

        return result;
    }

    public Grupos_produtos find(int id)
    {
        return db.find(Grupos_produtos.class, id);
    }

    public Session getSession()
    {
        return db.getSession();
    }
}
