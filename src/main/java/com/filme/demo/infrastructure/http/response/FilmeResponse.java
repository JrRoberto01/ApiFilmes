package com.filme.demo.infrastructure.http.response;

import com.filme.demo.application.output.FilmeOutput;
import java.util.UUID;

public record FilmeResponse(UUID id, String titulo, String genero, Integer anoLancamento) {
    public static FilmeResponse from(FilmeOutput output) {
        return new FilmeResponse(output.id(), output.titulo(), output.genero(), output.anoLancamento());
    }
}
