package com.filme.demo.infrastructure.persistence.repository;

import com.filme.demo.infrastructure.persistence.entity.FilmeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataFilmeRepository extends JpaRepository<FilmeJpaEntity, UUID> {}
