/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.com.persistor.abstractClasses.Entity;

/**
 *
 * @author Marcos Vinícius
 */
public class Usuarios_grupos extends Entity
{
    private int usuario_id;
    private int grupo_id;

    public int getUsuario_id()
    {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id)
    {
        this.usuario_id = usuario_id;
    }

    public int getGrupo_id()
    {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id)
    {
        this.grupo_id = grupo_id;
    }
}
