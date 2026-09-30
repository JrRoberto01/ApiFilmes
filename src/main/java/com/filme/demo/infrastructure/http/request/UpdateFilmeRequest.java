package com.filme.demo.infrastructure.http.request;

import com.filme.demo.application.input.UpdateFilmeInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateFilmeRequest(
        @NotBlank @Size(max = 100) String titulo,
        @NotBlank @Size(max = 50) String genero,
        @NotNull Integer anoLancamento
) {
    public UpdateFilmeInput toInput() {
        return new UpdateFilmeInput(titulo, genero, anoLancamento);
    }
}
