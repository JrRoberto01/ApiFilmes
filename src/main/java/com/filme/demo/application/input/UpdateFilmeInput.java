package com.filme.demo.application.input;

public record UpdateFilmeInput(
        String titulo,
        String genero,
        Integer anoLancamento
) {
}
