package com.filme.demo.application.usecase;

import com.filme.demo.application.output.FilmeOutput;
import com.filme.demo.domain.exception.FilmeNotFoundException;
import com.filme.demo.domain.model.FilmeId;
import com.filme.demo.domain.repository.FilmeRepository;

import java.util.Objects;
import java.util.UUID;

public class GetFilmeByIdUseCase {

    private final FilmeRepository filmeRepository;

    public GetFilmeByIdUseCase(FilmeRepository filmeRepository) {
        this.filmeRepository = Objects.requireNonNull(filmeRepository, "filmeRepository nao pode ser nulo");
    }

    public FilmeOutput execute(UUID id) {
        return execute(new FilmeId(id));
    }

    public FilmeOutput execute(FilmeId id) {
        Objects.requireNonNull(id, "id nao pode ser nulo");

        return filmeRepository.findById(id)
                .map(FilmeOutput::from)
                .orElseThrow(() -> new FilmeNotFoundException(id));
    }
}
