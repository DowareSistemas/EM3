/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import model.Enderecos;
import repository.EnderecosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class EnderecosController
{
    static EnderecosRepository db = new EnderecosRepository();
    
    public static void delete(Enderecos endereco, Session session)
    {
        db.remove(endereco, session);
    }
}
