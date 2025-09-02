package com.Secretaria.Secretaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AlumnoController {
    @GetMapping("/alumnos")
    public String alumnos(Model model) {
        return "abm_alumnos";
    }

}
