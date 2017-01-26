/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import javax.servlet.http.HttpServletRequest;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
public class Utility
{

    public static boolean exists(Class entityClass, String field, Object value)
    {
        Session mainSession = null;
        try
        {
            mainSession = SessionProvider.openSession();
            Object entity = entityClass.newInstance();
            ICriteria c = mainSession.createCriteria(entity, RESULT_TYPE.MULTIPLE)
                    .add(Restrictions.eq(FILTER_TYPE.WHERE, field, value))
                    .execute();
            mainSession.close();
            return (!mainSession.getList(entity).isEmpty());
        }
        catch (Exception ex)
        {
            if (mainSession != null)
                mainSession.close();
            return false;
        }
    }

    public static String getPath(String folder, HttpServletRequest request)
    {
        String path = request.getServletContext().getRealPath("/" + folder);
        if (path.contains("\\build"))
        {
            path = path.substring(0, path.indexOf("\\build"));
            path += "\\web\\" + folder + "\\";
        }
        else
            path += "\\";

        return path;
    }

    public static int tryParse(String text)
    {
        try
        {
            return Integer.parseInt(text);
        }
        catch (Exception ex)
        {
            return 0;
        }
    }
}
