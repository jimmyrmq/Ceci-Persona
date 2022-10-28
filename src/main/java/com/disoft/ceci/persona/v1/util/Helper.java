package com.disoft.ceci.persona.v1.util;

import com.disoft.ceci.persona.common.Log;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class Helper {
    private static Helper helper = null;

    private Helper(){}

    public static Helper getInstance(){
        if(helper== null){
            helper = new Helper();
        }
        return helper;
    }

    public String getPath(String file){

        Resource resource = new ClassPathResource(file);
        String filePath = null;
        try {
            //filePath = resource.getURL().getPath();
            String fp = resource.getURL().getPath();
            filePath = fp.replaceAll("%20"," ");
        } catch (IOException exc) {
            Log.error("No se pudo leer el archivo de propiedades: \n"+exc);
        }

        return filePath;
    }
}
