package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Livro;
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
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String inicio() {
        return "livros/inicio";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        return "livros/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute Livro livro, @RequestParam(required = false) Integer index) {
        if (index == null) {
            livros.add(livro);
        } else {
            livros.set(index, livro);
        }
        return "redirect:/livros/lista";
    }

    @GetMapping("/editar/{index}")
    public String editar(@PathVariable int index, Model model) {
        model.addAttribute("livro", livros.get(index));
        model.addAttribute("index", index);
        return "livros/formulario";
    }

    @GetMapping("/excluir/{index}")
    public String excluir(@PathVariable int index) {
        livros.remove(index);
        return "redirect:/livros/lista";
    }

    @GetMapping("/livro")
    public String exibirLivro(Model model) {
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        model.addAttribute("livro", livro);
        return "livro";
    }
}