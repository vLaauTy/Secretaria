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

import com.Secretaria.Secretaria.Model.AlumnoModel;
import com.Secretaria.Secretaria.service.AlumnoService;

@Controller
@RequestMapping
public class AlumnoController {
    @Autowired
    private AlumnoService AlumnoService;

    @GetMapping("/alumnos")
    public String alumnos(@RequestParam(required = false) String sexo,
            @RequestParam(required = false) Integer edadMin,
            @RequestParam(required = false) Integer edadMax,
            @RequestParam(required = false) String dni,
            Model model) {
        List<AlumnoModel> Alumnos = AlumnoService.listarTodosLosAlumnos();

        // Filtrar por sexo
        if (sexo != null && !sexo.isEmpty()) {
            Alumnos = Alumnos.stream()
                    .filter(Alumno -> sexo.equals(Alumno.getDA_Sex()))
                    .collect(java.util.stream.Collectors.toList());
        }

        // Filtrar por DNI (búsqueda parcial)
        if (dni != null && !dni.isEmpty()) {
            Alumnos = Alumnos.stream()
                    .filter(Alumno -> Alumno.getDni() != null &&
                            Alumno.getDni().toLowerCase().contains(dni.toLowerCase()))
                    .collect(java.util.stream.Collectors.toList());
        }

        // Filtrar por rango de edad
        if (edadMin != null || edadMax != null) {
            Alumnos = Alumnos.stream().filter(alumno -> {
                int edad = alumno.getEdad();
                boolean cumpleMin = (edadMin == null) || (edad >= edadMin);
                boolean cumpleMax = (edadMax == null) || (edad <= edadMax);
                return cumpleMin && cumpleMax;
            })
                    .toList();
        }
        model.addAttribute("alumnos", Alumnos);
        return "listado_alumnos";
    }

    @GetMapping("/alumnos/nuevo")
    public String nuevoAlumno(Model model) {
        model.addAttribute("Alumno", new AlumnoModel());
        return "formulario_alumnos"; // Nombre del archivo HTML en templates
    }

    @PostMapping("/alumno/guardar")
    public String guardarAlumno(@ModelAttribute("Alumno") AlumnoModel Alumno, Model model) {
        AlumnoService.save(Alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/alumnos/detalle/{id}")
    public String detalleAlumno(@PathVariable Long id, Model model) {
        Optional<AlumnoModel> alumno = AlumnoService.findById(id);
        if (alumno.isPresent()) {
            model.addAttribute("alumno", alumno.get());
            return "detalle_alumno";
        }
        return "redirect:/alumnos";
    }

    @GetMapping("/alumnos/editar/{id}")
    public String editarAlumno(@PathVariable Long id, Model model) {
        Optional<AlumnoModel> Alumno = AlumnoService.findById(id);
        if (Alumno.isPresent()) {
            model.addAttribute("Alumno", Alumno.get());
        } else {
            model.addAttribute("Alumno", new AlumnoModel());
        }
        return "formulario_alumnos";
    }

    @GetMapping("/alumnos/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Long id, Model model) {
        AlumnoService.deleteById(id);
        return "redirect:/alumnos";
    }

}
