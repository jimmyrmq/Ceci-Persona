package com.disoft.ceci.persona.common;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
    private static boolean isConfigured = false;
    private final static Logger log = Logger.getLogger(Log.class);
    //private static Logger logPrint = LoggerFactory.getLogger(Log.class);

    private static void configureLogger(){
        if(!isConfigured){
            String file = Helper.getInstance().getPath("/config/log4j.properties");
            PropertyConfigurator.configure(file);
            isConfigured = true;
        }
    }

    public static void error(String msg){
        configureLogger();
        log.error(msg);
        //System.err.println(msg);
    }

    public static void info(String msg){
        configureLogger();
        log.info(msg);
    }

    public static void trace(String msg){
        configureLogger();
        log.trace(msg);
    }
}