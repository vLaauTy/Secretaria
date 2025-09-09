package com.Secretaria.Secretaria.controller;

import com.Secretaria.Secretaria.Model.ProfesorModel;
import com.Secretaria.Secretaria.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

}