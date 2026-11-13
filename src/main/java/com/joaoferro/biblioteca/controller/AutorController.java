package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final List<Autor> autores = new ArrayList<>();

    public AutorController() {

        autores.add(new Autor("Machado de Assis", "Brasileira"));
        autores.add(new Autor("Robert C. Martin", "Americana"));
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