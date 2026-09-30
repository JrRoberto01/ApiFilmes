package com.filme.demo.infrastructure.http.request;

import com.filme.demo.application.input.CreateFilmeInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateFilmeRequest(
        @NotBlank @Size(max = 100) String titulo,
        @NotBlank @Size(max = 50) String genero,
        @NotNull Integer anoLancamento
) {
    public CreateFilmeInput toInput() {
        return new CreateFilmeInput(titulo, genero, anoLancamento);
    }
}
