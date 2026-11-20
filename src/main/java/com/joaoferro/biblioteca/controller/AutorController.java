package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Autor;
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
@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

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

    @PostMapping
    public String salvar(@ModelAttribute Autor autor, @RequestParam(required = false) Integer index) {
        if (index == null) {
            autores.add(autor);
        } else {
            autores.set(index, autor);
        }
        return "redirect:/autores";
    }

    @GetMapping("/editar/{index}")
    public String editar(@PathVariable int index, Model model) {
        model.addAttribute("autor", autores.get(index));
        model.addAttribute("index", index);
        return "autores/formulario";
    }

    @GetMapping("/excluir/{index}")
    public String excluir(@PathVariable int index) {
        autores.remove(index);
        return "redirect:/autores";
    }
}