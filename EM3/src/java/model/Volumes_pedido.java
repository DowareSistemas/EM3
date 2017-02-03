/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import java.math.BigDecimal;

/**
 *
 * @author Marcos Vinícius
 */
public class Volumes_pedido extends Entity
{
    private int id;
    private int numero;
    private String nome;
    private int item_pedido_id;
    private BigDecimal quant;

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getItem_pedido_id()
    {
        return item_pedido_id;
    }

    public void setItem_pedido_id(int item_pedido_id)
    {
        this.item_pedido_id = item_pedido_id;
    }

    public BigDecimal getQuant()
    {
        return quant;
    }

    public void setQuant(BigDecimal quant)
    {
        this.quant = quant;
    }
    
}
