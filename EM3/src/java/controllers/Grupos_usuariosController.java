/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.Grupos_usuarios;
import org.springframework.stereotype.Controller;
import repository.Grupos_usuariosRepository;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class Grupos_usuariosController
{
    static  Grupos_usuariosRepository db = new Grupos_usuariosRepository();
    
    public static Grupos_usuarios findByUsuario(int usuario_id)
    {
       return db.findByUsuario(usuario_id);
    }
}
