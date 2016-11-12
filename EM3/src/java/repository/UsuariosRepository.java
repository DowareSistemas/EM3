/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.Session;
import interfaces.IUsuarios;
import java.util.List;
import model.Usuarios;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class UsuariosRepository extends Repository<Usuarios> implements IUsuarios
{

    public boolean efetuaLogin(Usuarios usuario)
    {
        Session session = SessionProvider.openSession();
        List<Usuarios> result = session.createCriteria(usuario, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "nome", usuario.getNome()))
                .add(Restrictions.eq(FILTER_TYPE.AND, "senha", usuario.getSenha()))
                .execute()
                .loadList(usuario);
        session.close();
        return (!result.isEmpty());
    }

}
