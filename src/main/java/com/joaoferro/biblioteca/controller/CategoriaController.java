package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Categoria;
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
@RequestMapping("/categorias")
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();

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

    @PostMapping
    public String salvar(@ModelAttribute Categoria categoria, @RequestParam(required = false) Integer index) {
        if (index == null) {
            categorias.add(categoria);
        } else {
            categorias.set(index, categoria);
        }
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{index}")
    public String editar(@PathVariable int index, Model model) {
        model.addAttribute("categoria", categorias.get(index));
        model.addAttribute("index", index);
        return "categorias/formulario";
    }

    @GetMapping("/excluir/{index}")
    public String excluir(@PathVariable int index) {
        categorias.remove(index);
        return "redirect:/categorias";
    }
}