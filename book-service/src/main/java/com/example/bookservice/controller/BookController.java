package com.example.bookservice.controller;

import com.example.bookservice.service.BookService;
import com.example.resourceserver.openapi.api.BookControllerApi;
import com.example.resourceserver.openapi.model.BookDto;
import com.example.resourceserver.openapi.model.BookInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController implements BookControllerApi {
    private final BookService bookService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BookDto> createBook(BookInputDto bookInputDto) {
        return ResponseEntity.ok(bookService.create(bookInputDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<BookDto>> getBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BookDto> getBook(Long id) {
        return ResponseEntity.ok(bookService.get(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BookDto> putBook(Long id, BookInputDto bookInputDto) {
        return ResponseEntity.ok(bookService.update(id, bookInputDto));
    }

    @Override
    public ResponseEntity<Void> deleteBook(Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
