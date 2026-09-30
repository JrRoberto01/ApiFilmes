package com.filme.demo.application.usecase;

import com.filme.demo.application.output.FilmeOutput;
import com.filme.demo.domain.repository.FilmeRepository;

import java.util.List;
import java.util.Objects;

public class ListFilmesUseCase {

    private final FilmeRepository filmeRepository;

    public ListFilmesUseCase(FilmeRepository filmeRepository) {
        this.filmeRepository = Objects.requireNonNull(filmeRepository, "filmeRepository nao pode ser nulo");
    }

    public List<FilmeOutput> execute() {
        return filmeRepository.findAll().stream()
                .map(FilmeOutput::from)
                .toList();
    }
}
