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
import controllers.Grupos_usuariosController;
import controllers.Utility;
import enums.TipoPermissao;
import java.util.List;
import model.Funcionarios;
import model.Grupos_usuarios;
import model.Movimentacoes_caixas;
import model.Movimentos;
import model.Permissoes;
import model.Usuarios;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class UsuariosRepository extends RepositoryImpl<Usuarios>
{

    private String message = "";

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
        Grupos_usuarios grupo = new Grupos_usuariosController().findByUsuario(usuario);
        Permissoes permissoes = new Permissoes();

        Session session = SessionProvider.openSession();

        ICriteria c = session.createCriteria(permissoes, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.eq(FILTER_TYPE.WHERE, "grupo_usuarios_id", grupo.getId()));
        c.add(Restrictions.eq(FILTER_TYPE.AND, "telas_id", tela));

        switch (tipo_permissao)
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

    /**
     *
     * @param searchTerm
     * @param tipo 0 - Todos; 1 - Somente Ativos; 2 - Somente inativos;
     * @return
     */
    public List<Usuarios> search(String searchTerm, int tipo)
    {
        searchTerm = searchTerm.replace("'", "");

        Usuarios usuarios = new Usuarios();
        Grupos_usuarios grupos_usuarios = new Grupos_usuarios();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(usuarios, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, grupos_usuarios, "usuarios.grupo_usuarios_id = grupos_usuarios.id");
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "usuarios.nome", searchTerm, MATCH_MODE.ANYWHERE));
        c.add(Restrictions.like(FILTER_TYPE.OR, "grupos_usuarios.nome", searchTerm, MATCH_MODE.ANYWHERE));

        if (Utility.tryParse(searchTerm) > 0)
            c.add(Restrictions.eq(FILTER_TYPE.OR, "usuarios.id", Utility.tryParse(searchTerm)));

        switch (tipo)
        {
            case 0:

                c.add(Restrictions.in(FILTER_TYPE.AND, "ativo", new String[]
                {
                    "0", "1"
                }));
                break;
            case 1:

                c.add(Restrictions.eq(FILTER_TYPE.AND, "ativo", 1));
                break;

            case 2:

                c.add(Restrictions.eq(FILTER_TYPE.AND, "ativo", 0));
                break;
        }

        c.execute();
        c.loadList(usuarios);
        c.loadList(grupos_usuarios);
        session.close();

        List<Usuarios> listUsuarios = session.getList(usuarios);
        List<Grupos_usuarios> listGrupos = session.getList(grupos_usuarios);

        for (int i = 0; i < listUsuarios.size(); i++)
        {
            listUsuarios.get(i).setGrupos_usuarios(listGrupos.get(i));
        }

        return listUsuarios;
    }

    public List<Usuarios> getAll()
    {
        Usuarios usuarios = new Usuarios();
        Grupos_usuarios grupos_usuarios = new Grupos_usuarios();

        Session session = SessionProvider.openSession();
        ICriteria c = session.createCriteria(usuarios, RESULT_TYPE.MULTIPLE);
        c.add(JOIN_TYPE.INNER, grupos_usuarios, "usuarios.grupo_usuarios_id = grupos_usuarios.id");
        c.execute();
        c.loadList(usuarios);
        c.loadList(grupos_usuarios);
        session.close();

        List<Usuarios> listUsuarios = session.getList(usuarios);
        List<Grupos_usuarios> listGrupos = session.getList(grupos_usuarios);

        for (int i = 0; i < listUsuarios.size(); i++)
        {
            listUsuarios.get(i).setGrupos_usuarios(listGrupos.get(i));
        }

        return listUsuarios;
    }

    public boolean podeExcluir(int id)
    {
        Session session = SessionProvider.openSession();

        if (session.count(Movimentos.class, "usuario_id = " + id) > 0)
            message = "Não é possível excluir este usuário. Ele está relacionado a um ou mais movimentos.";

        if (session.count(Movimentacoes_caixas.class, "usuario_abertura = " + id) > 0
                || session.count(Movimentacoes_caixas.class, "usuario_fechamento = " + 0) > 0)
            message = "Não é possível excluir este usuário. Ele está relacionado a uma ou mais movimentações de caixa.";

        if (session.count(Funcionarios.class, "usuario_id = " + id) > 0)
            message = "Não é possível excluir este usuário. Ele está relacionado a um funcionário.";

        session.close();

        return message.isEmpty();
    }

    public String getMessage()
    {
        return this.message;
    }

    public int count(int tipo)
    {
        Session session = SessionProvider.openSession();
        int count = 0;
        switch (tipo)
        {
            case 0:

                count = session.count(Usuarios.class, "ativo in (0, 1)");
                break;
            case 1:

                count = session.count(Usuarios.class, "ativo = 1");
                break;

            case 2:

                count = session.count(Usuarios.class, "ativo = 0");
                break;
        }

        session.close();
        return count;
    }
}
