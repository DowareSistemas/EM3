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
import model.Usuarios;
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
}
