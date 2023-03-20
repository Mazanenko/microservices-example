package com.example.bookservice.service.impl;


import com.example.bookservice.model.Author;
import com.example.bookservice.repository.AuthorRepository;
import com.example.bookservice.service.AuthorService;
import com.example.bookservice.util.mapstructMapper.AuthorMapper;
import com.example.resourceserver.openapi.model.AuthorDto;
import com.example.resourceserver.openapi.model.AuthorInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorDto get(@NonNull Long authorId) {
        return authorMapper.authorToDto(getFromDb(authorId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AuthorDto> getAll() {
        return authorRepository.findAll().stream().map(authorMapper::authorToDto).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorDto create(@NonNull AuthorInputDto authorInputDto) {
        Author author = authorMapper.authorDtoToEntity(authorInputDto);
        return authorMapper.authorToDto(authorRepository.save(author));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorDto update(@NonNull Long authorId, @NonNull AuthorInputDto authorInputDto) {
        Author author = getFromDb(authorId);
        authorMapper.updateAuthorFromDto(authorInputDto, author);
        return authorMapper.authorToDto(authorRepository.save(author));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(@NonNull Long authorId) {
        authorRepository.delete(authorRepository.getReferenceById(authorId));
    }

    private Author getFromDb(@NonNull Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "В бд нет автора с id: " + authorId));
    }
}
