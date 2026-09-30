package com.filme.demo.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "filmes")
public class FilmeJpaEntity {
    @Id private UUID id;
    @Column(nullable = false, length = 100) private String titulo;
    @Column(nullable = false, length = 50) private String genero;
    @Column(name = "ano_lancamento", nullable = false) private Integer anoLancamento;

    protected FilmeJpaEntity() {}

    public FilmeJpaEntity(UUID id, String titulo, String genero, Integer anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public UUID getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public Integer getAnoLancamento() { return anoLancamento; }
}
