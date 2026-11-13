package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {
        usuarios.add(new Usuario("Mariana Silva", "2026001", "mariana@email.com"));
        usuarios.add(new Usuario("Lucas Andrade", "2026002", "lucas@email.com"));
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarios);
        return "usuarios/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

}