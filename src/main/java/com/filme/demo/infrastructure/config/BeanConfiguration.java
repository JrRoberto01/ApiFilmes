package com.filme.demo.infrastructure.config;

import com.filme.demo.application.usecase.CreateFilmeUseCase;
import com.filme.demo.application.usecase.DeleteFilmeUseCase;
import com.filme.demo.application.usecase.GetFilmeByIdUseCase;
import com.filme.demo.application.usecase.ListFilmesUseCase;
import com.filme.demo.application.usecase.UpdateFilmeUseCase;
import com.filme.demo.domain.repository.FilmeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean public CreateFilmeUseCase createFilmeUseCase(FilmeRepository repository) { return new CreateFilmeUseCase(repository); }
    @Bean public GetFilmeByIdUseCase getFilmeByIdUseCase(FilmeRepository repository) { return new GetFilmeByIdUseCase(repository); }
    @Bean public ListFilmesUseCase listFilmesUseCase(FilmeRepository repository) { return new ListFilmesUseCase(repository); }
    @Bean public UpdateFilmeUseCase updateFilmeUseCase(FilmeRepository repository) { return new UpdateFilmeUseCase(repository); }
    @Bean public DeleteFilmeUseCase deleteFilmeUseCase(FilmeRepository repository) { return new DeleteFilmeUseCase(repository); }
}
