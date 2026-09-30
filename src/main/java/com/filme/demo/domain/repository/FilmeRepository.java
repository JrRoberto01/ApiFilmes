package com.filme.demo.domain.repository;

import com.filme.demo.domain.model.Filme;
import com.filme.demo.domain.model.FilmeId;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository {

    Filme save(Filme filme);

    Optional<Filme> findById(FilmeId id);

    List<Filme> findAll();

    void deleteById(FilmeId id);
}
