/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Estoque;
import repository.EstoqueRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class EstoqueDao
{

    private EstoqueRepository db = null;

    public EstoqueDao(boolean... autoCommitOrClose)
    {
        db = new EstoqueRepository();
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public EstoqueDao(Session session)
    {
        db = new EstoqueRepository();
        db.setSession(session);
    }

    public void commit()
    {
        db.commit(true);
    }

    public Session getSession()
    {
        return db.getSession();
    }

    public void save(Estoque estoque)
    {
        if (db.exists(Estoque.class, "id", estoque.getId()))
            db.update(estoque);
        else
            db.save(estoque);
    }

    public void delete(Estoque estoque)
    {
        db.delete(estoque);
    }
    
    public void delete(int produto_id)
    {
        db.deleteByProduto(produto_id, getSession());
    }

    public Estoque getEstoquePadrao(int produto_id)
    {
        return db.getEstoquePadrao(produto_id);
    }

    public Estoque findByLocal(String nomeLocal)
    {
        return db.findByLocal(nomeLocal);
    }

    public List<Estoque> listByLocal(int local_id)
    {
        return db.listByLocal(local_id);
    }

    public Estoque find(int id)
    {
        return db.find(Estoque.class, id);
    }
}
