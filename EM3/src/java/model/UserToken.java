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
public class UserToken
{
    private Usuarios usuario;
    private String token;

    public UserToken(Usuarios usuario, String token)
    {
        this.usuario = usuario;
        this.token = token;
    }
    
    public Usuarios getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuarios usuario)
    {
        this.usuario = usuario;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
    
}
