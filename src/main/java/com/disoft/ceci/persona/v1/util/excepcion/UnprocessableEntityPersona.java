package com.disoft.ceci.persona.v1.util.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityPersona extends Exception{

    public UnprocessableEntityPersona(String msg){
        super(msg);
    }
}
