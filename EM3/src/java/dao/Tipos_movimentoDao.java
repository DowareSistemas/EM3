/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Tipos_movimento;
import repository.Tipos_movimentoRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Tipos_movimentoDao
{

    private Tipos_movimentoRepository db = null;

    public Tipos_movimentoDao(boolean... autoCommitOrClose)
    {
        db = new Tipos_movimentoRepository();

        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public Tipos_movimentoDao(Session session)
    {
        db = new Tipos_movimentoRepository();
        db.setSession(session);
    }

    public Session getSession()
    {
        return db.getSession();
    }

    public boolean podeExcluir(int id)
    {
        return db.podeExcluir(id);
    }
    
    public void delete(Tipos_movimento tipo)
    {
        db.delete(tipo);
    }

    public String getMessage()
    {
        return db.getMessage();
    }

    public void save(Tipos_movimento tipoMov)
    {
        if (db.exists(Tipos_movimento.class, "id", tipoMov.getId()))
            db.update(tipoMov);
        else
            db.save(tipoMov);
    }

    /**
     *
     * @param searchTerm termo de busca
     * @param tipo 0 - somente inativos; 1 - somente ativos; 2 - todos
     * @return
     */
    public List<Tipos_movimento> search(String searchTerm, int tipo)
    {
        List<Tipos_movimento> result;

        if (searchTerm.isEmpty())
            result = db.listAll(tipo);
        else
            result = db.search(searchTerm, tipo);

        return result;
    }

    public void commit()
    {
        db.commit(true);
    }

    public Tipos_movimento find(int id)
    {
        return db.find(Tipos_movimento.class, id);
    }
}
