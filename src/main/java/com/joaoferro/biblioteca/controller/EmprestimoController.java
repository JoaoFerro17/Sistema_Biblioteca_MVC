package com.joaoferro.biblioteca.controller;

import com.joaoferro.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataRetirada(LocalDate.now());
        emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(7));

        model.addAttribute("emprestimo", emprestimo);
        return "emprestimos/formulario";
    }
}