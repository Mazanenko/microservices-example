package com.example.bookservice.service.impl;


import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.service.BookService;
import com.example.bookservice.util.mapstructMapper.BookMapper;
import com.example.resourceserver.openapi.model.BookDto;
import com.example.resourceserver.openapi.model.BookInputDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public BookDto get(@NonNull Long bookId) {
        return bookMapper.bookToDto(getFromDb(bookId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll().stream().map(bookMapper::bookToDto).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public BookDto create(@NonNull BookInputDto bookInputDto) {
        Book book = bookMapper.bookDtoToEntity(bookInputDto);
        return bookMapper.bookToDto(bookRepository.save(book));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BookDto update(@NonNull Long bookId, @NonNull BookInputDto bookInputDto) {
        Book book = getFromDb(bookId);
        bookMapper.updateBookFromDto(bookInputDto, book);
        return bookMapper.bookToDto(bookRepository.save(book));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(@NonNull Long bookId) {
        bookRepository.delete(bookRepository.getReferenceById(bookId));
    }

    private Book getFromDb(@NonNull Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "В бд нет книги с id: " + bookId));
    }
}
