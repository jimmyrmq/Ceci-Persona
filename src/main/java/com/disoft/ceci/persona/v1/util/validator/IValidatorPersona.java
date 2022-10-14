package com.disoft.ceci.persona.v1.util.validator;

import com.disoft.ceci.persona.v1.model.Persona;
import com.disoft.ceci.persona.v1.util.excepcion.UnprocessableEntityPersona;
import org.springframework.stereotype.Service;

@Service
public interface IValidatorPersona {
    void validator(Persona persona) throws UnprocessableEntityPersona;
}
