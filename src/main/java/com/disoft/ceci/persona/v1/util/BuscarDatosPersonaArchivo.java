package com.disoft.ceci.persona.v1.util;

import com.disoft.ceci.persona.v1.model.Persona;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class BuscarDatosPersonaArchivo {

    public BuscarDatosPersonaArchivo(){}
    public synchronized Persona getPersona(Integer nroDocumento){
        long tiempoInicio = System.currentTimeMillis();
        Persona persona = null;
        String arch=buscarArchivo(nroDocumento);
        //System.out.println(arch);
        if(arch!=null){
            File f = new File(arch);//"nacional.txt"
            //System.out.println(f.getPath()+" "+f.getName()+" "+f.getAbsoluteFile());
            //persona = new Persona();
            //persona.setPrimerNombre(f.getPath()+" "+f.getName()+" "+f.getAbsoluteFile());
            BufferedReader entrada;
            String data[];
            try {
                entrada = new BufferedReader( new FileReader( f ) );

                String linea;
                int nroDoc;
                cont:while(entrada.ready()){
                    linea = entrada.readLine();

                    data=linea.split(";",6);
                    nroDoc = Integer.parseInt(data[1]);
                    if(nroDoc == nroDocumento){
                        persona = new Persona();
                        Integer tipoDoc = data[0].equalsIgnoreCase("V")?1:2;
                        persona.setIdTipoDocumento(tipoDoc);
                        persona.setNumeroDocumento(nroDoc);
                        persona.setPrimerApellido(data[2]);
                        persona.setSegundoApellido(data[3]);
                        persona.setPrimerNombre(data[4]);
                        persona.setSegundoNombre(data[5]);
                        persona.setSexo("S");
                        persona.setDataOrigin("FILE");

                        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
                        System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
                        break cont;
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return persona;
    }

    private String buscarArchivo(Integer nroDocumento){
        String arch=null;
        int i=0,j,fin,sum=500000;
        j=sum;
        fin=30000000/sum;
        do{
            if(nroDocumento>=((i*sum)+1)&nroDocumento<=j)
                return "data-persona/"+((i*sum)+1)+" a "+j+".txt";
            j+=sum;
            i++;
        }while(i<fin);

        return arch;
    }
}
