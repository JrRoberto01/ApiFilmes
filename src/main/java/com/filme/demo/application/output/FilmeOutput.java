package com.filme.demo.application.output;

import com.filme.demo.domain.model.Filme;

import java.util.UUID;

public record FilmeOutput(
        UUID id,
        String titulo,
        String genero,
        Integer anoLancamento
) {
    public static FilmeOutput from(Filme filme) {
        return new FilmeOutput(
                filme.getId().id(),
                filme.getTitulo(),
                filme.getGenero(),
                filme.getAnoLancamento()
        );
    }
}
