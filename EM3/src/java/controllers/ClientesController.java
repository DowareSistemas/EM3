/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.Clientes;
import repository.ClientesRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class ClientesController
{

    static ClientesRepository db = new ClientesRepository();

    public static void salva(Clientes cliente)
    {
        if (db.exists(Clientes.class, "id", cliente.getId()))
            db.merge(cliente);
        else
            db.add(cliente);

        db.commit(true);
    }
    
    public static void deletar(int id)
    {
        Clientes cliente = db.get(Clientes.class, id);
        db.remove(cliente);
        db.commit(true);
    }
}
