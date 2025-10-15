package com.Secretaria.Secretaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Secretaria.Secretaria.Model.MateriaModel;
import com.Secretaria.Secretaria.service.MateriaService;
import com.Secretaria.Secretaria.service.CarreraService;

@Controller
@RequestMapping
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @Autowired
    private CarreraService carreraService;

    @GetMapping("/materias")
    public String materias(Model model) {
        model.addAttribute("materias", materiaService.findAll());
        return "materias"; // Nombre del archivo HTML en templates
    }

    @GetMapping("/materias/nuevo")
    public String nuevaMateria(Model model) {
        model.addAttribute("materia", new MateriaModel());
        model.addAttribute("carreras", carreraService.findAll());
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
        model.addAttribute("carreras", carreraService.findAll());
        return "formulario_materia";
    }

    @GetMapping("/materias/eliminar/{id}")
    public String eliminarMateria(@PathVariable Long id, Model model) {
        materiaService.deleteById(id);
        return "redirect:/materias";
    }

}
