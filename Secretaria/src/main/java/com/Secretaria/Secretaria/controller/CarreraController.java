package com.Secretaria.Secretaria.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Secretaria.Secretaria.Model.CarreraModel;
import com.Secretaria.Secretaria.service.CarreraService;

@Controller
@RequestMapping
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping("/carreras")
    public String carreras(Model model) {
        model.addAttribute("carreras", carreraService.findAll());
        return "carreras"; 
    }

    @GetMapping("/carreras/nuevo")
    public String nuevaCarrera(Model model) {
        model.addAttribute("carrera", new CarreraModel());
        return "formulario_carrera"; 
    }

    @PostMapping("/carrera/guardar")
    public String guardarCarrera(@ModelAttribute("carrera") CarreraModel carrera, Model model) {
        carreraService.save(carrera);
        return "redirect:/carreras";
    }

    @GetMapping("/carreras/detalle/{id}")
    public String detalleCarrera(@PathVariable Long id, Model model) {
        CarreraModel carrera = carreraService.findById(id);
        if (carrera != null) {
            model.addAttribute("carrera", carrera);
        }
        return "redirect:/carreras";
    }

    @GetMapping("/carreras/editar/{id}")
    public String editarCarrera(@PathVariable Long id, Model model) {
        CarreraModel carrera = carreraService.findById(id);
        if (carrera != null) {
            model.addAttribute("carrera", carrera);
        } else {
            model.addAttribute("carrera", new CarreraModel());
        }
        return "formulario_carrera";
    }

    @GetMapping("/carreras/eliminar/{id}")
    public String eliminarCarrera(@PathVariable Long id, Model model) {
        carreraService.deleteById(id);
        return "redirect:/carreras";
    }
}