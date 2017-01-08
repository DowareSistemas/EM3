/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Operadoras_cartao;
import repository.Operadoras_cartaoRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Operadoras_cartaoDao
{

    private Operadoras_cartaoRepository db = null;

    public Operadoras_cartaoDao(boolean... autoCommitOrClose)
    {
        db = new Operadoras_cartaoRepository();
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public Operadoras_cartaoDao(Session session)
    {
        db = new Operadoras_cartaoRepository();
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

    public void save(Operadoras_cartao operadora)
    {
        if (db.exists(Operadoras_cartao.class, "id", operadora.getId()))
            db.update(operadora);
        else
            db.save(operadora);
    }

    public void delete(Operadoras_cartao operadora)
    {
        db.delete(operadora);
    }

    public Operadoras_cartao find(int id)
    {
        return db.find(Operadoras_cartao.class, id);
    }

    public List<Operadoras_cartao> search(String searchTerm)
    {
        return (searchTerm.isEmpty()
                ? db.listAll()
                : db.search(searchTerm));
    }
}
