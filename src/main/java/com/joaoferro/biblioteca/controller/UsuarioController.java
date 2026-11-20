package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

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

    @PostMapping
    public String salvar(@ModelAttribute Usuario usuario, @RequestParam(required = false) Integer index) {
        if (index == null) {
            usuarios.add(usuario);
        } else {
            usuarios.set(index, usuario);
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{index}")
    public String editar(@PathVariable int index, Model model) {
        model.addAttribute("usuario", usuarios.get(index));
        model.addAttribute("index", index);
        return "usuarios/formulario";
    }

    @GetMapping("/excluir/{index}")
    public String excluir(@PathVariable int index) {
        usuarios.remove(index);
        return "redirect:/usuarios";
    }
}