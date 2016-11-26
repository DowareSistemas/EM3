
/* AUTO-GENERATED CLASS */
 /* DOES NOT ADD ACCESSOR METHODS */
 /* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.OneToOne;
import br.com.persistor.enums.JOIN_TYPE;
import br.com.persistor.enums.LOAD;

/**
 *
 * @author Persistor4J
 */
public class Permissoes extends Entity
{

    private int grupos_usuarios_id;
    private String telas_id;
    private boolean acesso;
    private boolean inserir;
    private boolean atualizar;
    private boolean excluir;

    private Telas telas;
    private Grupos_usuarios grupos_usuarios;

    @OneToOne(join_type = JOIN_TYPE.INNER, source = "grupos_usuarios_id", target = "id", load = LOAD.AUTO)
    public Grupos_usuarios getGrupos_usuarios()
    {
        return grupos_usuarios;
    }

    public void setGrupos_usuarios(Grupos_usuarios grupos_usuarios)
    {
        this.grupos_usuarios = grupos_usuarios;
    }

    public int getGrupos_usuarios_id()
    {
        return grupos_usuarios_id;
    }

    public void setGrupos_usuarios_id(int grupos_usuarios_id)
    {
        this.grupos_usuarios_id = grupos_usuarios_id;
    }

    public void setTelas(Telas telas)
    {
        this.telas = telas;
    }

    public void setTelas_id(String telas_id)
    {
        this.telas_id = telas_id;
    }

    public String getTelas_id()
    {
        return telas_id;
    }

    @OneToOne(source = "telas_id", target = "id", load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
    public Telas getTelas()
    {
        return telas;
    }

    public void setAcesso(boolean acesso)
    {
        this.acesso = acesso;
    }

    public boolean isAcesso()
    {
        return acesso;
    }

    public void setInserir(boolean inserir)
    {
        this.inserir = inserir;
    }

    public boolean isInserir()
    {
        return inserir;
    }

    public void setAtualizar(boolean atualizar)
    {
        this.atualizar = atualizar;
    }

    public boolean isAtualizar()
    {
        return atualizar;
    }

    public void setExcluir(boolean excluir)
    {
        this.excluir = excluir;
    }

    public boolean isExcluir()
    {
        return excluir;
    }
}
