/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import interfaces.IGrupos_usuarios;
import model.Grupos_usuarios;
import model.Usuarios_grupos;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Grupos_usuariosRepository extends Repository<Grupos_usuarios> implements IGrupos_usuarios
{

    public Grupos_usuarios findByUsuario(int usuario_id)
    {
        Grupos_usuarios grupo = new Grupos_usuarios();
        Usuarios_grupos usuarios_grupos = new Usuarios_grupos();

        Session session = SessionProvider.openSession();

        ICriteria c = session.createCriteria(grupo, RESULT_TYPE.UNIQUE);
        c.add(JOIN_TYPE.INNER, usuarios_grupos, "usuarios_grupos.grupo_id = grupos.id");
        c.add(Restrictions.eq(FILTER_TYPE.WHERE, "usuario_id", usuario_id));
        c.execute();
        c.loadEntity(grupo);
        c.loadEntity(usuarios_grupos);

        session.close();
        
        return grupo;
    }
}
