package com.Secretaria.Secretaria.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Secretaria.Secretaria.Model.Documento;
import com.Secretaria.Secretaria.service.DocumentoService;
import com.Secretaria.Secretaria.service.UbicacionService;

@Controller
@RequestMapping("/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private UbicacionService ubicacionService;

    @PostMapping("/subir")
    public String subirDocumento(@RequestParam("archivo") MultipartFile archivo, Model model) {
        try {
            Documento doc = documentoService.guardarDocumento(archivo);
            model.addAttribute("mensaje", "Archivo subido correctamente: " + doc.getNombre());
        } catch (IOException e) {
            model.addAttribute("error", "Error al subir el archivo: " + e.getMessage());
        }
        return "redirect:/documentos/listar";
    }

    @PostMapping("/agregar-ubicacion")
    public String agregarUbicacion(@RequestParam("titulo") String titulo,
                                   @RequestParam("direccion") String direccion,
                                   Model model) {
        if (titulo == null || titulo.isBlank() || direccion == null || direccion.isBlank()) {
            model.addAttribute("error", "Título y dirección son obligatorios");
            return "redirect:/documentos/listar";
        }
        ubicacionService.guardarUbicacion(titulo.trim(), direccion.trim());
        model.addAttribute("mensaje", "Ubicación agregada correctamente");
        return "redirect:/documentos/listar";
    }

    @GetMapping("/listar")
    public String listarDocumentos(Model model) {
        model.addAttribute("documentos", documentoService.listarDocumentos());
        model.addAttribute("ubicaciones", ubicacionService.listarUbicaciones());
        return "documentos_lista";
    }

    @GetMapping("/eliminar-ubicacion/{id}")
    public String eliminarUbicacion(@PathVariable Long id, Model model) {
        ubicacionService.eliminarUbicacion(id);
        model.addAttribute("mensaje", "Ubicación eliminada correctamente");
        return "redirect:/documentos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDocumento(@PathVariable Long id, Model model) {
        try {
            documentoService.eliminarDocumento(id);
            model.addAttribute("mensaje", "Documento eliminado correctamente");
        } catch (IOException e) {
            model.addAttribute("error", "Error al eliminar el archivo: " + e.getMessage());
        }
        return "redirect:/documentos/listar";
    }
}
