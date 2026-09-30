package com.filme.demo.infrastructure.persistence.adapter;

import com.filme.demo.domain.model.Filme;
import com.filme.demo.domain.model.FilmeId;
import com.filme.demo.domain.repository.FilmeRepository;
import com.filme.demo.infrastructure.persistence.mapper.FilmePersistenceMapper;
import com.filme.demo.infrastructure.persistence.repository.SpringDataFilmeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmeRepositoryAdapter implements FilmeRepository {
    private final SpringDataFilmeRepository repository;

    public FilmeRepositoryAdapter(SpringDataFilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Filme save(Filme filme) {
        return FilmePersistenceMapper.toDomain(repository.save(FilmePersistenceMapper.toEntity(filme)));
    }

    @Override
    public Optional<Filme> findById(FilmeId id) {
        return repository.findById(id.id()).map(FilmePersistenceMapper::toDomain);
    }

    @Override
    public List<Filme> findAll() {
        return repository.findAll().stream().map(FilmePersistenceMapper::toDomain).toList();
    }

    @Override
    public void deleteById(FilmeId id) {
        repository.deleteById(id.id());
    }
}
