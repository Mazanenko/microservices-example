package com.example.bookservice.controller;

import com.example.bookservice.service.AuthorService;
import com.example.resourceserver.openapi.api.AuthorControllerApi;
import com.example.resourceserver.openapi.model.AuthorDto;
import com.example.resourceserver.openapi.model.AuthorInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController implements AuthorControllerApi {
    private final AuthorService authorService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<AuthorDto> createAuthor(AuthorInputDto authorInputDto) {
        return ResponseEntity.ok(authorService.create(authorInputDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteAuthor(Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<AuthorDto> getAuthor(Long id) {
        return ResponseEntity.ok(authorService.get(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<AuthorDto>> getAuthors() {
        return ResponseEntity.ok(authorService.getAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<AuthorDto> putAuthor(Long id, AuthorInputDto authorInputDto) {
        return ResponseEntity.ok(authorService.update(id, authorInputDto));
    }
}
