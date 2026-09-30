package com.filme.demo.application.usecase;

import com.filme.demo.application.input.CreateFilmeInput;
import com.filme.demo.application.output.FilmeOutput;
import com.filme.demo.domain.model.Filme;
import com.filme.demo.domain.repository.FilmeRepository;

import java.util.Objects;

public class CreateFilmeUseCase {

    private final FilmeRepository filmeRepository;

    public CreateFilmeUseCase(FilmeRepository filmeRepository) {
        this.filmeRepository = Objects.requireNonNull(filmeRepository, "filmeRepository nao pode ser nulo");
    }

    public FilmeOutput execute(CreateFilmeInput input) {
        Objects.requireNonNull(input, "input nao pode ser nulo");

        Filme filme = new Filme(
                input.titulo(),
                input.genero(),
                input.anoLancamento()
        );

        return FilmeOutput.from(filmeRepository.save(filme));
    }
}
