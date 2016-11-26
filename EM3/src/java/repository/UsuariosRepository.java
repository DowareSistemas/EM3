/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import controllers.Grupos_usuariosController;
import enums.TipoPermissao;
import interfaces.IUsuarios;
import model.Grupos_usuarios;
import model.Permissoes;
import model.Usuarios;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class UsuariosRepository extends Repository<Usuarios> implements IUsuarios
{

    public Usuarios efetuaLogin(Usuarios usuario)
    {
        Session session = SessionProvider.openSession();
        session.createCriteria(usuario, RESULT_TYPE.UNIQUE)
                .add(Restrictions.eq(FILTER_TYPE.WHERE, "nome", usuario.getNome()))
                .add(Restrictions.eq(FILTER_TYPE.AND, "senha", usuario.getSenha()))
                .execute();
        session.close();
        return usuario;
    }

    public boolean validaPermissao(String tela, int usuario, int tipo_permissao)
    {
        Grupos_usuarios grupo = Grupos_usuariosController.findByUsuario(usuario);
        Permissoes permissoes = new Permissoes();
        
        Session session = SessionProvider.openSession();
        
        ICriteria c = session.createCriteria(permissoes, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.eq(FILTER_TYPE.WHERE, "grupo_usuarios_id", grupo.getId()));
        c.add(Restrictions.eq(FILTER_TYPE.AND, "telas_id", tela));
        
        switch(tipo_permissao)
        {
            case TipoPermissao.ACESSO:
                
                c.add(Restrictions.eq(FILTER_TYPE.AND, "acesso", 1));
                break;
                
            case TipoPermissao.INSERIR:
                
                c.add(Restrictions.eq(FILTER_TYPE.AND, "inserir", 1));
                break;
                
            case TipoPermissao.ALTERAR:
                
                c.add(Restrictions.eq(FILTER_TYPE.AND, "atualizar", 1));
                break;
                
            case TipoPermissao.EXCLUIR:
                
                c.add(Restrictions.eq(FILTER_TYPE.AND, "excluir", 1));
                break;
        }
        
        c.execute();
        session.close();

        return (!session.getList(permissoes).isEmpty());
    }
}
