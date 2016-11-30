/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import controllers.Utility;
import java.util.List;
import model.Grupos_usuarios;
import model.Usuarios;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Grupos_usuariosRepository
{
    
    private String message = "";

    public Grupos_usuarios findByUsuario(int usuario_id)
    {
        Grupos_usuarios grupo = new Grupos_usuarios();
        Usuarios usuarios = new Usuarios();

        Session session = SessionProvider.openSession();

        ICriteria c = session.createCriteria(grupo, RESULT_TYPE.UNIQUE);
        c.add(JOIN_TYPE.INNER, usuarios, "usuarios.grupo_usuarios_id = grupos_usuarios.id");
        c.add(Restrictions.eq(FILTER_TYPE.WHERE, "usuarios.id", usuario_id));
        c.execute();
        c.loadEntity(grupo);
        c.loadEntity(usuarios);

        session.close();
        return grupo;
    }

    public List<Grupos_usuarios> listAll()
    {
        Grupos_usuarios grupos_usuarios = new Grupos_usuarios();

        Session session = SessionProvider.openSession();
        session.createCriteria(grupos_usuarios, RESULT_TYPE.MULTIPLE)
                .execute();
        session.close();

        return session.getList(grupos_usuarios);
    }

    public List<Grupos_usuarios> search(String searchTerm)
    {
        searchTerm = searchTerm.replace("'", "");

        Grupos_usuarios grupos_usuarios = new Grupos_usuarios();
        Session session = SessionProvider.openSession();

        ICriteria c = session.createCriteria(grupos_usuarios, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "nome", searchTerm, MATCH_MODE.ANYWHERE));

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "id", Utility.tryParse(searchTerm)));

        c.execute();
        session.close();

        return session.getList(grupos_usuarios);
    }

    public boolean podeExcluir(int grupo_id)
    {
        boolean result = true;
        Session session = SessionProvider.openSession();

        if(session.count(Usuarios.class, "grupo_usuarios_id = " + grupo_id) > 0)
        {
            message = "Não é possível excluir este grupo de usuários. Existem um ou mais usuários relacionados a ele.";
            result = false;
        }

        session.close();
        return result;
    }

    public String getMessage()
    {
        return message;
    }
}
