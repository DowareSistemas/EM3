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
public class Produtos_equivalentes extends Entity
{
    private int id;
    private int produto_original;
    private int produto_equivalente;

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getProduto_original()
    {
        return produto_original;
    }

    public void setProduto_original(int produto_original)
    {
        this.produto_original = produto_original;
    }

    public int getProduto_equivalente()
    {
        return produto_equivalente;
    }

    public void setProduto_equivalente(int produto_equivalente)
    {
        this.produto_equivalente = produto_equivalente;
    }
    
}
