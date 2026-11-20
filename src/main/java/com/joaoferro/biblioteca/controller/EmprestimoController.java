package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Emprestimo;
import com.joaoferro.biblioteca.model.Livro;
import com.joaoferro.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(new Livro());
        emprestimo.setUsuario(new Usuario());
        emprestimo.setDataRetirada(LocalDate.now());
        emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(7));

        model.addAttribute("emprestimo", emprestimo);
        return "emprestimos/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute Emprestimo emprestimo, @RequestParam(required = false) Integer index) {
        if (index == null) {
            emprestimos.add(emprestimo);
        } else {
            emprestimos.set(index, emprestimo);
        }
        return "redirect:/emprestimos";
    }

    @GetMapping("/editar/{index}")
    public String editar(@PathVariable int index, Model model) {
        Emprestimo emprestimo = emprestimos.get(index);
        if (emprestimo.getLivro() == null) {
            emprestimo.setLivro(new Livro());
        }
        if (emprestimo.getUsuario() == null) {
            emprestimo.setUsuario(new Usuario());
        }
        model.addAttribute("emprestimo", emprestimo);
        model.addAttribute("index", index);
        return "emprestimos/formulario";
    }

    @GetMapping("/excluir/{index}")
    public String excluir(@PathVariable int index) {
        emprestimos.remove(index);
        return "redirect:/emprestimos";
    }

    @GetMapping("/devolver/{index}")
    public String devolver(@PathVariable int index) {
        emprestimos.get(index).setDataDevolucao(LocalDate.now());
        return "redirect:/emprestimos";
    }
}