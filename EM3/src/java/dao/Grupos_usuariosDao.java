/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.persistor.interfaces.Session;
import java.util.List;
import java.util.List;
import model.Grupos_usuarios;
import repository.Grupos_usuariosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class Grupos_usuariosDao
{

    private Grupos_usuariosRepository db = null;

    public Grupos_usuariosDao(boolean... autoCommitOrClose)
    {
        db = new Grupos_usuariosRepository();

        if (autoCommitOrClose.length > 0)
            db.setAutoCommitOrClose(autoCommitOrClose[0]);
    }
    
    public Session getSession()
    {
        return db.getSession();
    }

    public Grupos_usuariosDao(Session session)
    {
        db = new Grupos_usuariosRepository();
        db.setSession(session);
    }

    public void save(Grupos_usuarios grupo)
    {
        if (db.exists(Grupos_usuarios.class, "id", grupo.getClass()))
            db.update(grupo);
        else
            db.save(grupo);
    }

    public Grupos_usuarios find(int id)
    {
        return db.find(Grupos_usuarios.class, id);
    }

    public void delete(Grupos_usuarios grupo)
    {
        db.delete(grupo);
    }

    public void commit()
    {
        db.commit(true);
    }

    public List<Grupos_usuarios> search(String searchTerm)
    {
        List<Grupos_usuarios> result;

        if (searchTerm.isEmpty())
            result = db.listAll();
        else
            result = db.search(searchTerm);

        return result;
    }

    public boolean podeExcluir(int id)
    {
        return db.podeExcluir(id);
    }

    public String getMessage()
    {
        return db.getMessage();
    }

    public Grupos_usuarios findByUsuario(int usuario_id)
    {
        return db.findByUsuario(usuario_id);
    }
}
