/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Empresa;
import repository.EmpresaRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class EmpresaDao
{

    private EmpresaRepository db = null;

    public EmpresaDao(boolean... autoCommitOrClose)
    {
        db = new EmpresaRepository();

        if (autoCommitOrClose != null)
            if (autoCommitOrClose.length > 0)
                db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public EmpresaDao(Session session, boolean... autoCommitOrClose)
    {
        db = new EmpresaRepository();

        if (autoCommitOrClose != null)
            if (autoCommitOrClose.length > 0)
                db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public void save(Empresa empresa)
    {
        if (db.exists(Empresa.class, "id", empresa.getId()))
            db.update(empresa);
        else
            db.save(empresa);
    }

    public void delete(Empresa empresa)
    {
        db.delete(empresa);
    }

    public Empresa find(int id)
    {
        return db.find(Empresa.class, id);
    }

    public void commit()
    {
        db.commit(true);
    }

    public List<Empresa> search(String searchTerm)
    {
        List<Empresa> empresas;
        if (searchTerm.isEmpty())
            empresas = db.getAll();
        else
            empresas = db.search(searchTerm);
        return empresas;
    }
}
