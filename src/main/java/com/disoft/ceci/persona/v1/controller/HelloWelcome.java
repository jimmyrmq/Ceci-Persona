package com.disoft.ceci.persona.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class HelloWelcome {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    //@GetMapping("/")
    public String welcome(){
        return "h3>Bienvenido</h3>";
    }
}
