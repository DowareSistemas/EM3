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
public class Ncm extends Entity
{
    private int id;
    private String cod_ncm;
    private String nome_ncm;

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCod_ncm()
    {
        return cod_ncm;
    }

    public void setCod_ncm(String cod_ncm)
    {
        this.cod_ncm = cod_ncm;
    }

    public String getNome_ncm()
    {
        return nome_ncm;
    }

    public void setNome_ncm(String nome_ncm)
    {
        this.nome_ncm = nome_ncm;
    }
    
}
