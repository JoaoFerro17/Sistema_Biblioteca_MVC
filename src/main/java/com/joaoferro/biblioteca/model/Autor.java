package com.joaoferro.biblioteca.model;
import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private String nacionalidade;
    private List<String> obrasPublicadas = new ArrayList<>();

    public Autor() {
    }

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<String> getObrasPublicadas() {
        return obrasPublicadas;
    }

    public void setObrasPublicadas(List<String> obrasPublicadas) {
        this.obrasPublicadas = obrasPublicadas;
    }

    public void adicionarObra(String obra) {
        this.obrasPublicadas.add(obra);
    }
}