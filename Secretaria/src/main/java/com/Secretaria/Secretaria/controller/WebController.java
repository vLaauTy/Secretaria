package com.Secretaria.Secretaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class WebController {

    @Autowired(required = false)

    @GetMapping("/")
    public String menu(Model model) {
        return "menu";
    }

    @GetMapping("/menuprofesor")
    public String menuProfesor(Model model) {
        return "menu_profesor";
    }

    @GetMapping("/abm_profesores")
    public String abmProfesores(Model model) {
        return "abm_profesores";
    }

    @GetMapping("/menumaterias")
    public String menuMaterias(Model model) {
        return "menu_materias";
    }

    @GetMapping("/abm_materias")
    public String abmMaterias(Model model) {
        return "abm_materias";
    }
}