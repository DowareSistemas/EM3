/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import model.Clientes;
import repository.ClientesRepository;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class ClientesController
{

    ClientesRepository db = new ClientesRepository();

    public void salva(Clientes cliente)
    {
        Session session = SessionProvider.openSession();

        if (Utility.exists(Clientes.class, "id", cliente.getId()))
            session.update(cliente);
        else
            session.save(cliente);
        
        session.commit();
        session.close();
    }

    public void deletar(int id)
    {
        Session session = SessionProvider.openSession();
        
        Clientes cliente = session.onID(Clientes.class, id);
        session.delete(cliente);
        session.commit();
        session.close();
    }
}
