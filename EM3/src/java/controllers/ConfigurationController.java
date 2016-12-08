/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.enums.DB_TYPE;
import br.com.persistor.generalClasses.DBConfig;
import br.com.persistor.interfaces.Session;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import loggers.PersistenceLogger;
import org.apache.commons.fileupload.DefaultFileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
public class ConfigurationController
{

    @RequestMapping("/autconfig")
    public @ResponseBody
    String aut(@RequestParam(value = "user") String user,
            @RequestParam(value = "passwd") String passwd)
    {
        if (user.equals("DBADMIN") && passwd.equals("dwmasterdb"))
            return "1";
        else
            return "0";
    }

    @RequestMapping("/testconfig")
    public @ResponseBody
    String testConfig(DBConfig config)
    {
        config.setPersistenceLogger(PersistenceLogger.class);
        SessionProvider.setConfig(config);
        if (SessionProvider.test())
            return "1";
        else
            return "0";
    }

    @RequestMapping("/getdb_type")
    public @ResponseBody
    String getDb(HttpServletRequest request)
    {
        return new OperationResult(StatusRetorno.OPERACAO_OK, getConfig(request).getDb_type().toString(), "").toJson();
    }

    @RequestMapping("/saveconfig")
    public @ResponseBody
    String save(DBConfig config, HttpServletRequest request)
    {
        try
        {
            String path = Utility.getPath("dbconfig", request);
            path += "config.properties";

            Properties p = new Properties();
            FileInputStream file = new FileInputStream(path);
            p.load(file);
            file.close();

            FileOutputStream fOut = new FileOutputStream(path);

            p.setProperty("prop.db", config.getDb_type().toString());
            p.setProperty("prop.server", config.getHost());
            p.setProperty("prop.port", config.getPort() + "");
            p.setProperty("prop.database", config.getDatabase());
            p.setProperty("prop.user", config.getUser());
            p.setProperty("prop.passwd", config.getPassword());

            p.store(fOut, "");
            fOut.close();

            return "1";
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return "0";
    }

    @RequestMapping(value = "ps_execute", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String executeSqlQuery(@RequestParam(value = "query") String query)
    {
        Session session = SessionProvider.openSession();
        try
        {
            PreparedStatement ps = session.getActiveConnection().prepareStatement(query);
            ps.execute();
            session.commit();
            ps.close();
            session.close();
            return new OperationResult(StatusRetorno.OPERACAO_OK, "", "").toJson();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            session.close();
            return new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema durante a criação do banco de dados. Acione o suporte Doware.", "").toJson();
        }
    }

    public static DBConfig getConfig(HttpServletRequest request)
    {
        try
        {
            String path = Utility.getPath("dbconfig", request);
            path += "config.properties";

            Properties p = new Properties();
            FileInputStream file = new FileInputStream(path);
            p.load(file);
            file.close();

            DBConfig config = new DBConfig();
            String db = p.getProperty("prop.db");

            if (db.equals("SQLServer"))
                config.setDb_type(DB_TYPE.SQLServer);
            if (db.equals("MySQL"))
                config.setDb_type(DB_TYPE.MySQL);
            if (db.equals("FirebirdSQL"))
                config.setDb_type(DB_TYPE.FirebirdSQL);
            if (db.equals("PostgreSQL"))
                config.setDb_type(DB_TYPE.PostgreSQL);
            if (db.equals("ORACLE"))
                config.setDb_type(DB_TYPE.ORACLE);

            config.setHost(p.getProperty("prop.server"));
            config.setPort(Integer.parseInt(p.getProperty("prop.port")));
            config.setUser(p.getProperty("prop.user"));
            config.setPassword(p.getProperty("prop.passwd"));
            config.setDatabase(p.getProperty("prop.database"));

            return config;

        }
        catch (Exception ex)
        {

        }
        return new DBConfig();
    }
}
