package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Categoria;
import com.joaoferro.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();

    @PostMapping
    public String cadastrar(@ModelAttribute Categoria categoria){
        categorias.add(categoria);
        return "redirect:/categorias";
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