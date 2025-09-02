package com.Secretaria.Secretaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Secretaria.Secretaria.Model.ProfesorModel;
import com.Secretaria.Secretaria.service.ProfesorService;

@Controller
@RequestMapping
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/profesores")
    public String profesores(@RequestParam(required = false) String sexo,
            @RequestParam(required = false) Integer edadMin,
            @RequestParam(required = false) Integer edadMax,
            @RequestParam(required = false) String dni,
            Model model) {
        List<ProfesorModel> profesores = profesorService.listarTodosLosProfesores();

        // Filtrar por sexo
        if (sexo != null && !sexo.isEmpty()) {
            profesores = profesores.stream()
                    .filter(profesor -> sexo.equals(profesor.getSexo()))
                    .collect(java.util.stream.Collectors.toList());
        }

        // Filtrar por DNI (búsqueda parcial)
        if (dni != null && !dni.isEmpty()) {
            profesores = profesores.stream()
                    .filter(profesor -> profesor.getDni() != null &&
                            profesor.getDni().toLowerCase().contains(dni.toLowerCase()))
                    .collect(java.util.stream.Collectors.toList());
        }

        // Filtrar por rango de edad
        if (edadMin != null || edadMax != null) {
            profesores = profesores.stream()
                    .filter(profesor -> {
                        Integer edad = profesor.getEdad();
                        if (edad == null)
                            return false;

                        boolean cumpleMin = edadMin == null || edad >= edadMin;
                        boolean cumpleMax = edadMax == null || edad <= edadMax;

                        return cumpleMin && cumpleMax;
                    })
                    .collect(java.util.stream.Collectors.toList());
        }

        model.addAttribute("profesores", profesores);
        return "listado_profesores";
    }

    @GetMapping("/profesores/nuevo")
    public String nuevoProfesor(Model model) {
        model.addAttribute("profesor", new ProfesorModel());
        return "formulario_profesor"; // Nombre del archivo HTML en templates
    }

    @PostMapping("/profesor/guardar")
    public String guardarProfesor(@ModelAttribute("profesor") ProfesorModel profesor, Model model) {
        profesorService.save(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/profesores/detalle/{id}")
    public String detalleProfesor(@PathVariable Long id, Model model) {
        Optional<ProfesorModel> profesor = profesorService.findById(id);
        if (profesor.isPresent()) {
            model.addAttribute("profesor", profesor.get());
        }
        return "redirect:/profesores";
    }

    @GetMapping("/profesores/editar/{id}")
    public String editarProfesor(@PathVariable Long id, Model model) {
        Optional<ProfesorModel> profesor = profesorService.findById(id);
        if (profesor.isPresent()) {
            model.addAttribute("profesor", profesor.get());
        } else {
            model.addAttribute("profesor", new ProfesorModel());
        }
        return "formulario_profesor";
    }

    @GetMapping("/profesores/eliminar/{id}")
    public String eliminarProfesor(@PathVariable Long id, Model model) {
        profesorService.deleteById(id);
        return "redirect:/profesores";
    }
}
