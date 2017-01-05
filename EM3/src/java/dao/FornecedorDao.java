/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Fornecedores;
import repository.FornecedoresRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class FornecedorDao
{

    private FornecedoresRepository db = null;

    public FornecedorDao(boolean... autoCommitOrClose)
    {
        db = new FornecedoresRepository();

        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public Session getSession()
    {
        return db.getSession();
    }
    
    public FornecedorDao(Session session)
    {
        db = new FornecedoresRepository();
        db.setSession(session);
    }

    public void save(Fornecedores fornecedor)
    {
        if (db.exists(Fornecedores.class, "id", fornecedor.getId()))
            db.update(fornecedor);
        else
            db.save(fornecedor);
    }

    public Fornecedores find(int id)
    {
        return db.find(Fornecedores.class, id);
    }

    public void delete(Fornecedores fornecedor)
    {
        db.delete(fornecedor);
    }

    public void commit()
    {
        db.commit(true);
    }

    public List<Fornecedores> search(String searchTerm)
    {
        List<Fornecedores> fornecedores;

        if (searchTerm.isEmpty())
            fornecedores = db.getAll();
        else
            fornecedores = db.search(searchTerm);

        return fornecedores;
    }
}
