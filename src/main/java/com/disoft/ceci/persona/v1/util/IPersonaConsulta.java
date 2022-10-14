package com.disoft.ceci.persona.v1.util;

import com.disoft.ceci.persona.v1.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPersonaConsulta {
    Persona obtener(Integer ID);
    List<Persona> listar();
}
