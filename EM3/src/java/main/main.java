/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import br.com.persistor.enums.DB_TYPE;
import br.com.persistor.generalClasses.DBConfig;
import br.com.persistor.test.LogTest;
import dao.MarcasDao;
import model.Marcas;
import sessionProvider.SessionProvider;

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
         /*   SessionProvider.setConfig(getConfig());
            
            Marcas m = new Marcas();
            m.setNome("hahaha");

            new MarcasDao(true).save(m);
            
            if(m.saved || m.updated)
            System.out.println(m.getId()); */
        }
        catch (Exception ex)
        {

        }
    }

    private static DBConfig getConfig()
    {
        DBConfig config = new DBConfig();
        config.setPersistenceLogger(LogTest.class);
        // config.setPersistenceContext(Contexto.class);
        config.setDb_type(DB_TYPE.SQLServer);
        config.setHost("localhost");
        config.setPort(1433);
        config.setUser("sa");
        config.setPassword("81547686");
        config.setDatabase("EM3");
        config.setMaxPoolSize(1);

        return config;
    }
}
