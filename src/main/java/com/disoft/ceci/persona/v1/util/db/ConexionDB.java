package com.disoft.ceci.persona.v1.util.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {
    private static Logger LOG = LoggerFactory.getLogger(ConexionDB.class);
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
        if(isDriver) {
            try {
                conexion = DriverManager.getConnection(getURL(), user, password);
            } catch (SQLException exc) {
                String desc = "No se pudo establecer conexión con la base de datos.\n" + exc;
                LOG.error(desc);
            }
        }

        return conexion;
    }

    public void closed(){
        try {
            conexion.close();
        } catch (SQLException exc) {
            String desc = "Error al tratar de cerrar la conexión de la base de datos.\n" + exc;
            LOG.error(desc);
        }
    }

    private boolean checkDriver() {
        boolean rtn = true;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException var4) {
            rtn = false;
            String desc = "No se puedo cargar el driver.\n" + var4;
            LOG.error(desc);
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

        File fileProperties = new File("D:\\Proyectos\\Ceci\\Persona\\Persona\\target\\classes\\conexion.properties");

        if(fileProperties.exists()) {
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
                LOG.error(desc);
            } catch (IOException exc) {
                rtn = false;
                String desc = "Error en el archivo de configuracion:\n" + exc.getMessage();
                LOG.error(desc);
            }
        }else
            LOG.error("No se pudo leer el archivo de propiedades");

        return rtn;
    }
}
