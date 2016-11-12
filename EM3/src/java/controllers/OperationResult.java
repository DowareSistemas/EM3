/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;

/**
 *
 * @author Marcos Vinícius
 */
public class OperationResult
{
    private int status;
    private String message;
    private Object object;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getObject()
    {
        return object;
    }

    public void setObject(Object object)
    {
        this.object = object;
    }
    
    
    public OperationResult(int status, String msg, Object obj)
    {
        this.status = status;
        this.message = msg;
        this.object = obj;
    }
    
   public String get()
   {
       Gson gson = new Gson();
       return gson.toJson(this);
   }
}
