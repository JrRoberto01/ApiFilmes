package com.filme.demo.application.usecase;

import com.filme.demo.domain.exception.FilmeNotFoundException;
import com.filme.demo.domain.model.FilmeId;
import com.filme.demo.domain.repository.FilmeRepository;

import java.util.Objects;
import java.util.UUID;

public class DeleteFilmeUseCase {

    private final FilmeRepository filmeRepository;

    public DeleteFilmeUseCase(FilmeRepository filmeRepository) {
        this.filmeRepository = Objects.requireNonNull(filmeRepository, "filmeRepository nao pode ser nulo");
    }

    public void execute(UUID id) {
        execute(new FilmeId(id));
    }

    public void execute(FilmeId id) {
        Objects.requireNonNull(id, "id nao pode ser nulo");

        if (filmeRepository.findById(id).isEmpty()) {
            throw new FilmeNotFoundException(id);
        }

        filmeRepository.deleteById(id);
    }
}
