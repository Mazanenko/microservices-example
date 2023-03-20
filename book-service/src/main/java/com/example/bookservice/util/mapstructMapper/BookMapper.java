package com.example.bookservice.util.mapstructMapper;


import com.example.bookservice.model.Author;
import com.example.bookservice.model.Book;
import com.example.resourceserver.openapi.model.AuthorDtoAttached;
import com.example.resourceserver.openapi.model.BookDto;
import com.example.resourceserver.openapi.model.BookInputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

    @Named("bookToDto")
    @Mapping(target = "author", source = "author", qualifiedByName = "authorToAuthorDtoAttached")
    BookDto bookToDto(Book book);

    @Named("bookDtoToEntity")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "author", qualifiedByName = "attachedAuthorDtoToEntity")
    Book bookDtoToEntity(BookInputDto bookInputDto);

    @Named("updateBookFromDto")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "author", qualifiedByName = "attachedAuthorDtoToEntity")
    void updateBookFromDto(BookInputDto bookInputDto, @MappingTarget Book bookForUpdate);

    @Named("attachedAuthorDtoToEntity")
    @Mapping(target = "books", ignore = true)
    Author attachedAuthorDtoToEntity(AuthorDtoAttached authorDto);

    @Named("authorToAuthorDtoAttached")
    AuthorDtoAttached authorToAuthorDtoAttached(Author author);
}
