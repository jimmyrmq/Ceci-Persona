package com.disoft.ceci.persona.v1.controller;

import com.disoft.ceci.persona.common.Log;
import com.disoft.ceci.persona.common.resultdata.ResultOperation;
import com.disoft.ceci.persona.v1.model.Persona;
import com.disoft.ceci.persona.v1.util.IPersonaAdministracion;
import com.disoft.ceci.persona.v1.util.IPersonaConsulta;
import com.disoft.ceci.persona.v1.util.excepcion.UnprocessableEntityPersona;
import com.disoft.ceci.persona.v1.util.validator.IValidatorPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("disoftjm/v1/persona")
public class PersonaController {
    @Autowired
    private IPersonaConsulta personaConsulta;

    @Autowired
    private IPersonaAdministracion personaAdministracion;

    @Autowired
    private IValidatorPersona validatorPersona;

    @GetMapping("{id}")
    public ResponseEntity obtenerPersona(@PathVariable Integer id) {
        Persona persona = personaConsulta.obtener(id);
        ResponseEntity responseEntity;

        if(persona!=null)
            responseEntity = new ResponseEntity(persona, HttpStatus.OK);
        else
            responseEntity = new ResponseEntity("Persona no encontrada", HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<ResultOperation> savePersona(@RequestBody Persona persona) throws UnprocessableEntityPersona {
        //Validamos los datos de la persona
        //validatorPersona.validator(persona);

        ResultOperation resultOperation = personaAdministracion.guardar(persona);

        ResponseEntity responseEntity = new ResponseEntity(resultOperation, HttpStatus.OK);

        return  responseEntity;
    }

    @GetMapping("check")
    public String checkStatus(){
        //return "Check status Empresa: Conexion OK";
        return "Check Status: Administracion Consulta y Acciones de Personas";
    }
}
