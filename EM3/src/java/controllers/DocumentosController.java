/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.interfaces.Session;
import model.Documentos;
import repository.DocumentosRepository;

/**
 *
 * @author Marcos Vinícius
 */
public class DocumentosController
{
    static DocumentosRepository db = new DocumentosRepository();
    
    public static void delete(Documentos documento, Session session)
    {
        db.remove(documento, session);
    }
}
