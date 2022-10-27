package com.disoft.ceci.persona.v1.util.db;

import com.disoft.ceci.persona.common.Log;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {
    private static org.slf4j.Logger SLog = org.slf4j.LoggerFactory.getLogger(ConexionDB.class);
    private Connection conexion;
    private boolean isConn = false;
    private String motor = "mysql";
    private String driver = "com.mysql.jdbc.Driver";
    private String dir = "localhost";
    private String dbname = "test";
    private String user = "root";
    private String password = "root";
    private String url = null;
    private boolean isDriver = false;

    private static ConexionDB conexionDB = null;

    private ConexionDB(){
        if(getDataConn())
            isDriver = this.checkDriver();
    }

    public static ConexionDB getInstance(){
        if(conexionDB == null)
            conexionDB = new ConexionDB();

        return conexionDB;
    }

    public Connection initConection(){
        StringBuilder sconn = new StringBuilder();
        sconn.append("Conexion: ");
        conexion = null;
        if(isDriver) {
            try {
                String urldb = getURL();
                //Log.info("URL de conexion: "+urldb);
                conexion = DriverManager.getConnection(urldb, user, password);
                sconn.append("OK.");
            } catch (SQLException exc) {
                String desc = "No se pudo establecer conexión con la base de datos.\n" + exc;
                Log.error(desc);
                sconn.append("ERROR.");
            }
        }
        if(conexion==null)
            sconn.append("ERROR.");

        Log.info(sconn.toString());

        return conexion;
    }

    public void closed(){
        try {
            conexion.close();
        } catch (SQLException exc) {
            String desc = "Error al tratar de cerrar la conexión de la base de datos.\n" + exc;
            Log.error(desc);
        }
    }

    private boolean checkDriver() {
        boolean rtn = true;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException var4) {
            rtn = false;
            String desc = "No se puedo cargar el driver.\n" + var4;
            Log.error(desc);
        }

        return rtn;
    }

    private String getURL() {
        StringBuffer sb = new StringBuffer();
        String ssl = "?verifyServerCertificate=false&useSSL=true";
        sb.append("jdbc:");
        sb.append(this.motor);
        sb.append("://");
        sb.append(this.dir);
        sb.append("/");
        sb.append(this.dbname);
        sb.append(ssl);
        this.url = sb.toString();
        return this.url;
    }

    private boolean getDataConn(){
        boolean rtn = false;
        Resource resource = new ClassPathResource("conexion.properties");
        String filePath = null;
        StringBuilder logFile = new StringBuilder();
        try {
            //filePath = resource.getURL().getPath();
            String fp = resource.getURL().getPath();
            filePath = fp.replaceAll("%20"," ");
        } catch (IOException exc) {
            Log.error("No se pudo leer el archivo de propiedades: \n"+exc);
        }

        logFile.append("File Data Conn: ");
        logFile.append(filePath);

        if(filePath !=null) {
            logFile.append(". OK");
            SLog.error(filePath);
            File fileProperties = new File(filePath);
            if (fileProperties.exists()) {
                rtn = true;
                Properties properties = new Properties();
                try {
                    properties.load(new FileInputStream(fileProperties));
                    motor = properties.getProperty("motor");
                    driver = properties.getProperty("driver");
                    dir = properties.getProperty("dir");
                    dbname = properties.getProperty("dbname");
                    user = properties.getProperty("user");
                    password = properties.getProperty("password");
                } catch (FileNotFoundException exc) {
                    rtn = false;
                    String desc = "Archivo de configuracion no encontrado:\n" + exc.getMessage();
                    Log.error(desc);
                    SLog.error(desc);
                } catch (IOException exc) {
                    rtn = false;
                    String desc = "Error en el archivo de configuracion:\n" + exc.getMessage();
                    Log.error(desc);
                    SLog.error(desc);
                }
            }else {
                logFile.append(" ERROR.");
                Log.error("No se pudo leer el archivo de propiedades");
            }
        }

        Log.info(logFile.toString());

        return rtn;
    }
}
