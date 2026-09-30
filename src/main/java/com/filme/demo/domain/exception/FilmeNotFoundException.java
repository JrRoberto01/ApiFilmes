package com.filme.demo.domain.exception;

import com.filme.demo.domain.model.FilmeId;

public class FilmeNotFoundException extends RuntimeException {

    private final FilmeId filmeId;

    public FilmeNotFoundException(FilmeId filmeId) {
        super(buildMessage(filmeId));
        this.filmeId = filmeId;
    }

    public FilmeId getFilmeId() {
        return filmeId;
    }

    private static String buildMessage(FilmeId filmeId) {
        if (filmeId == null) {
            throw new IllegalArgumentException("O identificador do filme não pode ser nulo");
        }

        return "Filme com identificador " + filmeId.id() + " não encontrado";
    }
}
