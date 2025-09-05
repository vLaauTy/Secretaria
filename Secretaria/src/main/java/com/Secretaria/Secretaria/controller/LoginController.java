package com.Secretaria.Secretaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Secretaria.Secretaria.Model.UserModel;
import com.Secretaria.Secretaria.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String username, @RequestParam String password, Model model) {
        UserModel usuario = userService.findByUsername(username);
        if (usuario != null && usuario.isBloqueado()) {
            model.addAttribute("errorMessage", "La cuenta está bloqueada. Contacte al administrador.");
            return "login";
        }
        boolean exito = userService.autenticar(username, password);
        if (exito) {
            return "redirect:/";
        } else {
            if (usuario != null && usuario.isBloqueado()) {
                model.addAttribute("errorMessage",
                        "La cuenta está bloqueada por intentos fallidos. Contacte al administrador.");
            } else {
                model.addAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            }
            return "login";
        }
    }
}
