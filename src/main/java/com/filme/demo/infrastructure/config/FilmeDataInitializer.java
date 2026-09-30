package com.filme.demo.infrastructure.config;

import com.filme.demo.application.input.CreateFilmeInput;
import com.filme.demo.application.usecase.CreateFilmeUseCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FilmeDataInitializer implements CommandLineRunner {
    private final CreateFilmeUseCase create;

    public FilmeDataInitializer(CreateFilmeUseCase create) {
        this.create = create;
    }

    @Override
    public void run(String... args) {
        create.execute(new CreateFilmeInput("Matrix", "Ficcao cientifica", 1999));
        create.execute(new CreateFilmeInput("O Poderoso Chefao", "Drama", 1972));
        create.execute(new CreateFilmeInput("Toy Story", "Animacao", 1995));
    }
}
