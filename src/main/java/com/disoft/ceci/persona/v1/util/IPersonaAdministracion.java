package com.disoft.ceci.persona.v1.util;

import com.disoft.ceci.persona.common.resultdata.ResultOperation;
import com.disoft.ceci.persona.v1.model.Persona;
import org.springframework.stereotype.Service;

public interface IPersonaAdministracion {
    ResultOperation guardar(Persona persona);
    ResultOperation eliminar(Integer id);
}
