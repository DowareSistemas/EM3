
/* AUTO-GENERATED CLASS */
 /* DOES NOT ADD ACCESSOR METHODS */
 /* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import br.com.persistor.annotations.OneToOne;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.LOAD;

/**
 *
 * @author Persistor4J
 */
public class Usuarios extends Entity
{

    private int id;
    private String nome;
    private String senha;
    private boolean admin;
    private boolean ativo;
    private int grupo_usuarios_id;

    private Grupos_usuarios grupos_usuarios;

    public void setId(int id)
    {
        this.id = id;
    }

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    @OneToOne(source = "grupo_usuarios_id", target = "id", join_type = JOIN_TYPE.INNER, load = LOAD.AUTO)
    public Grupos_usuarios getGrupos_usuarios()
    {
        return grupos_usuarios;
    }

    public void setGrupos_usuarios(Grupos_usuarios grupos_usuarios)
    {
        this.grupos_usuarios = grupos_usuarios;
    }

    public int getGrupo_usuarios_id()
    {
        return grupo_usuarios_id;
    }

    public void setGrupo_usuarios_id(int grupo_usuarios_id)
    {
        this.grupo_usuarios_id = grupo_usuarios_id;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }

    public boolean isAdmin()
    {
        return admin;
    }

    public void setAtivo(boolean ativo)
    {
        this.ativo = ativo;
    }

    public boolean isAtivo()
    {
        return ativo;
    }
}
