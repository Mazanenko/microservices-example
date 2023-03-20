package com.example.bookservice.service;


import com.example.resourceserver.openapi.model.AuthorDto;
import com.example.resourceserver.openapi.model.AuthorInputDto;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AuthorService {
    /**
     * Get author by its id.
     *
     * @param authorId author id
     * @return {@link AuthorDto} obj.
     */
    AuthorDto get(@NonNull Long authorId);

    /**
     * Get all authors.
     *
     * @return list of {@link AuthorDto} obj.
     */
    List<AuthorDto> getAll();

    /**
     * Create new author.
     *
     * @param authorInputDto {@link AuthorInputDto} obj.
     * @return created author as {@link AuthorDto}
     */
    AuthorDto create(@NonNull AuthorInputDto authorInputDto);

    /**
     * Update author by id.
     *
     * @param authorId id for author needed to be updated.
     * @param authorInputDto {@link AuthorInputDto} obj. for update whole author.
     * @return updated author as {@link AuthorDto}
     */
    AuthorDto update(@NonNull Long authorId, @NonNull AuthorInputDto authorInputDto);

    /**
     * Delete author by id.
     *
     * @param authorId id for author needed to be deleted.
     */
    void delete(@NonNull Long authorId);
}
