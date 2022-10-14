package com.disoft.ceci.persona.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("disoftjm/v1/persona")
public class Status {

    @GetMapping("check")
    public String checkStatus(){
        //return "Check status Empresa: Conexion OK";
        return "Check Status: Administracion Consulta y Acciones de Personas";
    }
}
