package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final List<Categoria> categorias = new ArrayList<>();

    public CategoriaController() {
        categorias.add(new Categoria("Tecnologia", "Livros de programação e engenharia de software"));
        categorias.add(new Categoria("Literatura Brasileira", "Clássicos e romances nacionais"));
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categorias);
        return "categorias/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }
}