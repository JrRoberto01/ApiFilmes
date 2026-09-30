package com.filme.demo.infrastructure.http.controller;

import com.filme.demo.application.usecase.CreateFilmeUseCase;
import com.filme.demo.application.usecase.DeleteFilmeUseCase;
import com.filme.demo.application.usecase.GetFilmeByIdUseCase;
import com.filme.demo.application.usecase.ListFilmesUseCase;
import com.filme.demo.application.usecase.UpdateFilmeUseCase;
import com.filme.demo.infrastructure.http.request.CreateFilmeRequest;
import com.filme.demo.infrastructure.http.request.UpdateFilmeRequest;
import com.filme.demo.infrastructure.http.response.FilmeResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final CreateFilmeUseCase create;
    private final GetFilmeByIdUseCase getById;
    private final ListFilmesUseCase list;
    private final UpdateFilmeUseCase update;
    private final DeleteFilmeUseCase delete;

    public FilmeController(CreateFilmeUseCase create, GetFilmeByIdUseCase getById,
                            ListFilmesUseCase list, UpdateFilmeUseCase update,
                            DeleteFilmeUseCase delete) {
        this.create = create;
        this.getById = getById;
        this.list = list;
        this.update = update;
        this.delete = delete;
    }

    @PostMapping
    public ResponseEntity<FilmeResponse> create(@Valid @RequestBody CreateFilmeRequest request) {
        FilmeResponse response = FilmeResponse.from(create.execute(request.toInput()));
        return ResponseEntity.created(URI.create("/filmes/" + response.id())).body(response);
    }

    @GetMapping
    public List<FilmeResponse> list() {
        return list.execute().stream().map(FilmeResponse::from).toList();
    }

    @GetMapping("/{id}")
    public FilmeResponse getById(@PathVariable UUID id) {
        return FilmeResponse.from(getById.execute(id));
    }

    @PutMapping("/{id}")
    public FilmeResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateFilmeRequest request) {
        return FilmeResponse.from(update.execute(id, request.toInput()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        delete.execute(id);
    }
}
