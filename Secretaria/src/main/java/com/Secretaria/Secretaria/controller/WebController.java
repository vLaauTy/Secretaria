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
    private ProfesorService profesorService;

    @GetMapping("/")
    public String menu(Model model) {
        return "menu";
    }

    @GetMapping("/profesores")
    public String profesores(@RequestParam(required = false) String dni, Model model) {
        if (profesorService == null) {
            model.addAttribute("profesores", Collections.emptyList());
            model.addAttribute("errorMessage", "El servicio de profesores no está disponible.");
            return "abm_profesores";
        }
        
        List<ProfesorModel> profesores = profesorService.listarTodosLosProfesores();

        if (dni != null && !dni.trim().isEmpty()) {
            profesores = profesores.stream()
                    .filter(p -> p.getDni().equalsIgnoreCase(dni.trim()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("profesores", profesores);
        return "abm_profesores";
    }

    @GetMapping("/profesores/eliminar")
    public String mostrarFormularioEliminar() {
        return "eliminar_profesor";
    }

    @PostMapping("/profesores/eliminar")
    public String eliminarProfesor(@RequestParam String dni, RedirectAttributes redirectAttributes) {
         if (profesorService == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "El servicio de profesores no está disponible.");
            return "redirect:/profesores/eliminar";
        }
        boolean eliminado = profesorService.eliminarProfesorPorDni(dni);
        if (eliminado) {
            redirectAttributes.addFlashAttribute("successMessage", "Profesor con DNI " + dni + " eliminado exitosamente.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "No se encontró ningún profesor con el DNI " + dni + ".");
        }
        return "redirect:/profesores/eliminar";
    }

    @GetMapping("/menuprofesor")
    public String menuProfesor(Model model) {
        return "menu_profesor";
    }

    @GetMapping("/abm_profesores")
    public String abmProfesores(Model model) {
        return "abm_profesores";
    }

    @GetMapping("/eliminarprofesor")
    public String eliminarProfesor(Model model) {
        return "eliminar_profesor";
    }
}