package com.filme.demo.application.usecase;

import com.filme.demo.application.input.UpdateFilmeInput;
import com.filme.demo.application.output.FilmeOutput;
import com.filme.demo.domain.exception.FilmeNotFoundException;
import com.filme.demo.domain.model.Filme;
import com.filme.demo.domain.model.FilmeId;
import com.filme.demo.domain.repository.FilmeRepository;

import java.util.Objects;
import java.util.UUID;

public class UpdateFilmeUseCase {

    private final FilmeRepository filmeRepository;

    public UpdateFilmeUseCase(FilmeRepository filmeRepository) {
        this.filmeRepository = Objects.requireNonNull(filmeRepository, "filmeRepository nao pode ser nulo");
    }

    public FilmeOutput execute(UUID id, UpdateFilmeInput input) {
        return execute(new FilmeId(id), input);
    }

    public FilmeOutput execute(FilmeId id, UpdateFilmeInput input) {
        Objects.requireNonNull(id, "id nao pode ser nulo");
        Objects.requireNonNull(input, "input nao pode ser nulo");

        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new FilmeNotFoundException(id));

        filme.update(
                input.titulo(),
                input.genero(),
                input.anoLancamento()
        );

        return FilmeOutput.from(filmeRepository.save(filme));
    }
}
