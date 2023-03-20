package com.example.bookservice.service;


import com.example.resourceserver.openapi.model.BookDto;
import com.example.resourceserver.openapi.model.BookInputDto;
import org.springframework.lang.NonNull;

import java.util.List;

public interface BookService {
    /**
     * Get book by its id.
     *
     * @param bookId book id
     * @return {@link BookDto} obj.
     */
    BookDto get(@NonNull Long bookId);

    /**
     * Get all books.
     *
     * @return list of {@link BookDto} obj.
     */
    List<BookDto> getAll();

    /**
     * Create new book.
     *
     * @param bookInputDto {@link BookInputDto} obj.
     * @return created book as {@link BookDto}
     */
    BookDto create(@NonNull BookInputDto bookInputDto);

    /**
     * Update book by id.
     *
     * @param bookId id for book needed to be updated.
     * @param bookInputDto {@link BookInputDto} obj. for update whole book.
     * @return updated book as {@link BookDto}
     */
    BookDto update(@NonNull Long bookId, @NonNull BookInputDto bookInputDto);

    /**
     * Delete book by id.
     *
     * @param bookId id for book needed to be deleted.
     */
    void delete(@NonNull Long bookId);
}
