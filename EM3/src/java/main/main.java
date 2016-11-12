/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;

/**
 *
 * @author Marcos Vinícius
 */
public class main
{

    public static void main(String[] args)
    {
        try
        {
            File f = new File("./config/configpath");
            System.out.println(f.exists());
        }
        catch (Exception ex)
        {

        }
    }
}
