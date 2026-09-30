package com.filme.demo.domain.model;

import java.util.UUID;

public record FilmeId(UUID id) {

    public FilmeId {
        if (id == null) {
            throw new IllegalArgumentException("O identificador do filme nao pode ser nulo");
        }
    }

    public FilmeId() {
        this(UUID.randomUUID());
    }

    public static FilmeId from(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O identificador do filme nao pode estar vazio");
        }

        try {
            return new FilmeId(UUID.fromString(id.trim()));
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("O identificador do filme deve ser um UUID valido", exception);
        }
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
