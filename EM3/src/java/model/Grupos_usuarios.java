/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;

/**
 *
 * @author Marcos Vinícius
 */
public class Grupos_usuarios extends Entity
{
    private int id;
    private String nome;

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
}
