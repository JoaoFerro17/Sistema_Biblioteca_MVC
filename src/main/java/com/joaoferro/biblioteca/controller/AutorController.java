package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Autor;
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
@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    @PostMapping
    public String cadastrar(@ModelAttribute Autor autor){
        autores.add(autor);
        return "redirect:/autores";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autores", autores);
        return "autores/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/formulario";
    }

}