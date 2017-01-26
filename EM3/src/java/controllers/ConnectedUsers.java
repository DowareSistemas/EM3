/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import model.UserToken;

/**
 *
 * @author Marcos Vinícius
 */
public class ConnectedUsers
{

    private List<UserToken> tokens = null;
    private static ConnectedUsers instance = null;

    private ConnectedUsers()
    {
        tokens = new ArrayList<UserToken>();
    }

    public List<UserToken> getTokens()
    {
        return instance.tokens;
    }
    
    public static ConnectedUsers getInstance()
    {
        if (instance == null)
            instance = new ConnectedUsers();

        return instance;
    }

    public void add(UserToken ut)
    {
        tokens.add(ut);
    }

    public boolean exists(String token)
    {
        for (UserToken ut : instance.tokens)
        {
            if (ut.getToken().equals(token))
                return true;
        }

        return false;
    }

    public boolean exists(int usuario_id)
    {
        for (UserToken ut : instance.tokens)
        {
            if (ut.getUsuario().getId() == usuario_id)
                return true;
        }

        return false;
    }

    public void remove(String token)
    {
        for (UserToken ut : instance.tokens)
        {
            if (ut.getToken().equals(token))
            {
                tokens.remove(ut);
                return;
            }
        }
    }

    public void disconnectAll(int usuario_id)
    {
        List<UserToken> toRemove = new ArrayList<UserToken>();

        for (UserToken uc : instance.tokens)
        {
            if (uc.getUsuario().getId() == usuario_id)
                toRemove.add(uc);
        }

        for (UserToken uc : toRemove)
        {
           instance.remove(uc.getToken());
        }
    }

    public UserToken find(int usuario_id)
    {
        for (UserToken uc : instance.tokens)
        {
            if (uc.getUsuario().getId() == usuario_id)
                return uc;
        }

        return null;
    }

    public UserToken find(String token)
    {
        for (UserToken uc : instance.tokens)
        {
            if (uc.getToken().equals(token))
                return uc;
        }

        return null;
    }
}
