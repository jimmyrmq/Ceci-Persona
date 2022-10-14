package com.disoft.ceci.persona.v1.util.validator;

import com.disoft.ceci.persona.v1.model.Persona;
import com.disoft.ceci.persona.v1.util.excepcion.UnprocessableEntityPersona;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PersonaValidator implements IValidatorPersona{

    @Override
    public void validator(Persona persona)throws UnprocessableEntityPersona {
        if(persona.getIdTipoDocumento() == null || persona.getIdTipoDocumento() <= 0)
            message("Tipo de persona invalido.");
        else if(persona.getNumeroDocumento() == null || persona.getNumeroDocumento()<=0)
            message("Numero de documento incorrecto.");
        else if(persona.getNombre() == null || persona.getNombre().trim().isEmpty())
            message("Ingrese el nombre de la persona.");
        else if(persona.getApellido() == null || persona.getApellido().trim().isEmpty())
            message("Ingrese el apellido de la persona.");
        //else if(persona.getSexo() == null || persona.getSexo().trim().isEmpty() || persona.getSexo().length() != 1)
        //    message("El sexo de la persona es invalido.");
        else if(persona.getFechaNacimiento()!=null && persona.getFechaNacimiento().isAfter(LocalDate.now()))
            message("La fecha de nacimiento es incorrecto.");

    }

    private void message(String msg) throws UnprocessableEntityPersona{
        throw new UnprocessableEntityPersona(msg);
    }
}
