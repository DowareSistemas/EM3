/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionProvider;

import br.com.persistor.generalClasses.DBConfig;
import br.com.persistor.interfaces.Session;
import br.com.persistor.sessionManager.SessionFactory;
import controllers.ConfigurationController;
import javax.servlet.http.HttpServletRequest;
import loggers.PersistenceLogger;

/**
 *
 * @author Marcos Vinícius
 */
public class SessionProvider
{

    private static SessionFactory factory = null;
    private static DBConfig config;

    public static void setConfig(DBConfig dBConfig)
    {
        config = dBConfig;
        config.setPersistenceLogger(PersistenceLogger.class);
    }

    public static void setConfig(HttpServletRequest request)
    {
        config = ConfigurationController.getConfig(request);
        config.setPersistenceLogger(PersistenceLogger.class);
        config.setMaxPoolSize(10);
    }

    public static Session openSession()
    {
        try
        {
            if (factory == null)
                factory = new SessionFactory();

            return factory.getSession(config);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    public static boolean test()
    {
        if (factory != null)
            factory.reset();

        Session session = openSession();
        if (session != null)
        {
            session.close();
            return true;
        }

        return false;
    }
}
