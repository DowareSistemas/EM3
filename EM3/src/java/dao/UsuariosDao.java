/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Usuarios;
import repository.UsuariosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class UsuariosDao
{

    private UsuariosRepository db = null;

    public UsuariosDao(boolean... autoCommitOrClose)
    {
        db = new UsuariosRepository();
        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }

    public UsuariosDao(Session session)
    {
        db = new UsuariosRepository();
        db.setSession(session);
    }

    public Usuarios last()
    {
        return db.last(Usuarios.class);
    }
    
    public Session getSession()
    {
        return db.getSession();
    }

    public void commit()
    {
        db.commit(true);
    }

    public Usuarios find(int id)
    {
        return db.find(Usuarios.class, id);
    }

    public void save(Usuarios usuario)
    {
        if (db.exists(Usuarios.class, "id", usuario.getId()))
            db.update(usuario);
        else
            db.save(usuario);
    }

    public void delete(Usuarios usuario)
    {
        db.delete(usuario);
    }

    public Usuarios efetuaLogin(Usuarios usuario)
    {
        return db.efetuaLogin(usuario);
    }

    public int count(int tipo)
    {
        return db.count(tipo);
    }

    public List<Usuarios> search(String searchTerm, int tipo)
    {
        List<Usuarios> result;

        if (searchTerm.isEmpty())
            result = db.getAll();
        else
            result = db.search(searchTerm, tipo);
       
        return result;
    }
    
    public boolean validaPermissao(String tela, int usuario, int permissao)
    {
        return db.validaPermissao(tela, usuario, permissao);
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
