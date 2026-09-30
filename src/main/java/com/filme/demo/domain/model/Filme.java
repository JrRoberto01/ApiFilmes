package com.filme.demo.domain.model;

public class Filme {
    private final FilmeId id;
    private String titulo;
    private String genero;
    private Integer anoLancamento;

    public Filme(String titulo, String genero, Integer anoLancamento) {
        this(new FilmeId(), titulo, genero, anoLancamento);
    }

    public Filme(FilmeId id, String titulo, String genero, Integer anoLancamento) {
        if (id == null) {
            throw new IllegalArgumentException("O identificador do filme nao pode ser nulo");
        }
        this.id = id;
        update(titulo, genero, anoLancamento);
    }

    public void update(String titulo, String genero, Integer anoLancamento) {
        validateText(titulo, 100, "O titulo");
        validateText(genero, 50, "O genero");
        if (anoLancamento == null) {
            throw new IllegalArgumentException("O ano de lancamento nao pode ser nulo");
        }
        this.titulo = titulo.trim();
        this.genero = genero.trim();
        this.anoLancamento = anoLancamento;
    }

    public FilmeId getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public Integer getAnoLancamento() { return anoLancamento; }

    private static void validateText(String value, int maxLength, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " nao pode estar vazio");
        }
        if (value.length() > maxLength) {
            throw new IllegalArgumentException(field + " deve possuir no maximo " + maxLength + " caracteres");
        }
    }
}
