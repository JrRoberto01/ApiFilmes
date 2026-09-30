package com.filme.demo.infrastructure.persistence.mapper;

import com.filme.demo.domain.model.Filme;
import com.filme.demo.domain.model.FilmeId;
import com.filme.demo.infrastructure.persistence.entity.FilmeJpaEntity;

public final class FilmePersistenceMapper {
    private FilmePersistenceMapper() {}

    public static FilmeJpaEntity toEntity(Filme filme) {
        return new FilmeJpaEntity(filme.getId().id(), filme.getTitulo(),
                filme.getGenero(), filme.getAnoLancamento());
    }

    public static Filme toDomain(FilmeJpaEntity entity) {
        return new Filme(new FilmeId(entity.getId()), entity.getTitulo(),
                entity.getGenero(), entity.getAnoLancamento());
    }
}
