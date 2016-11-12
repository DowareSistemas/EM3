/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Marcos Vinícius
 */
public class Utility
{

    public static String getPath(String folder, HttpServletRequest request)
    {
        String path = request.getServletContext().getRealPath("/" + folder);

        path = path.substring(0, path.indexOf("\\build"));
        path += "\\web\\" + folder + "\\";

        return path;
    }
}
