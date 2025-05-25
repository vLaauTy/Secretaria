package com.Secretaria.Secretaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Secretaria.Secretaria.Model.UserModel;
import com.Secretaria.Secretaria.repository.UserRepository;

@Controller
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new UserModel());
        return "formulario_usuario";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios";
    }

    @PostMapping("/nuevo")
    public String crearUsuario(@ModelAttribute UserModel usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return "redirect:/usuarios/nuevo?exito";
    }
}
