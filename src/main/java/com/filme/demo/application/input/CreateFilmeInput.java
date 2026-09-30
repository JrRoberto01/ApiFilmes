package com.filme.demo.application.input;

public record CreateFilmeInput(
        String titulo,
        String genero,
        Integer anoLancamento
) {
}
