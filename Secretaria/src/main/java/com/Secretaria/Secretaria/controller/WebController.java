package com.Secretaria.Secretaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class WebController {

    @GetMapping("/")
    public String menu(Model model) {
        return "menu";
    }

    @GetMapping("/profesores")
    public String profesores(Model model) {
        return "abm_profesores"; // Nombre del archivo HTML en templates
    }

    @GetMapping("/alumnos")
    public String alumnos(Model model) {
        return "abm_alumnos";
    }

}
