package com.Secretaria.Secretaria.controller;

import com.Secretaria.Secretaria.Model.MateriaModel;
import com.Secretaria.Secretaria.Model.ProfesorModel;
import com.Secretaria.Secretaria.service.MateriaService;
import com.Secretaria.Secretaria.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping
public class WebController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/")
    public String menu(Model model) {
        return "menu";
    }

    @GetMapping("/profesores")
    public String profesores(Model model) {
        model.addAttribute("profesores", profesorService.findAll());
        return "abm_profesores"; // Nombre del archivo HTML en templates
    }

    @GetMapping("/alumnos")
    public String alumnos(Model model) {
        return "abm_alumnos";
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
            // Aquí podrías crear una vista de detalle
            // return "detalle_profesor";
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

    @GetMapping("/materias")
    public String materias(Model model) {
        model.addAttribute("materias", materiaService.findAll());
        return "materias"; // Nombre del archivo HTML en templates
    }

    @GetMapping("/materias/nuevo")
    public String nuevaMateria(Model model) {
        model.addAttribute("materia", new MateriaModel());
        return "formulario_materia"; // Nombre del archivo HTML en templates
    }

    @PostMapping("/materia/guardar")
    public String guardarMateria(@ModelAttribute("materia") MateriaModel materia, Model model) {
        materiaService.save(materia);
        return "redirect:/materias";
    }

    @GetMapping("/materias/detalle/{id}")
    public String detalleMateria(@PathVariable Long id, Model model) {
        MateriaModel materia = materiaService.findById(id);
        if (materia != null) {
            model.addAttribute("materia", materia);
            // Aquí podrías crear una vista de detalle
            // return "detalle_materia";
        }
        return "redirect:/materias";
    }

    @GetMapping("/materias/editar/{id}")
    public String editarMateria(@PathVariable Long id, Model model) {
        MateriaModel materia = materiaService.findById(id);
        if (materia != null) {
            model.addAttribute("materia", materia);
        } else {
            model.addAttribute("materia", new MateriaModel());
        }
        return "formulario_materia";
    }

    @GetMapping("/materias/eliminar/{id}")
    public String eliminarMateria(@PathVariable Long id, Model model) {
        materiaService.deleteById(id);
        return "redirect:/materias";
    }

}