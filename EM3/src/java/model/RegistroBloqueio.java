/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marcos Vinícius
 */
public class RegistroBloqueio
{

    public String Tabela = "";
    public int Id = 0;
    public String Usuario = "";

    public RegistroBloqueio(String usuario, String tabela, int id)
    {
        this.Tabela = tabela;
        this.Id = id;
        this.Usuario = usuario;
    }
}
